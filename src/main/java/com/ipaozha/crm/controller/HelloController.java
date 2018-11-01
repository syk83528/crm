package com.ipaozha.crm.controller;

import com.ipaozha.crm.Response.Resp;
import com.ipaozha.crm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @RequestMapping("/test")
    @ResponseBody
    public Resp apiHello() {
        User user = new User();
        user.setName("admin");
        user.setPassword("987654321");
        user.setId(22);
        user.setNickName("张三");
        return Resp.success(user);
    }
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
    @RequestMapping("/zz")
    public String zz() {
        return "zz.html";
    }

}
