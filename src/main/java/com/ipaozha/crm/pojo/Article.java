package com.ipaozha.crm.pojo;

import java.util.Date;

public class Article {
    private Integer id;

    private String title;

    private String titlepic;

    private Integer authorId;

    private String type;

    private Integer status;

    private Integer categoryId;

    private String categoryName;

    private Boolean allowComment;

    private Integer likeCount;

    private Integer collectCount;

    private Date createTime;

    private Date updateTime;

    private String content;

    public Article(Integer id, String title, String titlepic, Integer authorId, String type, Integer status, Integer categoryId, String categoryName, Boolean allowComment, Integer likeCount, Integer collectCount, Date createTime, Date updateTime, String content) {
        this.id = id;
        this.title = title;
        this.titlepic = titlepic;
        this.authorId = authorId;
        this.type = type;
        this.status = status;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.allowComment = allowComment;
        this.likeCount = likeCount;
        this.collectCount = collectCount;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.content = content;
    }

    public Article() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitlepic() {
        return titlepic;
    }

    public void setTitlepic(String titlepic) {
        this.titlepic = titlepic == null ? null : titlepic.trim();
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Boolean getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(Boolean allowComment) {
        this.allowComment = allowComment;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}