package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.QuestionAnswersComment;

public interface QuestionAnswersCommentDao {
    int deleteByPrimaryKey(Long questionAnswersCommentId);

    int insert(QuestionAnswersComment record);

    int insertSelective(QuestionAnswersComment record);

    QuestionAnswersComment selectByPrimaryKey(Long questionAnswersCommentId);

    int updateByPrimaryKeySelective(QuestionAnswersComment record);

    int updateByPrimaryKey(QuestionAnswersComment record);
    
    List<QuestionAnswersComment> getQuestionAnswersCommentListByUserIdAndQuestionAnswerIdPage(Map questionAnswerId);
}