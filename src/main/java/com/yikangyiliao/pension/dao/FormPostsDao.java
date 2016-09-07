package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.FormPosts;
import com.yikangyiliao.pension.entity.UserServiceInfo;

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
    List<FormPosts> getForumPostsByTaglibsIdPage(Map<String,Object> paramMap);
    
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
    List<FormPosts> geForumPostsByCreateUserIdAndForumPostGroup(Map<String,Object> paramMap);
    
    /**
     * @author liushuaic
     * @date 2016-09-01 10:41
     * @param  createUserId 
     * @param  forumPostGroup
     * @param  Pageparameter page
     * @desc 获取某一个用户的所有文章
     * */
    List<FormPosts> geForumPostsByCreateUserIdAndForumPostGroupPage(Map<String,Object> paramMap);
    
    
    /**
     * @author liushuaic
     * @date 2016-06-06 19:18
     * @desc 获取最热帖子
     * **/
    List<FormPosts> getHotForumPosts();
    
    
    /**
     * @author liushuaic
     * @date 2016-09-07 10:41
     * @desc 获取最热帖子分页
     * **/
    List<FormPosts> getHotForumPostsPage(Map<String,Object> paramMap);
    
    
    /**
     * @author liushuaic
     * @date 2016-08-01 15:21
     * @desc 获取用户信息根据发部文章id
     * */
    UserServiceInfo getUserServiceInfoByForumPostId();
    
    
    /**
     * @author liushuaic
     * @date 2016-08-31 16:53
     * @desc 获取所有的文章
     * */
    List<FormPosts> getFormPostsAll();
    
}