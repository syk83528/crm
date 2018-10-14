package com.ipaozha.crm.service;

import com.ipaozha.crm.form.CategoryForm;
import com.ipaozha.crm.pojo.Category;
import org.springframework.data.domain.Page;

public interface CategoryService {

    Page<Category> list(Integer page,Integer size);

    Category save(CategoryForm category);

    Category findOne(Integer id);
}
