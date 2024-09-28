package com.htx.promotion.mapper;

import com.htx.promotion.domain.po.Coupon;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 优惠券的规则信息 Mapper 接口
 * </p>
 */
public interface CouponMapper extends BaseMapper<Coupon> {

    List<Coupon> selectByIds(@Param("ids") Set<Long> couponIds);

    @Select("UPDATE coupon SET issue_num = issue_num + 1 WHERE id = #{id} AND issue_num < total_num")
    void minusCouponIssueAmount(Long id);
}
