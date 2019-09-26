package com.free.entity.store;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 免税店楼层信息
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/8/28 13:06
 **/
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "floor")
public class FloorEntity {
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
     * 楼层号
     */
    private Integer no;
    /**
     * 店铺id
     */
    private String img;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
