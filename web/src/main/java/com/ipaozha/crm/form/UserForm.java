package com.ipaozha.crm.form;

import lombok.Data;

@Data
public class UserForm {
    /** 用户名 */
    private String name;
    /** '性别0-男,1-女,2-保密' */
    private Integer gender;
    /** '密码' */
    private String password;
//    /** '角色:0-普通用户,1-管理员' */
//    private Integer role;
}
