package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.ForumPostsAnswer;

public interface ForumPostsAnswerDao {
    int deleteByPrimaryKey(Long forumPostsAnswerId);

    int insert(ForumPostsAnswer record);

    int insertSelective(ForumPostsAnswer record);

    ForumPostsAnswer selectByPrimaryKey(Long forumPostsAnswerId);

    int updateByPrimaryKeySelective(ForumPostsAnswer record);

    int updateByPrimaryKey(ForumPostsAnswer record);
}