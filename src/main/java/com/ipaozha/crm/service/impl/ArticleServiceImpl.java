package com.ipaozha.crm.service.impl;

import com.ipaozha.crm.Response.RespEnum;
import com.ipaozha.crm.dao.ArticleMapper;
import com.ipaozha.crm.dao.ContentMapper;
import com.ipaozha.crm.exception.CrmAuthException;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.pojo.Article;
import com.ipaozha.crm.pojo.User;
import com.ipaozha.crm.service.ArticleService;
import com.ipaozha.crm.service.UserService;
import com.ipaozha.crm.utils.CrmUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article saveArticle(Map<String, Object> map) throws CrmException, CrmAuthException {
        //这里还需要当前用户的信息
        User user = CrmUtils.getLoginUser(request);
        if (null == user) {
            throw new CrmAuthException();
        }

        try {
            //取值
            Article article = new Article();
            String title = (String) map.get("title");
            Integer categoryId = new Integer((String) map.get("category"));
            String content = (String) map.get("my-text");
            article.setTitle(title);
            article.setCategoryId(categoryId);
            article.setContent(content);
            article.setAuthorId(user.getId());

            int result = articleMapper.insertSelective(article);
            if (result > 0) {
                return article;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CrmException(RespEnum.article_insert_error);
        }
    }
}
