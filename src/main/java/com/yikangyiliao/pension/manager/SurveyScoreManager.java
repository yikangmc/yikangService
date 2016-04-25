package com.yikangyiliao.pension.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.SurveyScoreDao;
import com.yikangyiliao.pension.entity.SurveyScore;


@Component
public class SurveyScoreManager {

	
	@Autowired
	private SurveyScoreDao surveyScoreDao;
	
	
	/**
	 * @author liushuaic
	 * @date  2015/08/06 20:02
	 * 查询某一个表评分
	 * 
	 * **/
	public SurveyScore selectByPrimaryKey(Long sureyScoreId){
		return surveyScoreDao.selectByPrimaryKey(sureyScoreId);
	}
	
	
    /**
     * @author liushuaic
     * @date 2015/08/06
     * 根据 档案袋id 与 查询表id， 查询出某一个表的总评分
     * */
	public SurveyScore getSureyScoreByAssessmentIdAndSureyTableId(Map<String,Object> paramData){
		return surveyScoreDao.getSureyScoreByAssessmentIdAndSureyTableId(paramData);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/06 20:20
	 * **/
	public int insertSelective(SurveyScore record){
		return surveyScoreDao.insertSelective(record);
	}
	
    /**
     * @author liushuaic
     * @date 2015/08/07 11：23
     * 修改某一人问卷的总得分
     * @param surveyScoreId 某一个问卷的总评分
     * **/
    public int updateTotalBySurveyScoreId(Long surveyScoreId){
    	return surveyScoreDao.updateTotalBySurveyScoreId(surveyScoreId);
    }
}
