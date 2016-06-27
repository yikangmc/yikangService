package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.ForumPostDetail;

public interface ForumPostDetailDao {
    int deleteByPrimaryKey(Long forumPostDetailId);

    int insert(ForumPostDetail record);

    int insertSelective(ForumPostDetail record);

    ForumPostDetail selectByPrimaryKey(Long forumPostDetailId);

    int updateByPrimaryKeySelective(ForumPostDetail record);

    int updateByPrimaryKey(ForumPostDetail record);
    
}