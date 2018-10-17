package com.ipaozha.crm.controller.api;

import com.ipaozha.crm.Response.Resp;
import com.ipaozha.crm.Response.RespEnum;
import com.ipaozha.crm.constant.WebConst;
import com.ipaozha.crm.controller.BaseController;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.form.CategoryForm;
import com.ipaozha.crm.form.UserForm;
import com.ipaozha.crm.pojo.Category;
import com.ipaozha.crm.pojo.User;
import com.ipaozha.crm.service.CategoryService;
import com.ipaozha.crm.service.UserService;
import com.ipaozha.crm.utils.CrmUtils;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/api/admin")
public class UserApiController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String add(@RequestParam("username") String username,
                    @RequestParam("password") String password,
                    HttpSession session, HttpServletResponse response) throws Exception {
        //获取用户信息
        User user = userService.login(username, password);

        //存储session
        session.setAttribute(WebConst.LOGIN_SESSION_KEY, user);

        //存储cookie
        CrmUtils.setCookie(response, user.getId());

        //返回首页
        return "admin/index";
    }


    @PostMapping("/regist")
    @ResponseBody
    public Resp regist(@Valid UserForm userForm, BindingResult bindResult,
                       Map<String, Object> map) throws Exception {
        if (bindResult.hasErrors()) {
            throw new CrmException(RespEnum.params_error);
        }

        User user = userService.regist(userForm);

        return Resp.success(user);
    }

}