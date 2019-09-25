package com.free.service.admin.impl;

import com.fanglin.common.annotation.LocalCache;
import com.fanglin.common.core.others.Assert;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.fanglin.common.util.*;
import com.free.entity.common.BannerEntity;
import com.free.entity.store.StoreEntity;
import com.free.mapper.MapperFactory;
import com.free.model.admin.store.AddStoreModel;
import com.free.model.admin.store.AdminStoreListModel;
import com.free.model.admin.store.UpdateStoreModel;
import com.free.service.admin.AdminStoreService;
import com.free.util.PinYinUtils;
import com.github.pagehelper.PageRowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 后台免税店
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:38
 **/
@Service
public class AdminStoreServiceImpl implements AdminStoreService {

    @Autowired
    MapperFactory mapperFactory;

    @Override
    public void addStore(AddStoreModel store) {
        ValidatorUtils.validate(store);
        StoreEntity storeEntity = BeanUtils.copy(store, StoreEntity.class);
        storeEntity.setShortPinyin(PinYinUtils.toFirstChar(store.getName()).toUpperCase());
        int count = mapperFactory.store.insertSelective(storeEntity);
        Assert.isTrue(count > 0, "添加失败");
    }

    @Override
    public void deleteStore(Integer id) {
        int count = mapperFactory.store.deleteByPrimaryKey(id);
        Assert.isTrue(count > 0, "删除失败");
    }

    @Override
    public void updateStore(UpdateStoreModel store) {
        ValidatorUtils.validate(store);
        StoreEntity storeEntity = BeanUtils.copy(store, StoreEntity.class);
        if (OthersUtils.notEmpty(store.getName())) {
            storeEntity.setShortPinyin(PinYinUtils.toFirstChar(store.getName()).toUpperCase());
        }
        int count = mapperFactory.store.updateByPrimaryKeySelective(storeEntity);
        Assert.isTrue(count > 0, "修改失败");
    }

    @Override
    public PageResult<AdminStoreListModel> storeList(Page page) {
        PageRowBounds rowBounds = PageUtils.rowBounds(page);
        return new PageResult<>(mapperFactory.store.adminStoreList(rowBounds), rowBounds.getTotal());
    }
}
