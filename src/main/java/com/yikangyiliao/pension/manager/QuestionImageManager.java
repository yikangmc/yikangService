package com.yikangyiliao.pension.manager;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.QuestionImageDao;
import com.yikangyiliao.pension.entity.QuestionImage;

@Component
public class QuestionImageManager {

	@Autowired
	private QuestionImageDao questionImageDao;
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2016-05-28 17:49
	 * @desc 添加活动图片
	 * 
	 * */
	public int insertSelective(String imageUrl,Long questionId){
		QuestionImage questionImage=new QuestionImage();
		questionImage.setCreateTime(Calendar.getInstance().getTime());
		questionImage.setImageUrl(imageUrl);
		questionImage.setQuestionId(questionId);
		return questionImageDao.insertSelective(questionImage);
	}
	
	
}
