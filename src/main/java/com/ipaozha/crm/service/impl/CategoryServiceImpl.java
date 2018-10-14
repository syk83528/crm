package com.ipaozha.crm.service.impl;

import com.ipaozha.crm.form.CategoryForm;
import com.ipaozha.crm.mapper.CategoryMapper;
import com.ipaozha.crm.pojo.Category;
import com.ipaozha.crm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper mapper;

    @Override
    public Page<Category> list(Integer page, Integer size) {
        PageRequest request = PageRequest.of(page, size);
        Page<Category> categoryPage = mapper.findAll(request);
        return categoryPage;
    }

    @Override
    public Category save(CategoryForm categoryForm) {
        Category category = new Category();
        category.setCategoryName(categoryForm.getName());
        category.setCategoryIcon(categoryForm.getIcon());
        category.setCategoryType(categoryForm.getType());
        // 保存更新一起
        if (categoryForm.getId() != null) {
            category.setCategoryId(categoryForm.getId());
        }
        Category result = mapper.save(category);
        return result;
    }

    @Override
    public Category findOne(Integer id) {
        Category category = mapper.getOne(id);
        return category;
    }
}
