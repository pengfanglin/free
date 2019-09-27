package com.free.mapper;

import com.free.entity.role.RoleEntity;
import com.free.model.admin.role.RoleListModel;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 角色
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:39
 **/
public interface RoleMapper extends Mapper<RoleEntity> {

    /**
     * 角色列表
     *
     * @param page
     * @return
     */
    @Select("select id,name,disable,create_time,module_ids from role order by id")
    List<RoleListModel> roleList(PageRowBounds page);

    /**
     * 账号拥有的权限ids
     *
     * @param accountId 账号id
     * @return
     */
    @Select("SELECT GROUP_CONCAT(permissions_ids) AS permissions_ids FROM role WHERE FIND_IN_SET(id,(SELECT role_ids FROM admin_account WHERE id=#{accountId})) and disable=false")
    String accountPermissionsIds(Integer accountId);
}
