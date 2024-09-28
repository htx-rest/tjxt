package com.htx.message.service;

import com.htx.message.domain.dto.UserInboxDTO;
import com.htx.message.domain.dto.UserInboxFormDTO;
import com.htx.api.dto.user.UserDTO;
import com.htx.message.domain.query.UserInboxQuery;
import com.htx.common.domain.dto.PageDTO;
import com.htx.message.domain.po.NoticeTemplate;
import com.htx.message.domain.po.UserInbox;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户通知记录 服务类
 * </p>
 */
public interface IUserInboxService extends IService<UserInbox> {

    void saveNoticeToInbox(NoticeTemplate noticeTemplate, List<UserDTO> users);

    PageDTO<UserInboxDTO> queryUserInBoxesPage(UserInboxQuery query);

    Long sentMessageToUser(UserInboxFormDTO userInboxFormDTO);
}
