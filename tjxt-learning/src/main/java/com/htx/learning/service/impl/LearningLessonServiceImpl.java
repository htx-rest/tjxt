package com.htx.learning.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.api.client.course.CatalogueClient;
import com.htx.api.client.course.CourseClient;
import com.htx.api.dto.IdAndNumDTO;
import com.htx.api.dto.course.CataSimpleInfoDTO;
import com.htx.api.dto.course.CourseFullInfoDTO;
import com.htx.api.dto.course.CourseSimpleInfoDTO;
import com.htx.common.domain.dto.PageDTO;
import com.htx.common.domain.query.PageQuery;
import com.htx.learning.domain.po.LearningLesson;
import com.htx.learning.domain.vo.LearningLessonVO;
import com.htx.learning.domain.vo.LearningPlanPageVO;
import com.htx.learning.mapper.LearningLessonMapper;
import com.htx.learning.mapper.LearningRecordMapper;
import com.htx.learning.service.ILearningLessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: htx
 * @GZH:二哈学习之路
 * @Date:2024/9/26
 * @Desc: 学生课程表 服务实现类
 */
@SuppressWarnings("ALL")
@Service
@RequiredArgsConstructor
@Slf4j
public class LearningLessonServiceImpl extends ServiceImpl<LearningLessonMapper, LearningLesson> implements ILearningLessonService {
    @Autowired
    private CourseClient courseClient;

    @Autowired
    private CatalogueClient catalogueClient;

    @Autowired
    private LearningRecordMapper recordMapper;

    @Override
    public void addUserLessons(Long userId, List<Long> courseIds) {

    }

    @Override
    public PageDTO<LearningLessonVO> queryMyLessons(PageQuery query) {
        return null;
    }

    @Override
    public LearningLessonVO queryMyCurrentLesson() {
        return null;
    }

    @Override
    public LearningLessonVO queryLessonByCourseId(Long courseId) {
        return null;
    }

    @Override
    public void deleteCourseFromLesson(Object o, Long courseId) {

    }

    @Override
    public Integer countLearningLessonByCourse(Long courseId) {
        return 0;
    }

    @Override
    public Long isLessonValid(Long courseId) {
        return 0;
    }

    @Override
    public LearningLesson queryByUserAndCourseId(Long userId, Long courseId) {
        return null;
    }

    @Override
    public void createLearningPlan(Long courseId, Integer freq) {

    }

    @Override
    public LearningPlanPageVO queryMyPlans(PageQuery query) {
        return null;
    }
}
