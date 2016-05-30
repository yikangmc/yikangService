package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.ForumPostsImage;

public interface ForumPostsImageDao {
    int deleteByPrimaryKey(Long forumPostsImagesId);

    int insert(ForumPostsImage record);

    int insertSelective(ForumPostsImage record);

    ForumPostsImage selectByPrimaryKey(Long forumPostsImagesId);

    int updateByPrimaryKeySelective(ForumPostsImage record);

    int updateByPrimaryKey(ForumPostsImage record);
    
    /**
     * @author liushuaic
     * @date 2016-05-28 19:13
     * @desc 获取某一个文章的所有图片
     * */
    List<ForumPostsImage> getForumPostImagesByForumPostsId(Long forumPostsImagesId);
}