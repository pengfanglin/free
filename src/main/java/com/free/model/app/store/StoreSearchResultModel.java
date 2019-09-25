package com.free.model.app.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 免税店搜索结果
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/26 0:19
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("免税店搜索结果")
public class StoreSearchResultModel {

    @ApiModelProperty("店铺id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;
}
