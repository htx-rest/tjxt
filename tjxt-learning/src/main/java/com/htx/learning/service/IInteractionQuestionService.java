package com.htx.learning.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.common.domain.dto.PageDTO;
import com.htx.learning.domain.dto.QuestionFormDTO;
import com.htx.learning.domain.po.InteractionQuestion;
import com.htx.learning.domain.query.QuestionAdminPageQuery;
import com.htx.learning.domain.query.QuestionPageQuery;
import com.htx.learning.domain.vo.QuestionAdminVO;
import com.htx.learning.domain.vo.QuestionVO;

/**
 * <p>
 * 互动提问的问题表 服务类
 * </p>

 */
public interface IInteractionQuestionService extends IService<InteractionQuestion> {

    void saveQuestion(QuestionFormDTO questionDTO);

    PageDTO<QuestionVO> queryQuestionPage(QuestionPageQuery query);

    QuestionVO queryQuestionById(Long id);

    PageDTO<QuestionAdminVO> queryQuestionPageAdmin(QuestionAdminPageQuery query);

    QuestionAdminVO queryQuestionByIdAdmin(Long id);

    void hiddenQuestion(Long id, Boolean hidden);

    void updateQuestion(Long id, QuestionFormDTO questionDTO);

    void deleteById(Long id);
}
