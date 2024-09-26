package com.htx.learning.service;

import com.htx.common.domain.dto.PageDTO;
import com.htx.learning.domain.dto.ReplyDTO;
import com.htx.learning.domain.po.InteractionReply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.learning.domain.query.ReplyPageQuery;
import com.htx.learning.domain.vo.ReplyVO;

/**
 * <p>
 * 互动问题的回答或评论 服务类
 * </p>
 */
public interface IInteractionReplyService extends IService<InteractionReply> {

    void saveReply(ReplyDTO replyDTO);

    PageDTO<ReplyVO> queryReplyPage(ReplyPageQuery pageQuery, boolean isStudent);

    void hiddenReply(Long id, Boolean hidden);

    ReplyVO queryReplyById(Long id);
}
