package com.free.model.admin.floor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 后台免税店楼层信息列表
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:42
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("后台免税店楼层信息列表")
public class AdminFloorListModel {

    @ApiModelProperty("楼层id")
    private Integer id;

    @ApiModelProperty("楼层号")
    private Integer no;

    @ApiModelProperty("楼层图片")
    private String img;

    @ApiModelProperty("创建时间")
    private Date createTime;
}
