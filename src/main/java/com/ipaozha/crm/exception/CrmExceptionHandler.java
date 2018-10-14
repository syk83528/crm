package com.ipaozha.crm.exception;

import com.ipaozha.crm.Response.Resp;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理
 */
@ControllerAdvice
public class CrmExceptionHandler {

    @ExceptionHandler(CrmException.class)
    @ResponseBody
    public Resp handleException(CrmException exception) {
        return Resp.error(exception.getCode(), exception.getMessage());
    }
}
