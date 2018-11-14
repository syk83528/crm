package com.ipaozha.crm.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Comment {
    private Integer id;

    private String addressIp;

    private Integer articleId;

    private Integer parentId;

    private String content;

    private Integer personId;

    private Integer status;

    private Integer likeCount;

    private Date createTime;

    private Date updateTime;

    private String name;

    private String icon;

    public Comment(Integer id, String addressIp, Integer articleId, Integer parentId, String content, Integer personId, Integer status, Integer likeCount, Date createTime, Date updateTime, String name, String icon) {
        this.id = id;
        this.addressIp = addressIp;
        this.articleId = articleId;
        this.parentId = parentId;
        this.content = content;
        this.personId = personId;
        this.status = status;
        this.likeCount = likeCount;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.name = name;
        this.icon = icon;
    }

    public Comment() {
        super();
    }
}