package com.htx.data.controller;

import com.htx.data.model.dto.Top10DataSetDTO;
import com.htx.data.model.vo.Top10DataVO;
import com.htx.data.service.Top10Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "工作台top10数据相关接口")
@RequestMapping("/data/top10")
public class Top10Controller {

    @Autowired
    private Top10Service top10Service;

    @GetMapping("")
    @ApiOperation("top10数据获取")
    public Top10DataVO getTop10Data() {
        return top10Service.getTop10Data();
    }

    @PutMapping("set")
    @ApiOperation("设置top10数据")
    public void setTop10Data(@RequestBody @Validated Top10DataSetDTO top10DataSetDTO) {
        top10Service.setTop10Data(top10DataSetDTO);
    }

}
