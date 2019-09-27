package com.free.mapper;

import com.fanglin.common.core.page.Page;
import com.free.entity.role.PermissionsEntity;
import com.free.model.admin.permissions.PermissionsListModel;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 权限
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:44
 **/
public interface PermissionsMapper extends Mapper<PermissionsEntity> {

    /**
     * 权限列表
     *
     * @param page
     * @return
     */
    @Select("select id,name,create_time from permissions order by id")
    List<PermissionsListModel> permissionsList(Page page);
}
