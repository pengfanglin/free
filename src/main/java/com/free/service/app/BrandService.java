package com.free.service.app;


import com.fanglin.common.core.page.Page;
import com.free.enums.brand.BrandSearchTypeEnum;
import com.free.model.app.brand.BrandSearchModel;
import com.free.model.app.brand.BrandSearchResultModel;

import java.util.List;

/**
 * 品牌
 *
 * @author 彭方林
 * @date 2019-09-26
 */
public interface BrandService {

    /**
     * 添加关注
     *
     * @param userId  用户id
     * @param brandId 品牌id
     * @return
     */
    int addFocus(Integer userId, Integer brandId);

    /**
     * 取消关注
     *
     * @param focusId 关注记录id
     * @return
     */
    void cancelFocus(Integer focusId);

    /**
     * 品牌搜索
     *
     * @return
     */
    List<BrandSearchResultModel> brandSearch(BrandSearchModel search, Page page);
}
