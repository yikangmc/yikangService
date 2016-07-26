package com.yikangyiliao.pension.dao;

import java.util.Map;

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
    
    /**
     * @author liushuaic
     * @date 2016-07-19 17:25
     * @desc 设置文章编辑记录为删除
     * */
    int updateForumPostTxtEditorSetIsDeletedById(Long forumPostTxtEditroId);
    
    /**
     * @author liushuaic
     * @date 2016-07-19 17:41
     * @desc 修改唯一标记的，所属用户 
     * **/
    int updateForumPostTxtEditorOwnUserIdEditorTypeByUniqueCode(Map<String,Object> paramMap);
    
    
    /**
     * @author liushuaic
     * @date 2016-07-20 13:34
     * @desc 查询某一个条记录，根据 unqiueCode And IsDelete
     * */
    ForumPostTxtEditor getForumPostTxtByUniqueCodeAndIsDelete(Map<String,Object> paramMap);
    
}