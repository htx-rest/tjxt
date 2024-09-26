package com.htx.learning.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.common.domain.dto.PageDTO;
import com.htx.common.domain.query.PageQuery;
import com.htx.learning.domain.po.LearningLesson;
import com.htx.learning.domain.vo.LearningLessonVO;
import com.htx.learning.domain.vo.LearningPlanPageVO;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.util.List;

/**
 * @Author: htx
 * @GZH:二哈学习之路
 * @Date:2024/9/26
 * @Desc: 学生课程表 服务类
 */
public interface ILearningLessonService extends IService<LearningLesson> {
    void addUserLessons(Long userId, List<Long> courseIds);

    PageDTO<LearningLessonVO> queryMyLessons(PageQuery query);

    LearningLessonVO queryMyCurrentLesson();

    LearningLessonVO queryLessonByCourseId(Long courseId);

    void deleteCourseFromLesson(Object o, Long courseId);

    Integer countLearningLessonByCourse(Long courseId);

    Long isLessonValid(Long courseId);

    LearningLesson queryByUserAndCourseId(Long userId, Long courseId);

    void createLearningPlan(@NotNull @Min(1) Long courseId, @NotNull @Range(min = 1, max = 50) Integer freq);

    LearningPlanPageVO queryMyPlans(PageQuery query);
}
