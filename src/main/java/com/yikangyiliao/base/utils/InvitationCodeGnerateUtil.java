package com.yikangyiliao.base.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.yikangyiliao.pension.entity.User;

/**
 * @author liushuaic
 * @date 2015/11/18 14:40
 * @desc 邀请码生成工具类
 * */
public class InvitationCodeGnerateUtil{
	
	private static final String[] storeInvitationChars={"a","c","b","d","f","e","h","i","j","k","l","m","n","o","p"
			,"q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9"};

	/**
	 * @author liushuaic
	 * @date 2015/11/18 14:53
	 * @desc  生成邀请码
	 * 格式： 15（年）+01（月）+18（日）+id
	 * */
	public static Integer generateInvitationCode(User user){
		Date date=Calendar.getInstance().getTime();
		SimpleDateFormat sdf2=new SimpleDateFormat("YYMMdd");
		String dateStr= sdf2.format(date);
		return Integer.valueOf(dateStr+user.getUserId().toString());
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/11/26 18:01
	 * @desc  生成邀请码
	 * 格式： cd12
	 * */
	public static String generateInvitationCodeTwo(User user){
		
		
		String userIdStr=user.getUserId().toString();
		int forSize=4-userIdStr.length();
		String randomStr="";
		for(int i=0;i<forSize;i++){
			Random random=new Random();
			int randomIndex=random.nextInt(35);
			randomStr=randomStr+storeInvitationChars[randomIndex];
		}
		return randomStr+userIdStr;
		
	}
	
	
	
	public static void main(String[] args) {
		//System.out.println(storeInvitationChars.length);
		
		User user=new User();
		user.setUserId(12l);
		String invitationCode=InvitationCodeGnerateUtil.generateInvitationCodeTwo( user);
		System.out.println(invitationCode);
	}
	
}
