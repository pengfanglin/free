package com.free.model.app.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 轮播图列表
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:42
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("轮播图列表")
public class BannerListModel {

    @ApiModelProperty("图片")
    private String img;

    @ApiModelProperty("跳转链接")
    private String url;

    @ApiModelProperty("标题")
    private String title;
}
