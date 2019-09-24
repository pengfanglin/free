package com.free.controller.admin;

import com.fanglin.common.annotation.NoToken;
import com.fanglin.common.annotation.Token;
import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.free.controller.common.BaseController;
import com.free.model.admin.account.AccountListModel;
import com.free.model.admin.account.AddAccountModel;
import com.free.model.admin.account.AdminLoginResultModel;
import com.free.model.admin.account.UpdateAccountModel;
import com.free.service.admin.AdminRoleService;
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
 * 系统
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/19 0:20
 **/
@RestController
@RequestMapping("/admin/role/")
@Api(value = "/admin/role/", tags = {"后台-权限"})
@Token("admin")
public class AdminRoleController extends BaseController {
    @Autowired
    AdminRoleService roleService;

    @ApiOperation("登录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "account", value = "账号", required = true),
        @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    @PostMapping("login")
    @NoToken
    public Ajax<AdminLoginResultModel> login(HttpServletResponse response, @RequestParam String account, @RequestParam String password) {
        return Ajax.ok(roleService.login(response, account, password));
    }

    @ApiOperation("系统账号列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "account", value = "用户名"),
        @ApiImplicitParam(name = "disable", value = "是否禁用")
    })
    @PostMapping("accountList")
    public Ajax<PageResult<AccountListModel>> accountList(String account, Boolean disable, Page page) {
        return Ajax.ok(roleService.accountList(account, disable, page));
    }

    @ApiOperation("修改系统账号")
    @PostMapping("updateAccount")
    public Ajax updateAccount(UpdateAccountModel account) {
        roleService.updateAccount(account);
        return Ajax.ok();
    }

    @ApiOperation("添加系统账号")
    @PostMapping("addAccount")
    public Ajax addAccount(AddAccountModel account) {
        roleService.addAccount(account);
        return Ajax.ok();
    }

    @ApiOperation("删除系统账号")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "账号id", required = true),
    })
    @PostMapping("deleteAccount")
    public Ajax deleteAccount(Integer id) {
        roleService.deleteAccount(id);
        return Ajax.ok();
    }

}
