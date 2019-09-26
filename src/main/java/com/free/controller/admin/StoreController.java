package com.free.controller.admin;

import com.fanglin.common.annotation.Token;
import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.free.model.admin.floor.AddFloorModel;
import com.free.model.admin.floor.AdminFloorListModel;
import com.free.model.admin.floor.UpdateFloorModel;
import com.free.model.admin.store.AddStoreModel;
import com.free.model.admin.store.AdminStoreListModel;
import com.free.model.admin.store.UpdateStoreModel;
import com.free.service.admin.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台免税店
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@RestController("adminStoreController")
@RequestMapping("/admin/store/")
@Token("admin")
@Api(value = "/admin/store/", tags = {"后台-免税店"})
public class StoreController {

    @Autowired
    StoreService storeService;

    @ApiOperation("添加店铺")
    @PostMapping("addStore")
    public Ajax addStore(AddStoreModel store) {
        storeService.addStore(store);
        return Ajax.ok();
    }

    @ApiOperation("删除店铺")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "店铺id", required = true),
    })
    @PostMapping("deleteStore")
    public Ajax deleteStore(@RequestParam Integer id) {
        storeService.deleteStore(id);
        return Ajax.ok();
    }

    @ApiOperation("修改店铺")
    @PostMapping("updateStore")
    public Ajax updateStore(UpdateStoreModel store) {
        storeService.updateStore(store);
        return Ajax.ok();
    }

    @ApiOperation("店铺列表")
    @PostMapping("storeList")
    public Ajax<PageResult<AdminStoreListModel>> storeList(Page page) {
        return Ajax.ok(storeService.storeList(page));
    }

    @ApiOperation("添加楼层")
    @PostMapping("addFloor")
    public Ajax addFloor(AddFloorModel floor) {
        storeService.addFloor(floor);
        return Ajax.ok();
    }

    @ApiOperation("删除楼层")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "楼层id", required = true),
    })
    @PostMapping("deleteFloor")
    public Ajax deleteFloor(@RequestParam Integer id) {
        storeService.deleteFloor(id);
        return Ajax.ok();
    }

    @ApiOperation("修改楼层")
    @PostMapping("updateFloor")
    public Ajax updateFloor(UpdateFloorModel floor) {
        storeService.updateFloor(floor);
        return Ajax.ok();
    }

    @ApiOperation("楼层列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "storeId", value = "免税店id", required = true),
    })
    @PostMapping("floorList")
    public Ajax<PageResult<AdminFloorListModel>> floorList(@RequestParam Integer storeId, Page page) {
        return Ajax.ok(storeService.floorList(storeId,page));
    }

}
