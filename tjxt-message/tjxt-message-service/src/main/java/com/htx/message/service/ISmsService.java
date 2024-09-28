package com.htx.message.service;

import com.htx.api.dto.sms.SmsInfoDTO;
import com.htx.api.dto.user.UserDTO;
import com.htx.message.domain.po.NoticeTemplate;

import java.util.List;

public interface ISmsService {
    void sendMessageByTemplate(NoticeTemplate noticeTemplate, List<UserDTO> users);

    void sendMessage(SmsInfoDTO smsInfoDTO);

    void sendMessageAsync(SmsInfoDTO smsInfoDTO);
}
