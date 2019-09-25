package com.free.entity.store;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 免税店
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/8/28 13:06
 **/
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "store")
public class StoreEntity {
    /**
     * 主键
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 拼音缩写
     */
    private String shortPinyin;
    /**
     * logo
     */
    private String logo;
    /**
     * 普通返点
     */
    private Float commonRebate;
    /**
     * 现金返点
     */
    private Float cashRebate;
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
