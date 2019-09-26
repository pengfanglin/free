package com.free.service.admin.impl;

import com.fanglin.common.core.others.Assert;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.fanglin.common.util.BeanUtils;
import com.fanglin.common.util.PageUtils;
import com.fanglin.common.util.ValidatorUtils;
import com.free.entity.brand.BrandEntity;
import com.free.mapper.MapperFactory;
import com.free.model.admin.brand.AddBrandModel;
import com.free.model.admin.brand.AdminBrandListModel;
import com.free.model.admin.brand.UpdateBrandModel;
import com.free.service.admin.BrandService;
import com.free.util.PinYinUtils;
import com.github.pagehelper.PageRowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 品牌 服务实现类
 *
 * @author 彭方林
 * @date 2019-09-26
 */
@Service("adminBrandService")
public class BrandServiceImpl implements BrandService {
    @Autowired
    MapperFactory mapperFactory;

    @Override
    public void addBrand(AddBrandModel brand) {
        ValidatorUtils.validate(brand);
        BrandEntity brandEntity = BeanUtils.copy(brand, BrandEntity.class);
        if (brand.getName() != null) {
            brandEntity.setShortPinyin(PinYinUtils.toFirstChar(brand.getName()).toUpperCase());
        }
        mapperFactory.brand.insertSelective(brandEntity);
    }

    @Override
    public void deleteBrand(Integer id) {
        int count = mapperFactory.brand.deleteByPrimaryKey(id);
        Assert.isTrue(count > 0, "删除失败");
    }

    @Override
    public void updateBrand(UpdateBrandModel brand) {
        ValidatorUtils.validate(brand);
        BrandEntity brandEntity = BeanUtils.copy(brand, BrandEntity.class);
        if (brand.getName() != null) {
            brandEntity.setShortPinyin(PinYinUtils.toFirstChar(brand.getName()).toUpperCase());
        }
        int count = mapperFactory.brand.updateByPrimaryKeySelective(brandEntity);
        Assert.isTrue(count > 0, "修改失败");
    }

    @Override
    public PageResult<AdminBrandListModel> brandList(Page page) {
        PageRowBounds rowBounds = PageUtils.rowBounds(page);
        return new PageResult<>(mapperFactory.brand.adminBrandList(rowBounds), rowBounds.getTotal());
    }
}
