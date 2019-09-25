package com.free.entity.common;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 轮播图
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/8/28 13:06
 **/
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "banner")
public class BannerEntity {
    /**
     * 主键
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    /**
     * 图片
     */
    private String img;
    /**
     * 标题
     */
    private String title;
    /**
     * 跳转链接
     */
    private String url;
    /**
     * 权重
     */
    private Float sort;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
