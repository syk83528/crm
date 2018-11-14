package com.ipaozha.crm.controller.api;

import com.ipaozha.crm.Response.Resp;
import com.ipaozha.crm.Response.RespEnum;
import com.ipaozha.crm.controller.BaseController;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.form.CommentForm;
import com.ipaozha.crm.pojo.Comment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("/comment")
@Controller
public class CommentApiController extends BaseController {


    @RequestMapping("/add")
    @ResponseBody
    public Resp add(CommentForm commentForm, BindingResult bindingResult,
                    Map<String, Object> map) throws CrmException {
        if (bindingResult.hasErrors()) {
            throw new CrmException(RespEnum.params_error);
        }

        Comment comment = commentService.add(commentForm);
//        commentService.add()
        return Resp.success(comment);
    }
}
