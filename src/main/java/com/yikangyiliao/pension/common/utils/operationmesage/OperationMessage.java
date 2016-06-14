package com.yikangyiliao.pension.common.utils.operationmesage;


/**
 * 
 * @author liushuaic
 * @date 2016-06-06 12:13
 * @desc 业务信息类
 * 
 * */
public class OperationMessage {

	//信息内容
	private String content;
	
	//信息类型
	/**
	 * 1:文章数据
	 * 2:问答数据
	 * */
	private String contentType;

	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	
	
	
}
