package com.free.mapper;

import com.free.entity.common.RegionEntity;
import com.free.model.admin.region.AdminRegionListModel;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 区域
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
public interface RegionMapper extends Mapper<RegionEntity> {

    /**
     * 区域列表缓存
     *
     * @return
     */
    @Select("select name from region order by sort desc, id")
    List<String> regionCache();

    /**
     * 后台区域列表
     *
     * @param rowBounds
     * @return
     */
    @Select("select id,name,sort,create_time from region order by id")
    List<AdminRegionListModel> adminRegionList(PageRowBounds rowBounds);
}
