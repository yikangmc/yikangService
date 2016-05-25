package com.yikangyiliao.pension.dao;

import java.util.List;

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
     * */
    List<Taglib> getRecommendTaglib();
    
    
    
    /**
     * @author liushuaic
     * @date 2016-05-12 10:19
     * @desc 查询一级列表标签
     * **/
    List<Taglib> getFristTaglib();
    
    
    /**
     * @author liushuaic
     * @date 2016-05-12 10:24
     * @desc 获取考级标签列表by parentId
     * 
     * **/
    List<Taglib> getSecondTaglibByParentId(Long parentId);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-19 16:03
     * @desc 获取所有的标签
     * */
    List<Taglib> getAllTag();
    
}