package com.free.model.admin.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import java.util.Date;

/**
 * 后台免税店列表
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:42
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("后台免税店列表")
public class AdminStoreListModel {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("普通返点")
    private Float commonRebate;

    @ApiModelProperty("现金返点")
    private Float cashRebate;

    @ApiModelProperty("logo")
    private String logo;

    @ApiModelProperty("权重")
    private Float sort;

    @ApiModelProperty("创建时间")
    private Date createTime;
}
