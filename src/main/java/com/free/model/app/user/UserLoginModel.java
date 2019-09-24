package com.free.model.app.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 用户登录信息
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/8/28 13:06
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("用户登录信息")
public class UserLoginModel {
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("是否禁用")
    private Boolean disable;
}
