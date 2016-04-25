package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.FormPostsStarList;

public interface FormPostsStarListDao {
    int deleteByPrimaryKey(Long forumPostsStarListId);

    int insert(FormPostsStarList record);

    int insertSelective(FormPostsStarList record);

    FormPostsStarList selectByPrimaryKey(Long forumPostsStarListId);

    int updateByPrimaryKeySelective(FormPostsStarList record);

    int updateByPrimaryKey(FormPostsStarList record);
}