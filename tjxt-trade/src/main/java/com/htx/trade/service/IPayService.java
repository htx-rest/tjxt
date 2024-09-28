package com.htx.trade.service;

import com.htx.trade.domain.dto.OrderDelayQueryDTO;
import com.htx.trade.domain.dto.PayApplyFormDTO;
import com.htx.trade.domain.vo.PayChannelVO;

import java.util.List;

public interface IPayService {
    List<PayChannelVO> queryPayChannels();

    String applyPayOrder(PayApplyFormDTO payApply);

    void queryPayResult(OrderDelayQueryDTO message);
}
