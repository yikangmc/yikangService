package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.QuestionAnswerDao;
import com.yikangyiliao.pension.dao.QuestionAnswerStartListDao;
import com.yikangyiliao.pension.entity.QuestionAnswer;
import com.yikangyiliao.pension.entity.QuestionAnswerStartList;
import com.yikangyiliao.pension.message.QuestionAnswerMsgOperation;

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
		Date currentDate=Calendar.getInstance().getTime();
		QuestionAnswer questionAnswer=new QuestionAnswer();
		questionAnswer.setCreateUserId(createUserId);
		questionAnswer.setContent(content);
		questionAnswer.setDataSource(Byte.valueOf("0"));
		questionAnswer.setQuestionId(questionId);
		questionAnswer.setStarNum(0);
		questionAnswer.setIsRecommend(Byte.valueOf("0"));
		questionAnswer.setCreateTime(currentDate);
		questionAnswer.setUpdateTime(currentDate);
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
			questionAnswerDao.updateQuestionAnswerStarUpByQuestionAnswerId(questionAnswerStartList2.getQuestionAnswerId());
		}
		
		
		return 0;
	}
	

	/**
	 * @author liushuaic
	 * @date 2016-06-13 14:06
	 * @desc 获取问题的回答
	 * */
	public QuestionAnswer getQuestionAnswerByQuestionAnswerId(Long questionAnswerId){
		QuestionAnswer questionAnswer=questionAnswerDao.selectByPrimaryKey(questionAnswerId);
		return questionAnswer;
	}

}
