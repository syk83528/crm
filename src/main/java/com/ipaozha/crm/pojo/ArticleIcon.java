package com.ipaozha.crm.pojo;

public class ArticleIcon {
    private Integer id;

    private String image;

    private String desc;

    public ArticleIcon(Integer id, String image, String desc) {
        this.id = id;
        this.image = image;
        this.desc = desc;
    }

    public ArticleIcon() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}