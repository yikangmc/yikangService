package com.yikangyiliao.pension.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.utils.GenreateNumberUtils;
import com.yikangyiliao.pension.dao.AssessmentDao;
import com.yikangyiliao.pension.dao.DailyIndexesDao;
import com.yikangyiliao.pension.dao.MentalIndexesDao;
import com.yikangyiliao.pension.dao.PerceptionCommunicationDao;
import com.yikangyiliao.pension.dao.SocialParticipationDao;
import com.yikangyiliao.pension.entity.Assessment;
import com.yikangyiliao.pension.entity.DailyIndexes;
import com.yikangyiliao.pension.entity.MentalIndexes;
import com.yikangyiliao.pension.entity.PerceptionCommunication;
import com.yikangyiliao.pension.entity.SocialParticipation;

@Service(value="scaleService")
public class ScaleService {
	
	private Logger logger =Logger.getLogger(ScaleService.class);
	
	@Autowired
	private PerceptionCommunicationDao perceptionCommunicationDao;
	
	@Autowired
	private  AssessmentDao assessmentdao;
	
	@Autowired
	private SocialParticipationDao socialParticipationDao;
	
	@Autowired
	private DailyIndexesDao dailyIndexesDao;
	
	@Autowired
	private MentalIndexesDao mentalIndexesDao;
	
	/**
	 * 生成项目编号
	 * **/
	@Autowired
	private GenreateNumberUtils genreateNumberUtils; 
	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/30 14:49
	 * @desc 保存感知与沟通 
	 * 
	 * */
	public Map<String,Object> savePerceptionCommunications(Map<String,Object> paramData){
		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		try{
			if(
				paramData.containsKey("consciousness")
				&&paramData.containsKey("vision")
				&&paramData.containsKey("hearing")
				&&paramData.containsKey("communication")
				&&paramData.containsKey("assessmentId")
			){
				
				Long currentDateTime=Calendar.getInstance().getTime().getTime();
				
				String consciousness=paramData.get("consciousness").toString();
				String vision=paramData.get("vision").toString();
				String hearing=paramData.get("hearing").toString();
				String communication=paramData.get("communication").toString();
				String assessmentId=paramData.get("assessmentId").toString();
				
				PerceptionCommunication  perceptionCommunication=new  PerceptionCommunication();
				perceptionCommunication.setCommunication(Byte.parseByte(communication));
				perceptionCommunication.setVision(Byte.parseByte(vision));
				perceptionCommunication.setHearing(Byte.parseByte(hearing));
				perceptionCommunication.setConsciousness(Byte.parseByte(consciousness));
				perceptionCommunication.setCreateTime(currentDateTime);
				perceptionCommunication.setUpdateTime(currentDateTime);
				perceptionCommunication.setAssessmentId(Long.parseLong(assessmentId));
				perceptionCommunication.setPerceptionCommunicationId("1a3_"+assessmentId);
				
				perceptionCommunicationDao.insert(perceptionCommunication);
				rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
			
			
		}catch(Exception e){
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
	
		return rtnData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/31 18:35
	 * @desc 保存档案袋
	 * @param assessmentName
	 * **/
	public Map<String,Object> saveAssessment(Map<String,Object> paramData){
		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		try{
			if(
				paramData.containsKey("assessmentName")&&
				paramData.containsKey("seniorId")
			){
				
				Long currentDateTime=Calendar.getInstance().getTime().getTime();
				
				String assessmentName=paramData.get("assessmentName").toString();
				String seniorId=paramData.get("seniorId").toString();
				
				Assessment assessment=new Assessment();
				assessment.setAssessmentName(assessmentName);
				String number=genreateNumberUtils.generateAssessmentNumber("LS","LS");
				assessment.setAssessmentNumber(number);
				assessment.setCreateTime(currentDateTime);
				assessment.setUpdateTime(currentDateTime);
				assessment.setSeniorId(Long.parseLong(seniorId));
				assessment.setOnlineAssess(true);
				
				assessmentdao.insertSelective(assessment);
				rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
			
			
		}catch(Exception e){
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
		return rtnData;
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/03 11:30
	 * @desc 社会参与
	 * 
	 * **/
	public Map<String,Object> saveSocialParticipation(Map<String,Object> paramData){
		
//		assessmentId:1		(检查袋id)
//		viability:1			(生成处理能力)
//		workingAbility:1		(工作能力）
//		temporalOrientation:1	(时空定向）
//		personalOrientation:1		(人物定向)
//		socialIntercourse:1		(社会交往能力)
//		totalScore:1			(总分)

		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		try{
			if(
				paramData.containsKey("assessmentId")&&
				paramData.containsKey("viability")&&
				paramData.containsKey("workingAbility")&&
				paramData.containsKey("temporalOrientation")&&
				paramData.containsKey("personalOrientation")&&
				paramData.containsKey("socialIntercourse")&&
				paramData.containsKey("totalScore")
			){
				
				Long currentDateTime=Calendar.getInstance().getTime().getTime();
				
				
				
				String assessmentId= paramData.get("assessmentId").toString();
				String viability=paramData.get("viability").toString();
				String workingAbility=paramData.get("workingAbility").toString();
				String temporalOrientation=paramData.get("temporalOrientation").toString();
				String personalOrientation=paramData.get("personalOrientation").toString();
				String socialIntercourse=paramData.get("socialIntercourse").toString();
				String totalScore=paramData.get("totalScore").toString();
			
				SocialParticipation socialParticipation=new SocialParticipation();
				
				socialParticipation.setCreateTime(currentDateTime);
				socialParticipation.setUpdateTime(currentDateTime);
				
				socialParticipation.setAssessmentId(Long.parseLong(assessmentId));
				socialParticipation.setViability(Byte.valueOf(viability));
				socialParticipation.setWorkingAbility(Byte.valueOf(workingAbility));
				socialParticipation.setTemporalOrientation(Byte.valueOf(temporalOrientation));
				socialParticipation.setPersonalOrientation(Byte.valueOf(personalOrientation));
				socialParticipation.setSocialIntercourse(Byte.valueOf(socialIntercourse));
				socialParticipation.setTotalScore(Integer.parseInt(totalScore));
				socialParticipation.setSocialParticipationId("1a4_"+assessmentId);
				
				
				
				socialParticipationDao.insertSelective(socialParticipation);
				
				rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
			
			
		}catch(Exception e){
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
		return rtnData;
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/03 12:36
	 * @desc 日常生活
	 * 
	 * assessmentId
	`seniorId`			bigint unsigned not null 		comment '老人编号',
	`eat` 				int 		not null default -1 comment '进食评分，0 5 10',
	`bath` 				int 		not null default -1 comment '洗澡评分，0 5 10',
	`facialDecency` 	int 		not null default -1 comment '头面修饰能力，0 5 10',
	`dressing` 			int 		not null default -1 comment '穿衣',
	`urinateControl` 	int 		not null default -1 comment '小便控制，0 5 10',
	`defecateControl` 	int 		not null default -1 comment '大便控制，0 5 10',
	`toileting` 		int 		not null default -1 comment '如厕，0 5 10',
	`bedToChair` 		int 		not null default -1 comment '床椅转移',
	`flatWalking` 		int 		not null default -1 comment '平地行走，0 5 10',
	`upanddownStairs` 	int 		not null default -1 comment '上下楼梯',
	`totalScore` 		int 		not null default -1 comment '总分',
	 * ***/
	
	public Map<String,Object> saveDailyIndexe(Map<String,Object> paramData){

		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		try{
			if(
				paramData.containsKey("assessmentId")&&
				paramData.containsKey("seniorId")&&
				paramData.containsKey("eat")&&
				paramData.containsKey("bath")&&
				paramData.containsKey("facialDecency")&&
				paramData.containsKey("dressing")&&
				paramData.containsKey("urinateControl")&&
				paramData.containsKey("defecateControl")&&
				paramData.containsKey("toileting")&&
				paramData.containsKey("bedToChair")&&
				paramData.containsKey("flatWalking")&&
				paramData.containsKey("upanddownStairs")&&
				paramData.containsKey("totalScore")
			){
				
				Long currentDateTime=Calendar.getInstance().getTime().getTime();
				
				
				
				String assessmentId= paramData.get("assessmentId").toString();
				String seniorId= paramData.get("seniorId").toString();
				String eat=paramData.get("eat").toString();
				String bath=paramData.get("bath").toString();
				String facialDecency=paramData.get("facialDecency").toString();
				String dressing=paramData.get("dressing").toString();
				String urinateControl=paramData.get("urinateControl").toString();
				String defecateControl=paramData.get("defecateControl").toString();
				String toileting=paramData.get("toileting").toString();
				String bedToChair=paramData.get("bedToChair").toString();
				String flatWalking=paramData.get("flatWalking").toString();
				String upanddownStairs=paramData.get("upanddownStairs").toString();
				String totalScore=paramData.get("totalScore").toString();
				
				DailyIndexes dailyIndexes=new DailyIndexes();
				dailyIndexes.setAssessmentId(Long.valueOf(assessmentId));
				dailyIndexes.setDailyIndexesId("1a1_"+assessmentId);
				dailyIndexes.setSeniorId(Long.parseLong(seniorId));

				dailyIndexes.setEat(Integer.valueOf(eat));
				dailyIndexes.setBath(Integer.valueOf(bath));
				dailyIndexes.setFacialDecency(Integer.valueOf(facialDecency));
				dailyIndexes.setDressing(Integer.valueOf(dressing));
				dailyIndexes.setUrinateControl(Integer.valueOf(urinateControl));
				dailyIndexes.setDefecateControl(Integer.valueOf(defecateControl));
				dailyIndexes.setToileting(Integer.valueOf(toileting));
				dailyIndexes.setBedToChair(Integer.valueOf(bedToChair));
				dailyIndexes.setFlatWalking(Integer.valueOf(flatWalking));
				dailyIndexes.setUpanddownStairs(Integer.valueOf(upanddownStairs));
				dailyIndexes.setTotalScore(Integer.valueOf(totalScore));
				
				dailyIndexes.setCreateTime(currentDateTime);
				dailyIndexes.setUpdateTime(currentDateTime);

				dailyIndexesDao.insertSelective(dailyIndexes);
				
				rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
			
			
		}catch(Exception e){
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
		return rtnData;
	}
	
	
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2015/08/03 12:27
	 * @desc 老人公共问题
	 * **/
	public Map<String,Object> saveCommonProblem(Map<String,Object> paramData){
		
//		assessmentId:1		(检查袋id)
//		viability:1			(生成处理能力)
//		workingAbility:1		(工作能力）
//		temporalOrientation:1	(时空定向）
//		personalOrientation:1		(人物定向)
//		socialIntercourse:1		(社会交往能力)
//		totalScore:1			(总分)

		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		try{
			if(
				paramData.containsKey("assessmentId")&&
				paramData.containsKey("viability")&&
				paramData.containsKey("workingAbility")&&
				paramData.containsKey("temporalOrientation")&&
				paramData.containsKey("personalOrientation")&&
				paramData.containsKey("socialIntercourse")&&
				paramData.containsKey("totalScore")
			){
				
				Long currentDateTime=Calendar.getInstance().getTime().getTime();
				
				
				
				String assessmentId= paramData.get("assessmentId").toString();
				String viability=paramData.get("viability").toString();
				String workingAbility=paramData.get("workingAbility").toString();
				String temporalOrientation=paramData.get("temporalOrientation").toString();
				String personalOrientation=paramData.get("personalOrientation").toString();
				String socialIntercourse=paramData.get("socialIntercourse").toString();
				String totalScore=paramData.get("totalScore").toString();
			
				SocialParticipation socialParticipation=new SocialParticipation();
				
				socialParticipation.setCreateTime(currentDateTime);
				socialParticipation.setUpdateTime(currentDateTime);
				
				socialParticipation.setAssessmentId(Long.parseLong(assessmentId));
				socialParticipation.setViability(Byte.valueOf(viability));
				socialParticipation.setWorkingAbility(Byte.valueOf(workingAbility));
				socialParticipation.setTemporalOrientation(Byte.valueOf(temporalOrientation));
				socialParticipation.setPersonalOrientation(Byte.valueOf(personalOrientation));
				socialParticipation.setSocialIntercourse(Byte.valueOf(socialIntercourse));
				socialParticipation.setTotalScore(Integer.parseInt(totalScore));
				socialParticipation.setSocialParticipationId("1a4_"+assessmentId);
				
				
				
				socialParticipationDao.insertSelective(socialParticipation);
				
				rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
			
			
		}catch(Exception e){
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
		return rtnData;
	}
	//精神状态
	
//	`cognitiveFunction` 	tinyint(3) 	not null default -1 comment '0  1 2',
//	`attackBehavior` 		tinyint(3) 	not null default -1 comment '0  1 2',
//	`depressiveSymptoms` 	tinyint(3) 	not null default -1 comment '0  1 2',
//	`totalScore` 			int 		unsigned not null default 0 comment '总分',
	public Map<String,Object> saveMentalIndexes(Map<String,Object> paramData){
		Map<String,Object> rtnData=new HashMap<String, Object>();
		try{
	   if(
			paramData.containsKey("assessmentId")&&
			paramData.containsKey("cognitiveFunction")&&
			paramData.containsKey("attackBehavior")&&
			paramData.containsKey("depressiveSymptoms")&&
			paramData.containsKey("totalScore")
		){
			String assessmentId=paramData.get("assessmentId").toString();
		   	String cognitiveFunction=paramData.get("cognitiveFunction").toString();
		   	String attackBehavior=paramData.get("attackBehavior").toString();
		   	String depressiveSymptoms=paramData.get("depressiveSymptoms").toString();
		   	String totalScore=paramData.get("totalScore").toString();
		   	
		   	
		   	Long currentDateTime=Calendar.getInstance().getTime().getTime();
		   	
		   	MentalIndexes mentalIndexes=new MentalIndexes();
		   	mentalIndexes.setAssessmentId(Long.valueOf(assessmentId));
		   	mentalIndexes.setMentalIndexesId("1a2_"+assessmentId);
		   	mentalIndexes.setCognitiveFunction(Byte.valueOf(cognitiveFunction));
		   	mentalIndexes.setAttackBehavior(Byte.valueOf(attackBehavior));
		   	mentalIndexes.setDepressiveSymptoms(Byte.valueOf(depressiveSymptoms));
		   	mentalIndexes.setTotalScore(Integer.valueOf(totalScore));
		   	
		   	mentalIndexes.setCreateTime(currentDateTime);
		   	mentalIndexes.setUpdateTime(currentDateTime);
		   	mentalIndexesDao.insert(mentalIndexes);
		   	
		   	
		   
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		}catch(Exception e){
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
		return rtnData;
	}
}
