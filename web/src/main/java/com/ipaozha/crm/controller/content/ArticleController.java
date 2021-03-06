package com.ipaozha.crm.controller.content;

import com.github.pagehelper.PageInfo;
import com.ipaozha.crm.VO.ArticleVO;
import com.ipaozha.crm.controller.BaseController;
import com.ipaozha.crm.dao.ArticleMapper;
import com.ipaozha.crm.dao.ContentMapper;
import com.ipaozha.crm.pojo.*;
import com.ipaozha.crm.utils.CrmUtils;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ArticleController extends BaseController {
    @Autowired
    private ArticleMapper articleMapper;

    @RequestMapping("/admin/article")
    public String list(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        //管理员权限判断

        //获取数据
        PageInfo<Article> pageInfo = articleService.list(page, size);
        //处理一下content,获取前15个字
        for (Article article : pageInfo.getList()) {
            if (null != article.getContent() &&  article.getContent().length() >= 15) {
                String content = article.getContent().substring(0, 14);
                article.setContent(content);
            }
        }
        // 塞入数据
        map.put("articlePage", pageInfo);
        map.put("currentPage", page);
        map.put("size", size);
        return "admin/article/article";
    }

    //发布页面
    @RequestMapping("/admin/article/add")
    public String add(Map<String, Object> map) {

        List<Category> categoryList = categoryService.list();
        //加点category
        map.put("categoryList", categoryList);
        return "admin/article/articleAdd";
    }

    //详情页面
    @RequestMapping("/article/{id}")
    public String article(@PathVariable("id") Integer id, Map<String, Object> map) {
        Article article = articleMapper.selectByPrimaryKey(id);
        //现在不需要先转html
//        String contentHtml = CrmUtils.mdToHtml(article.getContent());
//        article.setContent(contentHtml);
        //去一下作者的用户名
        User user = userService.findUser(article.getAuthorId());
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article, articleVO);
        articleVO.setIconImage(user.getIconImage());

        map.put("content", articleVO);

        //获取评论列表
        List<Comment> commentList = commentService.list(article.getId());
        map.put("commentList", commentList);

        return "admin/article/articleDetail";
    }
}
