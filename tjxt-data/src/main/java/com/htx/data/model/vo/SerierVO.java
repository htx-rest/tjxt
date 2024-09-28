package com.htx.data.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SerierVO {

    //折线图
    public static final String TYPE_LINE = "line";
    //柱状图
    public static final String TYPE_BAR = "bar";
    //饼图
    public static final String TYPE_PIE = "pie";

    private String name;
    private String type;
    private List<?> data;
    private String max;
    private String min;


}
