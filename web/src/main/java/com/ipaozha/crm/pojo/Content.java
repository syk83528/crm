package com.ipaozha.crm.pojo;

import java.io.Serializable;

public class Content implements Serializable {


    private static final long serialVersionUID = -3262526765382485502L;

    private Integer id;

    private String title;

    private String content;

    public Content(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Content() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}