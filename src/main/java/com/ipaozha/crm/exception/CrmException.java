package com.ipaozha.crm.exception;

import com.ipaozha.crm.Response.RespEnum;
import lombok.Data;

@Data
public class CrmException extends Exception{

    private Integer code;

    public CrmException(RespEnum respEnum) {
        super(respEnum.getMsg());
        this.code = respEnum.getCode();
    }

    public CrmException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
