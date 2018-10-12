package com.ipaozha.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @RequestMapping("/api/hello")
    @ResponseBody
    public String apiHello() {
        return "{'a':'helloooooccccccc'}";
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
