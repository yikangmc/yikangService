package com.yikangyiliao.pension.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yikangyiliao.base.utils.DateUtils;
import com.yikangyiliao.pension.common.constants.YKConstants;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.dao.OperateServiceLogDao;
import com.yikangyiliao.pension.dao.SeniorAccountDao;
import com.yikangyiliao.pension.dao.SeniorLivingConditionDao;
import com.yikangyiliao.pension.entity.Location;
import com.yikangyiliao.pension.entity.OperateServiceLog;
import com.yikangyiliao.pension.entity.SeniorAccount;
import com.yikangyiliao.pension.entity.SeniorLivingCondition;
import com.yikangyiliao.pension.manager.LocationManager;
import com.yikangyiliao.pension.manager.SeniorAccountManager;

/**
 * @author liushuaic
 * @date 2015/07/28 10:45
 * @desc 患者操作
 * 
 * **/
@Service(value = "seniorAccountService")
public class SeniorAccountService {

	private static final Logger logger = Logger
			.getLogger(SeniorAccountService.class);
	
	private ObjectMapper objectMapper=new ObjectMapper();

	@Autowired
	private SeniorAccountDao seniorAccountDao;
	
	@Autowired
	private OperateServiceLogDao operateServiceLogDao;
	
	@Autowired
	private SeniorLivingConditionDao seniorLivingConditionDao;

	@Autowired
	private LocationManager locationManager;
	
	
	@Autowired
	private SeniorAccountManager seniorAccountManager;
	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 10:45
	 * @desc 添加某一个患者
	 * **/
	public Map<String, Object> saveSeniorAccount(Map<String, Object> paramData) {

		Map<String, Object> rtnData = new HashMap<String, Object>();

		try {

			SeniorAccount seniroAccount = new SeniorAccount();

			SeniorLivingCondition seniorLivingCondition=new SeniorLivingCondition();
			
			try {
				
				Date currentDateTime=Calendar.getInstance().getTime();

				String userId=paramData.get("userId").toString();
				
				
				String name = paramData.get("name").toString();
				String sex = paramData.get("sex").toString();
				if(paramData.containsKey("birthday")){
					
					String birthday = paramData.get("birthday").toString();
					String birthYear = birthday.substring(0,birthday.indexOf("-"));
					seniroAccount.setBirthday(DateUtils.getＭillisecond(birthday));
					seniroAccount.setBirthYear(Integer.parseInt(birthYear));
				}
				
				if(paramData.containsKey("cardNumber")){
					String cardNumber = paramData.get("cardNumber").toString();
					String cardType = paramData.get("cardType").toString();
					seniroAccount.setCardNumber(cardNumber);
					seniroAccount.setCardType(Byte.valueOf(cardType));
				}
			
				if(paramData.containsKey("socialSecurity")){
					String socialSecurity = paramData.get("socialSecurity").toString();
					seniroAccount.setSocialSecurity(socialSecurity);
				}
				if(paramData.containsKey("race")){
					String race = paramData.get("race").toString();
					seniroAccount.setRace(race == "0" ? false : true);
				}
				if(paramData.containsKey("faith")){
					String faith = paramData.get("faith").toString();
					seniroAccount.setFaith(Byte.valueOf(faith));
				}
				if(paramData.containsKey("paymentType")){
					String paymentType = paramData.get("paymentType").toString();
					seniroAccount.setPaymentType(Byte.valueOf(paymentType));
				}
				if(paramData.containsKey("incomeSources")){
					String incomeSources = paramData.get("incomeSources").toString();
					seniroAccount.setIncomeSources(Byte.valueOf(incomeSources));
				}
				if(paramData.containsKey("phoneNo")){
					String phoneNo = paramData.get("phoneNo").toString();
					seniroAccount.setPhoneNo(phoneNo);
				}
				if(paramData.containsKey("profession")){
					String profession = paramData.get("profession").toString();
					seniroAccount.setProfession(profession);
				}
				
				
//				if(paramData.containsKey("city")){
//					String city = paramData.get("city").toString();
//					seniorLivingCondition.setCity(city);
//				}
				
				
				if(paramData.containsKey("district")){
					String district = paramData.get("district").toString();
					seniorLivingCondition.setDistrict(district);
					Location location=locationManager.getCityByDistrictCode(district);
					seniorLivingCondition.setCity(location.getAdministrativeCode());
				}
				if(paramData.containsKey("floor")){
					String floor = paramData.get("floor").toString();
					seniorLivingCondition.setFloor(Integer.parseInt(floor));
				}
				if(paramData.containsKey("liveWith")){
					String liveWith = paramData.get("liveWith").toString();
					seniorLivingCondition.setLiveWith(Byte.parseByte(liveWith));
				}
				if(paramData.containsKey("outWindow")){
					String outWindow = paramData.get("outWindow").toString();
					seniorLivingCondition.setOutWindow(outWindow=="0"?false:true);
				}
				
				if(paramData.containsKey("residentialQuarter")){
					String residentialQuarter = paramData.get("residentialQuarter").toString();
					seniorLivingCondition.setResidentialQuarter(residentialQuarter);
				}
				
				
				if(paramData.containsKey("roomOrientation")){
					String roomOrientation = paramData.get("roomOrientation").toString();
					seniorLivingCondition.setRoomOrientation(Byte.parseByte(roomOrientation));
				}
				if(paramData.containsKey("unit")){
					String unit = paramData.get("unit").toString();
					seniorLivingCondition.setUnit(Integer.parseInt(unit));
				}
				String longitude="0";
				if(paramData.containsKey("longitude")){
					longitude = paramData.get("longitude").toString();
				}
				seniorLivingCondition.setLongitude(Double.parseDouble(longitude));
				
				String latitude="0";
				if(paramData.containsKey("latitude")){
					latitude = paramData.get("latitude").toString();
				}
				seniorLivingCondition.setLatitude(Double.parseDouble(latitude));
				
			
					seniroAccount.setName(name);
					seniroAccount.setSex(Byte.valueOf(sex));
					seniroAccount.setCreateTime(currentDateTime.getTime());
					seniroAccount.setUpdateTime(currentDateTime.getTime());
					seniroAccount.setCreateUserId(Long.valueOf(userId));
					
					
					seniorAccountDao.insertSelective(seniroAccount);
					OperateServiceLog operateServiceLog=new OperateServiceLog();
					operateServiceLog.setCreateTime(currentDateTime.getTime());
					operateServiceLog.setUpdateTime(currentDateTime.getTime());
					operateServiceLog.setOperateType(YKConstants.OperateType.insert.getValue().byteValue());
					operateServiceLog.setTableName("senior_account");
					operateServiceLog.setCreateUserId(-1l);
					operateServiceLog.setOpreateContent(objectMapper.writeValueAsString(paramData));
					operateServiceLogDao.insertSelective(operateServiceLog);
				
					
					
					seniorLivingCondition.setSeniorId(seniroAccount.getSeniorId());
					
					seniorLivingConditionDao.insertSelective(seniorLivingCondition);
					Map<String,Object> data=new HashMap<String,Object>();
					data.put("seniorId",  seniroAccount.getSeniorId());
					rtnData.put("data",data);
					rtnData.put("status", "000000");
					rtnData.put("message", "保存成功！");
		

			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
				rtnData.put("status", "999999");
				rtnData.put("message", "数据不正确！");
			}

		} catch (Exception e) {

			logger.error(e);

			rtnData.put("status", "999999");
			rtnData.put("message", "保存失败！");
			e.printStackTrace();

		}

		return rtnData;

	}

	/**
	 * @author liushuaic
	 * @date 2015/07/28 18:06
	 * @desc 删除某一个患者
	 * 
	 * */
	public Map<String, Object> deleteSeniorAccountById(
			Map<String, Object> paramData) {

		Map<String, Object> rtnData = new HashMap<String, Object>();

		try {

			if (null != paramData && null != paramData.get("seniorId")) {
				String seniorId = paramData.get("seniorId").toString();
				if (StringUtils.isEmpty(seniorId)) {
					seniorAccountDao.deleteByPrimaryKey(Long
							.parseLong(seniorId));
				}
			}
			rtnData.put("status", "000000");
			rtnData.put("message", "操作成功！");

		} catch (Exception e) {

			logger.error(e);

			rtnData.put("status", "999999");
			rtnData.put("message", "保存失败！");
			e.printStackTrace();

		}

		return rtnData;
	}

	/**
	 * @author liushuaic
	 * @date 2015/07/27 18:06
	 * @desc 查询某一个患者
	 * 
	 * */
	public Map<String, Object> updateSeniorAccountById(
			Map<String, Object> paramData) {

		Map<String, Object> rtnData = new HashMap<String, Object>();

		try {

			if (null != paramData) {
				SeniorAccount seniorAccount = (SeniorAccount) paramData
						.get("seniroAccount");
				seniorAccountDao.updateByPrimaryKey(seniorAccount);
			}
			rtnData.put("status", "000000");
			rtnData.put("message", "操作成功！");

		} catch (Exception e) {

			logger.error(e);

			rtnData.put("status", "999999");
			rtnData.put("message", "保存失败！");
			e.printStackTrace();

		}

		return rtnData;
	}

	/**
	 * @author liushuaic
	 * @date 2015/07/27 18:06
	 * @desc 查询某一个患者
	 * 
	 * */
	public Map<String, Object> getSeniorAccountById(
			Map<String, Object> paramData) {

		Map<String, Object> rtnData = new HashMap<String, Object>();

		try {

			if (null != paramData && null != paramData.get("seniorId")) {
				String seniorId = paramData.get("seniorId").toString();
				if (StringUtils.isEmpty(seniorId)) {
					SeniorAccount seniorAccount = seniorAccountDao
							.selectByPrimaryKey(Long.parseLong(seniorId));
					rtnData.put("data", seniorAccount);
				}
			}
			rtnData.put("status", "000000");
			rtnData.put("message", "操作成功！");

		} catch (Exception e) {

			logger.error(e);

			rtnData.put("status", "999999");
			rtnData.put("message", "保存失败！");
			e.printStackTrace();

		}

		return rtnData;
	}
	
    
    /**
     * @author liushuaic
     * @date 2015/07/30 18:50
     * @desc 查询某一个用户下的所有的 老人信息
     * 
     * */
	public  Map<String,Object> getSeniorAccountByUserId(Map<String,Object> paramData){
		Map<String, Object> rtnData = new HashMap<String, Object>();
		

		try {
			if(null != paramData.get("userId").toString()){
				String userId=paramData.get("userId").toString();
				List<SeniorAccount> data=seniorAccountDao.getSeniorAccountByUserId(Long.parseLong(userId));
				rtnData.put("data",data);
				rtnData.put("status","000000");
				rtnData.put("message","操作成功！");
			}else {
				rtnData.put("status","999999");
				rtnData.put("message","操作失败！");
			}
			
		}catch(Exception e){
			logger.error(e.getMessage());
			rtnData.put("status","999999");
			rtnData.put("message","操作失败！");
			e.printStackTrace();
		}
    	return rtnData;
    }
	
	
	/**
	 * @author liushuaic
	 * @date 2015/11/17 18:28
	 * @desc 查询用户推荐的患者
	 * 
	 * **/
	public Map<String,Object> getSeniorAccountInfoByInvitationUserId(Map<String,Object> paramData){
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		try{
			if(paramData.containsKey("userStatus")){
				
				String userStatus=paramData.get("userStatus").toString();
				if(userStatus.equals("-1") || userStatus.equals("0") || userStatus.equals("1")){
					String userId=paramData.get("userId").toString();
					List<Map<String,Object>> rtnData=seniorAccountManager.getSeniorAccountInfoByInvitationUserId(Integer.valueOf(userStatus),Long.valueOf(userId));
					DateUtils.formateListObejctDateMilins(rtnData, "createTime");
					rtnMap.put("data", rtnData);
					rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
					rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
				}else{
					rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
					rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
				}
				
			}else{
				rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			rtnMap.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnMap.put("message", ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return rtnMap;
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/12/28 17:18
	 * @desc 查询某一个
	 * */
	public ResponseMessage getSeniorAccountByClentUserId(Map<String,Object> paramData){
		
		ResponseMessage responseMessage=new ResponseMessage();
		
		try{
			
			if(paramData.containsKey("userId")){
				
				String userId=paramData.get("userId").toString();
				List<SeniorAccount> data=seniorAccountManager.getSeniorAccountByCreateUserId(Long.valueOf(userId));
				responseMessage.setData(data);
				responseMessage.setStatus( ExceptionConstants.responseSuccess.responseSuccess.code);
				responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			responseMessage.setStatus( ExceptionConstants.systemException.systemException.errorCode);
			responseMessage.setMessage( ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		
		return responseMessage;
		
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-03-18 16:00
	 * @desc 查询某一个
	 * */
	public ResponseMessage getMyinvitationUserByUserId(Map<String,Object> paramData){
		
		ResponseMessage responseMessage=new ResponseMessage();
		
		try{
			
			if(paramData.containsKey("userId")){
				
				String userId=paramData.get("userId").toString();
				
				//List<SeniorAccount> data=seniorAccountManager.getMyinvitationUserByUserId(Long.valueOf(userId));
				//responseMessage.setData(data);
				
				
				
				responseMessage.setStatus( ExceptionConstants.responseSuccess.responseSuccess.code);
				responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			responseMessage.setStatus( ExceptionConstants.systemException.systemException.errorCode);
			responseMessage.setMessage( ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		
		return responseMessage;
		
		
	}
	
	
}
