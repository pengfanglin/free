package com.free.model.app.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 免税店楼层信息
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/26 0:19
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("免税店楼层信息")
public class StoreFloorListModel {

    @ApiModelProperty("楼层号")
    private Integer no;

    @ApiModelProperty("图片")
    private String img;
}
