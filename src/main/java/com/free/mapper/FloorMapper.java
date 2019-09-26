package com.free.mapper;

import com.free.entity.store.FloorEntity;
import com.free.model.admin.floor.AdminFloorListModel;
import com.free.model.admin.store.AdminStoreListModel;
import com.free.model.app.store.StoreFloorListModel;
import com.free.model.app.store.StoreSearchResultModel;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 免税店楼层信息
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
public interface FloorMapper extends Mapper<FloorEntity> {

    /**
     * 后台免税店楼层信息列表
     *
     * @param rowBounds
     * @return
     */
    @Select("select * from floor where store_id=#{storeId} order by id desc")
    List<AdminFloorListModel> adminFloorList(@Param("storeId") Integer storeId, PageRowBounds rowBounds);

    /**
     * 店铺下楼层号id
     *
     * @param storeId 店铺id
     * @return
     */
    @Select("select id from floor where store_id=#{storeId} and no=#{no} limit 1")
    Integer noExist(@Param("storeId") Integer storeId, @Param("no") Integer no);

    /**
     * 判断店铺下楼层号是否存在
     *
     * @param id 店铺id
     * @param no 楼层号
     * @return
     */
    @Select("select count(*) from floor where store_id=(select store_id from floor where id=#{id}) and no=#{no} and id!=#{id}")
    int getIdByNo(@Param("id") Integer id, @Param("no") Integer no);

    /**
     * 免税店楼层信息
     *
     * @param storeId 店铺id
     * @return
     */
    @Select("select no,img from floor where store_id=#{storeId} order by no")
    List<StoreFloorListModel> storeFloorList(@Param("storeId") Integer storeId);
}
