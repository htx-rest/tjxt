package com.htx.exam.service.impl;

import com.htx.exam.domain.po.QuestionDetail;
import com.htx.exam.mapper.QuestionDetailMapper;
import com.htx.exam.service.IQuestionDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 题目 服务实现类
 * </p>
 */
@Service
public class QuestionDetailServiceImpl extends ServiceImpl<QuestionDetailMapper, QuestionDetail> implements IQuestionDetailService {

}
