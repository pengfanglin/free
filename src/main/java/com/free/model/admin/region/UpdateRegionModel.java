package com.free.model.admin.region;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 修改区域
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:42
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("修改区域")
public class UpdateRegionModel {

    @ApiModelProperty(value = "区域id", required = true)
    @NotBlank(message = "区域id不能为空")
    private Integer id;

    @ApiModelProperty(value = "名称")
    @Length(max = 50, message = "名称最大50个字符")
    private String name;

    @ApiModelProperty(value = "权重")
    private Float sort;
}
