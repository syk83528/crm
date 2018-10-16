package com.ipaozha.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ipaozha.crm.dao.CategoryMapper;
import com.ipaozha.crm.form.CategoryForm;
import com.ipaozha.crm.pojo.Category;
import com.ipaozha.crm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public PageInfo<Category> list(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Category> list = categoryMapper.list();
        PageInfo<Category> pageInfo = new PageInfo<>(list);
        return pageInfo;
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
        int result = categoryMapper.insertSelective(category);
        if (0 == result) {
            return null;
        }
        return category;
    }

    @Override
    public Category findOne(Integer id) {
        Category category = categoryMapper.selectByPrimaryKey(id);

        return category;
    }
}
