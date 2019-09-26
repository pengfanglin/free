package com.free.service.app.impl;

import com.fanglin.common.core.others.Assert;
import com.fanglin.common.core.others.BusinessException;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.fanglin.common.util.OthersUtils;
import com.fanglin.common.util.PageUtils;
import com.free.entity.brand.BrandEntity;
import com.free.entity.brand.BrandFocusEntity;
import com.free.enums.brand.BrandSearchTypeEnum;
import com.free.mapper.MapperFactory;
import com.free.model.app.brand.BrandSearchModel;
import com.free.model.app.brand.BrandSearchResultModel;
import com.free.service.app.BrandService;
import com.free.util.PinYinUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 品牌
 *
 * @author 彭方林
 * @date 2019-09-26
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    MapperFactory mapperFactory;


    @Override
    public int addFocus(Integer userId, Integer brandId) {
        try {
            return mapperFactory.brandFocus.insertSelective(
                new BrandFocusEntity().setUserId(userId).setBrandId(brandId)
            );
        } catch (DuplicateKeyException e) {
            throw new BusinessException("不能重复关注");
        }
    }

    @Override
    public void cancelFocus(Integer focusId) {
        int count = mapperFactory.brandFocus.deleteByPrimaryKey(focusId);
        Assert.isTrue(count > 0, "取消关注成功");
    }

    @Override
    public List<BrandSearchResultModel> brandSearch(BrandSearchModel search, Page page) {
        search.setPinyin(OthersUtils.isEmpty(search.getName()) ? null : PinYinUtils.toFirstChar(search.getName()).toUpperCase());
        RowBounds rowBounds = PageUtils.page(page);
        List<BrandSearchResultModel> data = mapperFactory.brand.brandSearch(search, rowBounds);
        data.forEach(item -> {
            if (item.getFocusId() == null) {
                item.setFocusId(0);
            }
        });
        return data;
    }
}
