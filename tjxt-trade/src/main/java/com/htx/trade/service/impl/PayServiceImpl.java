package com.htx.trade.service.impl;

import com.htx.common.autoconfigure.mq.RabbitMqHelper;
import com.htx.common.exceptions.BadRequestException;
import com.htx.common.exceptions.BizIllegalException;
import com.htx.common.utils.AssertUtils;
import com.htx.common.utils.BeanUtils;
import com.htx.common.utils.CollUtils;
import com.htx.pay.sdk.client.PayClient;
import com.htx.pay.sdk.constants.PayType;
import com.htx.pay.sdk.dto.PayApplyDTO;
import com.htx.pay.sdk.dto.PayChannelDTO;
import com.htx.pay.sdk.dto.PayResultDTO;
import com.htx.trade.config.TradeProperties;
import com.htx.trade.constants.OrderStatus;
import com.htx.trade.constants.TradeErrorInfo;
import com.htx.trade.domain.dto.OrderDelayQueryDTO;
import com.htx.trade.domain.dto.PayApplyFormDTO;
import com.htx.trade.domain.po.Order;
import com.htx.trade.domain.po.OrderDetail;
import com.htx.trade.domain.vo.PayChannelVO;
import com.htx.trade.service.IOrderDetailService;
import com.htx.trade.service.IOrderService;
import com.htx.trade.service.IPayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.htx.common.constants.MqConstants.Exchange.TRADE_DELAY_EXCHANGE;
import static com.htx.common.constants.MqConstants.Key.ORDER_DELAY_KEY;
import static com.htx.trade.constants.TradeErrorInfo.ORDER_NOT_EXISTS;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayServiceImpl implements IPayService {

    private final PayClient payClient;
    private final IOrderService orderService;
    private final IOrderDetailService detailService;
    private final TradeProperties tradeProperties;
    private final RabbitMqHelper mqHelper;

    @Override
    public List<PayChannelVO> queryPayChannels() {
        List<PayChannelDTO> list = payClient.listAllPayChannels();
        if (list == null) {
            return CollUtils.emptyList();
        }
        return list.stream()
                .filter(p -> p.getStatus() == 1)
                .map(p -> BeanUtils.copyBean(p, PayChannelVO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String applyPayOrder(PayApplyFormDTO payApply) {
        Long orderId = payApply.getOrderId();
        // 1.查询订单信息
        Order order = orderService.getById(orderId);
        if (order == null) {
            throw new BadRequestException(ORDER_NOT_EXISTS);
        }
        // 2.判断订单状态
        if (!OrderStatus.NO_PAY.equalsValue(order.getStatus())) {
            // 订单已经支付或关闭
            throw new BizIllegalException(TradeErrorInfo.ORDER_ALREADY_FINISH);
        }
        // 3.判断订单是否已经超时
        if (order.getCreateTime().plusMinutes(tradeProperties.getPayOrderTTLMinutes()).isBefore(LocalDateTime.now())) {
            // 订单已经超时，无法支付
            throw new BizIllegalException(TradeErrorInfo.ORDER_OVER_TIME);
        }
        // 4.查询订单详情
        List<OrderDetail> details = detailService.queryByOrderId(orderId);
        AssertUtils.isNotEmpty(details, ORDER_NOT_EXISTS);

        // 5.封装下单参数
        PayApplyDTO payApplyDTO = PayApplyDTO.builder()
                .bizOrderNo(orderId)
                .amount(order.getRealAmount())
                .orderInfo(details.get(0).getName())
                .bizUserId(order.getUserId())
                .payType(PayType.NATIVE.getValue())
                .payChannelCode(payApply.getPayChannelCode())
                .build();
        String url = payClient.applyPayOrder(payApplyDTO);
        // 6.通过延迟队列，异步查询支付结果
        sendDelayQueryMessage(OrderDelayQueryDTO.init(orderId));
        return url;
    }

    private void sendDelayQueryMessage(OrderDelayQueryDTO message) {
        mqHelper.sendDelayMessage(
                TRADE_DELAY_EXCHANGE,
                ORDER_DELAY_KEY,
                message, Duration.ofMillis(message.removeFirst()));
    }

    @Override
    public void queryPayResult(OrderDelayQueryDTO message) {
        // 1.获取订单信息
        Long orderId = message.getOrderId();
        Order order = orderService.getById(orderId);
        if (order == null) {
            log.error("要查询状态的订单：{}不存在", orderId);
            return;
        }
        // 2.判断订单状态
        if (!OrderStatus.NO_PAY.equalsValue(order.getStatus())) {
            // 订单已经支付或关闭，任务结束
            return;
        }
        // 3.查询支付状态
        PayResultDTO payResult = payClient.queryPayResult(orderId);
        int status = payResult.getStatus();
        if(PayResultDTO.SUCCESS != status){
            // 3.1.支付中或支付失败，需要重试查询
            if(message.getDelayMillis().size() == 0){
                // 重试次数用尽，结束
                return;
            }
            // 发送延迟查询消息，再次查询支付状态
            sendDelayQueryMessage(message);
        }
        // 3.2.支付成功
        orderService.handlePaySuccess(payResult);
    }
}
