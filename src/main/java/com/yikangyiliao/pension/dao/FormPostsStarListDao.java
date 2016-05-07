package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.FormPostsStarList;

public interface FormPostsStarListDao {
    int deleteByPrimaryKey(Long forumPostsStarListId);

    int insert(FormPostsStarList record);

    int insertSelective(FormPostsStarList record);

    FormPostsStarList selectByPrimaryKey(Long forumPostsStarListId);

    int updateByPrimaryKeySelective(FormPostsStarList record);

    int updateByPrimaryKey(FormPostsStarList record);
    
    /**
     * @author liushuaic
     * @date 2016-05-04 17:57
     * @desc 获取某一个文章的支持列表根据文章的id
     **/
    List<FormPostsStarList> getForumPostStartListByForumPostsId();

    
    
    /**
     * @author liushuaic
     * @date 2016-05-05 19:05
     * @desc 删除我的支持
     * **/
    int deleteForumPostStartList(Map<String,Object> paramMap);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-06 11:12
     * @desc 获取某一个用户的支持数据
     * **/
    FormPostsStarList selectForumPostStartListByCreateUserIdAndForumPostsId(Map<String,Object> paramMap);

}