package com.ipaozha.crm.controller.api;

import com.ipaozha.crm.Response.Resp;
import com.ipaozha.crm.Response.RespEnum;
import com.ipaozha.crm.controller.BaseController;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.form.CategoryForm;
import com.ipaozha.crm.pojo.Category;
import com.ipaozha.crm.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/api/admin/category")
@Slf4j
public class CategoryApiController extends BaseController {
    @Value("${user-icon}")
    private String categoryPath;

    @Value("${web.upload}")
    private String rootPath;

    @PostMapping("/add")
    public String add(@Valid CategoryForm categoryForm,
                      BindingResult bindingResult,
                      @RequestParam("file") MultipartFile file,
                      Map<String, Object> map) throws Exception {
        //验证权限
        log.info(categoryPath);
        //验证参数
        if (bindingResult.hasErrors()) {
            throw new CrmException(RespEnum.params_error);
        }
        //校验类型
        Category oldCategory = categoryService.findOneByType(categoryForm.getType());
        if (oldCategory != null) {
            throw new CrmException(RespEnum.category_type_exist_error);
        }
        // 上传图片
        String uploadPath = FileUtils.upload(file, rootPath, categoryPath);
        if (StringUtils.isBlank(uploadPath)) {
            throw new CrmException(RespEnum.image_upload_error);
        }
        // 数据存储
        categoryForm.setIcon(uploadPath);
        //保存
        Category result = categoryService.save(categoryForm);

        if (ObjectUtils.isEmpty(result)) {
            //失败界面
            return "common/error";
        }else {
            map.put("url", "/admin/category");
//            //成功界面
            return "common/success";
        }
    }

    @PostMapping("/update")
    public String update(@Valid CategoryForm categoryForm, BindingResult bindingResult, Map<String, Object> map) throws Exception {
        //验证权限

        //验证参数
        if (bindingResult.hasErrors()) {
            throw new CrmException(RespEnum.params_error);
        }

        //保存
        Category result = categoryService.save(categoryForm);
        if (ObjectUtils.isEmpty(result)) {
            //失败界面
            return "common/error";
        }else {
            map.put("url", "/admin/category");
//            //成功界面
            return "common/success";
        }
    }


    @GetMapping("/delete")
    public String delete(Integer id, Map<String, Object> map) throws Exception {
        int result = categoryService.delete(id);
        if (result > 0) {
            map.put("url", "/category");
//            //成功界面
            return "common/success";
        }else {
            //失败界面
            map.put("url", "/category");
            return "common/error";
        }
    }
}
