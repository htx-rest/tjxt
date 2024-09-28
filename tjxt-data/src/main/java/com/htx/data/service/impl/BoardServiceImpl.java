package com.htx.data.service.impl;

import com.htx.common.utils.JsonUtils;
import com.htx.common.utils.NumberUtils;
import com.htx.data.constants.DataTypeEnum;
import com.htx.data.model.dto.BoardDataSetDTO;
import com.htx.data.model.vo.AxisVO;
import com.htx.data.model.vo.EchartsVO;
import com.htx.data.model.vo.SerierVO;
import com.htx.data.service.BoardService;
import com.htx.data.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.htx.data.constants.RedisConstants.KEY_BOARD_DATA;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public EchartsVO boardData(List<Integer> types) {
        // 1.定义echarts变量
        EchartsVO echartsVO = new EchartsVO();
        List<AxisVO> yAxis = new ArrayList<>();
        List<SerierVO> series = new ArrayList<>();
        // 2.遍历数据类型types
        // 2.1.数据版本
        int version = DataUtils.getVersion(1);

        for (Integer type : types) {
            // 2.1.获取数据类型
            DataTypeEnum dataTypeEnum = DataTypeEnum.get(type);
            // 2.2.获取数据
            Object originData = redisTemplate.opsForHash().get(KEY_BOARD_DATA + version, type.toString());
            List<Double> data = originData == null
                    ? new ArrayList<>()
                    : JsonUtils.toList(originData.toString(), Double.class);
            // 2.3.计算最大最小值
            Double max = NumberUtils.null2Zero(NumberUtils.max(data));
            Double min = NumberUtils.null2Zero(NumberUtils.min(data));
            // 2.2.设置数据
            series.add(new SerierVO(
                    dataTypeEnum.nameWithUnit(),
                    dataTypeEnum.getAxisType(),
                    data,
                    max + dataTypeEnum.getUnit(),
                    min + dataTypeEnum.getUnit()
                    ));
            // 2.3.设置y轴数据
            yAxis.add(AxisVO.builder()
                    .max(max)
                    .min(NumberUtils.setScale(min * 0.9))
                    .interval(((int)NumberUtils.div((max - min * 0.9), 10.0) + 1) * 1.0)
                    .average(
                            NumberUtils.setScale(NumberUtils.null2Zero(NumberUtils.average(data))))
                    .type(AxisVO.TYPE_VALUE)
                    .build());
        }
        // 3.封装数据
        // 3.1.x轴数据
        echartsVO.setXAxis(Collections.singletonList(AxisVO.last15Day()));
        // 3.2.y轴数据
        echartsVO.setYAxis(yAxis);
        // 3.3.series数据
        echartsVO.setSeries(series);
        return echartsVO;
    }

    @Override
    public void setBoardData(BoardDataSetDTO boardDataSetDTO) {
        String key = KEY_BOARD_DATA + boardDataSetDTO.getVersion();
        redisTemplate.opsForHash()
                .put(key,
                        boardDataSetDTO.getType().toString(),
                        JsonUtils.toJsonStr(boardDataSetDTO.getData()));
    }
}
