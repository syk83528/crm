package com.ipaozha.crm.controller.api;

import com.ipaozha.crm.Response.Resp;
import com.ipaozha.crm.Response.RespEnum;
import com.ipaozha.crm.controller.BaseController;
import com.ipaozha.crm.dao.ContentMapper;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.pojo.Category;
import com.ipaozha.crm.pojo.Content;
import com.ipaozha.crm.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
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

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, Object> upload(HttpSession session, @RequestParam(value = "editormd-image-file") MultipartFile file) throws CrmException {

        //对图片名字进行一次转码


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
