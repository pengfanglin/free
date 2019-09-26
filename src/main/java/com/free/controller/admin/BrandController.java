package com.free.controller.admin;

import com.fanglin.common.annotation.Token;
import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.free.entity.brand.BrandEntity;
import com.free.entity.brand.BrandFocusEntity;
import com.free.model.admin.brand.AddBrandModel;
import com.free.model.admin.brand.AdminBrandListModel;
import com.free.model.admin.brand.UpdateBrandModel;
import com.free.service.admin.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 品牌
 *
 * @author 彭方林
 * @date 2019-09-26
 */
@RestController("adminBrandController")
@RequestMapping("/admin/brand/")
@Api(value = "/admin/brand/", tags = {"后台-品牌"})
@Token("admin")
public class BrandController {

    @Autowired
    BrandService brandService;

    @ApiOperation("添加品牌")
    @PostMapping("addBrand")
    public Ajax addBrand(AddBrandModel brand) {
        brandService.addBrand(brand);
        return Ajax.ok();
    }

    @ApiOperation("删除品牌")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "品牌id", required = true)
    })
    @PostMapping("deleteBrand")
    public Ajax deleteBrand(Integer id) {
        brandService.deleteBrand(id);
        return Ajax.ok();
    }

    @ApiOperation("修改品牌")
    @PostMapping("updateBrand")
    public Ajax updateBrand(UpdateBrandModel brand) {
        brandService.updateBrand(brand);
        return Ajax.ok();
    }

    @ApiOperation("品牌列表")
    @PostMapping("brandList")
    public Ajax<PageResult<AdminBrandListModel>> brandList(Page page) {
        return Ajax.ok(brandService.brandList(page));
    }

}
