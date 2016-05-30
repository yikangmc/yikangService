package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.QuestionAnswerDao;
import com.yikangyiliao.pension.dao.QuestionAnswerStartListDao;
import com.yikangyiliao.pension.entity.QuestionAnswer;
import com.yikangyiliao.pension.entity.QuestionAnswerStartList;

@Component
public class QuestionAnswerManager {
	
	@Autowired
	private QuestionAnswerDao questionAnswerDao;
	
	@Autowired
	private QuestionAnswerStartListDao questionAnswerStartListDao; 
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-09 18:17
	 * @desc 添加问题回复
	 * **/
	public int insertSelective(Long questionId,String content,Long createUserId){
		QuestionAnswer questionAnswer=new QuestionAnswer();
		questionAnswer.setCreateUserId(createUserId);
		questionAnswer.setContent(content);
		questionAnswer.setDataSource(Byte.valueOf("0"));
		questionAnswer.setQuestionId(questionId);
		
		
		return questionAnswerDao.insert(questionAnswer);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-05-09 18:36 
	 * @desc 修改问题回复支持状态
	 * */
	public int updateQustionAnswerStar(Long questionAnswerId,Long userId){
		
		QuestionAnswerStartList questionAnswerStartList=questionAnswerStartListDao.getRowByQuestionAnswerIdAndCreateUserId(questionAnswerId, userId);
		
		if(null != questionAnswerStartList){
			questionAnswerStartListDao.deleteQuestionAnswerStartListByQuestionAnswerIdAndCreateUserId(questionAnswerId, userId);
			questionAnswerDao.updateQuestionAnswerdown(questionAnswerId);
		}else{
			Date createTime=Calendar.getInstance().getTime();
			QuestionAnswerStartList questionAnswerStartList2=new QuestionAnswerStartList();
			questionAnswerStartList2.setQuestionAnswerId(questionAnswerId);
			questionAnswerStartList2.setCreateUserId(userId);
			questionAnswerStartList2.setCreateTime(createTime);
			questionAnswerStartListDao.insertSelective(questionAnswerStartList2);
		}
		
		
		return 0;
	}
	

}
