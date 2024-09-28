package com.htx.promotion.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.common.domain.dto.PageDTO;
import com.htx.promotion.domain.po.Coupon;
import com.htx.promotion.domain.po.ExchangeCode;
import com.htx.promotion.domain.query.CodeQuery;

/**
 * <p>
 * 兑换码 服务类
 * </p>
 */
public interface IExchangeCodeService extends IService<ExchangeCode> {

    void generateExchangeCodeAsync(Coupon coupon);

    PageDTO<String> queryCodePage(CodeQuery query);

    void exchangeCoupon(String code);
}
