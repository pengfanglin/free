package com.free.model.admin.brand;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 后台品牌列表
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:42
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("后台品牌列表")
public class AdminBrandListModel {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("店铺id")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("普通返点")
    private Float commonRebate;

    @ApiModelProperty("现金返点")
    private Float cashRebate;

    @ApiModelProperty("logo")
    private String logo;

    @ApiModelProperty("创建时间")
    private Date createTime;
}
