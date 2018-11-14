package com.ipaozha.crm.pojo;

import java.util.Date;

public class CommentLike {
    private Integer id;

    private Integer commentId;

    private Integer authorId;

    private String name;

    private String email;

    private String content;

    private Integer likeCount;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public CommentLike(Integer id, Integer commentId, Integer authorId, String name, String email, String content, Integer likeCount, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.commentId = commentId;
        this.authorId = authorId;
        this.name = name;
        this.email = email;
        this.content = content;
        this.likeCount = likeCount;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CommentLike() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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