package com.htx.pay.service;

import com.htx.pay.sdk.dto.PayChannelDTO;
import com.htx.pay.domain.po.PayChannel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 支付渠道 服务类
 * </p>
 */
public interface IPayChannelService extends IService<PayChannel> {

    Long addPayChannel(PayChannelDTO channelDTO);

    void updatePayChannel(PayChannelDTO channelDTO);
}
