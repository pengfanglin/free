package com.free.controller.app;

import com.fanglin.common.core.others.Ajax;
import com.free.model.app.user.UserLoginResultModel;
import com.free.service.app.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@RestController
@RequestMapping("/app/user/")
@Api(value = "/app/user/", tags = {"APP-用户"})
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("登录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "openId", value = "openId", required = true)
    })
    @PostMapping("login")
    public Ajax<UserLoginResultModel> login(HttpServletResponse response, @RequestParam String openId) {
        return Ajax.ok(userService.login(response, openId));
    }

    @ApiOperation("注册")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "openId", value = "openId", required = true)
    })
    @PostMapping("register")
    public Ajax<UserLoginResultModel> register(HttpServletResponse response, @RequestParam String openId) {
        return Ajax.ok(userService.register(response, openId));
    }
}
