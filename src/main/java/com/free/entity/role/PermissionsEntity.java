package com.free.entity.role;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 权限
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:43
 **/
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "permissions")
public class PermissionsEntity {
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
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
