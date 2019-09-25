package com.free.service.app;

import com.free.model.app.store.StoreSearchResultModel;

import java.util.List;

/**
 * 免税店
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface AppStoreService {

    /**
     * 免税店搜索
     *
     * @param name 店铺名称
     * @return
     */
    List<StoreSearchResultModel> storeSearch(String name);

}
