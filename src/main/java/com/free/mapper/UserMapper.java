package com.free.mapper;

import com.free.entity.user.UserEntity;
import com.free.model.admin.user.UserListModel;
import com.free.model.admin.user.UserListSearch;
import com.free.model.app.user.UserLoginModel;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 会员
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
public interface UserMapper extends Mapper<UserEntity> {


    /**
     * 会员登录
     *
     * @param account 账号
     * @return
     */
    @Select("select id,disable from user where open_id=#{openId}")
    UserLoginModel login(@Param("openId") String openId);

    /**
     * 用户列表
     *
     * @param rowBounds
     * @return
     */
    List<UserListModel> userList(UserListSearch search, PageRowBounds rowBounds);
}
