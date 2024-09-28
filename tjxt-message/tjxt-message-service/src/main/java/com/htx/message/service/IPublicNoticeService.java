package com.htx.message.service;

import com.htx.message.domain.po.NoticeTemplate;
import com.htx.message.domain.po.PublicNotice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 公告消息模板 服务类
 * </p>
 */
public interface IPublicNoticeService extends IService<PublicNotice> {

    void saveNoticeOfTemplate(NoticeTemplate noticeTemplate);
}
