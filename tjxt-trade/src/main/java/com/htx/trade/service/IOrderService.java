package com.htx.trade.service;

import com.htx.common.domain.dto.PageDTO;
import com.htx.pay.sdk.dto.PayResultDTO;
import com.htx.trade.domain.dto.PlaceOrderDTO;
import com.htx.trade.domain.po.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.trade.domain.po.OrderDetail;
import com.htx.trade.domain.query.OrderPageQuery;
import com.htx.trade.domain.vo.OrderConfirmVO;
import com.htx.trade.domain.vo.OrderPageVO;
import com.htx.trade.domain.vo.OrderVO;
import com.htx.trade.domain.vo.PlaceOrderResultVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 订单 服务类
 * </p>
 */
public interface IOrderService extends IService<Order> {

    PlaceOrderResultVO placeOrder(PlaceOrderDTO placeOrderDTO);

    @Transactional
    void saveOrderAndDetails(Order order, List<OrderDetail> orderDetails);

    void cancelOrder(Long orderId);

    void deleteOrder(Long id);

    PageDTO<OrderPageVO> queryMyOrderPage(OrderPageQuery pageQuery);

    OrderVO queryOrderById(Long id);

    PlaceOrderResultVO queryOrderStatus(Long orderId);

    void handlePaySuccess(PayResultDTO payResult);

    PlaceOrderResultVO enrolledFreeCourse(Long courseId);

    OrderConfirmVO prePlaceOrder(List<Long> courseIds);

}
