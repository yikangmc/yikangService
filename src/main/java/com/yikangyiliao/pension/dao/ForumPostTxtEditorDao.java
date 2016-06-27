package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.ForumPostTxtEditor;

public interface ForumPostTxtEditorDao {
    int deleteByPrimaryKey(Long forumPostTxtEditorId);

    int insert(ForumPostTxtEditor record);

    int insertSelective(ForumPostTxtEditor record);

    ForumPostTxtEditor selectByPrimaryKey(Long forumPostTxtEditorId);

    int updateByPrimaryKeySelective(ForumPostTxtEditor record);

    int updateByPrimaryKey(ForumPostTxtEditor record);
    
    /**
     * @author liushuaic
     * @date 2016-06-20 19:01
     * @desc 查询某一个唯一的数据 
     * **/
    ForumPostTxtEditor selectByUniqueCode(String uniqueCode);
    
}