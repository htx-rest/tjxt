package com.htx.data.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class EchartsVO {
    private List<AxisVO> xAxis;
    private List<AxisVO> yAxis;
    private List<SerierVO> series;
}
