package com.ipaozha.crm.dao;

import org.apache.ibatis.jdbc.SQL;


public class CategorySqlProvider {

    public String findById(Integer categoryId) {
//        String sql = "select * from category where category_id = " + categoryId + ";";
        return new SQL() {{
            SELECT("*");
            FROM("category");
            WHERE("category_id = "+ categoryId);

        }}.toString();
    }
}
