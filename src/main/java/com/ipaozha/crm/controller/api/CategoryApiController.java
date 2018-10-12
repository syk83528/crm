package com.ipaozha.crm.controller.api;

import com.ipaozha.crm.form.CategoryForm;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api/category")
public class CategoryApiController {

    @PostMapping("/add")
    public String category(BindingResult bindingResult, @Valid CategoryForm categoryForm) {
        //验证权限

        //验证参数
//        if (bindingResult.hasErrors()) {
//            throw
//        }

        //保存

        //返回成功页面
        return "null";
    }
}
