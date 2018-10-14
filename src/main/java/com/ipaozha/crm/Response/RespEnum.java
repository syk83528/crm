package com.ipaozha.crm.Response;

import lombok.Getter;
@Getter
public enum RespEnum {
    success(0, "成功"),

    params_error(100, "参数错误")
    ;

    private Integer code;
    private String msg;

    RespEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
