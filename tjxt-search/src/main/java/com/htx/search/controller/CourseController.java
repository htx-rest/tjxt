package com.htx.search.controller;

import com.htx.common.domain.dto.PageDTO;
import com.htx.search.domain.query.CoursePageQuery;
import com.htx.search.domain.vo.CourseVO;
import com.htx.search.service.ICourseService;
import com.htx.search.service.ISearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("courses")
@Api(tags = "课程搜索接口")
@RequiredArgsConstructor
public class CourseController {

    private final ISearchService searchService;
    private final ICourseService courseService;

    @ApiOperation("用户端课程搜索接口")
    @GetMapping("/portal")
    public PageDTO<CourseVO> queryCoursesForPortal(CoursePageQuery query){
        return searchService.queryCoursesForPortal(query);
    }

    @ApiIgnore
    @GetMapping("/name")
    public List<Long> queryCoursesIdByName(@RequestParam("keyword") String keyword){
        return searchService.queryCoursesIdByName(keyword);
    }

    @ApiOperation("处理指定课程上架失败的问题")
    @PostMapping("/up")
    public void handleCoursesUp(
            @ApiParam("课程id集合") @RequestParam("courseIds") List<Long> courseIds) {
        for (Long courseId : courseIds) {
            courseService.handleCourseUp(courseId);
        }
    }

    @ApiOperation("处理指定课程下架失败的问题")
    @PostMapping("/down")
    public void handleCoursesDown(
            @ApiParam("课程id集合") @RequestParam("courseIds") List<Long> courseIds) {
        for (Long courseId : courseIds) {
            courseService.handleCourseDeletes(courseIds);
        }
    }
}
