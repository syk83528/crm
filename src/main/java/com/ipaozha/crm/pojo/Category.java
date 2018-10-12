package com.ipaozha.crm.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@Proxy(lazy = false)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    /** 分类名称 */
    private String categoryName;
    /** '分类类型' */
    private Integer categoryType;
    /** 分类icon */
    private String categoryIcon;
    /** '创建时间' */
    private Date createTime;
    /** '更新时间' */
    private Date updateTime;
}
