package com.ipaozha.crm.form;

import lombok.Data;

@Data
public class ArticleForm {

    private String title;

    private Integer categoryId;

    private String type;

    private String text;
}
