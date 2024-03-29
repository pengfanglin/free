package com.free.enums.others;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 验证码类型
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/16 20:27
 **/
@AllArgsConstructor
public enum CodeTypeEnum {

    /**
     * 验证码
     */
    CODE("SMS_173246287"),
    /**
     * 用户注册
     */
    USER_REGISTER("SMS_173246287");

    @Getter
    private String code;
}
