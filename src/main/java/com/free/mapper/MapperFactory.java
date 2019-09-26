package com.free.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通用mapper的总仓库
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:34
 **/
@Component
public class MapperFactory {
    @Autowired
    public CommonMapper common;
    @Autowired
    public UserMapper user;
    @Autowired
    public RegionMapper region;
    @Autowired
    public AccountMapper account;
    @Autowired
    public BannerMapper banner;
    @Autowired
    public HtmlStyleMapper htmlStyle;
    @Autowired
    public StoreMapper store;
    @Autowired
    public FloorMapper floor;
    @Autowired
    public BrandMapper brand;
    @Autowired
    public BrandFocusMapper brandFocus;
}
