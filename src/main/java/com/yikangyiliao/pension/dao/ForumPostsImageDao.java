package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.ForumPostsImage;

public interface ForumPostsImageDao {
    int deleteByPrimaryKey(Long forumPostsImagesId);

    int insert(ForumPostsImage record);

    int insertSelective(ForumPostsImage record);

    ForumPostsImage selectByPrimaryKey(Long forumPostsImagesId);

    int updateByPrimaryKeySelective(ForumPostsImage record);

    int updateByPrimaryKey(ForumPostsImage record);
}