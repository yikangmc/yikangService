package com.yikangyiliao.base.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random; 

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import com.yikangyiliao.base.utils.messageUtil.CaptchaMessageSMS;
import com.yikangyiliao.base.utils.messageUtil.SMSUtil;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;

/**
 * @author liushuaic
 * @date 2015/12/31 11:42
 * @验证码工具类
 * */
public class MobileCaptchaUtil {
	
	//验证码，缓存集合
	private static Map<String,CaptchaMessageSMS> CAPTCHACACHE=new HashMap<String,CaptchaMessageSMS>();
	
	
	static{
		CaptchaMessageSMS cms=new CaptchaMessageSMS();
		cms.setMobileNumber("13716907523");
		cms.setCaptcha("123");
		cms.setSendDate(Calendar.getInstance().getTime());
		cms.setDestoryTime(1);
		CAPTCHACACHE.put("13716907523", cms);
	}
	/**
	 * @author liushuaic
	 * @date 2015/09/01 20:00
	 * @desc 获取验证码
	 * **/
	public static Map<String, Object> getCaptcha(ModelMap modelMap,
			String mobileNumber, HttpServletRequest request) {

		
		Map<String, Object> rtnData = new HashMap<String, Object>();
		if(null != mobileNumber && mobileNumber.length()==11){
			
	
			Random random = new Random();
			int captcha = random.nextInt(99999);
			
			Date currentDate=Calendar.getInstance().getTime();
			Date getDate=(Date) request.getSession().getAttribute("getCaptchaDate");
			boolean isTure=false;
			if(null != getDate){
				   long diff = currentDate.getTime() - getDate.getTime();
				    long days = diff / (1000 * 60 );
				    if(days>1){
				    	isTure=true;
				    }
			}
			
			if(getDate==null || isTure){
				
					if (SMSUtil.sendMessage(mobileNumber, captcha + "", 1 + "")) {
						
						request.getSession().setAttribute("captcha", captcha);
						request.getSession().setAttribute("getCaptchaDate", currentDate);
						
						rtnData.put("status",
								ExceptionConstants.responseSuccess.responseSuccess.code);
						rtnData.put("message", "您的验证码，已经发送！请注意，手机提醒！");
					} else {
						rtnData.put(
								"status",
								ExceptionConstants.systemException.systemException.errorCode);
						rtnData.put("message", "抱歉，验证码发送失败！请您联系服务人员！");
					}
			}else{
				rtnData.put(
						"status",
						ExceptionConstants.systemException.systemException.errorCode);
				rtnData.put("message", "请1分钟后在获取！");
			}
		
		}else{
			rtnData.put( "status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", "请输入正确的手机号！");
		}

		return rtnData;
	}

	
	
	public static ResponseMessage getCaptchaForService(String mobileNumber){
		ResponseMessage responseMessage=new ResponseMessage();
		if(null != mobileNumber && mobileNumber.length()==11){
			
			
			Random random = new Random();
			int captcha = random.nextInt(99999);
			
			Date currentDate=Calendar.getInstance().getTime();
			CaptchaMessageSMS cacheCMS=(CaptchaMessageSMS) MobileCaptchaUtil.CAPTCHACACHE.get(mobileNumber);
			
			
			//判断是大于0
			boolean isTure=false;
			if(null != cacheCMS){
				  Date getDate=cacheCMS.getSendDate();
				   long diff = currentDate.getTime() - getDate.getTime();
				    long days = diff / (1000 * 60 );
				    if(days>cacheCMS.getDestoryTime()){
				    	isTure=true;
				    }
			}
			int destoryTime=2;
			if(cacheCMS == null || isTure){
				
					if (SMSUtil.sendMessage(mobileNumber, captcha + "", destoryTime + "")) {
						
						CaptchaMessageSMS cms=new CaptchaMessageSMS();
						cms.setDestoryTime(destoryTime); //设置销毁时间
						cms.setMobileNumber(mobileNumber); //设置手机号
						cms.setSendDate(currentDate);     //设置发送时间
						cms.setCaptcha(captcha+"");
						MobileCaptchaUtil.CAPTCHACACHE.put(mobileNumber, cms);
						responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
						responseMessage.setMessage("您的验证码，已经发送！请注意，手机提醒！");
					} else {
						responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
						responseMessage.setMessage("抱歉，验证码发送失败！请您联系服务人员！");
					}
			}else{
				responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
				responseMessage.setMessage("请"+destoryTime+"分钟后在获取！");
			}
		
		}else{
			responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			responseMessage.setMessage("请输入正确的手机号！");
		}

		return responseMessage;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-03-22 14:59
	 * @desc 验证数据是否正确
	 * **/
	public static boolean validateCaptcha(String mobileNumber,String captcha){
		
		if(null != mobileNumber && mobileNumber.length()==11){
			if(MobileCaptchaUtil.CAPTCHACACHE.containsKey(mobileNumber)){
				CaptchaMessageSMS cms=MobileCaptchaUtil.CAPTCHACACHE.get(mobileNumber);
				if(!cms.isOutOfValidateTime()){
					if(cms.getCaptcha().equals(captcha)){
						MobileCaptchaUtil.CAPTCHACACHE.remove(mobileNumber);
						return  true;
					}
				}else{
					return false;
				}
				
			}
		}
		
		
		return false;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/01 19：58 验证短信，校验码。
	 * **/
	public static Map<String, Object> validateCaptcha(String captcha,
			HttpServletRequest request) {
		Map<String, Object> rtnData = new HashMap<String, Object>();

		String sesionCaptcha = request.getSession().getAttribute("captcha")
				.toString();
		if (captcha.equals(sesionCaptcha)) {
			rtnData.put("status",
					ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", "您的验证码，输入成功！");
		} else {
			rtnData.put(
					"status",
					ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", "抱歉，您的验证码，输入有问题");
		}
		return rtnData;
	}
	
	
	public static void main(String[] args) {
		boolean isTrue=MobileCaptchaUtil.validateCaptcha("13716907523", "123");
		System.out.println(isTrue);
		boolean dd=MobileCaptchaUtil.validateCaptcha("13716907523", "123");
		System.out.println(dd);
	}
}
