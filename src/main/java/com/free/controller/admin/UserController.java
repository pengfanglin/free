package com.free.controller.admin;

import com.fanglin.common.annotation.Token;
import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.free.controller.common.BaseController;
import com.free.model.admin.user.UserListModel;
import com.free.model.admin.user.UserListSearch;
import com.free.service.admin.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/19 0:20
 **/
@RestController("adminUserController")
@RequestMapping("/admin/user/")
@Api(value = "/admin/user/", tags = {"后台-用户"})
@Token("admin")
public class UserController extends BaseController {
    @Autowired
    UserService memberService;

    @ApiOperation("用户列表")
    @PostMapping("userList")
    public Ajax<PageResult<UserListModel>> userList(UserListSearch search, Page page) {
        return Ajax.ok(memberService.userList(search, page));
    }

    @ApiOperation("删除用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "用户id", required = true)
    })
    @PostMapping("deleteUser")
    public Ajax deleteUser(@RequestParam Integer id) {
        memberService.deleteUser(id);
        return Ajax.ok();
    }

}
