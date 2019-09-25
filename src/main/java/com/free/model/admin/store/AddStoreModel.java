package com.free.model.admin.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 添加免税店
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:42
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("添加免税店")
public class AddStoreModel {

    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称不能为空")
    @Length(max = 20, message = "名称最大20个字符")
    private String name;

    @ApiModelProperty(value = "普通返点", required = true)
    @NotNull(message = "请输入普通返点")
    @Max(value = 100, message = "普通返点最大100")
    private Float commonRebate;

    @ApiModelProperty(value = "现金返点", required = true)
    @NotNull(message = "请输入现金返点")
    @Max(value = 100, message = "现金返点最大100")
    private Float cashRebate;

    @ApiModelProperty(value = "logo", required = true)
    @NotNull(message = "请上传logo")
    @Length(max = 100, message = "logo最大100个字符")
    private String logo;

    @ApiModelProperty(value = "权重")
    private Float sort;
}
