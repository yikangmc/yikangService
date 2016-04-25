package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.AnswerDao;
import com.yikangyiliao.pension.entity.Answer;


@Component
public class AnswerManager {

	
	@Autowired
	private AnswerDao answerDao;
	
	
	/**
	 * @author liushuaic
	 * @date 添加问答
	 * **/
	public int insertSelective(Answer record){
		return answerDao.insert(record);
	}
	
}
