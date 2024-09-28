package com.htx.trade.controller;


import com.htx.common.domain.dto.PageDTO;
import com.htx.trade.domain.dto.ApproveFormDTO;
import com.htx.trade.domain.dto.RefundCancelDTO;
import com.htx.trade.domain.dto.RefundFormDTO;
import com.htx.trade.domain.query.RefundApplyPageQuery;
import com.htx.trade.domain.vo.RefundApplyPageVO;
import com.htx.trade.domain.vo.RefundApplyVO;
import com.htx.trade.service.IRefundApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 退款申请 前端控制器
 * </p>
 */
@Api(tags = "退款相关接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/refund-apply")
public class RefundApplyController {

    private final IRefundApplyService refundApplyService;

    @ApiOperation("退款申请")
    @PostMapping
    public void applyRefund(@Valid @RequestBody RefundFormDTO refundFormDTO) {
        refundApplyService.applyRefund(refundFormDTO);
    }

    @ApiOperation("审批退款申请")
    @PutMapping("/approval")
    public void approveRefundApply(@Valid @RequestBody ApproveFormDTO approveDTO){
        refundApplyService.approveRefundApply(approveDTO);
    }

    @ApiOperation("取消退款申请")
    @PutMapping("/cancel")
    public void cancelRefundApply(@Valid @RequestBody RefundCancelDTO cancelDTO){
        refundApplyService.cancelRefundApply(cancelDTO);
    }

    @ApiOperation("分页查询退款申请")
    @GetMapping("/page")
    public PageDTO<RefundApplyPageVO> queryRefundApplyByPage(RefundApplyPageQuery pageQuery){
        return refundApplyService.queryRefundApplyByPage(pageQuery);
    }

    @ApiOperation("根据id查询退款详情")
    @GetMapping("/{id}")
    public RefundApplyVO queryRefundDetailById(@ApiParam("退款id") @PathVariable("id") Long id){
        return refundApplyService.queryRefundDetailById(id);
    }

    @ApiOperation("根据子订单id查询退款详情")
    @GetMapping("/detail/{id}")
    public RefundApplyVO queryRefundDetailByDetailId(@ApiParam("子订单id") @PathVariable("id") Long detailId){
        return refundApplyService.queryRefundDetailByDetailId(detailId);
    }

    @ApiOperation("查询下一个待审批的退款申请")
    @GetMapping("/next")
    public RefundApplyVO nextRefundApplyToApprove(){
        return refundApplyService.nextRefundApplyToApprove();
    }
}
