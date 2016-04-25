package com.yikangyiliao.base.config;

public class YiKangServiceConfige {

	
	/**
	 * service名称
	 * ***/
	private String serviceName;
	
	
	/**
	 * 方法名称
	 * **/
	private String methodName;
	
	
	/**
	 * 是不过滤
	 * **/
	private boolean isFileter;
	
	


	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public String getMethodName() {
		return methodName;
	}


	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}


	public boolean getIsFileter() {
		return isFileter;
	}


	public void setIsFileter(boolean isFileter) {
		this.isFileter = isFileter;
	}
	
	
	
	
}
