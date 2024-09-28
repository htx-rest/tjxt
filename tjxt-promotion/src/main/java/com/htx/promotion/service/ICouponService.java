package com.htx.promotion.service;

import com.htx.common.domain.dto.PageDTO;
import com.htx.promotion.domain.dto.CouponFormDTO;
import com.htx.promotion.domain.dto.CouponIssueFormDTO;
import com.htx.promotion.domain.po.Coupon;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.promotion.domain.po.UserCoupon;
import com.htx.promotion.domain.query.CouponQuery;
import com.htx.promotion.domain.vo.CouponDetailVO;
import com.htx.promotion.domain.vo.CouponPageVO;

/**
 * <p>
 * 优惠券的规则信息 服务类
 * </p>
 */
public interface ICouponService extends IService<Coupon> {

    void saveCoupon(CouponFormDTO couponDTO);

    void deleteById(Long id);

    void updateCoupon(CouponFormDTO couponDTO);

    PageDTO<CouponPageVO> queryCouponPage(CouponQuery query);

    CouponDetailVO queryCouponById(Long id);

    void pauseIssue(Long id);

    void beginIssue(CouponIssueFormDTO couponIssueDTO);

    void snapUpCoupon(Long couponId);

    void snapUpCoupon(UserCoupon userCoupon);

    void issueCouponByPage(int page, int size);
}
