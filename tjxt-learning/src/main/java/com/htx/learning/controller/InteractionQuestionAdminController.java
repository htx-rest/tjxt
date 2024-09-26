package com.htx.learning.controller;


import com.htx.common.domain.dto.PageDTO;
import com.htx.learning.domain.query.QuestionAdminPageQuery;
import com.htx.learning.domain.vo.QuestionAdminVO;
import com.htx.learning.service.IInteractionQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 互动提问的问题表 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/admin/questions")
@Api(tags = "互动问答的相关接口")
@RequiredArgsConstructor
public class InteractionQuestionAdminController {

    private final IInteractionQuestionService questionService;

    @ApiOperation("管理端分页查询互动问题")
    @GetMapping("page")
    public PageDTO<QuestionAdminVO> queryQuestionPageAdmin(QuestionAdminPageQuery query){
        return questionService.queryQuestionPageAdmin(query);
    }

    @ApiOperation("管理端根据id查询互动问题")
    @GetMapping("{id}")
    public QuestionAdminVO queryQuestionByIdAdmin(@PathVariable("id") Long id){
        return questionService.queryQuestionByIdAdmin(id);
    }

    @ApiOperation("隐藏或显示问题")
    @PutMapping("/{id}/hidden/{hidden}")
    public void hiddenQuestion(
            @ApiParam(value = "问题id", example = "1") @PathVariable("id") Long id,
            @ApiParam(value = "是否隐藏，true/false", example = "true") @PathVariable("hidden") Boolean hidden
    ){
        questionService.hiddenQuestion(id, hidden);
    }
}
