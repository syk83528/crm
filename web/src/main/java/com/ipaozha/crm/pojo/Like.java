package com.ipaozha.crm.pojo;

import java.util.Date;

public class Like {
    private Integer id;

    private Integer likeId;

    private Integer articleId;

    private Date createTime;

    private Date updateTime;

    public Like(Integer id, Integer likeId, Integer articleId, Date createTime, Date updateTime) {
        this.id = id;
        this.likeId = likeId;
        this.articleId = articleId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Like() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}