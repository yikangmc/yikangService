package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.ForumPostsAnswer;

public interface ForumPostsAnswerDao {
    int deleteByPrimaryKey(Long forumPostsAnswerId);

    int insert(ForumPostsAnswer record);

    int insertSelective(ForumPostsAnswer record);

    ForumPostsAnswer selectByPrimaryKey(Long forumPostsAnswerId);

    int updateByPrimaryKeySelective(ForumPostsAnswer record);

    int updateByPrimaryKey(ForumPostsAnswer record);
    
    
    /**
     * @author liushuaic
     * @date 2016-04-28 19:15
     * @descc 获取文章回复
     * */
    List<ForumPostsAnswer> getForumPostsAnswersByFormPostId(Long forumPostsId);
    
    
    
    /**
     * @author liushuaic
     * @date 2016-09-28 14:20
     * @desc 获取文章回复列表分页
     * */
    List<ForumPostsAnswer> getForumPostsAnswersByFormPostIdPage(Map<String,Object> paramMap);
    
    
    
}