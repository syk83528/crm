package com.ipaozha.crm.dao;

import com.ipaozha.crm.pojo.CommentLike;

public interface CommentLikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentLike record);

    int insertSelective(CommentLike record);

    CommentLike selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentLike record);

    int updateByPrimaryKey(CommentLike record);
}