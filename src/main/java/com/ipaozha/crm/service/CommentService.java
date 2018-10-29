package com.ipaozha.crm.service;

import com.github.pagehelper.PageInfo;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.form.CommentForm;
import com.ipaozha.crm.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {

    Comment add(CommentForm commentForm) throws CrmException;

    List<Comment> list(Integer articleId);

    PageInfo<Comment> list(@Param("articleId") Integer articleId,
                           @Param("page") Integer page,
                           @Param("size") Integer size);
}
