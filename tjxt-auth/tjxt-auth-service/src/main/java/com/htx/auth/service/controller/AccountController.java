package com.htx.auth.service.controller;


import com.htx.api.dto.user.LoginFormDTO;
import com.htx.auth.common.constants.JwtConstants;
import com.htx.auth.service.service.IAccountService;
import com.htx.common.utils.WebUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 账户登录相关接口
 */
@RestController
@RequestMapping("/accounts")
@Api(tags = "账户管理")
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService accountService;

    @ApiOperation("登录并获取token")
    @PostMapping(value = "/login")
    public String loginByPw(@RequestBody LoginFormDTO loginFormDTO){
        return accountService.login(loginFormDTO, false);
    }

    @ApiOperation("管理端登录并获取token")
    @PostMapping(value = "/admin/login")
    public String adminLoginByPw(@RequestBody LoginFormDTO loginFormDTO){
        return accountService.login(loginFormDTO, true);
    }

    @ApiOperation("退出登录")
    @PostMapping(value = "/logout")
    public void logout(){
        accountService.logout();
    }

    @ApiOperation("刷新token")
    @GetMapping(value = "/refresh")
    public String refreshToken(@CookieValue(JwtConstants.REFRESH_HEADER) String token){
        return accountService.refreshToken(WebUtils.cookieBuilder().decode(token));
    }
}
