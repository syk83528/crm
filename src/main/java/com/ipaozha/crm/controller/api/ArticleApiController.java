package com.ipaozha.crm.controller.api;

import com.ipaozha.crm.Response.Resp;
import com.ipaozha.crm.Response.RespEnum;
import com.ipaozha.crm.dao.ContentMapper;
import com.ipaozha.crm.pojo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleApiController {

    @Autowired
    private ContentMapper mapper;

    @RequestMapping("/publish")
    @ResponseBody
    public Resp publish(@RequestParam Map<String, Object> map) {

        Content content = new Content();

        content.setTitle((String) map.get("title"));
        content.setContent((String) map.get("my-text"));

        int result = mapper.insertSelective(content);

        if (result > 0) {
            return Resp.success(null);
        }else {
            return Resp.error(RespEnum.article_insert_error);
        }
    }



}
