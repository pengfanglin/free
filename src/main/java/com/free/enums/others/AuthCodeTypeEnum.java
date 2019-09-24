package com.free.enums.others;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 需要鉴权的验证码类型
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/16 20:27
 **/
@AllArgsConstructor
public enum AuthCodeTypeEnum {

    /**
     * 找回密码
     */
    FIND_PASSWORD("SMS_173246287"),
    /**
     * 修改密码
     */
    UPDATE_PASSWORD("SMS_173246287");

    @Getter
    private String code;
}
