package com.free.model.admin.region;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 后台区域列表
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:42
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("后台区域列表")
public class AdminRegionListModel {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("权重")
    private Float sort;

    @ApiModelProperty("创建时间")
    private Date createTime;
}
