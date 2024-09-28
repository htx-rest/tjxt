package com.htx.course.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 课程类目分页查询
 **/
@ApiModel(description = "课程类目分页查询条件")
@Data
public class CategoryListDTO {
    @ApiModelProperty("类目状态1:正常，2：禁用")
    private Integer status;
    @ApiModelProperty("类目名称")
    private String name;


}
