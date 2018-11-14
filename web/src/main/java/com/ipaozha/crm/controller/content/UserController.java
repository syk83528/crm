package com.ipaozha.crm.controller.content;

import com.ipaozha.crm.constant.WebConst;
import com.ipaozha.crm.form.UserForm;
import com.ipaozha.crm.pojo.User;
import com.ipaozha.crm.utils.CrmUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/admin")
@Slf4j
public class UserController {

    @RequestMapping("/login")
    public String login(HttpSession session) {
        //判断是否已登录
        User user = (User) session.getAttribute(WebConst.LOGIN_SESSION_KEY);

        if (null != user) {

            return "admin/index";
        }
        //这里其实还可以再判断一下管理员权限
        return "admin/login";
    }

    @RequestMapping("/regist")
    public String regist(HttpServletRequest request) {

        return "admin/regist";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        return "admin/index";
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response) {
        session.removeAttribute(WebConst.LOGIN_SESSION_KEY);
        Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, "");
        cookie.setValue(null);
        cookie.setMaxAge(0);// 立即销毁cookie
        cookie.setPath("/");
        response.addCookie(cookie);
        try {
            response.sendRedirect("/admin/login");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("注销失败", e);
        }
    }
}
