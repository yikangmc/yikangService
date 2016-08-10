package com.yikangyiliao.pension.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.base.utils.AccessTiketCheckout;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.dao.UserDao;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserInfo;
import com.yikangyiliao.pension.manager.ThreePartAccountManager;
import com.yikangyiliao.pension.manager.UserManager;



/**
 * @author liushuaic
 * @date 2015/07/25 13:28
 * 用于用户登陆
 * **/
@Service(value="login")
public class LoginService {
	
	
	@SuppressWarnings("unused")
	private static Logger logger=Logger.getLogger(LoginService.class);
	
	@Autowired
	private  UserDao userDao;
	
	@Autowired
	private UserManager userManager;
	
	public ResponseMessage<String> loginForThreepartLogin(Map<String,Object> paramData){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		
		if(
			paramData.containsKey("accountId")
			&& paramData.containsKey("machineCode")
		){
			String accountId=paramData.get("accountId").toString();
			String machineCode=paramData.get("machineCode").toString();
			if(accountId.length()>5 && accountId.length()<50){
				UserInfo user=userManager.getUserIdByThreePartAccountId(accountId);

				/** 
				 * 随机数+ip+logintime
				 * 验证方式，与 redis 中的内容对比 
				 * 对登陆时间 
				 * 找出用户信息
				 * **/
				try {
					
					if(null != user){
						String accessTicket=AccessTiketCheckout.generateAccessTicket(user.getUserId().toString(), Calendar.getInstance().getTimeInMillis(), machineCode);
						resData.setData(accessTicket);						
						resData.setStatus("000000");
						resData.setMessage("登陆成功！");
					}else{
						resData.setStatus("000001");
						resData.setMessage("用户不存在！");
					}
			
				} catch (Exception e) {
					resData.setStatus("999999");
					resData.setMessage("登陆失败！");
					e.printStackTrace();
				}
			}else{
				resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
				resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
			}
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return resData;
		
	}

	/**
	 * @author liushuaic
	 * @date 2015/07/30 20:03 
	 * @desc 登陆
	 * 密码加密方式，
	 * solt  加密 
	 * password=加密（加密（password)+加密（solt）)
	 * */
	public Map<String,Object> login(Map<String,Object> paramData){
		
		
		Map<String,Object> rtnData=new HashMap<String, Object>();
		
		
		/**
		 * userName:用户名
		 * password:密码
		 * machineCode:机器码
		 * **/
		if(
			paramData.containsKey("loginName") && 
			paramData.containsKey("passWord") &&
			paramData.containsKey("machineCode")
		   ){
			
			String loginName=paramData.get("loginName").toString();
			String passWord=paramData.get("passWord").toString();
			String machineCode=paramData.get("machineCode").toString();
			if(null != loginName && null != passWord && null != machineCode){
				
				
				User user=userDao.getUserByLoginName(loginName);
				if(null != user){
					
					String passwordStr=user.getLoginPassword();
					if(passWord.equals(passwordStr)){
						
						/**
						 * 
						 * 随机数+ip+logintime
						 * 验证方式，与 redis 中的内容对比 
						 * 对登陆时间 
						 * 找出用户信息
						 * **/
						
//						String accessTiket=user.getAccessTiket();
//						Long currentDateTime=Calendar.getInstance().getTime().getTime();
//						rtnData.put("accessTiket","") ;
						
						
						try {
							
							String accessTicket=AccessTiketCheckout.generateAccessTicket(user.getUserId().toString(), Calendar.getInstance().getTimeInMillis(), machineCode);
							rtnData.put("data", accessTicket);
							rtnData.put("status", "000000");
							rtnData.put("message", "登陆成功！");
						} catch (Exception e) {
							rtnData.put("status", "999999");
							rtnData.put("message", "登陆失败！");
							e.printStackTrace();
						}
						
					}else{
						rtnData.put("status", ExceptionConstants.loginException.userNameOrPasswordException.errorCode);
						rtnData.put("message", ExceptionConstants.loginException.userNameOrPasswordException.errorMessage);
					}
				}else{
					rtnData.put("status", ExceptionConstants.loginException.userNameOrPasswordException.errorCode);
					rtnData.put("message", ExceptionConstants.loginException.userNameOrPasswordException.errorMessage);
				}
			}else{
				rtnData.put("status", ExceptionConstants.loginException.userNameOrPasswordException.errorCode);
				rtnData.put("message", ExceptionConstants.loginException.userNameOrPasswordException.errorMessage);
			}
		}else{
			rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		/**
		 * 
		 * 随机数+ip+logintime
		 * 验证方式，与 redis 中的内容对比 
		 * 
		 * 
		 * 对登陆时间
		 * 找出用户信息
		 * **/
		
		return rtnData;
		
	}
	
}
