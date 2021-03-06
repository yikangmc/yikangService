package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.QuestionAnswer;

public interface QuestionAnswerDao {
    int deleteByPrimaryKey(Long questionAnswerId);

    int insert(QuestionAnswer record);

    int insertSelective(QuestionAnswer record);

    QuestionAnswer selectByPrimaryKey(Long questionAnswerId);

    int updateByPrimaryKeySelective(QuestionAnswer record);

    int updateByPrimaryKey(QuestionAnswer record);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-10 15:44
     * @desc 添加问题支持
     * */
    int updateQuestionAnsweStartup(Long questionAnswerId);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-10 15:47
     * @desc 取消回答的支持
     * */
    int updateQuestionAnswerdown(Long questionAnswerId);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-30 15:08
     * @desc 获取问题的所有答案
     * */
    List<QuestionAnswer> selectQuestionAnswer(Map<String,Object> paramMap);
    
    
    /**
     * @author liushuaic
     * @date 2016-06-6 19:28
     * @desc 获取精彩回答
     * */
    List<QuestionAnswer> getHotQuestionAnswer(Map<String,Object> paramMap);
    
    /**
     * @author liushuaic
     * @date 2016-06-13 15:48
     * @desc 支持某一个问题回答
     * */
    int updateQuestionAnswerStarUpByQuestionAnswerId(Long questionAnswerId);
    
    
    /**
     * 
     * @author liushuaic
     * @date 2016-06-28 18:55
     * @desc 获取用户的创建回复
     * 
     ***/
    List<QuestionAnswer> getMyQuestionAnswerByCreateUserIdPage(Map<String,Object> paramMap);
    
    /**
     * 
     * @author liushuaic
     * @date 2016-06-28 18:55
     * @desc 获取用户的创建回复
     * 
     ***/
    List<QuestionAnswer> getMyQuestionAnswerByCreateUserId(Map<String,Object> paramMap);
    
    
    /**
     * @author liushuaic
     * @date 2016-07-06 11:23
     * @desc 获取某一个回答的详情
     * @param long questionAnswerId
     * @param long userId
     * **/
    QuestionAnswer getQuestionAnswerByQuestionAnswerId(Map<String,Object> paramMap);
}