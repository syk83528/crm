package com.ipaozha.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ipaozha.crm.Response.RespEnum;
import com.ipaozha.crm.dao.CommentMapper;
import com.ipaozha.crm.exception.CrmException;
import com.ipaozha.crm.form.CommentForm;
import com.ipaozha.crm.pojo.Comment;
import com.ipaozha.crm.service.CommentService;
import com.ipaozha.crm.utils.IPKit;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CommentMapper commentMapper;
    @Override
    public Comment add(CommentForm commentForm) throws CrmException {
        //鉴权,ip上次时间太大不允许发布
        final String ip = IPKit.getIpAddrByRequest(request);
        //插入ip
        commentForm.setAddressIp(ip);

        Comment comment = commentMapper.selectByIp(ip);
        if (null == comment) {
            // 没有发过评论则直接插入
            return insertComment(commentForm);
        }else {
            //发过评论看上次更新时间
            Date lastUpdateTime = comment.getUpdateTime();
            Date nowDate = new Date();
            long timeinterval = nowDate.getTime() - lastUpdateTime.getTime();

            if (timeinterval < 30000) {
                // now比last大相隔小于30秒
                throw new CrmException(RespEnum.comment_timeShort_error);
            }else {
                return insertComment(commentForm);
            }
        }
    }

    @Override
    public List<Comment> list(Integer articleId) {
        List<Comment> commentList = commentMapper.list(articleId);
        return commentList;
    }

    @Override
    public PageInfo<Comment> list(Integer articleId, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Comment> list = commentMapper.list(articleId);
        PageInfo<Comment> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    //插入流程
    private Comment insertComment(CommentForm commentForm) throws CrmException {
        //装配bean
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentForm, comment);
        comment.setAddressIp(commentForm.getAddressIp());
        try {
            //参数是否为空已在form层判断,这里直接插入
            int result = commentMapper.insertSelective(comment);
            if (result > 0) {
                comment = commentMapper.selectByPrimaryKey(comment.getId());
                return comment;
            }else {
                throw new CrmException(RespEnum.comment_insert_error);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CrmException(450, e.getMessage());
        }
    }
}
