package com.htx.learning.controller;


import com.htx.common.domain.dto.PageDTO;
import com.htx.learning.domain.dto.ReplyDTO;
import com.htx.learning.domain.query.ReplyPageQuery;
import com.htx.learning.domain.vo.ReplyVO;
import com.htx.learning.service.IInteractionReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 互动问题的回答或评论 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
@Api(tags = "互动问答相关接口 ")
public class InteractionReplyController {

    private final IInteractionReplyService replyService;

    @ApiOperation("新增回答或评论")
    @PostMapping
    public void saveReply(@RequestBody ReplyDTO replyDTO) {
        replyService.saveReply(replyDTO);
    }

    @ApiOperation("分页查询回答或评论")
    @GetMapping("page")
    public PageDTO<ReplyVO> queryReplyPage(ReplyPageQuery pageQuery){
        return replyService.queryReplyPage(pageQuery, false);
    }
}
