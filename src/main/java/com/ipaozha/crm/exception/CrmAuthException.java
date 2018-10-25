package com.ipaozha.crm.exception;

import lombok.Data;

@Data
public class CrmAuthException extends Exception {

    private Integer code;
}
