package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.Taglib;

public interface TaglibDao {
    int deleteByPrimaryKey(Long taglibId);

    int insert(Taglib record);

    int insertSelective(Taglib record);

    Taglib selectByPrimaryKey(Long taglibId);

    int updateByPrimaryKeySelective(Taglib record);

    int updateByPrimaryKey(Taglib record);
    
    

    /**
     * @author liushuaic
     * @date 2016-04-26 12:06
     * @desc 获取标签列表
     * **/
    List<Taglib> getTaglibs(String tagName);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-11 16:16
     * @desc 获取推荐的2级标签列表
     * @param userId
     * */
    List<Taglib> getRecommendTaglib(Map<String,Object> paramMap);
    
    /**
     * @author houyt
     * @date 2016-09-23 16:16
     * @desc 获取推荐的2级标签列表
     * @param userId
     * */
    List<Taglib> getRecommendTaglibTwo(Map<String,Object> paramMap);
    
    
    
    /**
     * @author liushuaic
     * @date 2016-05-12 10:19
     * @desc 查询一级列表标签
     * **/
    List<Taglib> getFristTaglib();
    
    
    /**
     * @author liushuaic
     * @date 2016-05-12 10:24
     * @desc 获取考级标签列表by 
     * @param parentId
     * @param userId
     * 
     * **/
    List<Taglib> getSecondTaglibByParentId(Map<String,Object> paramMap );
    
    
    /**
     * @author liushuaic
     * @date 2016-05-19 16:03
     * @desc 获取所有的标签
     * @param userId
     * */
    List<Taglib> getAllTag(Map<String,Object> paramMap);
    
    
    
    List<Taglib> getTaglibsByFormPostId(Long formPostId);
    
    
    
    /**
     * @author liushuaic
     * @date 2016-06-01 09:27
     * @desc  获取我关注的标签
     * */
    List<Taglib> getMyWatchTaglibsByUserid(Long createUserId);
    
    /**
     * @author liushuaic
     * @date 2016-06-01 09:27
     * @desc  获取我关注的标签
     * */
    List<Taglib> getMyWatchTaglibsByUseridPage(Map<String, Object> paramMap);
    
    
    /**
     * @author liushuaic
     * @date 2016-06-01 14:05
     * @desc 获取所有的二级taglib
     * */
    List<Taglib> getSecondAllTaglib();
    
    /**
     * @author liushuaic
     * @date 2016-06-30 18:23
     * @desc 修改标签的关注数量 +1
     * **/
    int updateFollowNumberAddByTaglibId(Long taglibId);
    
    /**
     * @author liushuaic
     * @date 2016-06-30 18:24
     * @desc 修改关注数量-1
     * */
    int updateFollowNumberSubByTaglibId(Long taglibId);
    
    
    /**
     * @author liushuaic
     * @date 2016-07-06 15:01
     * 修改标签帖子关注数量 +1
     * **/
    int updateForumPostsTZNumberAddByTaglibId(Long taglibId);

    
    /**
     * 
     * @author liushuaic
     * @date 2016-07-06 15:01
     * 修改标签帖子关注数量 -1 
     * 
     * */
    int updateForumPostsTZNumberSubByTaglibId(Long taglibId);
    
    /**
     * @author liushuaic
     * @date 2016-07-06 16:50
     * @desc 文章发部数量加1
     * */
    int updateForumPostsNumberAddByTaglibId(Long taglibId);
    
    
    /**
     * @author liushuaic
     * @date 2016-07-06 16:54
     * @desc 标签文章数量减一
     * **/
    int updateForumPostsNumberSubByTaglibId(Long taglibId);
    
    
    /**
     * @author liushuaic
     * @date 2016-09-22 20:37
     * @desc 获取某一个标签详情及是否已经关注
     * */
    Taglib getTaglibByTaglibIdUserId(Map<String,Object> paramMap);
    
}