package com.ipaozha.crm.VO;

import lombok.Data;

import java.util.Date;
@Data
public class ArticleVO {
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

    /** 作者头像 */
    private String iconImage;
}
