package com.htx.message.controller;


import com.htx.common.domain.dto.PageDTO;
import com.htx.message.domain.dto.UserInboxDTO;
import com.htx.message.domain.dto.UserInboxFormDTO;
import com.htx.message.domain.query.UserInboxQuery;
import com.htx.message.service.IUserInboxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户通知记录 前端控制器
 * </p>
 */
@Api(tags = "用户收件箱接口")
@RestController
@RequestMapping("/inboxes")
@RequiredArgsConstructor
public class UserInboxController {

    private final IUserInboxService inboxService;

    @PostMapping
    @ApiOperation("发送私信")
    public Long sentMessageToUser(@RequestBody UserInboxFormDTO userInboxFormDTO){
        return inboxService.sentMessageToUser(userInboxFormDTO);
    }

    @ApiOperation("分页查询收件箱")
    @GetMapping
    public PageDTO<UserInboxDTO> queryUserInBoxesPage(UserInboxQuery query){
        return inboxService.queryUserInBoxesPage(query);
    }
}
