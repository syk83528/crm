package com.ipaozha.crm.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String name;

    private Boolean gender;

    private String password;

    private Boolean role;

    private String iconImage;

    private Date createTime;

    private Date updateTime;

    public User(Integer id, String name, Boolean gender, String password, Boolean role, String iconImage, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.role = role;
        this.iconImage = iconImage;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }
}