package com.free.service.admin.impl;

import com.fanglin.common.annotation.LocalCache;
import com.fanglin.common.core.others.Assert;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.fanglin.common.util.*;
import com.free.entity.common.BannerEntity;
import com.free.entity.common.RegionEntity;
import com.free.mapper.MapperFactory;
import com.free.model.admin.banner.AddBannerModel;
import com.free.model.admin.banner.AdminBannerListModel;
import com.free.model.admin.banner.UpdateBannerModel;
import com.free.model.admin.region.AddRegionModel;
import com.free.model.admin.region.AdminRegionListModel;
import com.free.model.admin.region.UpdateRegionModel;
import com.free.service.admin.AdminCommonService;
import com.github.pagehelper.PageRowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 后台公共服务
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:38
 **/
@Service
public class AdminCommonServiceImpl implements AdminCommonService {

    @Autowired
    MapperFactory mapperFactory;

    @Override
    public void addRegion(AddRegionModel region) {
        ValidatorUtils.validate(region);
        int count = mapperFactory.region.insertSelective(BeanUtils.copy(region, RegionEntity.class));
        Assert.isTrue(count > 0, "添加失败");
    }

    @Override
    public void deleteRegion(Integer id) {
        int count = mapperFactory.region.deleteByPrimaryKey(id);
        Assert.isTrue(count > 0, "删除失败");
    }

    @Override
    public void updateRegion(UpdateRegionModel region) {
        ValidatorUtils.validate(region);
        int count = mapperFactory.region.updateByPrimaryKeySelective(BeanUtils.copy(region, RegionEntity.class));
        Assert.isTrue(count > 0, "修改失败");
    }

    @Override
    public PageResult<AdminRegionListModel> regionList(Page page) {
        PageRowBounds rowBounds = PageUtils.rowBounds(page);
        return new PageResult<>(mapperFactory.region.adminRegionList(rowBounds), rowBounds.getTotal());
    }

    @Override
    public void addBanner(AddBannerModel banner) {
        ValidatorUtils.validate(banner);
        String fileName = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + new Random().nextInt(Integer.MAX_VALUE);
        String url = String.format("/html/banner/%s.html", fileName);
        String htmlStyle = SpringUtils.getBean(AdminCommonService.class).defaultHtmlStyleContent();
        if (htmlStyle == null) {
            htmlStyle = "";
        }
        OthersUtils.writeHtml(UploadUtils.getFileSaveParentPath() + url, banner.getContent(), htmlStyle);
        int count = mapperFactory.banner.insertSelective(BeanUtils.copy(banner, BannerEntity.class).setUrl(url));
        Assert.isTrue(count > 0, "添加失败");
    }

    @LocalCache(value = "'html_style'", timeout = 1, unit = TimeUnit.DAYS)
    @Override
    public String defaultHtmlStyleContent() {
        return mapperFactory.htmlStyle.defaultHtmlStyleContent();
    }

    @Override
    public void deleteBanner(Integer id) {
        int count = mapperFactory.banner.deleteByPrimaryKey(id);
        Assert.isTrue(count > 0, "删除失败");
    }

    @Override
    public void updateBanner(UpdateBannerModel banner) {
        ValidatorUtils.validate(banner);
        String url = mapperFactory.banner.urlById(banner.getId());
        if (OthersUtils.isEmpty(url)) {
            String fileName = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + new Random().nextInt(Integer.MAX_VALUE);
            url = String.format("/html/banner/%s.html", fileName);
        }
        String htmlStyle = SpringUtils.getBean(AdminCommonService.class).defaultHtmlStyleContent();
        if (htmlStyle == null) {
            htmlStyle = "";
        }
        OthersUtils.writeHtml(UploadUtils.getFileSaveParentPath() + url, banner.getContent(), htmlStyle);
        int count = mapperFactory.banner.updateByPrimaryKeySelective(BeanUtils.copy(banner, BannerEntity.class));
        Assert.isTrue(count > 0, "修改失败");
    }

    @Override
    public PageResult<AdminBannerListModel> bannerList(Page page) {
        PageRowBounds rowBounds = PageUtils.rowBounds(page);
        return new PageResult<>(mapperFactory.banner.adminBannerList(rowBounds), rowBounds.getTotal());
    }
}
