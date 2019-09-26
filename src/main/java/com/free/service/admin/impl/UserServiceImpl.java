package com.free.service.admin.impl;

import com.fanglin.common.core.others.Assert;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.fanglin.common.util.PageUtils;
import com.free.mapper.MapperFactory;
import com.free.model.admin.user.UserListModel;
import com.free.model.admin.user.UserListSearch;
import com.free.service.admin.UserService;
import com.github.pagehelper.PageRowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@Service("adminUserService")
public class UserServiceImpl implements UserService {

    @Autowired
    MapperFactory mapperFactory;


    @Override
    public PageResult<UserListModel> userList(UserListSearch search, Page page) {
        PageRowBounds rowBounds = PageUtils.rowBounds(page);
        return new PageResult<>(mapperFactory.user.userList(search, rowBounds), rowBounds.getTotal());
    }

    @Override
    public void deleteUser(Integer id) {
        int count = mapperFactory.user.deleteByPrimaryKey(id);
        Assert.isTrue(count > 0, "删除失败");
    }
}
