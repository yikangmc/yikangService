package com.yikangyiliao.base.utils.messageUtil.im;



/**
 * @author liushuaic
 * @date 2015/12/01 15:21
 * @desc 推送信息
 * 
 * ***/
public class Message{

	/**推送设备别名**/
	private String alias;
	
	/**
	 * 推送内容
	 * **/
	private String content;
	
	/**
	 * 信息分类
	 * 
	 * **/
	private String messageCategroy;
	
	
	
	/**
	 * 数据分类
	 * 1:字符串
	 * 2:图片
	 * */
	private String dataType;
	

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
	
	
	
	
	
}
