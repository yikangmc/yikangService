package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

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
    List<FormPosts> getIsEssence(Map<String,Object> paramMap);
    
    /**
     * @author liushuaic
     * @desc 获取文章详情
     * forumPostId
     * userId
     * **/
    FormPosts getFormPoustsDetailByForumPostId(Map<String,Object> paramMap);
    
    
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
    
    
    /**
     * @author liushuaic
     * @date 2016-05-12 18:00
     * @desc 获取某一个标签下的文章。
     * @param taglibId
     * @param userId
     * */
    List<FormPosts> getForumPostsByTaglibsId(Map<String,Object> paramMap);
    
    /**
     * 
     * @author liushuaic
     * @date 2016-05-31 14:10
     * @desc 获取某一个用户的最新发的文章
     * */
    List<FormPosts> getUserNewForumPostByCreateUserId(Long createUserId);
    
    /**
     * @author liushuaic
     * @date 2016-06-07 10:41
     * @desc 获取文章列表根据某一个用户的id
     * */
    List<FormPosts> geForumPostsByCreateUserId(Long createUserId);
    
    
    /**
     * @author liushuaic
     * @date 2016-06-06 19:18
     * @desc 获取最热帖子
     * **/
    List<FormPosts> getHotForumPosts();
    
    
    /**
     * @author liushuaic
     * @date 2016-06-07 11:02
     * @desc 获取某一个用户创建的文章
     * */
    List<FormPosts> geForumPostsByCreateUserId();
    
    
    
}