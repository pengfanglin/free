package com.free.service.admin;

import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.free.model.admin.account.AccountListModel;
import com.free.model.admin.account.AddAccountModel;
import com.free.model.admin.account.AdminLoginResultModel;
import com.free.model.admin.account.UpdateAccountModel;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface RoleService {

    /**
     * 系统账号列表
     *
     * @param account 账号
     * @param disable 是否禁用
     * @param page    分页
     * @return
     */
    PageResult<AccountListModel> accountList(String account, Boolean disable, Page page);

    /**
     * 修改系统账号
     *
     * @param account 系统账号
     */
    void updateAccount(UpdateAccountModel account);

    /**
     * 添加系统账号
     *
     * @param account 账号
     */
    void addAccount(AddAccountModel account);

    /**
     * 删除系统账号
     *
     * @param id 账号id
     */
    void deleteAccount(Integer id);

    /**
     * 登录
     *
     * @param response
     * @param account  账号
     * @param password 密码
     * @return
     */
    AdminLoginResultModel login(HttpServletResponse response, String account, String password);
}
