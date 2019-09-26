package com.free.mapper;

import com.free.entity.brand.BrandEntity;
import com.free.model.admin.brand.AdminBrandListModel;
import com.free.model.app.brand.BrandSearchModel;
import com.free.model.app.brand.BrandSearchResultModel;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 品牌
 *
 * @author 彭方林
 * @date 2019-09-26
 */
public interface BrandMapper extends Mapper<BrandEntity> {

    /**
     * 品牌搜索
     */
    List<BrandSearchResultModel> brandSearch(BrandSearchModel search, RowBounds rowBounds);

    /**
     * 后台品牌搜索
     *
     * @param rowBounds
     * @return
     */
    List<AdminBrandListModel> adminBrandList(PageRowBounds rowBounds);
}