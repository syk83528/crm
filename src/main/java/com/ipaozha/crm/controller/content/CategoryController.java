package com.ipaozha.crm.controller.content;

import com.ipaozha.crm.Response.RespEnum;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.pojo.Category;
import com.ipaozha.crm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping
    public String category(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        //管理员权限判断

        //获取数据
        Page<Category> categoryPage = categoryService.list(page - 1, size);
        // 塞入数据
        map.put("categoryPage", categoryPage);
        map.put("currentPage", page);
        map.put("size", size);

        return "content/category";
    }

    @RequestMapping("/add")
    public String add() {
        return "content/categoryAdd";
    }

    @RequestMapping("/update")
    public String update(Integer id, Map<String, Object> map) throws CrmException {
        Category category = categoryService.findOne(id);
        if (category == null) {
            throw new CrmException(RespEnum.params_error);
        }
        map.put("category", category);
        return "content/categoryUpdate";
    }

}
