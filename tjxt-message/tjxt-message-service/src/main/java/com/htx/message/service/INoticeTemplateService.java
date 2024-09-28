package com.htx.message.service;

import com.htx.message.domain.dto.NoticeTemplateDTO;
import com.htx.message.domain.dto.NoticeTemplateFormDTO;
import com.htx.message.domain.query.NoticeTemplatePageQuery;
import com.htx.common.domain.dto.PageDTO;
import com.htx.message.domain.po.NoticeTemplate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 通知模板 服务类
 * </p>
 */
public interface INoticeTemplateService extends IService<NoticeTemplate> {

    Long saveNoticeTemplate(NoticeTemplateFormDTO noticeTemplateFormDTO);

    void updateNoticeTemplate(NoticeTemplateFormDTO noticeTemplateFormDTO);

    PageDTO<NoticeTemplateDTO> queryNoticeTemplates(NoticeTemplatePageQuery pageQuery);

    NoticeTemplateDTO queryNoticeTemplate(Long id);

    NoticeTemplate queryByCode(String code);
}
