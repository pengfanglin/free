package com.free.service.app;


import java.util.List;

/**
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface AppCommonService {
    /**
     * 发送验证码
     *
     * @param mobile 手机号
     * @param type   类型
     */
    void sendCode(String mobile, String type);

    /**
     * 发送测试验证码
     *
     * @param mobile 手机号
     * @param type   类型
     */
    String sendTestCode(String mobile, String type);

    /**
     * 区域缓存
     *
     * @return
     */
    List<String> regionCache();
}
