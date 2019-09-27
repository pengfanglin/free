package com.free.model.admin.permissions;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 权限列表
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:38
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("权限列表")
public class PermissionsListModel {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("权限名称")
    private String name;

    @ApiModelProperty("创建时间")
    private Date createTime;
}
