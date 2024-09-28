package com.htx.promotion.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.promotion.domain.po.CouponScope;
import com.htx.promotion.strategy.scope.Scope;

import java.util.List;

/**
 * <p>
 * 优惠券作用范围信息 服务类
 * </p>
 */
public interface ICouponScopeService extends IService<CouponScope> {

    void removeByCouponId(Long couponId);

    List<Scope> queryScopeByCouponId(Long couponId);
}
