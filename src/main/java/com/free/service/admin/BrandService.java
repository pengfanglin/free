package com.free.service.admin;

import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.free.model.admin.brand.AddBrandModel;
import com.free.model.admin.brand.AdminBrandListModel;
import com.free.model.admin.brand.UpdateBrandModel;

/**
 * 品牌 服务类
 *
 * @author 彭方林
 * @date 2019-09-26
 */
public interface BrandService {
    /**
     * 添加品牌
     *
     * @param brand
     * @return
     */
    void addBrand(AddBrandModel brand);

    /**
     * 删除品牌
     *
     * @param id 主键
     * @return
     */
    void deleteBrand(Integer id);

    /**
     * 修改品牌
     *
     * @param brand
     * @return
     */
    void updateBrand(UpdateBrandModel brand);

    /**
     * 品牌列表
     *
     * @param page
     * @return
     */
    PageResult<AdminBrandListModel> brandList(Page page);

}
