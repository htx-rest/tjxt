package com.htx.pay.controller;


import com.htx.common.utils.BeanUtils;
import com.htx.pay.sdk.dto.PayChannelDTO;
import com.htx.pay.service.IPayChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 支付渠道 前端控制器
 * </p>
 */
@Api(tags = "支付相关接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/pay-channels")
public class PayChannelController {

    private final IPayChannelService channelService;

    @ApiOperation("查询支付渠道列表")
    @GetMapping("/list")
    public List<PayChannelDTO> listAllPayChannels(){
        return BeanUtils.copyList(channelService.list(), PayChannelDTO.class);
    }

    @ApiOperation("添加支付渠道")
    @PostMapping
    public Long addPayChannel(@Valid @RequestBody PayChannelDTO channelDTO){
        return channelService.addPayChannel(channelDTO);
    }

    @ApiOperation("修改支付渠道")
    @PutMapping("/{id}")
    public void updatePayChannel(
            @ApiParam("支付渠道id") @PathVariable("id") Long id,
            @RequestBody PayChannelDTO channelDTO){
        channelDTO.setId(id);
        channelService.updatePayChannel(channelDTO);
    }
}
