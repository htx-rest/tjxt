package com.htx.promotion.service;

import com.htx.api.dto.promotion.CouponDiscountDTO;
import com.htx.api.dto.promotion.OrderCouponDTO;
import com.htx.api.dto.promotion.OrderCourseDTO;
import com.htx.common.domain.dto.PageDTO;
import com.htx.promotion.domain.po.Coupon;
import com.htx.promotion.domain.po.UserCoupon;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.promotion.domain.query.UserCouponQuery;
import com.htx.promotion.domain.vo.UserCouponVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户领取优惠券的记录，是真正使用的优惠券信息 服务类
 * </p>
 */
public interface IUserCouponService extends IService<UserCoupon> {

    Map<Long, Integer> countUsedTimes(List<Long> couponIds);

    PageDTO<UserCouponVO> queryUserCouponPage(UserCouponQuery query);

    List<CouponDiscountDTO> queryAvailableCoupon(List<OrderCourseDTO> orderCourses);

    CouponDiscountDTO queryDiscountByCouponId(OrderCouponDTO orderCouponDTO);

    int countUserReceiveNum(Long couponId, Long userId);

    void createUserCouponWithId(Coupon coupon, Long id, Long userId);

    void writeOffCoupon(Long couponId, Long orderId);

    void refundCoupon(Long couponId);

}
