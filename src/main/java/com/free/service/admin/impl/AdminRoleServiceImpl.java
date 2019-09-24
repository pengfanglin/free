package com.free.service.admin.impl;

import com.fanglin.common.core.others.Assert;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.fanglin.common.core.token.TokenInfo;
import com.fanglin.common.util.*;
import com.free.core.others.AdminTokenData;
import com.free.entity.role.AccountEntity;
import com.free.mapper.MapperFactory;
import com.free.model.admin.account.AccountListModel;
import com.free.model.admin.account.AddAccountModel;
import com.free.model.admin.account.AdminLoginResultModel;
import com.free.model.admin.account.UpdateAccountModel;
import com.free.service.admin.AdminRoleService;
import com.github.pagehelper.PageRowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 系统服务实现类
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:44
 **/
@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    @Autowired
    MapperFactory mapperFactory;

    @Override
    public PageResult<AccountListModel> accountList(String account, Boolean disable, Page page) {
        PageRowBounds rowBounds = PageUtils.rowBounds(page);
        return new PageResult<>(mapperFactory.account.accountList(account, disable, rowBounds), rowBounds.getTotal());
    }

    @Override
    public void updateAccount(UpdateAccountModel account) {
        ValidatorUtils.validate(account);
        if (OthersUtils.notEmpty(account.getAccount())) {
            Assert.isTrue(mapperFactory.account.selectCount(new AccountEntity().setAccount(account.getAccount())) == 0, "账号已存在");
        }
        int count = mapperFactory.account.updateByPrimaryKeySelective(BeanUtils.copy(account, AccountEntity.class));
        Assert.isTrue(count > 0, "修改失败");
    }

    @Override
    public void addAccount(AddAccountModel account) {
        ValidatorUtils.validate(account);
        Assert.isTrue(mapperFactory.account.selectCount(new AccountEntity().setAccount(account.getAccount())) == 0, "账号已存在");
        AccountEntity accountEntity = BeanUtils.copy(account, AccountEntity.class);
        accountEntity
            .setSalt(UUID.randomUUID().toString().replace("-", ""))
            .setPassword(EncodeUtils.md5Encode(account.getPassword(), accountEntity.getSalt()));
        mapperFactory.account.insertSelective(accountEntity);
    }

    @Override
    public void deleteAccount(Integer id) {
        Assert.isTrue(mapperFactory.account.deleteByPrimaryKey(id) > 0, "删除失败");
    }

    @Override
    public AdminLoginResultModel login(HttpServletResponse response, String account, String password) {
        AccountEntity accountEntity = mapperFactory.account.login(account);
        Assert.notNull(accountEntity, "用户不存在");
        Assert.isFalse(accountEntity.getDisable(), "账号已冻结");
        Assert.isTrue(EncodeUtils.md5Encode(password, accountEntity.getSalt()).equals(accountEntity.getPassword()), "密码错误");
        AdminTokenData tokenData = new AdminTokenData(accountEntity.getId());
        TokenInfo tokenInfo = new TokenInfo().setData(tokenData).setType("admin").setRefreshTokenTimeout(0);
        TokenUtils.login(response, tokenInfo);
        return new AdminLoginResultModel(tokenInfo.getAssessToken(), tokenInfo.getRefreshToken());
    }
}
