package com.ipaozha.crm.service.impl;

import com.ipaozha.crm.Response.RespEnum;
import com.ipaozha.crm.dao.UserMapper;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.form.UserForm;
import com.ipaozha.crm.pojo.User;
import com.ipaozha.crm.service.UserService;
import com.ipaozha.crm.utils.CodeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String username, String password) throws CrmException {
        //用户名密码不为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw  new CrmException(RespEnum.username_password_empty);
        }
        //用户名已存在
        String md5Password = CodeUtils.Md5encode(password);
        User user = userMapper.login(username, md5Password);
        if (null == user) {
            throw new CrmException(RespEnum.username_password_error);
        }

        return user;
    }

    @Override
    public User regist(UserForm userForm) throws CrmException {
        //判断为空
        //用户名密码不为空
        if (StringUtils.isBlank(userForm.getName()) || StringUtils.isBlank(userForm.getPassword())) {
            throw  new CrmException(RespEnum.username_password_empty);
        }
        //判断用户是否已存在
        User user = userMapper.getUserByUsername(userForm.getName());
        if (null != user) {
            throw new CrmException(RespEnum.user_exist_error);
        }
        user = new User();
        BeanUtils.copyProperties(userForm, user);
        String md5Password = CodeUtils.Md5encode(userForm.getPassword());
        user.setPassword(md5Password);
        int result = userMapper.insertSelective(user);
        if (result == 0) {
            throw new CrmException(RespEnum.user_regist_error);
        }

        return userMapper.selectByPrimaryKey(user.getId());
    }
}
