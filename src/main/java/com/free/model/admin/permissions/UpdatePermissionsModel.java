package com.free.model.admin.permissions;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 修改权限
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:40
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("修改权限")
public class UpdatePermissionsModel {

    @ApiModelProperty("权限id")
    @NotNull(message = "权限id不能为空")
    private Integer id;

    @ApiModelProperty("权限名称")
    @Length(max = 20, message = "权限名称最多20个字符")
    private String name;
}
