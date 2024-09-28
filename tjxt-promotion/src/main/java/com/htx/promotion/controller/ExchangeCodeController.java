package com.htx.promotion.controller;


import com.htx.common.domain.dto.PageDTO;
import com.htx.promotion.domain.query.CodeQuery;
import com.htx.promotion.service.IExchangeCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 兑换码 前端控制器
 * </p>
 */
@RequiredArgsConstructor
@RestController
@Api(tags = "优惠券相关接口")
@RequestMapping("/codes")
public class ExchangeCodeController {

    private final IExchangeCodeService codeService;

    @ApiOperation("分页查询兑换码")
    @GetMapping("page")
    public PageDTO<String> queryCodePage(@Valid CodeQuery query){
        return codeService.queryCodePage(query);
    }

    @ApiOperation("兑换优惠券")
    @PostMapping("/{code}/exchange")
    public void exchangeCoupon(@PathVariable("code") String code){
        codeService.exchangeCoupon(code);
    }
}
