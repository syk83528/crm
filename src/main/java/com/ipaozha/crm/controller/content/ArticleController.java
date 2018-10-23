package com.ipaozha.crm.controller.content;

import com.ipaozha.crm.dao.ContentMapper;
import com.ipaozha.crm.pojo.Content;
import com.ipaozha.crm.utils.CrmUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ContentMapper mapper;

    @RequestMapping("/{id}")
    public String article(@PathVariable("id") Integer id, Map<String, Object> map) {
        Content content = mapper.selectByPrimaryKey(id);
        String contentHtml = CrmUtils.mdToHtml(content.getContent());
        content.setContent(contentHtml);
        map.put("content", content);
        return "markHtml";
    }
}
