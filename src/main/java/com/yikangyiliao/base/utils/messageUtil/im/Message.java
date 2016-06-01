package com.yikangyiliao.base.utils.messageUtil.im;



/**
 * @author liushuaic
 * @date 2015/12/01 15:21
 * @desc 推送信息
 * 
 * ***/
public class Message{

	/**
	 * 推送设备别名
	 * or tagName
	 * **/
	private String alias;
	
	/**
	 * 推送内容
	 * **/
	private String content;
	
	/**
	 * 信息分类
	 * 0:别名推送
	 * 1:tag推送
	 * **/
	private int messageCategroy=0;
	
	
	
	/**
	 * 数据分类
	 * 1:字符串
	 * 2:图片
	 * */
	private String dataType;
	
	/**
	 * 尝试次数
	 * */
	private int retrayNum=0;
	 
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMessageCategroy() {
		return messageCategroy;
	}

	/**
	 * 信息分类
	 * 0:别名推送
	 * 1:tag推送
	 * **/
	public void setMessageCategroy(int messageCategroy) {
		this.messageCategroy = messageCategroy;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public int getRetrayNum() {
		return retrayNum;
	}

	public void setRetrayNum(int retrayNum) {
		this.retrayNum = retrayNum;
	}

	
	
	
}
