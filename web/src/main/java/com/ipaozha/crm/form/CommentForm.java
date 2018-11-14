package com.ipaozha.crm.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CommentForm {

    @NotNull(message = "文章id不能为空")
    private Integer articleId;

    @NotNull(message = "昵称不能为空")
    private String name;

    @NotNull(message = "评论内容不能为空")
    private String content;

    private Integer parentId;

    private Integer personId;

    private String addressIp;

}
