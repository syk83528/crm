package com.ipaozha.crm.Response;

import lombok.Getter;
@Getter
public enum RespEnum {
    success(0, "成功"),

    params_error(100, "参数错误"),
    sql_error(101, "数据库操作异常"),
    image_upload_error(101, "图片上传失败"),
    username_password_empty(200, "用户名或密码不能为空"),
    username_password_error(201, "用户名或密码错误"),
    user_exist_error(202, "用户名已被注册"),
    user_regist_error(203, "注册失败"),
    category_file_empty_error(300, "分类图片不能为空"),
    category_type_exist_error(301, "分类类型已存在"),
    article_insert_error(400, "创建文章失败"),
    comment_insert_error(450, "创建评论失败"),
    comment_timeShort_error(451, "两次发布时间小于10秒"),
    ;

    private Integer code;
    private String msg;

    RespEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
