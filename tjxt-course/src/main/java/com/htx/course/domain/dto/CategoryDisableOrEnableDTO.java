package com.htx.course.domain.dto;

import com.htx.common.validate.annotations.EnumValid;
import com.htx.course.constants.CourseErrorInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 课程目录启用或停用模型
 **/
@Data
@ApiModel(description = "课程分类启用/禁用")
public class CategoryDisableOrEnableDTO {
    @ApiModelProperty("课程分类id")
    @NotNull(message = CourseErrorInfo.Msg.CATEGORY_ID_NOT_NULL)
    private Long id;
    @ApiModelProperty("课程分类状态，1：启用，0：禁用")
    @EnumValid(enumeration = {0,1}, message = CourseErrorInfo.Msg.CATEGORY_DISABLE_ENABLE_STATUS_ENUM)
    private Integer status;
}
