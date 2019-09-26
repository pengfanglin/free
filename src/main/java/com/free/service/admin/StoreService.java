package com.free.service.admin;

import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.free.model.admin.floor.AddFloorModel;
import com.free.model.admin.floor.AdminFloorListModel;
import com.free.model.admin.floor.UpdateFloorModel;
import com.free.model.admin.store.AddStoreModel;
import com.free.model.admin.store.AdminStoreListModel;
import com.free.model.admin.store.UpdateStoreModel;

/**
 * 后台免税店
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface StoreService {

    /**
     * 增加店铺
     *
     * @param store 店铺名称
     */
    void addStore(AddStoreModel store);

    /**
     * 删除店铺
     *
     * @param id 店铺id
     */
    void deleteStore(Integer id);

    /**
     * 修改店铺
     *
     * @param store 店铺
     */
    void updateStore(UpdateStoreModel store);

    /**
     * 店铺列表
     *
     * @param page
     */
    PageResult<AdminStoreListModel> storeList(Page page);

    /**
     * 添加漏乘
     *
     * @param floor
     */
    void addFloor(AddFloorModel floor);

    /**
     * 删除楼层
     *
     * @param floor
     */
    void deleteFloor(Integer id);

    /**
     * 修改楼层
     *
     * @param floor
     */
    void updateFloor(UpdateFloorModel floor);

    /**
     * 楼层列表
     *
     * @param floor
     */
    PageResult<AdminFloorListModel> floorList(Integer storeId, Page page);
}
