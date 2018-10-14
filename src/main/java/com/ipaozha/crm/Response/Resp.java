package com.ipaozha.crm.Response;

import lombok.Data;

@Data
public class Resp<T> {

    private Integer code;
    private String msg;
    private T data;

    public Resp(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Resp(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Resp success(Object data) {
        return new Resp(0, "成功", data);
    }

    public static Resp error(Integer code, String msg) {
        return new Resp(code, msg);
    }

    public static Resp error(RespEnum respEnum) {
        return new Resp(respEnum.getCode(), respEnum.getMsg());
    }

}
