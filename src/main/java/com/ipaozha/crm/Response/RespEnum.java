package com.ipaozha.crm.Response;

import lombok.Getter;
@Getter
public enum RespEnum {
    success(0, "成功"),

    params_error(100, "参数错误"),
    username_password_empty(200, "用户名或密码不能为空"),
    username_password_error(201, "用户名或密码错误"),
    user_exist_error(202, "用户名已被注册"),
    user_regist_error(203, "注册失败"),
    ;

    private Integer code;
    private String msg;

    RespEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
