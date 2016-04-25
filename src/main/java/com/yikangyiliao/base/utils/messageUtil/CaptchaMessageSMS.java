package com.yikangyiliao.base.utils.messageUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * @author liushuaic
 * @date 2016-03-22 11:49
 * @desc 验证码信息对象
 **/
public class CaptchaMessageSMS {

	/**
	 * 手机号
	 */
	private String mobileNumber;
	/**
	 * 发送时间
	 **/
	private Date sendDate;
	/**
	 * 失效时间 分
	 */
	private Integer destoryTime;
	
	/**
	 * 验证码
	 * */
	private String captcha;
	
	

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Integer getDestoryTime() {
		return destoryTime;
	}

	public void setDestoryTime(Integer destoryTime) {
		this.destoryTime = destoryTime;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-03-22 14:48
	 * @desc 是否超出验证时间
	 * @return true 超出验证时间 false 没有超出验证时间
	 * **/
	public boolean isOutOfValidateTime(){
		Date currentDate=Calendar.getInstance().getTime();
		Long poorTime= this.getSendDate().getTime()-currentDate.getTime();
		if(poorTime>this.destoryTime*1000){
			return true;
		}else{
			return false;
		}
	}

}
