package com.free.mapper;

import com.free.entity.store.StoreEntity;
import com.free.model.admin.region.AdminRegionListModel;
import com.free.model.admin.store.AdminStoreListModel;
import com.free.model.app.store.StoreSearchResultModel;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 免税店
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
public interface StoreMapper extends Mapper<StoreEntity> {

    /**
     * 免税店搜索
     *
     * @return
     */
    List<StoreSearchResultModel> storeSearch(@Param("name") String name, @Param("pinyin") String pinyin);

    /**
     * 后台免税店列表
     *
     * @param rowBounds
     * @return
     */
    @Select("select * from store order by id desc")
    List<AdminStoreListModel> adminStoreList(PageRowBounds rowBounds);
}
