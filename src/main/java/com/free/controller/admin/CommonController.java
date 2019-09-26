package com.free.controller.admin;

import com.fanglin.common.annotation.Token;
import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.free.model.admin.banner.AddBannerModel;
import com.free.model.admin.banner.AdminBannerListModel;
import com.free.model.admin.banner.UpdateBannerModel;
import com.free.model.admin.region.AddRegionModel;
import com.free.model.admin.region.AdminRegionListModel;
import com.free.model.admin.region.UpdateRegionModel;
import com.free.service.admin.CommonService;
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
 * 后台公共服务
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@RestController("adminCommonController")
@RequestMapping("/admin/common/")
@Token("admin")
@Api(value = "/admin/common/", tags = {"后台-公共"})
public class CommonController {

    @Autowired
    CommonService commonService;

    @ApiOperation("添加区域")
    @PostMapping("addRegion")
    public Ajax addRegion(AddRegionModel region) {
        commonService.addRegion(region);
        return Ajax.ok();
    }

    @ApiOperation("删除区域")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "区域id", required = true),
    })
    @PostMapping("deleteRegion")
    public Ajax deleteRegion(@RequestParam Integer id) {
        commonService.deleteRegion(id);
        return Ajax.ok();
    }

    @ApiOperation("修改区域")
    @PostMapping("updateRegion")
    public Ajax addRegion(UpdateRegionModel region) {
        commonService.updateRegion(region);
        return Ajax.ok();
    }

    @ApiOperation("区域列表")
    @PostMapping("regionList")
    public Ajax<PageResult<AdminRegionListModel>> regionList(Page page) {
        return Ajax.ok(commonService.regionList(page));
    }

    @ApiOperation("添加轮播图")
    @PostMapping("addBanner")
    public Ajax addBanner(AddBannerModel banner) {
        commonService.addBanner(banner);
        return Ajax.ok();
    }

    @ApiOperation("删除轮播图")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "轮播图id", required = true),
    })
    @PostMapping("deleteBanner")
    public Ajax deleteBanner(@RequestParam Integer id) {
        commonService.deleteBanner(id);
        return Ajax.ok();
    }

    @ApiOperation("修改轮播图")
    @PostMapping("updateBanner")
    public Ajax updateBanner(UpdateBannerModel banner) {
        commonService.updateBanner(banner);
        return Ajax.ok();
    }

    @ApiOperation("轮播图列表")
    @PostMapping("bannerList")
    public Ajax<PageResult<AdminBannerListModel>> bannerList(Page page) {
        return Ajax.ok(commonService.bannerList(page));
    }
}
