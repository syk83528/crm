package com.ipaozha.crm.service;

import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.form.UserForm;
import com.ipaozha.crm.pojo.User;
import org.apache.commons.lang3.StringUtils;

public interface UserService {
    User login(String username, String password) throws CrmException;

    User regist(UserForm userForm) throws CrmException;

    User findUser(Integer id);
}
