package com.ipaozha.crm.service;

import com.github.pagehelper.PageInfo;
import com.ipaozha.crm.exception.CrmAuthException;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.form.ArticleForm;
import com.ipaozha.crm.pojo.Article;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ArticleService {
    Article saveArticle(ArticleForm articleForm) throws CrmException, CrmAuthException;

    PageInfo<Article> list(Integer page, Integer size);

}
