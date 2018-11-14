package com.ipaozha.crm.exception;

import com.ipaozha.crm.Response.Resp;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(CrmException.class)
    @ResponseBody
    public Resp handleException(CrmException exception) {
        return Resp.error(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(CrmAuthException.class)
    public String hanleAuthException(CrmAuthException exception) {
        return "/admin/login";
    }

    @ExceptionHandler(Exception.class)
    public Void handleException(Exception exception) {


        return null;
    }
}
