package com.free.model.admin.banner;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 修改轮播图
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:42
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("修改轮播图")
public class UpdateBannerModel {

    @ApiModelProperty(value = "id", required = true)
    @NotNull(message = "id不能为空")
    private Integer id;

    @ApiModelProperty(value = "名称")
    @Length(max = 100, message = "图片最多100个字符")
    private String img;

    @ApiModelProperty(value = "标题")
    @Length(max = 50, message = "标题最多50个字符")
    private String title;

    @ApiModelProperty(value = "富文本内容,类型为内链时必传")
    private String content;

    @ApiModelProperty(value = "权重")
    private Float sort;
}
