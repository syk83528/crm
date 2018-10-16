package com.ipaozha.crm.dao;

import com.ipaozha.crm.pojo.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryDaoTest {

    @Autowired
    private CategoryMapper categoryDao;

    @Test
    public void insertByMap() {
    }

    @Test
    public void select() {
        Category category = categoryDao.selectByPrimaryKey(2);

        log.info(category.toString());

    }
    
    @Test
    public void save() {
        Category category = new Category();
        category.setCategoryIcon("xxxxxxxx");
        category.setCategoryName("天上的");
        category.setCategoryType(35);

        int result = categoryDao.insertSelective(category);
    }
}