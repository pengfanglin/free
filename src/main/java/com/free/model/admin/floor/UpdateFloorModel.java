package com.free.model.admin.floor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 修改楼层信息
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:42
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("修改楼层信息")
public class UpdateFloorModel {

    @ApiModelProperty(value = "楼层id", required = true)
    @NotNull(message = "楼层id不能为空")
    private Integer id;

    @ApiModelProperty(value = "楼层号")
    private Integer no;

    @ApiModelProperty(value = "楼层图片")
    @Length(max = 100, message = "楼层图片最大100个字符")
    private String img;

}
