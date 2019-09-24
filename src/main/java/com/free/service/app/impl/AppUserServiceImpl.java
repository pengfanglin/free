package com.free.service.app.impl;

import com.fanglin.common.core.others.Assert;
import com.fanglin.common.core.token.TokenInfo;
import com.fanglin.common.util.*;
import com.free.core.others.AppTokenData;
import com.free.entity.user.UserEntity;
import com.free.mapper.MapperFactory;
import com.free.model.app.user.UserLoginModel;
import com.free.model.app.user.UserLoginResultModel;
import com.free.service.app.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;


/**
 * 用户服务实现类
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    MapperFactory mapperFactory;

    @Override
    public UserLoginResultModel login(HttpServletResponse response, String openId) {
        UserLoginModel user = mapperFactory.user.login(openId);
        Assert.notNull(user, "用户不存在");
        Assert.isFalse(user.getDisable(), "账号已冻结");
        AppTokenData tokenData = new AppTokenData().setId(user.getId());
        TokenInfo tokenInfo = new TokenInfo().setData(tokenData).setType("user");
        TokenUtils.login(response, tokenInfo);
        return new UserLoginResultModel(tokenInfo.getAssessToken(), tokenInfo.getRefreshToken());
    }

    @Override
    public UserLoginResultModel register(HttpServletResponse response, String openId) {
        UserEntity user = new UserEntity().setOpenId(openId);
        int count = mapperFactory.user.selectCount(user);
        Assert.isTrue(count == 0, "账号已存在");
        mapperFactory.user.insertSelective(user);
        AppTokenData tokenData = new AppTokenData().setId(user.getId());
        TokenInfo tokenInfo = new TokenInfo().setData(tokenData).setType("user");
        TokenUtils.login(response, tokenInfo);
        return new UserLoginResultModel(tokenInfo.getAssessToken(), tokenInfo.getRefreshToken());
    }
}
