package com.htx.course.handler;

import com.htx.course.service.ICourseService;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName CourseJobHandler
 **/
@Component
@Slf4j
public class CourseJobHandler {

    @Autowired
    private ICourseService courseService;

    @XxlJob("courseFinished")
    public void courseFinished(){
        courseService.courseFinished();
    }
}
