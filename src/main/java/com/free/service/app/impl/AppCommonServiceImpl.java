package com.free.service.app.impl;

import com.fanglin.common.annotation.LocalCache;
import com.fanglin.common.util.JedisUtils;
import com.fanglin.common.util.OthersUtils;
import com.fanglin.common.util.SmsUtils;
import com.free.enums.others.RedisKeyEnum;
import com.free.mapper.MapperFactory;
import com.free.service.app.AppCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * 其他服务实现类
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@Service
public class AppCommonServiceImpl implements AppCommonService {

    @Autowired
    MapperFactory mapperFactory;

    @Override
    public void sendCode(String mobile, String type) {
        String code = OthersUtils.randomString(4);
        String key = String.format("%s:%s:%s:%s", RedisKeyEnum.CODE.getKey(), type, mobile, code);
        String params = String.format("{\"code\":\"%s\"}", code);
        SmsUtils.aliCode(mobile, "趣兼职", type, params);
        try (Jedis jedis = JedisUtils.getJedis()) {
            jedis.set(key, "", "ex", 600);
        }
    }

    @Override
    public String sendTestCode(String mobile, String type) {
        String code = OthersUtils.randomString(4);
        String key = String.format("%s:%s:%s:%s", RedisKeyEnum.CODE.getKey(), type, mobile, code);
        try (Jedis jedis = JedisUtils.getJedis()) {
            jedis.set(key, "", "ex", 600);
        }
        return code;
    }

    @Override
    @LocalCache(value = "'regionCache'", timeout = 1, unit = TimeUnit.DAYS)
    public List<String> regionCache() {
        return mapperFactory.region.regionCache();
    }
}
