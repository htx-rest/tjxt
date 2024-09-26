package com.htx.api.dto.promotion;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "订单中课程及优惠券信息")
public class OrderCouponDTO {
    @ApiModelProperty("用户优惠券id")
    private Long userCouponId;
    @ApiModelProperty("订单中的课程列表")
    private List<OrderCourseDTO> courseList;
}
