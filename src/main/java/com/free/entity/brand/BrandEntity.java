package com.free.entity.brand;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 品牌
 *
 * @author 彭方林
 * @date 2019-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "brand")
public class BrandEntity implements Serializable {

    /**
     * 主键
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 店铺id
     */
    private Integer storeId;

    /**
     * 名称
     */
    private String name;

    /**
     * 拼音简写
     */
    private String shortPinyin;

    /**
     * 基本返点
     */
    private Float commonRebate;

    /**
     * 现金返点
     */
    private Float cashRebate;

    /**
     * logo
     */
    private String logo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
