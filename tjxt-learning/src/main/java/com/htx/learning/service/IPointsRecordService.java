package com.htx.learning.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.learning.domain.po.PointsRecord;
import com.htx.learning.domain.vo.PointsStatisticsVO;
import com.htx.learning.enums.PointsRecordType;

import java.util.List;

/**
 * <p>
 * 学习积分记录，每个月底清零 服务类
 * </p>
 */
public interface IPointsRecordService extends IService<PointsRecord> {
    void addPointsRecord(Long userId, int points, PointsRecordType type);

    List<PointsStatisticsVO> queryMyPointsToday();

}
