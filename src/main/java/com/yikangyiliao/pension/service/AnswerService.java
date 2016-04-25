package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.error.ExceptionInfo;
import com.yikangyiliao.pension.dao.SurveyScoreDetailDao;
import com.yikangyiliao.pension.entity.Assessment;
import com.yikangyiliao.pension.entity.SurveyScore;
import com.yikangyiliao.pension.entity.SurveyScoreDetail;
import com.yikangyiliao.pension.manager.AnswerManager;
import com.yikangyiliao.pension.manager.AssessmentManager;
import com.yikangyiliao.pension.manager.SurveyScoreDetailManager;
import com.yikangyiliao.pension.manager.SurveyScoreManager;



@Service(value="answerService")
public class AnswerService {
	
	@SuppressWarnings("unused")
	private Logger logger =Logger.getLogger(AnswerService.class);

	
	@Autowired
	private AnswerManager answerManager;
	
	@Autowired
	private AssessmentManager assessmentManager;
	
	@Autowired
	private SurveyScoreManager surveyScoreManager;
	
	@Autowired
	private SurveyScoreDetailDao surveyScoreDetailDao;
	
	@Autowired
	private SurveyScoreDetailManager  surveyScoreDetailManager;
	
	
	/**
	 * @author liushuaic
	 * @throws ExceptionInfo 
	 * @date 2015/08/06 查询生活护理评估表的，评估项
	 * **/
	@SuppressWarnings("unchecked")
	public Map<String, Object> saveAnswer(Map<String,Object> paramData) throws ExceptionInfo {
		Map<String,Object> rtnData=new HashMap<String, Object>();
		 
			if(null != paramData){
				if(
					paramData.containsKey("assessmentId")&&
					paramData.containsKey("surveyTableId")&&
					paramData.containsKey("questionCrosswiseId")&&
					paramData.containsKey("questions")
				){
					
					String assessmentId=paramData.get("assessmentId").toString();
					String surveyTableId=paramData.get("surveyTableId").toString();
					
					
					
					//获取传过来的问题数组
					List<Map<String,Object>> questions=(List<Map<String,Object>>)paramData.get("questions");
					
					
					Assessment assessment=assessmentManager.selectByPrimaryKey(Long.valueOf(assessmentId));
					if(null == assessment){
						assessment=new Assessment();
						//TODO如果进入到本页面，一定是添加了一个档案袋
						assessment.setAppraisersId(-1l);
						assessment.setAppraisersName("项目初期系统");
						assessment.setAssessmentNumber("test-test-2015101011");
						assessment.setAssessmentId(-1l);
						assessment.setSeniorId(0l);
					}
					
					
					SurveyScore sureyScore=surveyScoreManager.getSureyScoreByAssessmentIdAndSureyTableId(paramData);
					if(null == sureyScore){
						sureyScore=new SurveyScore();
						sureyScore.setConclusionUserId(assessment.getAppraisersId());
						sureyScore.setConclusion("初始化");
						sureyScore.setAssessorUserId(assessment.getAppraisersId());
						
						sureyScore.setDataSource(Byte.valueOf("1"));
						sureyScore.setIsDelete(Byte.valueOf("0"));
						sureyScore.setSenorId(assessment.getSeniorId());
						sureyScore.setSurveyTableId(Long.valueOf(surveyTableId));
						sureyScore.setTotal(0);
						sureyScore.setAssessmentId(Long.valueOf(assessmentId));
						sureyScore.setAssessmentNumber("1ac_"+assessmentId);
						sureyScore.setDataSource(Byte.valueOf("1"));
						
						surveyScoreManager.insertSelective(sureyScore);
					}
					
					//删除某一个表下的所有答案
					surveyScoreDetailManager.deleteSurveyScoreDetailBySurveyScoreIdAndQuestionCrosswiseId(paramData);
					
					
					for(int i=0;i<questions.size();i++){
						Map<String,Object> question=questions.get(i);
						
						String questionId=question.get("questionId").toString();
						List<Map<String,Object>> answers=(List<Map<String,Object>>)question.get("answers");
						for(int j=0;j<answers.size();j++){
							
							Map<String,Object> answer=answers.get(j);
							
							String answerVal=answer.get("answerVal").toString();
							String answerId=answer.get("answerId").toString();
							
							SurveyScoreDetail surveyScoreDetail=new SurveyScoreDetail();
							surveyScoreDetail.setAnswerId(Long.valueOf(answerId));
							surveyScoreDetail.setScore(Float.valueOf(answerVal));
							surveyScoreDetail.setSurveyId(Long.valueOf(surveyTableId));
							surveyScoreDetail.setQuestionId(Long.valueOf(questionId));
							surveyScoreDetail.setSurveyScoreId(sureyScore.getSureyScoreId());
							surveyScoreDetail.setIsDelete(Byte.valueOf("0"));
							surveyScoreDetailDao.insert(surveyScoreDetail);
						}
						
					}
					surveyScoreManager.updateTotalBySurveyScoreId(sureyScore.getSureyScoreId());
					rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
					rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
				}else{
					rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
					rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
				}
			}else{
				rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
				rtnData.put("message", ExceptionConstants.systemException.systemException.errorMessage);
			}
			
		
		 
		return rtnData;
		
	}
	
	
	/**
	 * @author liushuaic
	 * @throws ExceptionInfo 
	 * @date 2015/08/12 14:20
	 * 保存普通问题接口
	 * **/
	@SuppressWarnings("unchecked")
	public Map<String, Object> saveAnswerForQuestion(Map<String,Object> paramData) throws ExceptionInfo {
		Map<String,Object> rtnData=new HashMap<String, Object>();
			if(null != paramData){
				if(
					paramData.containsKey("assessmentId")&&
					paramData.containsKey("surveyTableId")&&
					paramData.containsKey("questions")
				){
					
					String assessmentId=paramData.get("assessmentId").toString();
					String surveyTableId=paramData.get("surveyTableId").toString();
					
					
					//获取传过来的问题数组
					List<Map<String,Object>> questions=(List<Map<String,Object>>)paramData.get("questions");
					
					
					Assessment assessment=assessmentManager.selectByPrimaryKey(Long.valueOf(assessmentId));
					if(null == assessment){
						assessment=new Assessment();
						//TODO如果进入到本页面，一定是添加了一个档案袋
						assessment.setAppraisersId(-1l);
						assessment.setAppraisersName("项目初期系统");
						assessment.setAssessmentNumber("test-test-2015101011");
						assessment.setAssessmentId(-1l);
						assessment.setSeniorId(0l);
						
					}
					
					
					SurveyScore sureyScore=surveyScoreManager.getSureyScoreByAssessmentIdAndSureyTableId(paramData);
					if(null == sureyScore){
						sureyScore=new SurveyScore();
						
						sureyScore.setConclusionUserId(assessment.getAppraisersId());
						sureyScore.setConclusion(assessment.getAppraisersName());
						
						sureyScore.setAssessorUserId(assessment.getAppraisersId());
						
						sureyScore.setIsDelete(Byte.valueOf("0"));
						sureyScore.setSenorId(assessment.getSeniorId());
						sureyScore.setSurveyTableId(Long.valueOf(surveyTableId));
						sureyScore.setTotal(0);
						sureyScore.setAssessmentId(Long.valueOf(assessmentId));
						sureyScore.setAssessmentNumber("1ac_"+assessmentId);
						sureyScore.setDataSource(Byte.valueOf("0"));
						
						surveyScoreManager.insertSelective(sureyScore);
					}
					
					
					surveyScoreDetailManager.deleteSurveyScoreDetailBySurveyScoreId(sureyScore.getSureyScoreId());
					 Map<String,Object> paramDatas=new HashMap<String, Object>();
					 paramDatas.put("surveyScoreId", sureyScore.getSureyScoreId());
					for(int i=0;i<questions.size();i++){
						Map<String,Object> question=questions.get(i);
						
						String questionId=question.get("questionId").toString();
						paramDatas.put("questionId",questionId);
						
						// 某一个问题的答案
						
						List<Map<String,Object>> answers=(List<Map<String,Object>>)question.get("answers");
						for(int j=0;j<answers.size();j++){
							
							Map<String,Object> answer=answers.get(j);
							
							String answerVal=answer.get("answerVal").toString();
							String answerId=answer.get("answerId").toString();
							
							SurveyScoreDetail surveyScoreDetail=new SurveyScoreDetail();
							surveyScoreDetail.setAnswerId(Long.valueOf(answerId));
							surveyScoreDetail.setScore(Float.valueOf(answerVal));
							surveyScoreDetail.setSurveyId(Long.valueOf(surveyTableId));
							surveyScoreDetail.setQuestionId(Long.valueOf(questionId));
							surveyScoreDetail.setSurveyScoreId(sureyScore.getSureyScoreId());
							surveyScoreDetail.setIsDelete(Byte.valueOf("0"));
							surveyScoreDetailDao.insert(surveyScoreDetail);
						}
						
					}
					surveyScoreManager.updateTotalBySurveyScoreId(sureyScore.getSureyScoreId());
					rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
					rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
				}else{
					rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
					rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
				}

			}else{
				rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
			
	  
		return rtnData;
		
	}
	
	
}
