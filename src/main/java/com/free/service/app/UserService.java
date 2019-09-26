package com.free.service.app;

import com.free.model.app.user.UserLoginResultModel;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户服务
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface UserService {

    /**
     * 登录
     *
     * @param response
     * @param openId   openId
     * @param password 密码
     * @return
     */
    UserLoginResultModel login(HttpServletResponse response, String openId);

    /**
     * 注册
     *
     * @param response
     * @param openId   openId
     * @param password 密码
     * @return
     */
    UserLoginResultModel register(HttpServletResponse response, String openId);
}
