package com.htx.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.course.domain.po.CourseCataSubjectDraft;

/**
 * <p>
 * 课程-题目关系表草稿 服务类
 * </p>
 */
public interface ICourseCataSubjectDraftService extends IService<CourseCataSubjectDraft> {
    /**
     * 删除不在的课程小节目录
     * @param courseId
     */
    void deleteNotInCataIdList(Long courseId);
}
