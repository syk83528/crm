package com.ipaozha.crm.controller;

import com.ipaozha.crm.service.ArticleService;
import com.ipaozha.crm.service.CategoryService;
import com.ipaozha.crm.service.CommentService;
import com.ipaozha.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class BaseController {

    @Autowired
    public CategoryService categoryService;

    @Autowired
    public UserService userService;

    @Autowired
    public ArticleService articleService;

    @Autowired
    public CommentService commentService;

    @Value("${base-upload-path}")
    public String baseUploadPath;

}
