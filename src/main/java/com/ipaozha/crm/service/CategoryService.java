package com.ipaozha.crm.service;

import com.github.pagehelper.PageInfo;
import com.ipaozha.crm.form.CategoryForm;
import com.ipaozha.crm.pojo.Category;

public interface CategoryService {

    PageInfo<Category> list(Integer page, Integer size);

    Category save(CategoryForm category);

    Category findOne(Integer id);

    int delete(Integer id);
}
