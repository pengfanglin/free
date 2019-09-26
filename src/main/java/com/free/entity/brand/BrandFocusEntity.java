package com.free.entity.brand;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 品牌关注
 *
 * @author 彭方林
 * @date 2019-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "brand_focus")
public class BrandFocusEntity implements Serializable {

    /**
     * 主键
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 品牌id
     */
    private Integer brandId;

    /**
     * 创建时间
     */
    private Date createTime;
}
