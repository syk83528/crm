package com.ipaozha.crm.controller.api;

import com.ipaozha.crm.Response.RespEnum;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.form.CategoryForm;
import com.ipaozha.crm.pojo.Category;
import com.ipaozha.crm.service.CategoryService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/api/category")
public class CategoryApiController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public String add(@Valid CategoryForm categoryForm,BindingResult bindingResult, Map<String, Object> map) throws Exception {
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
            map.put("url", "/category");
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
            map.put("url", "/category");
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
