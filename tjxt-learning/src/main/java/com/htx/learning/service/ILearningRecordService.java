package com.htx.learning.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.api.dto.leanring.LearningLessonDTO;
import com.htx.learning.domain.dto.LearningRecordFormDTO;
import com.htx.learning.domain.po.LearningRecord;

/**
 * <p>
 * 学习记录表 服务类
 * </p>
 */
public interface ILearningRecordService extends IService<LearningRecord> {

    LearningLessonDTO queryLearningRecordByCourse(Long courseId);

    void addLearningRecord(LearningRecordFormDTO formDTO);
}
