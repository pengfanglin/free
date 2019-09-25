package com.free.service.admin;


import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.free.model.admin.banner.AddBannerModel;
import com.free.model.admin.banner.AdminBannerListModel;
import com.free.model.admin.banner.UpdateBannerModel;
import com.free.model.admin.region.AddRegionModel;
import com.free.model.admin.region.AdminRegionListModel;
import com.free.model.admin.region.UpdateRegionModel;

import java.util.List;

/**
 * 后台公共服务
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface AdminCommonService {

    /**
     * 增加区域
     *
     * @param region 区域名称
     */
    void addRegion(AddRegionModel region);

    /**
     * 删除区域
     *
     * @param id 区域id
     */
    void deleteRegion(Integer id);

    /**
     * 修改区域
     *
     * @param region 区域
     */
    void updateRegion(UpdateRegionModel region);

    /**
     * 区域列表
     *
     * @param page
     */
    PageResult<AdminRegionListModel> regionList(Page page);

    /**
     * 添加轮播图
     *
     * @param banner
     */
    void addBanner(AddBannerModel banner);

    /**
     * 删除轮播图
     *
     * @param id
     */
    void deleteBanner(Integer id);

    /**
     * 修改轮播图
     *
     * @param banner
     */
    void updateBanner(UpdateBannerModel banner);

    /**
     * 轮播图列表
     *
     * @param page
     * @return
     */
    PageResult<AdminBannerListModel> bannerList(Page page);

    /**
     * 默认html样式内容
     *
     * @return
     */
    String defaultHtmlStyleContent();
}
