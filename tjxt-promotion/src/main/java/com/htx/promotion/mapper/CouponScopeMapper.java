package com.htx.promotion.mapper;

import com.htx.promotion.domain.po.CouponScope;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 优惠券作用范围信息 Mapper 接口
 * </p>
 */
public interface CouponScopeMapper extends BaseMapper<CouponScope> {

    @Select("SELECT type, biz_id FROM coupon_biz WHERE coupon_id = #{couponId}")
    List<CouponScope> queryBizByCouponId(Long couponId);
}
