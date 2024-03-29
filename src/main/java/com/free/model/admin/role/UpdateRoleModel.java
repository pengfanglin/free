package com.free.model.admin.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 修改角色
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:40
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("修改角色")
public class UpdateRoleModel {

    @ApiModelProperty("ID")
    @NotNull(message = "ID不能为空")
    private Integer id;

    @ApiModelProperty("角色名称")
    @Length(max = 20, message = "角色名称最多20个字符")
    private String name;

    @ApiModelProperty("模块")
    @Length(max = 1000, message = "模块最多1000个字符")
    private String moduleIds;

    @ApiModelProperty("权限")
    @Length(max = 1000, message = "权限最多1000个字符")
    private String permissionsIds;

    @ApiModelProperty("是否禁用")
    private Boolean disable;
}
