package com.yikangyiliao.pension.service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yikangyiliao.base.utils.DateUtils;
import com.yikangyiliao.base.utils.ParamMapUtils;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.page.PageParameter;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Activety;
import com.yikangyiliao.pension.entity.ActivetyComment;
import com.yikangyiliao.pension.manager.ActivetyCommentManager;
import com.yikangyiliao.pension.manager.ActivetyManager;
import com.yikangyiliao.pension.manager.IntegralManager;
import com.yikangyiliao.pension.manager.UserActivetyListManager;

@Service(value="activetyService")
public class ActivetyService {

	@Autowired
	private ActivetyManager activetyManager;
	
	
	@Autowired
	private UserActivetyListManager activetyListManager;
	
	
	@Autowired
	private ActivetyCommentManager activetyCommentManager;
	
	@Autowired
	private IntegralManager integralManager;
	
	
	/**
     * @author liushuaic
     * @date 2016-05-13 10:19
     * @desc 获取所有活动
     * **/
	public ResponseMessage<List<Activety>> getActivetys(Map<String,Object> paramMap){
		ResponseMessage<List<Activety>> resData=new ResponseMessage<List<Activety>>(); 
			
			Long userId=null;
			if(paramMap.containsKey("userId") && (!StringUtils.isEmpty(paramMap.get("userId")))){
				Long.valueOf(paramMap.get("userId").toString());
			}
			List<Activety> data=activetyManager.getActivetys(userId);
			resData.setData(data);
		
		return resData;
		 
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-13 16:19
	 * @desc 获取某一个活动
	 * **/
	public ResponseMessage<Activety> getActivetyByActivetyId(Map<String,Object> paramMap){
		ResponseMessage<Activety> resData=new ResponseMessage<Activety>(); 
		if(
			paramMap.containsKey("activetyId")  && (!StringUtils.isEmpty(paramMap.get("activetyId")))
			&& paramMap.containsKey("userId")  && (!StringUtils.isEmpty(paramMap.get("userId")))
		){
			Long activetyId=Long.valueOf(paramMap.get("activetyId").toString());
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			Activety activety=activetyManager.getActivetysDetailById(userId,activetyId);
			resData.setData(activety);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return resData;
	}
	
	/**
	 * @author liushuaic
	 * @date 
	 * @desc 添加活动
	 * **/
	public ResponseMessage<Activety> insertActivety(Map<String,Object> paramMap){
		ResponseMessage<Activety> resData=new ResponseMessage<Activety>();
		if(
			   paramMap.containsKey("title")
			&& paramMap.containsKey("content")
			&& paramMap.containsKey("startTime")
			&& paramMap.containsKey("endTime")
			&& paramMap.containsKey("entryStartTime")
			&& paramMap.containsKey("entryEndTime")
			&& paramMap.containsKey("personNumber")
			&& paramMap.containsKey("cost")
			&& paramMap.containsKey("activetyMode")
		 ){
			String title=paramMap.get("title").toString();
			String content=paramMap.get("content").toString();
			
			Date startTime = null;
			try {
				startTime = DateUtils.formateDateTime(paramMap.get("startTime").toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date endTime=null;
			try {
				endTime = DateUtils.formateDateTime(paramMap.get("endTime").toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Date entryStartTime=null;
			try {
				entryStartTime=DateUtils.formateDateTime(paramMap.get("entryStartTime").toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date entryEndTime=null;
			try {
				entryEndTime=DateUtils.formateDateTime(paramMap.get("entryEndTime").toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String mapPositionAddress="";
			if(paramMap.containsKey("mapPositionAddress")){
				mapPositionAddress=paramMap.get("mapPositionAddress").toString();
			}
			String detailAddress="";
			if(paramMap.containsKey("detailAddress")){
				detailAddress=paramMap.get("detailAddress").toString();
			}
			String districtCode="";
			if(paramMap.containsKey("districtCode")){
				 districtCode=paramMap.get("districtCode").toString();
			}
			
			//获取经度
			Double lng=0d;
			if(paramMap.containsKey("lng")){
				lng=Double.valueOf(paramMap.get("lng").toString());
			}
			//纬度
			Double lat=0d;
			if(paramMap.containsKey("lat")){
				lat=Double.valueOf(paramMap.get("lat").toString());
			}
			
			Integer personNumber=Integer.valueOf(paramMap.get("personNumber").toString());
			Double cost=Double.valueOf(paramMap.get("cost").toString());
			
			//标签
			Long[] taglibIds=null;
			if(paramMap.containsKey("taglibs")){
				List taglibs=(List)paramMap.get("taglibs");
				taglibIds=ParamMapUtils.converObjectArrayToLong(taglibs);
			}
			
			
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			
			Byte activetyMode=Byte.valueOf(paramMap.get("activetyMode").toString());
			
			String recommendPicUrl="";
			if(paramMap.containsKey("recommendPicUrl")){
				recommendPicUrl=paramMap.get("recommendPicUrl").toString();
			}
			
			activetyManager.insertActivety(title,content,startTime,endTime,entryStartTime,entryEndTime,lng,lat,personNumber,cost,taglibIds,mapPositionAddress,detailAddress,districtCode,userId,activetyMode,recommendPicUrl);
			integralManager.insertIntegralAddScoreIsUsualJob("FBHD",Byte.valueOf("2"),userId);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return resData;
	}
	
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2016-05-17 18:33
	 * @desc 添加我参与的活动
	 * 
	 * **/
	public ResponseMessage<String> insertMyAcitivety(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		
		if(paramMap.containsKey("activetyId")){
			
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			Long activetyId=Long.valueOf(paramMap.get("activetyId").toString());
			//判断是否已经参见了活动
			//判断活动是否，可以接收报名
			Activety myActivety=activetyManager.getActivetyByUserIdAndActivetyId(userId, activetyId);
			if(null == myActivety){
				Activety activety=activetyManager.selectByPrimaryKey(activetyId);
				Long currentDateTime=Calendar.getInstance().getTime().getTime();
				if(activety.getEntryStartTime().getTime()<currentDateTime && activety.getEntryEndTime().getTime()>currentDateTime){
					activetyListManager.insertUserActivetyList(activetyId, userId);
					resData.setMessage("活动报名成功！");
				}else{
					resData.setStatus(ExceptionConstants.activetyException.activetyIsEnd.errorCode);
					resData.setMessage(ExceptionConstants.activetyException.activetyIsEnd.errorMessage);
				}
			}else{
				resData.setStatus(ExceptionConstants.activetyException.isPartake.errorCode);
				resData.setMessage(ExceptionConstants.activetyException.isPartake.errorMessage);
			}
			
			
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return resData;
		
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-05-18 16:34
	 * @desc 文章评论
	 * **/
	public ResponseMessage<String> insertActivetyComment(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		
		if(
				paramMap.containsKey("activetyId")
			&& paramMap.containsKey("content")
			){
			
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			Long activetyId=Long.valueOf(paramMap.get("activetyId").toString());
			String content=paramMap.get("content").toString();
			
			activetyCommentManager.insertActivetyComment(activetyId, content, userId);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return resData;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-05-19 16:39
	 * @desc 获取活动的评论列表
	 * ***/
	public ResponseMessage<List<ActivetyComment>> getActivetyCommentByActivetyId(Map<String,Object> paramMap){
		ResponseMessage<List<ActivetyComment>> resData=new ResponseMessage<List<ActivetyComment>>();
		if(
				paramMap.containsKey("activetyId")
		 ){
			Long activetyId=Long.valueOf(paramMap.get("activetyId").toString());
			List<ActivetyComment> data=activetyCommentManager.getActivetyCommentList(activetyId);
			resData.setMessage("获取成功！");
			resData.setData(data);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-23 10:57
	 * @desc 获取我参加的活动列表
	 * **/
	public ResponseMessage<List<Activety>> getActiveyByJoinUserId(Map<String,Object> paramMap){
		
		ResponseMessage<List<Activety>> resData=new ResponseMessage<List<Activety>>();
		
		if(paramMap.containsKey("userId")){
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", userId);
			List<Activety> activetys= activetyListManager.getMyActivetyByUserId(map);
			resData.setData(activetys);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-09-08 10:20
	 * @desc 获取某一个用户创建的活动  分页
	 * **/
	public ResponseMessage<List<Activety>> getActivetyByCreateUserIdPage(Map<String,Object> paramMap){
		
		ResponseMessage<List<Activety>> resData=new ResponseMessage<List<Activety>>();
		
		if(paramMap.containsKey("userId")&&paramMap.containsKey("page")){
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			Integer currentPage = Integer.valueOf(paramMap.get("page").toString());
			PageParameter pageParameter = new PageParameter();
			pageParameter.setCurrentPage(currentPage);
			List<Activety> activetys=activetyManager.selectActivetyByUserIdPage(userId, pageParameter);
			resData.setData(activetys);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return resData;
		
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-23 10:57
	 * @desc 获取我参加的活动列表
	 * **/
	public ResponseMessage<List<Activety>> getActiveyByJoinUserIdPage(Map<String,Object> paramMap){
		
		ResponseMessage<List<Activety>> resData=new ResponseMessage<List<Activety>>();
		
		if(paramMap.containsKey("serverUserId")&&paramMap.containsKey("page")){
			Long userId=Long.valueOf(paramMap.get("serverUserId").toString());
			Integer currentPage = Integer.valueOf(paramMap.get("page").toString());
			PageParameter pageParameter = new PageParameter();
			pageParameter.setCurrentPage(currentPage);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", userId);
			map.put("page", pageParameter);
			List<Activety> activetys= activetyListManager.getMyActivetyByUserIdPage(map);
			resData.setData(activetys);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return resData;
	}
	
	
	
	
}
