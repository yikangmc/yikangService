package com.yikangyiliao.pension.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.utils.GenreateNumberUtils;
import com.yikangyiliao.pension.entity.Assessment;
import com.yikangyiliao.pension.entity.SeniorAccount;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.manager.AssessmentManager;
import com.yikangyiliao.pension.manager.SeniorAccountManager;
import com.yikangyiliao.pension.manager.UserManager;


@Service(value="assessmentService")
public class AssessmentService {
	
	@Autowired
	private AssessmentManager assessmentManager;
	
	@Autowired
	private GenreateNumberUtils  genreateNumberUtils;
	
	@Autowired
	private SeniorAccountManager seniorAccountManager;
	
	
	@Autowired
	private UserManager userManager;  
	
	/**
	 * @author liushuaic
	 * @date 2015/08/13 12:25
	 * 保存一个病例夹
	 * **/
	public Map<String,Object> saveAssessment(Map<String,Object> paramData){
			 Map<String,Object> rtnMap=new HashMap<String, Object>();
			 
			if(null != paramData){
				
				String seniorId=paramData.get("seniorId").toString();
				String userId=paramData.get("userId").toString();
				SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String assessmentName=sdf.format(Calendar.getInstance().getTime());
				
				User user=userManager.selectByPrimaryKey(Long.parseLong(userId));
				
				Long currentDateTime=Calendar.getInstance().getTimeInMillis();
				
				// 档案袋编号
//				accountString 患者名称  用pin4j 转成  每个汉字的第一个字符
//				scaleName 评估人名称
				SeniorAccount seniorAccount=seniorAccountManager.selectByPrimaryKey(Long.parseLong(seniorId));
				String assessmentNumber= genreateNumberUtils.generateAssessmentNumber(seniorAccount.getName(),user.getUserName());
				
				
				Assessment assessment=new Assessment();
				assessment.setAppraisersId(user.getUserId());
				assessment.setAppraisersName(user.getUserName());
				assessment.setAssessmentName(assessmentName);
				assessment.setCreateTime(currentDateTime);
				assessment.setUpdateTime(currentDateTime);
				assessment.setSeniorId(Long.valueOf(seniorId));
				assessment.setAssessmentNumber(assessmentNumber);
				assessmentManager.insertSelective(assessment);
				Map<String,Object> rtnData=new HashMap<String,Object>();
				rtnData.put("assessmentId", assessment.getAssessmentId());
				rtnMap.put("data", rtnData);
				rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnMap.put("message",ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
			
			return rtnMap;
	}

	
	/**
	 * @author liushuaic
	 * @date 2015/08/13 12:25
	 * 获取某一个患者的所有病例夹
	 * **/
	public Map<String,Object> getAssessmentBySeniorId(Map<String,Object> paramData){
			 Map<String,Object> rtnMap=new HashMap<String, Object>();
			 
			if(null != paramData &&  paramData.containsKey("seniorId")){
				
				String seniorId=paramData.get("seniorId").toString();
				List<Assessment> data=assessmentManager.getAssessmentBySeniorId(Long.valueOf(seniorId));
				rtnMap.put("data", data);
				rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnMap.put("message",ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
			
			return rtnMap;
	}
// ae7433528cdd54dc76e922c1d612c82d3ac401f2dcf94d01c3e66576d38dcfbb5e4c7afd323d91954ba85f0a1bf9bb45
}
