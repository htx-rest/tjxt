package com.htx.pay.service;

import com.htx.common.domain.dto.PageDTO;
import com.htx.pay.domain.po.RefundOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.pay.sdk.dto.RefundApplyDTO;
import com.htx.pay.sdk.dto.RefundResultDTO;

/**
 * <p>
 * 退款订单 服务类
 * </p>
 */
public interface IRefundOrderService extends IService<RefundOrder> {

    RefundResultDTO applyRefund(RefundApplyDTO refundApplyDTO);

    RefundResultDTO queryRefundResult(Long bizRefundOrderId);

    RefundOrder queryByRefundOrderNo(Long refundOrderNo);

    PageDTO<RefundOrder> queryRefundingOrderByPage(int pageNo, int size);

    void checkRefundOrder(RefundOrder refundOrder);

    RefundResultDTO queryRefundDetail(Long bizRefundOrderId);
}
