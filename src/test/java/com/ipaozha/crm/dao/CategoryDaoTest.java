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

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryDaoTest {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("category_name", "师兄最爱");
        map.put("category_type", 101);
        map.put("category_icon", "xxxxxx");

        int result = categoryDao.insertByMap(map);

        Assert.assertNotEquals(0, result);
    }

    @Test
    public void select() {
        Category category = categoryDao.findById(2);

        log.info(category.toString());

    }
}