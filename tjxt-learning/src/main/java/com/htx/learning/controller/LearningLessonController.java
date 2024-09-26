package com.htx.learning.controller;

import com.htx.common.domain.dto.PageDTO;
import com.htx.common.domain.query.PageQuery;
import com.htx.learning.domain.dto.LearningPlanDTO;
import com.htx.learning.domain.vo.LearningLessonVO;
import com.htx.learning.domain.vo.LearningPlanPageVO;
import com.htx.learning.service.ILearningLessonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: htx
 * @GZH: 二哈学习之路
 * @Date: 2024/9/26
 * @Desc: 学生课程表 前端控制器
 */
@RestController
@RequestMapping("/lessons")
@Api(tags = "我的课表相关接口")
@RequiredArgsConstructor
public class LearningLessonController {
    @Autowired
    private ILearningLessonService lessonService;

    @GetMapping("/page")
    @ApiOperation("分页查询我的课表")
    public PageDTO<LearningLessonVO> queryMyLessons(PageQuery query) {
        return lessonService.queryMyLessons(query);
    }

    @GetMapping("/now")
    @ApiOperation("查询我正在学习的课程")
    public LearningLessonVO queryMyCurrentLesson() {
        return lessonService.queryMyCurrentLesson();
    }

    @GetMapping("/{courseId}")
    @ApiOperation("查询指定课程信息")
    public LearningLessonVO queryLessonByCourseId(
            @ApiParam(value = "课程id" ,example = "1") @PathVariable("courseId") Long courseId) {
        return lessonService.queryLessonByCourseId(courseId);
    }

    @DeleteMapping("/{courseId}")
    @ApiOperation("删除指定课程信息")
    public void deleteCourseFromLesson(
            @ApiParam(value = "课程id" ,example = "1") @PathVariable("courseId") Long courseId) {
        lessonService.deleteCourseFromLesson(null, courseId);
    }

    @ApiOperation("统计课程学习人数")
    @GetMapping("/{courseId}/count")
    public Integer countLearningLessonByCourse(
            @ApiParam(value = "课程id" ,example = "1") @PathVariable("courseId") Long courseId){
        return lessonService.countLearningLessonByCourse(courseId);
    }

    @ApiOperation("校验当前课程是否已经报名")
    @GetMapping("/{courseId}/valid")
    public Long isLessonValid(
            @ApiParam(value = "课程id" ,example = "1") @PathVariable("courseId") Long courseId){
        return lessonService.isLessonValid(courseId);
    }

    @ApiOperation("创建学习计划")
    @PostMapping("/plans")
    public void createLearningPlans(@Valid @RequestBody LearningPlanDTO planDTO){
        lessonService.createLearningPlan(planDTO.getCourseId(), planDTO.getFreq());
    }

    @ApiOperation("查询我的学习计划")
    @GetMapping("/plans")
    public LearningPlanPageVO queryMyPlans(PageQuery query){
        return lessonService.queryMyPlans(query);
    }
}
