package com.free.mapper;

import com.free.entity.common.BannerEntity;
import com.free.model.admin.banner.AdminBannerListModel;
import com.free.model.app.common.BannerListModel;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * html样式
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
public interface HtmlStyleMapper extends Mapper<BannerEntity> {

    /**
     * 默认html样式内容
     *
     * @return
     */
    @Select("select content from html_style order by id limit 1")
    String defaultHtmlStyleContent();
}
