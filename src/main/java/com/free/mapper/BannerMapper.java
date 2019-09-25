package com.free.mapper;

import com.free.entity.common.BannerEntity;
import com.free.model.admin.banner.AdminBannerListModel;
import com.free.model.app.common.BannerListModel;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 轮播图
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
public interface BannerMapper extends Mapper<BannerEntity> {

    /**
     * 区域列表缓存
     *
     * @return
     */
    @Select("select img,title,url from banner order by sort desc,id desc")
    List<BannerListModel> bannerCache();

    /**
     * 后台区域列表
     *
     * @param rowBounds
     * @return
     */
    @Select("select id,img,title,url,sort,create_time from banner order by id desc")
    List<AdminBannerListModel> adminBannerList(PageRowBounds rowBounds);

    /**
     * 通过id查询url
     *
     * @param id 轮播图id
     * @return
     */
    @Select("select url from banner where id=#{id}")
    String urlById(@Param("id") Integer id);
}
