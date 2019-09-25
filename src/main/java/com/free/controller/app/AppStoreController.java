package com.free.controller.app;

import com.fanglin.common.annotation.Token;
import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.free.model.admin.store.AddStoreModel;
import com.free.model.admin.store.AdminStoreListModel;
import com.free.model.admin.store.UpdateStoreModel;
import com.free.model.app.store.StoreSearchResultModel;
import com.free.service.admin.AdminStoreService;
import com.free.service.app.AppStoreService;
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
public class AppStoreController {

    @Autowired
    AppStoreService storeService;


    @ApiOperation("免税店搜索")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "店铺名称")
    })
    @PostMapping("storeSearch")
    public Ajax<List<StoreSearchResultModel>> storeSearch(String name) {
        return Ajax.ok(storeService.storeSearch(name));
    }

}
