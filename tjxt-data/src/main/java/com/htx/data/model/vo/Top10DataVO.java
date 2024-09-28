package com.htx.data.model.vo;

import com.htx.data.model.po.CourseInfo;
import lombok.Data;

import java.util.List;

@Data
public class Top10DataVO {
    // 热门课程
    private List<CourseInfo> hot;
    // 热销课程
    private List<CourseInfo> hotSales;
}
