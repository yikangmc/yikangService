package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.FormPostsTaglibsMap;

public interface FormPostsTaglibsMapDao {
    int deleteByPrimaryKey(Long forumPostsTaglibsMapsId);

    int insert(FormPostsTaglibsMap record);

    int insertSelective(FormPostsTaglibsMap record);

    FormPostsTaglibsMap selectByPrimaryKey(Long forumPostsTaglibsMapsId);

    int updateByPrimaryKeySelective(FormPostsTaglibsMap record);

    int updateByPrimaryKey(FormPostsTaglibsMap record);
}