package com.free.model.app.brand;

import com.free.enums.brand.BrandSearchTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 品牌搜索条件
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/26 0:19
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("品牌搜索条件")
public class BrandSearchModel {

    @ApiModelProperty("COMMON:普通返点 CASH:现金返点")
    BrandSearchTypeEnum type;

    @ApiModelProperty("店铺id")
    private Integer storeId;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("拼音")
    private String pinyin;
}
