package com.free.service.app.impl;

import com.fanglin.common.util.OthersUtils;
import com.free.mapper.MapperFactory;
import com.free.model.app.store.StoreSearchResultModel;
import com.free.service.app.AppStoreService;
import com.free.util.PinYinUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 免税店
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 20:38
 **/
@Service
public class AppStoreServiceImpl implements AppStoreService {

    @Autowired
    MapperFactory mapperFactory;


    @Override
    public List<StoreSearchResultModel> storeSearch(String name) {
        String pinyin = null;
        if (OthersUtils.notEmpty(name)) {
            pinyin = PinYinUtils.toFirstChar(name).toUpperCase();
        }
        return mapperFactory.store.storeSearch(name, pinyin);
    }
}
