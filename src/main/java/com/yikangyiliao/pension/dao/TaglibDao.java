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
}