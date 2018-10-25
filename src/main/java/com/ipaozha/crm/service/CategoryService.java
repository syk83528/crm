package com.ipaozha.crm.service;

import com.github.pagehelper.PageInfo;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.form.CategoryForm;
import com.ipaozha.crm.pojo.Category;

import java.util.List;

public interface CategoryService {

    PageInfo<Category> list(Integer page, Integer size);

    List<Category> list();

    Category save(CategoryForm category) throws CrmException;

    Category findOne(Integer id);

    int delete(Integer id);

    Category findOneByType(Integer type);

    Integer findMaxType();
}
