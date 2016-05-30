package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.QuestionImage;

public interface QuestionImageDao {
    int deleteByPrimaryKey(Long questionImageId);

    int insert(QuestionImage record);

    int insertSelective(QuestionImage record);

    QuestionImage selectByPrimaryKey(Long questionImageId);

    int updateByPrimaryKeySelective(QuestionImage record);

    int updateByPrimaryKey(QuestionImage record);
    

    /**
     * @author liushuaic
     * @date 2016-05-28 18:25
     * @desc 获取某一个问题的数据图片
     * **/
    List<QuestionImage> getQuestionImageByQuestionId(Long questionId);

}