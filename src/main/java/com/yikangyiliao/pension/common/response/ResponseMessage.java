package com.yikangyiliao.pension.common.response;

import com.yikangyiliao.pension.common.error.ExceptionConstants;

public class ResponseMessage<T extends Object> {

	private String status=ExceptionConstants.responseSuccess.responseSuccess.code;
	
	private String message=ExceptionConstants.responseSuccess.responseSuccess.message;
	
	private T data;


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
