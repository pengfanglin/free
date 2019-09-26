package com.free.model.app.brand;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 品牌搜索结果
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/26 0:19
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("品牌搜索结果")
public class BrandSearchResultModel {

    @ApiModelProperty("品牌id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("logo")
    private String logo;

    @ApiModelProperty("普通返点")
    private BigDecimal commonRebate;

    @ApiModelProperty("现金返点")
    private BigDecimal cashRebate;

    @ApiModelProperty("关注记录id")
    private Integer focusId;
}
