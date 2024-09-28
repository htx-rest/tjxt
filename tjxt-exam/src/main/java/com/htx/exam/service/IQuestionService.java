package com.htx.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.api.dto.exam.QuestionDTO;
import com.htx.common.domain.dto.PageDTO;
import com.htx.exam.domain.dto.QuestionFormDTO;
import com.htx.exam.domain.po.Question;
import com.htx.exam.domain.query.QuestionPageQuery;
import com.htx.exam.domain.vo.QuestionDetailVO;
import com.htx.exam.domain.vo.QuestionPageVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 题目 服务类
 * </p>
 */
public interface IQuestionService extends IService<Question> {

    void addQuestion(QuestionFormDTO questionFormDTO);

    void updateQuestion(QuestionFormDTO questionDTO);

    void deleteQuestionById(Long id);

    PageDTO<QuestionPageVO> queryQuestionByPage(QuestionPageQuery query);

    QuestionDetailVO queryQuestionDetailById(Long id);

    List<QuestionDTO> queryQuestionByIds(List<Long> ids);

    Map<Long, Integer> countQuestionNumOfCreater(List<Long> createrIds);

    List<QuestionDTO> queryQuestionByBizId(Long bizId);

    Boolean checkNameValid(String name);

    Map<Long, Integer> queryQuestionScores(List<Long> ids);
}
