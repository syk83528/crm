package com.ipaozha.crm.pojo;

import java.util.Date;

public class Comment {
    private Integer id;

    private Integer parentId;

    private String content;

    private Integer articleId;

    private Integer personId;

    private Date createTime;

    private Date updateTime;

    public Comment(Integer id, Integer parentId, String content, Integer articleId, Integer personId, Date createTime, Date updateTime) {
        this.id = id;
        this.parentId = parentId;
        this.content = content;
        this.articleId = articleId;
        this.personId = personId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Comment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
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