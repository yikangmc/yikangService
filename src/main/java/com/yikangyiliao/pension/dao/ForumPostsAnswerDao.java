package com.yikangyiliao.pension.dao;

import java.util.List;

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
    
    
    
}