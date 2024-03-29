package com.free.controller.admin;

import com.fanglin.common.annotation.NoToken;
import com.fanglin.common.annotation.Token;
import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.free.controller.common.BaseController;
import com.free.core.others.AdminTokenData;
import com.free.model.admin.account.AccountListModel;
import com.free.model.admin.account.AddAccountModel;
import com.free.model.admin.account.AdminLoginResultModel;
import com.free.model.admin.account.UpdateAccountModel;
import com.free.model.admin.module.AddModuleModel;
import com.free.model.admin.module.ModuleListModel;
import com.free.model.admin.module.ModuleTreeModel;
import com.free.model.admin.module.UpdateModuleModel;
import com.free.model.admin.permissions.PermissionsListModel;
import com.free.model.admin.permissions.UpdatePermissionsModel;
import com.free.model.admin.role.AddRoleModel;
import com.free.model.admin.role.RoleListModel;
import com.free.model.admin.role.UpdateRoleModel;
import com.free.service.admin.RoleService;
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
import java.util.List;


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
public class RoleController extends BaseController {
    @Autowired
    RoleService roleService;

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

    @ApiOperation("系统模块树")
    @PostMapping("moduleTree")
    public Ajax<List<ModuleTreeModel>> moduleTree() {
        return Ajax.ok(roleService.moduleTree());
    }

    @ApiOperation("左侧菜单树")
    @PostMapping("leftMenuTree")
    public Ajax<List<ModuleTreeModel>> leftMenuTree(AdminTokenData tokenData) {
        return Ajax.ok(roleService.leftMenuTree(tokenData.getId()));
    }

    @ApiOperation("模块列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "parentId", value = "父节点id，根节点为0", required = true),
    })
    @PostMapping("moduleList")
    public Ajax<PageResult<ModuleListModel>> moduleList(Integer parentId, Page page) {
        return Ajax.ok(roleService.moduleList(parentId, page));
    }

    @ApiOperation("添加系统模块")
    @PostMapping("addModule")
    public Ajax addModule(AddModuleModel module) {
        roleService.addModule(module);
        return Ajax.ok();
    }

    @ApiOperation("删除系统模块")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "模块id", required = true)
    })
    @PostMapping("deleteModule")
    public Ajax deleteModule(@RequestParam Integer id) {
        roleService.deleteModule(id);
        return Ajax.ok();
    }

    @ApiOperation("修改系统模块")
    @PostMapping("updateModule")
    public Ajax updateModule(UpdateModuleModel module) {
        roleService.updateModule(module);
        return Ajax.ok();
    }

    @ApiOperation("添加角色")
    @PostMapping("addRole")
    public Ajax addRole(AddRoleModel role) {
        roleService.addRole(role);
        return Ajax.ok();
    }

    @ApiOperation("删除角色")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "角色id", required = true)
    })
    @PostMapping("deleteRole")
    public Ajax deleteRole(@RequestParam Integer id) {
        roleService.deleteRole(id);
        return Ajax.ok();
    }

    @ApiOperation("修改角色")
    @PostMapping("updateRole")
    public Ajax updateRole(UpdateRoleModel role) {
        roleService.updateRole(role);
        return Ajax.ok();
    }

    @ApiOperation("角色列表")
    @PostMapping("roleList")
    public Ajax<PageResult<RoleListModel>> roleList(Page page) {
        return Ajax.ok(roleService.roleList(page));
    }

    @ApiOperation("添加权限")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "权限名称", required = true)
    })
    @PostMapping("addPermissions")
    public Ajax addPermissions(@RequestParam String name) {
        roleService.addPermissions(name);
        return Ajax.ok();
    }

    @ApiOperation("删除权限")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "权限id", required = true)
    })
    @PostMapping("deletePermissions")
    public Ajax deletePermissions(@RequestParam Integer id) {
        roleService.deletePermissions(id);
        return Ajax.ok();
    }

    @ApiOperation("修改权限")
    @PostMapping("updatePermissions")
    public Ajax updatePermissions(UpdatePermissionsModel permissions) {
        roleService.updatePermissions(permissions);
        return Ajax.ok();
    }

    @ApiOperation("权限列表")
    @PostMapping("permissionsList")
    public Ajax<PageResult<PermissionsListModel>> permissionsList(Page page) {
        return Ajax.ok(roleService.permissionsList(page));
    }

}
