package com.yikangyiliao.pension.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.QuestionTaglibMapDao;
import com.yikangyiliao.pension.entity.Taglib;

@Component
public class QuesetionTaglibManager {
	
	@Autowired
	private QuestionTaglibMapDao questionTaglibMapDao;
	
	
	
	 /**
     * @author liushuaic
     * @date 2016-05-10 18:42
     * @desc 查询某一个问题的所有标签
     * **/
	public  List<Taglib> getQuestionTaglibsByQuestionId(Long questionid){
		return questionTaglibMapDao.getQuestionTaglibsByQuestionId(questionid);
	}
	
	
	
	

}
