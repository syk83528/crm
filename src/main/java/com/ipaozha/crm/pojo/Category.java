package com.ipaozha.crm.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private String categoryIcon;

    private Date createTime;

    private Date updateTime;

    public Category(Integer categoryId, String categoryName, Integer categoryType, String categoryIcon, Date createTime, Date updateTime) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.categoryIcon = categoryIcon;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Category() {
        super();
    }
}