package com.ipaozha.crm.controller.api;

import com.ipaozha.crm.Response.Resp;
import com.ipaozha.crm.Response.RespEnum;
import com.ipaozha.crm.controller.BaseController;
import com.ipaozha.crm.dao.ContentMapper;
import com.ipaozha.crm.exception.CrmAuthException;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.pojo.Article;
import com.ipaozha.crm.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/admin/article")
@Slf4j
public class ArticleApiController extends BaseController {

    @Value("${article-img}")
    private String articlePath;

    @Value("${web.upload}")
    private String rootPath;

    @Autowired
    private ContentMapper mapper;

    @RequestMapping("/publish")
    @ResponseBody
    public Resp publish(@RequestParam Map<String, Object> map) throws CrmException, CrmAuthException {
        Article article = articleService.saveArticle(map);
        return Resp.success(article);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, Object> upload(HttpSession session, @RequestParam(value = "editormd-image-file") MultipartFile file) throws CrmException {

        // 上传图片
        String uploadPath = FileUtils.upload(file, rootPath, articlePath);
        if (StringUtils.isBlank(uploadPath)) {
            throw new CrmException(RespEnum.image_upload_error);
        }

        Map<String, Object> map = new HashMap<>();
        //上传成功
        if (StringUtils.isNotBlank(uploadPath)) {
            map.put("success", 1);
            map.put("message", "成功");
            map.put("url", baseUploadPath + uploadPath);
        }else {
            map.put("success", 0);
            map.put("message", "上传失败！");
        }
        return map;
    }




}
