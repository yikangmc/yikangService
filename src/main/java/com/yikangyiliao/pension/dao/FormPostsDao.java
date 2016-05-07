package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.FormPosts;

public interface FormPostsDao {
    int deleteByPrimaryKey(Long forumPostId);

    int insert(FormPosts record);

    int insertSelective(FormPosts record);

    FormPosts selectByPrimaryKey(Long forumPostId);

    int updateByPrimaryKeySelective(FormPosts record);

    int updateByPrimaryKey(FormPosts record);
    
    
    /**
     * @author liushuaic
     * @date 2016-04-27 11:11
     * @desc 获取推荐文章
     * **/
    List<FormPosts> getIsEssence();
    
    /**
     * @author liushuaic
     * @desc 获取文章详情
     * 
     * **/
    FormPosts getFormPoustsDetailByForumPostId(Long forumPostId);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-05 17:53
     * 文章支持+1
     * */
    void formPostsStarsUpByForumPostId(Long forumPostId);
    
    /**
     * @author liushuaic
     * @date 2016-05-05 17:53
     * 文章支持-1
     * */
    void formPostsStarsDownByForumPostId(Long forumPostId);
    
    
    
    
}