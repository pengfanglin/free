package com.free.controller.app;

import com.fanglin.common.annotation.Token;
import com.fanglin.common.core.others.Ajax;
import com.free.model.app.store.StoreFloorListModel;
import com.free.model.app.store.StoreSearchResultModel;
import com.free.service.app.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 免税店
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@RestController
@RequestMapping("/app/store/")
@Token("user")
@Api(value = "/app/store/", tags = {"APP-免税店"})
public class StoreController {

    @Autowired
    StoreService storeService;


    @ApiOperation("免税店搜索")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "店铺名称")
    })
    @PostMapping("storeSearch")
    public Ajax<List<StoreSearchResultModel>> storeSearch(String name) {
        return Ajax.ok(storeService.storeSearch(name));
    }

    @ApiOperation("免税店楼层信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "storeId", value = "店铺id", required = true)
    })
    @PostMapping("storeFloorList")
    public Ajax<List<StoreFloorListModel>> storeFloorList(@RequestParam Integer storeId) {
        return Ajax.ok(storeService.storeFloorList(storeId));
    }
}
