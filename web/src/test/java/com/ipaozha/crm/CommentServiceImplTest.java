package com.ipaozha.crm;

import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.form.CommentForm;
import com.ipaozha.crm.pojo.Comment;
import com.ipaozha.crm.service.CommentService;
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
public class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;

    @Test
    public void add() {
        CommentForm commentForm = new CommentForm();
        commentForm.setArticleId(1);
        commentForm.setContent("爱的方式很多很多返回个");

        try {
            Comment comment = commentService.add(commentForm);
            log.info(comment.toString());

        } catch (CrmException e) {
            e.printStackTrace();

        }

    }
}