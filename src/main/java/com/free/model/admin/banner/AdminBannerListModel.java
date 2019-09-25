package com.free.model.admin.banner;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 后台轮播图列表
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:42
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("后台轮播图列表")
public class AdminBannerListModel {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("图片")
    private String img;

    @ApiModelProperty("跳转链接")
    private String url;

    @ApiModelProperty("权重")
    private Float sort;

    @ApiModelProperty("创建时间")
    private Date createTime;
}
