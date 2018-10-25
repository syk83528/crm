package com.ipaozha.crm.controller.content;

import com.ipaozha.crm.VO.ArticleVO;
import com.ipaozha.crm.controller.BaseController;
import com.ipaozha.crm.dao.ArticleMapper;
import com.ipaozha.crm.dao.ContentMapper;
import com.ipaozha.crm.pojo.Article;
import com.ipaozha.crm.pojo.Category;
import com.ipaozha.crm.pojo.Content;
import com.ipaozha.crm.pojo.User;
import com.ipaozha.crm.utils.CrmUtils;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/article")
public class ArticleController extends BaseController {
    @Autowired
    private ArticleMapper articleMapper;

    //发布页面
    @RequestMapping("/add")
    public String add(Map<String, Object> map) {

        List<Category> categoryList = categoryService.list();
        //加点category
        map.put("categoryList", categoryList);
        return "admin/article/articleAdd";
    }

    //详情页面
    @RequestMapping("/{id}")
    public String article(@PathVariable("id") Integer id, Map<String, Object> map) {
        Article article = articleMapper.selectByPrimaryKey(id);
        //现在不需要先转html
//        String contentHtml = CrmUtils.mdToHtml(article.getContent());
//        article.setContent(contentHtml);
        //去一下作者的用户名
        User user = userService.findUser(article.getId());
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article, articleVO);
        articleVO.setIconImage(user.getIconImage());

        map.put("content", articleVO);

        return "admin/article/articleDetail";
    }
}
