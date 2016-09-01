package com.yikangyiliao.pension.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.base.utils.AliasFactory;
import com.yikangyiliao.base.utils.DateUtils;
import com.yikangyiliao.base.utils.InvitationCodeGnerateUtil;
import com.yikangyiliao.base.utils.SystemProperties;
import com.yikangyiliao.base.utils.messageUtil.SMSUtil;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.common.utils.map.MapUtils;
import com.yikangyiliao.pension.common.utils.map.model.GeoCodeModel;
import com.yikangyiliao.pension.entity.Location;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserFrom;
import com.yikangyiliao.pension.entity.UserInfo;
import com.yikangyiliao.pension.entity.UserModel;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.manager.IntegralManager;
import com.yikangyiliao.pension.manager.LocationManager;
import com.yikangyiliao.pension.manager.ThreePartAccountManager;
import com.yikangyiliao.pension.manager.UserAdeptMapManager;
import com.yikangyiliao.pension.manager.UserConfigrationManager;
import com.yikangyiliao.pension.manager.UserFromManager;
import com.yikangyiliao.pension.manager.UserManager;
import com.yikangyiliao.pension.manager.UserServiceInfoManager;
import com.yikangyiliao.pension.responseDataModel.MyInvationUserModel;

@Service(value = "userService")
public class UserService {

	@Autowired
	private UserManager userManager;

	@Autowired
	private LocationManager locationManager;

	@Autowired
	private UserFromManager userFromManager;
	
	@Autowired
	private IntegralManager integralManager;

//	@Autowired
//	private OfficeManager officeManager;
//
//	@Autowired
//	private AdeptManager adeptManager;
	
	@Autowired
	private UserAdeptMapManager adeptMapManager;
	
	@Autowired
	private UserServiceInfoManager userServiceInfoManager;
	
	@Autowired
	private UserConfigrationManager userConfigrationManager;
	
	@Autowired
	private ThreePartAccountManager threePartAccountManager;
	
	
	private Logger logger=LoggerFactory.getLogger(UserService.class);

	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:44 注册用户及保存用户信息
	 **/
	public Map<String, Object> saveRegisterUserAndSaveServiceInfo(Map<String, Object> paramData) {
		Map<String, Object> rtnData = new HashMap<String, Object>();
		if (
				paramData.containsKey("loginName")
				&& paramData.containsKey("passWord") 
				&& paramData.containsKey("userName")
		) {
			String loginName = paramData.get("loginName").toString();
			User u = userManager.getUserByLoginName(loginName);
			if (null == u) {

				Long currentDateTime = Calendar.getInstance().getTimeInMillis();

				String passWord = paramData.get("passWord").toString();
				String userName = paramData.get("userName").toString();

				//默认-2 未填写
				String jobCategory = "-2";
				if (paramData.containsKey("jobCategory")) {
					jobCategory = paramData.get("jobCategory").toString();
				}
				
				//默认-2 未填写
				String mapPositionAddress = "";
				if (paramData.containsKey("mapPositionAddress")) {
					mapPositionAddress = paramData.get("mapPositionAddress").toString();
				}
				//默认-2 未填写
				String districtCode = "-2";
				if (paramData.containsKey("districtCode")) {
					districtCode = paramData.get("districtCode").toString();
				}
				//默认空串
				String addressDetail = "";
				if (paramData.containsKey("addressDetail")) {
					addressDetail = paramData.get("addressDetail").toString();
				}

				//默认空串
				String photoUrl = "";
				if (paramData.containsKey("photoUrl")) {
					photoUrl = paramData.get("photoUrl").toString();
				}
				//默认空串
				String offices = ""; 
				if (paramData.containsKey("offices")) {
					photoUrl = paramData.get("offices").toString();
				}
				
				// 职位
				Byte userPosition=0;  //默认是未认证
				if( paramData.containsKey("userPosition")){
					userPosition=Byte.valueOf(paramData.get("userPosition").toString());
				}
				

				User user = new User();
				user.setUserName(userName);
				user.setLoginName(loginName);
				user.setLoginPassword(passWord);
				user.setCreateTime(currentDateTime);
				user.setSalt("000000");
				user.setLoginTime(currentDateTime);
				user.setPushAlias("");
				user.setInvitationCode("");

				userManager.insertUserSelective(user);
				user.setUserName(null);
				user.setLoginName(null);
				user.setLoginPassword(null);
				user.setCreateTime(null);
				user.setSalt(null);
				user.setLoginTime(null);
				user.setPushAlias(AliasFactory.generateAliasByUser(user.getUserId().toString()));
				userManager.updateUser(user); // 修改用户推送
				// 修改用户邀请码
				userManager.updateInvitationCodeByUserId(InvitationCodeGnerateUtil.generateInvitationCodeTwo(user),
						user.getUserId());
				
				// 初始化用户信息
				UserInfo userInfo=new UserInfo();
				userInfo.setBirthday(null);
				userInfo.setCityCode("");
				userInfo.setCreateAt(currentDateTime.longValue());
				userInfo.setDistrictCode("");
				userInfo.setProvenceCode("");
				userInfo.setCityCode("");
				userInfo.setPhotoUrl("");
				userInfo.setUserIntroduce("");
				userInfo.setUserSex(Byte.valueOf("0"));
				userInfo.setUserName(userName);
				userInfo.setIsDelete(0l);
				userInfo.setUpdateAt(currentDateTime);
				userInfo.setUserId(user.getUserId());
				userManager.insertSelective(userInfo);
				
				
				//初始化服务人员信息
				UserServiceInfo userServiceInfo = new UserServiceInfo();
				userServiceInfo.setUserId(user.getUserId());
				userServiceInfo.setPhotoUrl(photoUrl);
				userServiceInfo.setProvenceCode(Long.valueOf("0"));
				userServiceInfo.setAddressDetail(addressDetail);
				userServiceInfo.setOffices(Integer.valueOf(offices));
				userServiceInfo.setJobCategory(Long.valueOf(jobCategory));
				userServiceInfo.setUserPosition(userPosition);

				userServiceInfo.setDistrictCode(Long.valueOf(districtCode));

				userServiceInfo.setCreateTime(currentDateTime);
				userServiceInfo.setUpdateTime(currentDateTime);
				userServiceInfo.setIsDelete(Byte.valueOf("0"));
				userServiceInfo.setUserServiceName(userName);

				String hospital = "";
				if (paramData.containsKey("hospital")) {
					hospital = paramData.get("hospital").toString();
				}
				userServiceInfo.setHospital(hospital);
				if (paramData.containsKey("offices")) {
					userServiceInfo.setOffices(Integer.valueOf(paramData.get("offices").toString()));
				}
				if (paramData.containsKey("adept")) {
					userServiceInfo.setAdept(paramData.get("adept").toString());
				}

				// 反推一下，用户用户地址

				Location city = locationManager.getCityByDistrictCode(districtCode);
				Location provence = locationManager.getProvenceByCityCode(districtCode);
				if (null != city) {
					userServiceInfo.setCityCode(Long.valueOf(city.getAdministrativeCode()));
				} else {
					userServiceInfo.setCityCode(0L);
				}
				if (null != provence) {
					userServiceInfo.setProvenceCode(Long.valueOf(provence.getAdministrativeCode()));
				} else {
					userServiceInfo.setProvenceCode(0L);
				}
				userServiceInfo.setMapPositionAddress(mapPositionAddress);

				// 设置经纬度
				if (mapPositionAddress.length() > 0) {
					try {
						if (null != city) {
							GeoCodeModel geoCodeModel = MapUtils.getGeoCodeModelByAddress(mapPositionAddress,
									city.getAdministrativeCode());
							if (null != geoCodeModel.getGeocodes() && geoCodeModel.getGeocodes().size() > 0) {
								// TODO 有可能模糊地址对应的有多个这个问题要修改
								String lngLatStr = geoCodeModel.getGeocodes().get(0).getLocation();
								String lngStr = lngLatStr.split(",")[0];
								String latStr = lngLatStr.split(",")[1];
								userServiceInfo.setLongitude(Double.valueOf(lngStr));
								userServiceInfo.setLatitude(Double.valueOf(latStr));
							} else {
								userServiceInfo.setLongitude(0d);
								userServiceInfo.setLatitude(0d);
							}
						} else {
							userServiceInfo.setLongitude(0d);
							userServiceInfo.setLatitude(0d);
						}

					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					userServiceInfo.setLongitude(0d);
					userServiceInfo.setLatitude(0d);
				}

				userManager.insertUserServiceSelective(userServiceInfo);

				if (paramData.containsKey("invitationCode")) {
					UserFrom userFrom = new UserFrom();
					userFrom.setUserId(user.getUserId());
					userFrom.setFromUrl("");
					userFrom.setInvitationCode(paramData.get("invitationCode").toString());
					userFrom.setCreateTime(currentDateTime);
					userFrom.setUpdateTime(currentDateTime);
					// 设置为用户注册
					userFrom.setUserFrom("5");
					userFrom.setUserStatus(Byte.valueOf("0"));
					userFrom.setNumbers(0l);
					userFrom.setActiveTime(0l);
					userFromManager.insertSelective(userFrom);
				}
				
				userConfigrationManager.insertSelective(1, 1, user.getUserId());

				rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			} else {
				rtnData.put("status", ExceptionConstants.operationException.userDuplicateException.errorCode);
				rtnData.put("message", ExceptionConstants.operationException.userDuplicateException.errorMessage);
			}
		} else {
			rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnData;
	}

	
	
	public ResponseMessage<String> insertRegisterUserForThreepart(Map<String,Object> paramData){
		
		ResponseMessage<String> resData=new ResponseMessage<String>();
		
		if(
			paramData.containsKey("userName")
		    && paramData.containsKey("gender")
		    && paramData.containsKey("accountId")
		    && paramData.containsKey("threePartAccountInfo")
		    && paramData.containsKey("userSource")
		){
			Date currentDate= Calendar.getInstance().getTime();
			Long currentDateTime = Calendar.getInstance().getTimeInMillis();
			
			String userName=paramData.get("userName").toString();
			String gender=paramData.get("gender").toString();
			String accountId=paramData.get("accountId").toString();
			String threePartAccountInfo=paramData.get("threePartAccountInfo").toString();
			Byte userSource=Byte.valueOf(paramData.get("userSource").toString());
			
			
			Byte sex=Byte.valueOf("0");
			if(null != gender &&  gender.length()==1){
				if(gender.equals("男") || gender.equals("m") || gender.equals("1")){
					sex=Byte.valueOf("1");
				}else if(gender.equals("女") || gender.equals("wm") || gender.equals("2")){
					sex=Byte.valueOf("2");
				}
			}
			
		

			UserInfo users = userManager.getUserIdByThreePartAccountId(accountId);
			if (null == users) {
				String passWord = "-2";

				User user = new User();
				user.setUserName(userName);
				user.setLoginName(accountId);
				user.setLoginPassword(passWord);
				user.setCreateTime(currentDateTime);
				user.setSalt("000000");
				user.setLoginTime(currentDateTime);
				user.setPushAlias("");
				user.setInvitationCode("");
				user.setInfoWrite((byte)0); //设置为没有填写个人信息

				userManager.insertUserSelective(user);
				
				user.setUserName(null);
				user.setLoginName(null);
				user.setLoginPassword(null);
				user.setCreateTime(currentDateTime);
				user.setSalt(null);
				user.setLoginTime(null);
				user.setPushAlias(AliasFactory.generateAliasByUser(user.getUserId().toString()));
				userManager.updateUser(user); // 修改用户推送
				// 修改用户邀请码
				userManager.updateInvitationCodeByUserId(InvitationCodeGnerateUtil.generateInvitationCodeTwo(user),
						user.getUserId());

				UserServiceInfo userServiceInfo = new UserServiceInfo();
				userServiceInfo.setUserId(user.getUserId());
				userServiceInfo.setPhotoUrl("");
				userServiceInfo.setProvenceCode(Long.valueOf("0"));
				userServiceInfo.setAddressDetail("");
				userServiceInfo.setOffices(Integer.valueOf(-2));
				userServiceInfo.setJobCategory(Long.valueOf(-2));
				userServiceInfo.setUserPosition(Byte.valueOf("0"));

				userServiceInfo.setDistrictCode(Long.valueOf(-2));

				userServiceInfo.setCreateTime(currentDateTime);
				userServiceInfo.setUpdateTime(currentDateTime);
				userServiceInfo.setIsDelete(Byte.valueOf("0"));
				userServiceInfo.setUserServiceName("");
				userServiceInfo.setCityCode(Long.valueOf(0));
				userServiceInfo.setDistrictCode(Long.valueOf(0));
				userServiceInfo.setMapPositionAddress("");
				userServiceInfo.setUserName(userName);
				String hospital = "";
				if (paramData.containsKey("hospital")) {
					hospital = paramData.get("hospital").toString();
				}
				userServiceInfo.setHospital(hospital);
				if (paramData.containsKey("offices")) {
					userServiceInfo.setOffices(Integer.valueOf(paramData.get("offices").toString()));
				}
				if (paramData.containsKey("adept")) {
					userServiceInfo.setAdept(paramData.get("adept").toString());
				}
				

				userServiceInfo.setLongitude(0d);
				userServiceInfo.setLatitude(0d);

				userManager.insertUserServiceSelective(userServiceInfo);
				
				
				

//				ThreePartAccount threePartAccount=new ThreePartAccount();
//				threePartAccount.setAccountId(accountId);
//				threePartAccount.setCreateTime(currentDate);
//				threePartAccount.setUpdateTime(currentDate);
//				threePartAccount.setUserName(userName);
//				threePartAccount.setUserSource(userSource);
//				threePartAccount.setUserId(user.getUserId());
//				threePartAccount.setThreePartAccountInfo(threePartAccountInfo);
				threePartAccountManager.insertSelective(userName, gender, accountId, userSource, threePartAccountInfo,user.getUserId());
				

				UserFrom userFrom = new UserFrom();
				userFrom.setUserId(user.getUserId());
				userFrom.setFromUrl("");
				if (paramData.containsKey("invitationCode")) {
					userFrom.setInvitationCode(paramData.get("invitationCode").toString());
				} else {
					userFrom.setInvitationCode("");
				}
				userFrom.setCreateTime(currentDateTime);
				userFrom.setUpdateTime(currentDateTime);
				// 设置为用户注册
				if(paramData.containsKey("userFrom")){
					String userFromStr=paramData.get("userFrom").toString();
					userFrom.setUserFrom(userFromStr);
				}else{
					userFrom.setUserFrom("6");
				}
				userFrom.setUserStatus(Byte.valueOf("0"));
				userFrom.setNumbers(0l);
				userFrom.setActiveTime(0l);
				userFromManager.insertSelective(userFrom);


				// 初始化用户信息
				UserInfo userInfo=new UserInfo();
				userInfo.setBirthday(null);
				userInfo.setCityCode("");
				userInfo.setCreateAt(currentDateTime.longValue());
				userInfo.setDistrictCode("");
				userInfo.setProvenceCode("");
				userInfo.setCityCode("");
				userInfo.setPhotoUrl("");
				userInfo.setUserIntroduce("");
				userInfo.setUserSex(sex);
				userInfo.setUserName(userName);
				userInfo.setIsDelete(0l);
				userInfo.setUpdateAt(currentDateTime);
				userInfo.setUserId(user.getUserId());
				userInfo.setAddress("");
				userManager.insertSelective(userInfo);

				resData.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
				resData.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
			} else {
				resData.setStatus( ExceptionConstants.systemException.systemException.errorCode);
				resData.setMessage("用户已注册！");
			}
			
			
			
		}
		
		
		return resData;
		
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:44 注册用户
	 **/
	public Map<String, Object> registerUser(Map<String, Object> paramData) {
		Map<String, Object> rtnData = new HashMap<String, Object>();
		if (paramData.containsKey("loginName") && paramData.containsKey("password")) {

			Long currentDateTime = Calendar.getInstance().getTimeInMillis();

			String loginName = paramData.get("loginName").toString();
			User users = userManager.getUserByLoginName(loginName);
			if (null == users) {
				String passWord = paramData.get("password").toString();

				User user = new User();
				String userName="";
				if(null != loginName && loginName.length()==11){
					userName=loginName.substring(0,3)+"****"+loginName.substring(7,11);
				}else{
					userName=loginName;
				}
				user.setUserName(userName);
				user.setLoginName(loginName);
				user.setLoginPassword(passWord);
				user.setCreateTime(currentDateTime);
				user.setSalt("000000");
				user.setLoginTime(currentDateTime);
				user.setPushAlias("");
				user.setInvitationCode("");
				user.setInfoWrite((byte)0); //设置为没有填写个人信息

				userManager.insertUserSelective(user);
				
				user.setUserName(null);
				user.setLoginName(null);
				user.setLoginPassword(null);
				user.setCreateTime(currentDateTime);
				user.setSalt(null);
				user.setLoginTime(null);
				user.setPushAlias(AliasFactory.generateAliasByUser(user.getUserId().toString()));
				userManager.updateUser(user); // 修改用户推送
				// 修改用户邀请码
				userManager.updateInvitationCodeByUserId(InvitationCodeGnerateUtil.generateInvitationCodeTwo(user),
						user.getUserId());

				UserServiceInfo userServiceInfo = new UserServiceInfo();
				userServiceInfo.setUserId(user.getUserId());
				userServiceInfo.setPhotoUrl("");
				userServiceInfo.setProvenceCode(Long.valueOf("0"));
				userServiceInfo.setAddressDetail("");
				userServiceInfo.setOffices(Integer.valueOf(-2));
				userServiceInfo.setJobCategory(Long.valueOf(-2));
				userServiceInfo.setUserPosition(Byte.valueOf("0"));

				userServiceInfo.setDistrictCode(Long.valueOf(-2));

				userServiceInfo.setCreateTime(currentDateTime);
				userServiceInfo.setUpdateTime(currentDateTime);
				userServiceInfo.setIsDelete(Byte.valueOf("0"));
				userServiceInfo.setUserServiceName("");
				userServiceInfo.setCityCode(Long.valueOf(0));
				userServiceInfo.setDistrictCode(Long.valueOf(0));
				userServiceInfo.setMapPositionAddress("");
				
				String hospital = "";
				if (paramData.containsKey("hospital")) {
					hospital = paramData.get("hospital").toString();
				}
				userServiceInfo.setHospital(hospital);
				if (paramData.containsKey("offices")) {
					userServiceInfo.setOffices(Integer.valueOf(paramData.get("offices").toString()));
				}
				if (paramData.containsKey("adept")) {
					userServiceInfo.setAdept(paramData.get("adept").toString());
				}
				

				userServiceInfo.setLongitude(0d);
				userServiceInfo.setLatitude(0d);

				userManager.insertUserServiceSelective(userServiceInfo);

				UserFrom userFrom = new UserFrom();
				userFrom.setUserId(user.getUserId());
				userFrom.setFromUrl("");
				if (paramData.containsKey("invitationCode")) {
					userFrom.setInvitationCode(paramData.get("invitationCode").toString());
				} else {
					userFrom.setInvitationCode("");
				}
				userFrom.setCreateTime(currentDateTime);
				userFrom.setUpdateTime(currentDateTime);
				// 设置为用户注册
				if(paramData.containsKey("userFrom")){
					String userFromStr=paramData.get("userFrom").toString();
					userFrom.setUserFrom(userFromStr);
				}else{
					userFrom.setUserFrom("6");
				}
				userFrom.setUserStatus(Byte.valueOf("0"));
				userFrom.setNumbers(0l);
				userFrom.setActiveTime(0l);
				userFromManager.insertSelective(userFrom);


				// 初始化用户信息
				UserInfo userInfo=new UserInfo();
				userInfo.setBirthday(null);
				userInfo.setCityCode("");
				userInfo.setCreateAt(currentDateTime.longValue());
				userInfo.setDistrictCode("");
				userInfo.setProvenceCode("");
				userInfo.setCityCode("");
				userInfo.setPhotoUrl("");
				userInfo.setUserIntroduce("");
				userInfo.setUserSex(Byte.valueOf("0"));
				userInfo.setUserName(userName);
				userInfo.setIsDelete(0l);
				userInfo.setUpdateAt(currentDateTime);
				userInfo.setUserId(user.getUserId());
				userInfo.setAddress("");
				userManager.insertSelective(userInfo);

				rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			} else {
				rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
				rtnData.put("message", "用户已注册！");
			}

		} else {
			rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnData;
	}

	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:44 注册用户及保存用户信息
	 **/
	public Map<String, Object> saveServiceUserInfo(Map<String, Object> paramData) {

		// 用户id 在paramData中存着
		Map<String, Object> rtnData = new HashMap<String, Object>();
		if (
				paramData.containsKey("userPostion") // 职位
				&& paramData.containsKey("jobCategory") // 全职，兼职
				&& paramData.containsKey("provenceCode") && paramData.containsKey("cityCode")
				&& paramData.containsKey("districtCode") && paramData.containsKey("addressDetail")
				&& paramData.containsKey("photoUrl") && paramData.containsKey("userName")) {

			Long currentDateTime = Calendar.getInstance().getTimeInMillis();

			String userId = paramData.get("userId").toString();
			Byte userPostion = Byte.valueOf(paramData.get("userPostion").toString());
			String jobCategory = paramData.get("jobCategory").toString();
			String cityCode = paramData.get("cityCode").toString();
			String districtCode = paramData.get("districtCode").toString();
			String addressDetail = paramData.get("addressDetail").toString();
			String photoUrl = paramData.get("photoUrl").toString();
			String userName = paramData.get("userName").toString();

			UserServiceInfo userServiceInfo = new UserServiceInfo();
			userServiceInfo.setUserId(Long.parseLong(userId));
			userServiceInfo.setPhotoUrl(photoUrl);
			userServiceInfo.setProvenceCode(Long.valueOf("0"));
			userServiceInfo.setCityCode(Long.valueOf(cityCode));
			userServiceInfo.setAddressDetail(addressDetail);
			userServiceInfo.setDistrictCode(Long.valueOf(districtCode));
			userServiceInfo.setUserPosition(userPostion);
			userServiceInfo.setJobCategory(Long.valueOf(jobCategory));
			userServiceInfo.setCreateTime(currentDateTime);
			userServiceInfo.setUpdateTime(currentDateTime);
			userServiceInfo.setUserServiceName(userName);

			User user = new User();
			user.setUserId(Long.valueOf(userId));
			user.setUserName(userName);
			userManager.updateUser(user);

			String address = "";
			Location district = locationManager.getLocationByAdministrativeCode(districtCode);
			Location city = locationManager.getCityByDistrictCode(districtCode);
			Location provence = locationManager.getProvenceByCityCode(districtCode);

			address = provence.getName() + city.getName() + district.getName() + addressDetail;
			// 设置经纬度
			if (address.length() > 0) {
				try {
					GeoCodeModel geoCodeModel = MapUtils.getGeoCodeModelByAddress(address,
							city.getAdministrativeCode());
					if (null != geoCodeModel.getGeocodes() && geoCodeModel.getGeocodes().size() > 0) {
						// TODO 有可能模糊地址对应的有多个这个问题要修改
						String lngLatStr = geoCodeModel.getGeocodes().get(0).getLocation();
						String lngStr = lngLatStr.split(",")[0];
						String latStr = lngLatStr.split(",")[1];
						userServiceInfo.setLongitude(Double.valueOf(lngStr));
						userServiceInfo.setLatitude(Double.valueOf(latStr));
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			userManager.insertUserServiceSelective(userServiceInfo);
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);

		} else {
			rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnData;
	}

	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:44 修改用户信息
	 **/
	public Map<String, Object> updateUser(Map<String, Object> paramData) {
		Map<String, Object> rtnData = new HashMap<String, Object>();
		if (paramData.containsKey("loginName") && paramData.containsKey("passWord")) {

			// Long currentDateTime=Calendar.getInstance().getTimeInMillis();

			String loginName = paramData.get("loginName").toString();
			String passWord = paramData.get("passWord").toString();

			User user = new User();
			// user.setUserName("未填写");
			user.setLoginName(loginName);
			user.setLoginPassword(passWord);

			userManager.insertUserSelective(user);
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		} else {
			rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnData;
	}

	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:44 修改用户信息
	 **/
	public Map<String, Object> getUserServiceInfoByUserId(Map<String, Object> paramData) {

		Map<String, Object> rtnData = new HashMap<String, Object>();

		String userId = paramData.get("userId").toString();

		Map<String, Object> userServiceInfo = userManager.getUserServiceInfoByUserId(Long.valueOf(userId));
		// 邀请url
		String invitationUrl = SystemProperties.getPropertieValue("invitationUrl")
				+ userServiceInfo.get("invitationCode").toString();
		userServiceInfo.put("invitationUrl", invitationUrl);
		rtnData.put("data", userServiceInfo);
		rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
		rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		return rtnData;
	}

	/**
	 * @author liushuaic
	 * @date 2016/03/14 11:56 查询个人信息
	 **/
	public Map<String, Object> getUserServiceInfoByUserIdTwo(Map<String, Object> paramData) {

		Map<String, Object> rtnData = new HashMap<String, Object>();
		String userId = paramData.get("userId").toString();

		UserServiceInfo userServiceInfo = userManager.getUserServiceInfoByUserIdTwo(Long.valueOf(userId));
		// 邀请url
		String invitationUrl = SystemProperties.getPropertieValue("invitationUrl")+ userServiceInfo.getInvitationCode();
		userServiceInfo.setInvitationUrl(invitationUrl);

		rtnData.put("data", userServiceInfo);
		rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
		rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		
		return rtnData;
	}

	/**
	 * 
	 * @author liushuaic
	 * @date 2015/11/26 16:11
	 * @desc 修改用户信息
	 * 
	 ***/
	public Map<String, Object> updateUserServiceAndServiceInfo(Map<String, Object> paramData) {

		Map<String, Object> rtnData = new HashMap<String, Object>();

		Long currentDateTime = Calendar.getInstance().getTimeInMillis();

		UserServiceInfo userServiceInfo = new UserServiceInfo();

		String userId = paramData.get("userId").toString();

		userServiceInfo.setUserId(Long.valueOf(userId));

		//userManager.updateUserServiceInfoIsEmptyByUserId(Long.valueOf(userId));

		if (paramData.containsKey("jobCategory")) {
			String jobCategory = paramData.get("jobCategory").toString();
			userServiceInfo.setJobCategory(Long.valueOf(jobCategory));
		}
		if (paramData.containsKey("districtCode") && paramData.containsKey("mapPositionAddress")) {

			String mapPositionAddress = paramData.get("mapPositionAddress").toString();
			userServiceInfo.setMapPositionAddress(mapPositionAddress);

			String districtCode = paramData.get("districtCode").toString();
			userServiceInfo.setDistrictCode(Long.valueOf(districtCode));
		}
		if (paramData.containsKey("addressDetail")) {
			String addressDetail = paramData.get("addressDetail").toString();
			userServiceInfo.setAddressDetail(addressDetail);
		}

		if (paramData.containsKey("photoUrl")) {
			String photoUrl = paramData.get("photoUrl").toString();
			userServiceInfo.setPhotoUrl(photoUrl);
		}

		if (paramData.containsKey("userPosition")) {
			Byte userPosition = Byte.valueOf(paramData.get("userPosition").toString());
			userServiceInfo.setUserPosition(userPosition);
		}

		if (paramData.containsKey("userName")) {
			String userName = paramData.get("userName").toString();
			userServiceInfo.setUserServiceName(userName);
		}

		userServiceInfo.setUpdateTime(currentDateTime);

		if (paramData.containsKey("hospital")) {
			String hospital = paramData.get("hospital").toString();
			userServiceInfo.setHospital(hospital);
		}
		if (paramData.containsKey("offices")) {
			userServiceInfo.setOffices(Integer.valueOf(paramData.get("offices").toString()));
		}
		if (paramData.containsKey("adept")) {
			userServiceInfo.setAdept(paramData.get("adept").toString());
		}

		// 反推一下，用户用户地址

		if (paramData.containsKey("districtCode") && paramData.containsKey("mapPositionAddress")) {

			String districtCode = paramData.get("districtCode").toString();
			String mapPositionAddress = paramData.get("mapPositionAddress").toString();

			Location city = locationManager.getCityByDistrictCode(districtCode);
			Location provence = locationManager.getProvenceByCityCode(districtCode);
			if (null != city) {
				userServiceInfo.setCityCode(Long.valueOf(city.getAdministrativeCode()));
			} else {
				userServiceInfo.setCityCode(0L);
			}
			if (null != provence) {
				userServiceInfo.setProvenceCode(Long.valueOf(provence.getAdministrativeCode()));
			} else {
				userServiceInfo.setProvenceCode(0L);
			}

			userServiceInfo.setMapPositionAddress(mapPositionAddress);

			// 设置经纬度
			if (mapPositionAddress.length() > 0) {
				try {
					if (null != city) {
						GeoCodeModel geoCodeModel = MapUtils.getGeoCodeModelByAddress(mapPositionAddress,
								city.getAdministrativeCode());
						if (null != geoCodeModel.getGeocodes() && geoCodeModel.getGeocodes().size() > 0) {
							// TODO 有可能模糊地址对应的有多个这个问题要修改
							String lngLatStr = geoCodeModel.getGeocodes().get(0).getLocation();
							String lngStr = lngLatStr.split(",")[0];
							String latStr = lngLatStr.split(",")[1];
							userServiceInfo.setLongitude(Double.valueOf(lngStr));
							userServiceInfo.setLatitude(Double.valueOf(latStr));
						} else {
							userServiceInfo.setLongitude(0d);
							userServiceInfo.setLatitude(0d);
						}
					} else {
						userServiceInfo.setLongitude(0d);
						userServiceInfo.setLatitude(0d);
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				userServiceInfo.setLongitude(0d);
				userServiceInfo.setLatitude(0d);
			}

		}

		userManager.updateUserServiceInfo(userServiceInfo);

		rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
		rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);

		return rtnData;
	}

	
	/**
	 * 
	 * @author liushuaic
	 * @date 2015/11/26 16:11
	 * @desc 修改用户信息
	 * 
	 ***/
	@SuppressWarnings("unchecked")
	public ResponseMessage<UserInfo> updateUserServiceAndServiceInfoTwo(Map<String, Object> paramData) {

		ResponseMessage<UserInfo> rtnData = new ResponseMessage<UserInfo>();

		Long currentDateTime = Calendar.getInstance().getTimeInMillis();

		UserServiceInfo userServiceInfo = new UserServiceInfo();
		UserInfo userInfo=new UserInfo();

		String userId = paramData.get("userId").toString();

		userServiceInfo.setUserId(Long.valueOf(userId));
		userInfo.setUserId(Long.valueOf(userId));

		if (paramData.containsKey("jobCategory")) {
			String jobCategory = paramData.get("jobCategory").toString();
			userServiceInfo.setJobCategory(Long.valueOf(jobCategory));
		} 
		if (paramData.containsKey("districtCode") && paramData.containsKey("mapPositionAddress")) {

			String mapPositionAddress = paramData.get("mapPositionAddress").toString();
			userServiceInfo.setMapPositionAddress(mapPositionAddress);

			String districtCode = paramData.get("districtCode").toString();
			userServiceInfo.setDistrictCode(Long.valueOf(districtCode));
		}
		if (paramData.containsKey("addressDetail")) {
			String addressDetail = paramData.get("addressDetail").toString();
			userServiceInfo.setAddressDetail(addressDetail);
		}

		//上传头像
		if (paramData.containsKey("photoUrl")) {
			String photoUrl = paramData.get("photoUrl").toString();
			userServiceInfo.setPhotoUrl(photoUrl);
			userInfo.setPhotoUrl(photoUrl);
			integralManager.insertIntegralAddScoreIsONCEJob("HSXTX", Long.valueOf(userId));
		}

		if (paramData.containsKey("userPosition")) {
			Byte userPosition = Byte.valueOf(paramData.get("userPosition").toString());
			userServiceInfo.setUserPosition(userPosition);
			userServiceInfo.setNewUserPosition(Integer.valueOf(userPosition));
		}

		if (paramData.containsKey("userName")) {
			String userName = paramData.get("userName").toString();
			userServiceInfo.setUserServiceName(userName);
			userInfo.setUserName(userName);
		}

		userServiceInfo.setUpdateTime(currentDateTime);

		if (paramData.containsKey("hospital")) {
			String hospital = paramData.get("hospital").toString();
			userServiceInfo.setHospital(hospital);
		}
		if (paramData.containsKey("offices")) {
			userServiceInfo.setOffices(Integer.valueOf(paramData.get("offices").toString()));
		}
		List<String> adepts=null;
		if (paramData.containsKey("adepts")) {
			 adepts=(List<String>) paramData.get("adepts");
		}

		// 反推一下，用户用户地址

		if (paramData.containsKey("districtCode") && paramData.containsKey("mapPositionAddress")) {

			String districtCode = paramData.get("districtCode").toString();
			String mapPositionAddress = paramData.get("mapPositionAddress").toString();

			Location city = locationManager.getCityByDistrictCode(districtCode);
			Location provence = locationManager.getProvenceByCityCode(districtCode);
			if (null != city) {
				userServiceInfo.setCityCode(Long.valueOf(city.getAdministrativeCode()));
			} else {
				userServiceInfo.setCityCode(0L);
			}
			if (null != provence) {
				userServiceInfo.setProvenceCode(Long.valueOf(provence.getAdministrativeCode()));
			} else {
				userServiceInfo.setProvenceCode(0L);
			}

			userServiceInfo.setMapPositionAddress(mapPositionAddress);

			// 设置经纬度
			if (mapPositionAddress.length() > 0) {
				try {
					if (null != city) {
						GeoCodeModel geoCodeModel = MapUtils.getGeoCodeModelByAddress(mapPositionAddress,
								city.getAdministrativeCode());
						if (null != geoCodeModel.getGeocodes() && geoCodeModel.getGeocodes().size() > 0) {
							// TODO 有可能模糊地址对应的有多个这个问题要修改
							String lngLatStr = geoCodeModel.getGeocodes().get(0).getLocation();
							String lngStr = lngLatStr.split(",")[0];
							String latStr = lngLatStr.split(",")[1];
							userServiceInfo.setLongitude(Double.valueOf(lngStr));
							userServiceInfo.setLatitude(Double.valueOf(latStr));
						} else {
							userServiceInfo.setLongitude(0d);
							userServiceInfo.setLatitude(0d);
						}
					} else {
						userServiceInfo.setLongitude(0d);
						userServiceInfo.setLatitude(0d);
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				userServiceInfo.setLongitude(0d);
				userServiceInfo.setLatitude(0d);
			}

		}
		if(paramData.containsKey("infoWrite")){
			String infoWrite=paramData.get("infoWrite").toString();
			User user=new User();
			user.setUserId(Long.valueOf(userId));
			user.setInfoWrite(Byte.valueOf(infoWrite));
			userManager.updateUser(user);
		}
		
		userInfo.setUserId(Long.valueOf(userId));
		//用户个人简介
		if(paramData.containsKey("userIntroduce")){
			String userIntroduce=paramData.get("userIntroduce").toString();
			//userServiceInfo.setUserIntroduce(userIntroduce);
			userInfo.setUserIntroduce(userIntroduce);
		}
		
		//机构名称
		if(paramData.containsKey("oraganizationName")){
			String oraganizationName=paramData.get("oraganizationName").toString();
			userServiceInfo.setOraganizationName(oraganizationName);
		}
		
//		工作领域
		if(paramData.containsKey("workRealm")){
			Byte workRealm=Byte.valueOf(paramData.get("workRealm").toString());
			userServiceInfo.setWorkRealm(workRealm);
		}
		//用户证书
		if(paramData.containsKey("userCertificate")){
			String userCertificate=paramData.get("userCertificate").toString();
			userServiceInfo.setUserCertificate(userCertificate);
		}
		
		userManager.updateUserServiceInfo(userServiceInfo);
		
		if(paramData.containsKey("birthday") && paramData.get("birthday").toString().length()>0){
			String birthday=paramData.get("birthday").toString();
			try {
				userInfo.setBirthday(DateUtils.formateDateTime(birthday+" 00:00:00"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(paramData.containsKey("userSex")){
			String sex=paramData.get("userSex").toString();
			userInfo.setUserSex(Byte.valueOf(sex));
		}
		if(paramData.containsKey("designationId")){
			Long designationId=Long.valueOf(paramData.get("designationId").toString());
			userInfo.setDesignationId(designationId);
			integralManager.insertIntegralAddScoreIsONCEJob("TGFH", Long.valueOf(userId));
		}
		
		userInfo.setUserId(Long.valueOf(userId));
		userManager.updateByUserIdSelective(userInfo);
		
		if(null != adepts){
			adeptMapManager.deleteUserAdeptAll(Long.valueOf(userId));
			for(String adept:adepts){
				adeptMapManager.insertSelective(Long.valueOf(adept),Long.valueOf(userId));
			}
		}
		
		//在第一次进入系统时，初始化为审核通过
		if (paramData.containsKey("userPosition")) {
			userManager.updateUserPositionStatusCheckePass(Long.valueOf(userId));
		}
		rtnData.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
		rtnData.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);

		return rtnData;
	}
	
	
	
	public Map<String, Object> testMessage(Map<String, Object> paramData) {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		rtnMap.put("data", "测试！");
		rtnMap.put("status", "000000");
		rtnMap.put("message", "测试！");
		return rtnMap;
	}

	/**
	 * 
	 * @author liushuaic
	 * @date 2015/12/01 14:57
	 * @desc 忘记密码 TODO 设置访问过多限制
	 **/
	public Map<String, Object> forgotPassword(Map<String, Object> paramData) {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		try {
			if (paramData.containsKey("loginName")) {
				String loginName = paramData.get("loginName").toString();
				User user = userManager.getUserByLoginName(loginName);
				if (null != user) {
					String mobileNumber = user.getLoginName();
					boolean isSend = SMSUtil.sendMessage(mobileNumber, SMSUtil.messageMode.getMyPassword.modeId,
							new String[] { user.getLoginPassword() });
					if (isSend) {
						rtnMap.put("status", "000000");
						rtnMap.put("message", "信息发送成功！");
					} else {
						rtnMap.put("status", "999999");
						rtnMap.put("message", "信息发送失败！");
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			rtnMap.put("status", "999999");
			rtnMap.put("message", "信息发送失败！");
		}

		return rtnMap;
	}

	/**
	 * 
	 * @author liushuaic
	 * @date 2015/12/19 00:16
	 * @desc 重置密码
	 * 
	 ***/
	public ResponseMessage<String> resetPassword(Map<String, Object> paramData) {
		ResponseMessage<String> responseMessage = new ResponseMessage<String>();
		if (paramData.containsKey("loginName")) {
			String loginName = paramData.get("loginName").toString();

			User user = userManager.getUserByLoginName(loginName);

			if (null != user) {

				String password = paramData.get("password").toString();

				userManager.updatePasswordByLoginName(loginName, password);
				responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
				responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
			} else {
				responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
				responseMessage.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
			}

		} else {
			responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}

		return responseMessage;
	}

	/**
	 * @author liushuaic
	 * @date 2015/12/21 17:50
	 * @desc 是否存在系统中
	 * 
	 **/
	public ResponseMessage<String> isMySystemUser(Map<String, Object> paramData) {
		ResponseMessage<String> responseMessage = new ResponseMessage<String>();
		if (paramData.containsKey("loginName")) {
			String loginName = paramData.get("loginName").toString();
			User user = userManager.getUserByLoginName(loginName);
			if (null != user) {
				responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
				responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
			} else {
				responseMessage.setStatus(ExceptionConstants.userException.userNotAtSystem.errorCode);
				responseMessage.setMessage(ExceptionConstants.userException.userNotAtSystem.errorMessage);
			}
		} else {
			responseMessage.setStatus(ExceptionConstants.userException.userNotAtSystem.errorCode);
			responseMessage.setMessage(ExceptionConstants.userException.userNotAtSystem.errorMessage);
		}

		return responseMessage;

	}

	/**
	 * @author liushuaic
	 * @date 2016-02-26 16:38
	 * @desc 获取我邀请的用户
	 */
	public ResponseMessage<List<UserModel>> getInvationUserInfoByInvationUserId(Map<String, Object> paramData) {
		ResponseMessage<List<UserModel>>  responseMessage = new ResponseMessage<List<UserModel>>();
		try {
			if (paramData.containsKey("userStatus")) {

				String userStatus = paramData.get("userStatus").toString();
				if (userStatus.equals("-1") || userStatus.equals("0") || userStatus.equals("1")) {
					String userId = paramData.get("userId").toString();
					List<UserModel> rtnData = userManager.getInvationUserInfoByInvationUserId(Long.valueOf(userId),
							Integer.valueOf(userStatus));
					responseMessage.setData(rtnData);
					responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
					responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
				} else {
					responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
					responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
				}

			} else {
				responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
				responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			responseMessage.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}

		return responseMessage;
	}

	/**
	 * @author liushuaic
	 * @date 2016-03-21 10:27
	 * @desc 查询我邀请的用户
	 */
	public ResponseMessage<MyInvationUserModel> getInvationUserInfoByInvationUserIdTwo(Map<String, Object> paramData) {
		ResponseMessage<MyInvationUserModel> responseMessage = new ResponseMessage<MyInvationUserModel>();
		try {
			if (paramData.containsKey("userStatus")) {

				String userStatus = paramData.get("userStatus").toString();
				if (userStatus.equals("-1") || userStatus.equals("0") || userStatus.equals("1")
						|| userStatus.equals("2")) {
					String userId = paramData.get("userId").toString();
					List<UserModel> rtnData = userManager.getInvationUserInfoByInvationUserIdAndUserStatus(
							Long.valueOf(userId), Integer.valueOf(userStatus));

					Long nums = userManager.getMyInvitionUserNumsByInvitionUserId(Long.valueOf(userId));
					Long regiestUserNums = userManager.getMyinvationUserNoPaying(Long.valueOf(userId));
					Long serviceingUserNums = userManager.getServiceingUserNumsByInvitionUserId(Long.valueOf(userId));
					Long servicedUerNums = userManager.getServiceingUserNumsByInvitionUserId(Long.valueOf(userId));

					MyInvationUserModel myInvationUserModel = new MyInvationUserModel();
					myInvationUserModel.setNums(nums.intValue());
					myInvationUserModel.setRegiestUserNums(regiestUserNums.intValue());
					myInvationUserModel.setServiceingUserNums(serviceingUserNums.intValue());
					myInvationUserModel.setServicedUerNums(servicedUerNums.intValue());
					myInvationUserModel.setInvitionUsers(rtnData);

					responseMessage.setData(myInvationUserModel);
					responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
					responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
				} else {
					responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
					responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
				}

			} else {
				responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
				responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			responseMessage.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}

		return responseMessage;
	}

	/**
	 * @author liushuaic
	 * @date 2016-03-24 19:30
	 * @desc 提交职位审核
	 */
	public ResponseMessage<String> submitUpdateUserPosition(Map<String,Object> paramData) {
		ResponseMessage<String> responseMessage = new ResponseMessage<String>();

		try {
			if(paramData.containsKey("userPosition")){
				String userPosition=paramData.get("userPosition").toString();
				String userId=paramData.get("userId").toString();
				userManager.submitUpdateUserPosition(Long.valueOf(userId),Long.valueOf(userPosition));
				responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
				responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
				responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			responseMessage.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}

		return responseMessage;
	}
	
	
	public ResponseMessage<String> saveUserInfos(){
		ResponseMessage<String> responseMessage = new ResponseMessage<String>();
		
		try{
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return responseMessage;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-31 15:45
	 * @desc 获取我关注的用户
	 * **/
	public ResponseMessage<List<UserServiceInfo>> getMyFollowUser(Map<String,Object> paramMap){
		
		ResponseMessage<List<UserServiceInfo>> resData=new ResponseMessage<List<UserServiceInfo>>();
		
		if(paramMap.containsKey("userId")){
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			List<UserServiceInfo> data=userServiceInfoManager.getMyFollowUser(userId);
			resData.setData(data);
			resData.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
			resData.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			resData.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			resData.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return resData;
	}
 
	
	/**
	 * @author liushuaic
	 * @date 2016/07/09 11:15 查询某一个服务人员的信息
	 **/
	public Map<String, Object> getUserServiceInfoByServerUserId(Map<String, Object> paramData) {

		Map<String, Object> rtnData = new HashMap<String, Object>();
		String serverUserId = paramData.get("serverUserId").toString();
		Long serarchUserid=0l;
		if(paramData.containsKey("userId")){
			serarchUserid=Long.valueOf(paramData.get("userId").toString());
		}

		UserServiceInfo userServiceInfo = userServiceInfoManager.getUserServiceInfoByServerUserId(serarchUserid,Long.valueOf(serverUserId));
		// 邀请url
		String invitationUrl = SystemProperties.getPropertieValue("invitationUrl")+ userServiceInfo.getInvitationCode();
		userServiceInfo.setInvitationUrl(invitationUrl);

		rtnData.put("data", userServiceInfo);
		rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
		rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		
		return rtnData;
	}
	
	
}
