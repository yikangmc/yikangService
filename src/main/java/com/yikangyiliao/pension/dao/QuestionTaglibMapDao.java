package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.QuestionTaglibMap;
import com.yikangyiliao.pension.entity.Taglib;

public interface QuestionTaglibMapDao {
    int deleteByPrimaryKey(Long questionTaglibMapsId);

    int insert(QuestionTaglibMap record);

    int insertSelective(QuestionTaglibMap record);

    QuestionTaglibMap selectByPrimaryKey(Long questionTaglibMapsId);

    int updateByPrimaryKeySelective(QuestionTaglibMap record);

    int updateByPrimaryKey(QuestionTaglibMap record);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-10 18:42
     * @desc 查询某一个问题的所有标签
     * **/
    List<Taglib> getQuestionTaglibsByQuestionId(Long questionid);

}