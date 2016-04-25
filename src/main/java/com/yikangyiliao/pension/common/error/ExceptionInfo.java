package com.yikangyiliao.pension.common.error;





/**
 * @author liushuaic
 * 
 * 错误信息代码，及 错误内容
 * errorCode 分为6位
 * 000000
 * 前2位 controller 代码
 * 3，4位，方法 代码
 * 5，6位 ，错误
 * **/
public class ExceptionInfo extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -901352075010858921L;
	
	
	private String  errorCode;
	private String  message;
	
	public ExceptionInfo(String errorCode,String message){
		this.errorCode=errorCode;
		this.message=message;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message; 
	}
	
	
}


