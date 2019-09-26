package com.free.service.app;

import com.free.model.app.store.StoreFloorListModel;
import com.free.model.app.store.StoreSearchResultModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 免税店
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface StoreService {

    /**
     * 免税店搜索
     *
     * @param name 店铺名称
     * @return
     */
    List<StoreSearchResultModel> storeSearch(String name);

    /**
     * 免税店楼层信息
     * @param storeId 店铺id
     * @return
     */
    List<StoreFloorListModel> storeFloorList(Integer storeId);
}
