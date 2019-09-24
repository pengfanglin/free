package com.free.service.admin;


import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.free.model.admin.user.UserListModel;
import com.free.model.admin.user.UserListSearch;

/**
 * 后台用户服务
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface AdminUserService {


    /**
     * 用户列表
     *
     * @return
     */
    PageResult<UserListModel> userList(UserListSearch search, Page page);


    /**
     * 删除用户
     * @param id 会员id
     */
    void deleteUser(Integer id);
}
