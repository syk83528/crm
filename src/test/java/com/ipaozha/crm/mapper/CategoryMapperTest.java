package com.ipaozha.crm.mapper;

import com.ipaozha.crm.dao.CategoryMapper;
import com.ipaozha.crm.pojo.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryMapperTest {

    @Autowired
    private CategoryMapper mapper;

    @Test
    public void test() {
        Category category = mapper.selectByPrimaryKey(1);
        log.info(category.toString());
    }
}