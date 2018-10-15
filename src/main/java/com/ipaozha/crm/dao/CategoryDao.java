package com.ipaozha.crm.dao;

import com.ipaozha.crm.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.Map;

public interface CategoryDao {

    @Insert("insert into category(category_name,category_type,category_icon) values(#{category_name,jdbcType=VARCHAR}, #{category_type, jdbcType=INTEGER}, #{category_icon, jdbcType=VARCHAR})")
    int insertByMap(Map<String,Object> map);

    @Select("select * from category where category_id=#{category_id}")
    @Results(id = "BaseMap", value = {
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    Category findByCategoryId(Integer categoryId);


    @SelectProvider(type = CategorySqlProvider.class, method ="findById")
    @ResultMap("BaseMap")
    Category findById(Integer id);
}
