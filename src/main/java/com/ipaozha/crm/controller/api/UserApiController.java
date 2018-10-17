package com.ipaozha.crm.controller.api;

import com.ipaozha.crm.Response.Resp;
import com.ipaozha.crm.Response.RespEnum;
import com.ipaozha.crm.controller.BaseController;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.form.CategoryForm;
import com.ipaozha.crm.pojo.Category;
import com.ipaozha.crm.pojo.User;
import com.ipaozha.crm.service.CategoryService;
import com.ipaozha.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/api/admin")
public class UserApiController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    @ResponseBody
    public Resp add(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      Map<String, Object> map) throws Exception {
        User user = userService.login(username, password);

        return Resp.success(user);
    }


    @PostMapping("/regist")
    @ResponseBody
    public Resp regist(@RequestParam("username") String username,
                    @RequestParam("password") String password,
                    Map<String, Object> map) throws Exception {
        User user = userService.login(username, password);

        return Resp.success(user);
    }

}