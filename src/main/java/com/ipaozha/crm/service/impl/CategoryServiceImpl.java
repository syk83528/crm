package com.ipaozha.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ipaozha.crm.Response.RespEnum;
import com.ipaozha.crm.dao.CategoryMapper;
import com.ipaozha.crm.exception.CrmException;
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
    public Category save(CategoryForm categoryForm) throws CrmException {
        Category category = new Category();
        category.setCategoryName(categoryForm.getName());
        category.setCategoryIcon(categoryForm.getIcon());
        category.setCategoryType(categoryForm.getType());

        int result = 0;
        if (categoryForm.getId() != null) {
            // 更新
            category.setCategoryId(categoryForm.getId());
            result = categoryMapper.updateByPrimaryKeySelective(category);
        }else {
            // 插入
            try {
                result = categoryMapper.insertSelective(category);
            } catch (Exception e) {
                throw new CrmException(RespEnum.sql_error.getCode(), e.getMessage());
            }
        }

        //结果
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

    @Override
    public int delete(Integer id) {
        int result = categoryMapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public Category findOneByType(Integer type) {
        return categoryMapper.selectByType(type);
    }

    @Override
    public Integer findMaxType() {
        return categoryMapper.selectByMaxType();
    }
}
