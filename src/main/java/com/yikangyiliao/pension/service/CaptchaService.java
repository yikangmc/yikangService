package com.yikangyiliao.pension.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.yikangyiliao.base.utils.MobileCaptchaUtil;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;

@Service(value="captchaService")
public class CaptchaService {

		
	
	
	/**
	 * @author liushuaic
	 * @date 2016-03-22 15:11
	 * @desc 获取验证码
	 * **/
	public ResponseMessage getCaptchar(Map<String,Object> paramData){
		ResponseMessage responseMessage=new ResponseMessage();
		if(paramData.containsKey("mobileNumber")){
			String mobileNumber=paramData.get("mobileNumber").toString();
			  responseMessage=MobileCaptchaUtil.getCaptchaForService( mobileNumber);
		}
		return responseMessage;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-03-22 15:54
	 * @desc 校验验证码
	 * @param  mobileNumber 手机号
	 * @param  ·captchar  验证码
	 * **/
	public ResponseMessage validateCaptchar(Map<String,Object> paramData){
		
		ResponseMessage responseMessage=new ResponseMessage();
		if(paramData.containsKey("mobileNumber") && paramData.containsKey("captchar")){
			String mobileNumber=paramData.get("mobileNumber").toString();
			String captcha=paramData.get("captchar").toString(); 
			if(MobileCaptchaUtil.validateCaptcha(mobileNumber, captcha)){
				responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
				responseMessage.setMessage("验证码正确！");
			}else{
				responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
				responseMessage.setMessage("验证码不正确！");
			}
		}else{
			responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return responseMessage;
		
	}
}
