package com.ipaozha.crm.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Proxy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@Proxy(lazy = false)
@EntityListeners(AuditingEntityListener.class)
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
    @CreatedDate
    private Date createTime;
    /** '更新时间' */
    @LastModifiedDate
    private Date updateTime;
}
