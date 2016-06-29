package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.QuestionAnswerDao;
import com.yikangyiliao.pension.dao.QuestionDao;
import com.yikangyiliao.pension.dao.QuestionTaglibMapDao;
import com.yikangyiliao.pension.entity.Question;
import com.yikangyiliao.pension.entity.QuestionAnswer;
import com.yikangyiliao.pension.entity.QuestionTaglibMap;

@Component
public class QuestionManager {

	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private QuestionTaglibMapDao questionTaglibMapDao;
	
	
	@Autowired
	private QuestionImageManager questionImageManager;
	
	@Autowired
	private QuestionAnswerDao questionAnswerDao;
	
	/**
	 * @author liushuaic
	 * @date 2015-05-09 10:34
	 * @desc 添加新的问题
	 * */
	public int insertSelective(Question record){
		return questionDao.insertSelective(record);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-09 11:15
	 * @desc 添加问题
	 * **/
	public int insertQuestion(String title,String content,Long[] taglibIds,Long createUserId,String[] images){
		Date date=Calendar.getInstance().getTime();
		Question question=new Question();
		question.setTitle(title);
		question.setContent(content);
		question.setCreateTime(date);
		question.setUpdateTime(date);
		question.setCreateUserId(createUserId);
		question.setStar(0);
		questionDao.insertSelective(question);
		for(Long taglibId:taglibIds){
			QuestionTaglibMap questionTaglibMap=new QuestionTaglibMap();
			questionTaglibMap.setCreateTime(date);
			questionTaglibMap.setUpdateTime(date);
			questionTaglibMap.setTaglibsId(taglibId);
			questionTaglibMap.setQuestionsId(question.getQuestionId());
			questionTaglibMapDao.insertSelective(questionTaglibMap);
		}
		
		for(String imageId:images){
			 questionImageManager.insertSelective(imageId, question.getQuestionId());
		 }
		return 1;
	}
	
    /**
     * @author liushuaic
     * @date 2016-05-11 11:49
     * @desc 查询某一个问题的详情
     * **/
    public Question getQuestionDetailByQuestionId(Long questionId,Long userId){
    	Question question= questionDao.getQuestionDetailByQuestionId(questionId);
    	
    	Map<String,Object> paramMap=new HashMap<String,Object>();
    	paramMap.put("questionId", questionId);
    	paramMap.put("userId", userId);
    	List<QuestionAnswer> questionAnswers=questionAnswerDao.selectQuestionAnswer(paramMap);
    	question.setQuestionAnswers(questionAnswers);
    	return question;
    }
  

    /**
     * @author liushuaic
     * @date 2016-06-6 19:28
     * @desc 获取精彩回答
     * */
    public List<QuestionAnswer> getHotQuestionAnswer(Long userId){
    	Map<String,Object> paramMap=new HashMap<String,Object>();
    	paramMap.put("userId", userId);
    	List<QuestionAnswer> questionAnswers=questionAnswerDao.getHotQuestionAnswer(paramMap);
    	return questionAnswers;
    }
	
    
    /**
     * @author liushuaic
     * @date 2016-05-24 15:25
     * @desc 获取某一个标签下的所有问题
     * */
    public List<Question> getQuestionByTaglibid(Long taglibId){
    	return questionDao.getQuestionByTaglibid(taglibId);
    }
    
    /**
     * @author liushuaic
     * @date 2016-06-06 11:23
     * @desc 获取某一个用户创建的所有问题
     * */
    public List<Question> getQuestionByCreateUserId(Long taglibId){
    	return questionDao.getQuestionByCreateUserId(taglibId);
    }
    
    
    /**
     * @author liushuaic
     * @date 2016-06-13 获取文章详情 by questionId
     * **/
    public Question getQuestionByQuestionId(Long questionId){
    	return questionDao.selectByPrimaryKey(questionId);
    }
    
    
}
