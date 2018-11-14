package com.ipaozha.crm;

import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.form.UserForm;
import com.ipaozha.crm.pojo.User;
import com.ipaozha.crm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void login() {
    }

    @Test
    public void regist() throws CrmException {

        UserForm userForm = new UserForm();
        userForm.setName("admin");
        userForm.setGender(0);
        userForm.setPassword("admin");

        User user = userService.regist(userForm);

        log.info(user.toString());
    }
}