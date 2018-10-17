package com.ipaozha.crm.dao;

import com.ipaozha.crm.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(String username, String md5Password);

    User getUserByUsername(String username);
}