package com.free.controller.app;

import com.fanglin.common.annotation.Token;
import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.core.page.Page;
import com.free.core.others.AppTokenData;
import com.free.entity.brand.BrandEntity;
import com.free.entity.brand.BrandFocusEntity;
import com.free.enums.brand.BrandSearchTypeEnum;
import com.free.model.app.brand.BrandSearchModel;
import com.free.model.app.brand.BrandSearchResultModel;
import com.free.service.app.BrandService;
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
 * 品牌
 *
 * @author 彭方林
 * @date 2019-09-26
 */
@RestController
@RequestMapping("/app/brand/")
@Api(value = "/app/brand/", tags = "APP-品牌")
@Token("user")
public class BrandController {

    @Autowired
    BrandService brandService;

    @ApiOperation("添加品牌关注")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "brandId", value = "品牌id", required = true),
    })
    @PostMapping("addFocus")
    public Ajax addFocus(AppTokenData token, @RequestParam Integer brandId) {
        return Ajax.ok(brandService.addFocus(token.getId(), brandId));
    }

    @ApiOperation("删除品牌关注")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "关注记录id", required = true),
    })
    @PostMapping("deleteBrandFocus")
    public Ajax deleteBrandFocus(Integer id) {
        brandService.cancelFocus(id);
        return Ajax.ok();
    }

    @ApiOperation("品牌搜索")
    @PostMapping("brandSearch")
    public Ajax<List<BrandSearchResultModel>> brandSearch(AppTokenData token, BrandSearchModel search, Page page) {
        return Ajax.ok(brandService.brandSearch(search.setUserId(token.getId()), page));
    }
}
