package com.ipaozha.crm.dao;

import com.ipaozha.crm.pojo.ArticleIcon;

public interface ArticleIconMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleIcon record);

    int insertSelective(ArticleIcon record);

    ArticleIcon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleIcon record);

    int updateByPrimaryKey(ArticleIcon record);
}