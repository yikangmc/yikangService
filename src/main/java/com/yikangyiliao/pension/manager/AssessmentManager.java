package com.yikangyiliao.pension.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.AssessmentDao;
import com.yikangyiliao.pension.entity.Assessment;


@Component
public class AssessmentManager {
	
	
	@Autowired
	private AssessmentDao assessmentDao;
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/06  19:55
	 * 
	 * */
	public Assessment selectByPrimaryKey(Long assessmentId){
		return assessmentDao.selectByPrimaryKey(assessmentId);
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/13 12:22
	 * 添加病例夹
	 * 
	 * */
	public int insertSelective(Assessment assessment){
		return assessmentDao.insertSelective(assessment);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/13 12:25
	 * 获取某一个患者的所有的病例夹
	 * **/
	public List<Assessment> getAssessmentBySeniorId(Long seniorId){
		return assessmentDao.getAssessmentBySeniorId(seniorId);
	}

}
