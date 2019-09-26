package com.free.model.admin.brand;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * 修改品牌
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:42
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("修改品牌")
public class UpdateBrandModel {

    @ApiModelProperty(value = "品牌id", required = true)
    @NotNull(message = "品牌id不能为空")
    private Integer id;

    @ApiModelProperty(value = "品牌名称")
    @Length(max = 20, message = "品牌名称最大20个字符")
    private String name;

    @ApiModelProperty(value = "普通返点")
    @Max(value = 100, message = "普通返点最大100")
    private Float commonRebate;

    @ApiModelProperty(value = "现金返点")
    @Max(value = 100, message = "现金返点最大100")
    private Float cashRebate;

    @ApiModelProperty(value = "logo")
    @Length(max = 100, message = "logo最大100个字符")
    private String logo;
}
