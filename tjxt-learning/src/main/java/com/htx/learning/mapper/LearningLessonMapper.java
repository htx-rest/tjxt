package com.htx.learning.mapper;

import com.htx.learning.domain.po.LearningLesson;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 学生课程表 Mapper 接口
 * </p>
 */
public interface LearningLessonMapper extends BaseMapper<LearningLesson> {

    Integer queryTotalPlan(@Param("userId") Long userId);
}
