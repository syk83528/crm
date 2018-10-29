package com.ipaozha.crm.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CommentForm {

    @NotNull(message = "文章id不能为空")
    private Integer articleId;

    private Integer parentId;

    private Integer personId;

    @NotNull(message = "评论内容不能为空")
    private String content;

    private String addressIp;

}
