
package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;
import com.yikangyiliao.pension.entity.Adept;


/**
 * @author liushuaic
 * @date 2015/08/26 10:59
 * @desc 用户测试
 * 
 * **/
public class UserTest {

	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-17-01 登陆用户
	 * */
	@Test
	public void TestRegisterUser(){
		try {
//			for(int i=1;i<51;i++){
				Map<String,Object> paramData=new HashMap<String, Object>();
				paramData.put("loginName","13716907546");
				paramData.put("password","123456");
				paramData.put("userFrom","7");
				SendRequest.sendPost("registerUser?appId=1",paramData);
//			}
//			for(int i=141;i<201;i++){
//				Map<String,Object> paramData=new HashMap<String, Object>();
//				paramData.put("loginName","bingren"+i);
//				paramData.put("password","111111");
//				SendRequest.sendPost("registerUser?appId=1",paramData);
//			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-17-01 登陆用户
	 * */
	@Test
	public void resgisterUserForThreepart(){
		try {
//			for(int i=1;i<51;i++){
				Map<String,Object> paramData=new HashMap<String, Object>();
				paramData.put("userName","test2");
				paramData.put("gender","m");
				paramData.put("accountId","123456333ooo");
				paramData.put("threePartAccountInfo","{user:'sdfsdf',userId:11}");
				paramData.put("userSource","0");
				SendRequest.sendPost("insertRegisterUserForThreepart?appId=1",paramData);
//			}
//			for(int i=141;i<201;i++){
//				Map<String,Object> paramData=new HashMap<String, Object>();
//				paramData.put("loginName","bingren"+i);
//				paramData.put("password","111111");
//				SendRequest.sendPost("registerUser?appId=1",paramData);
//			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author houyt
	 * @serialData 2016/09/12 14:59
	 * @desc 测试00-17-02注册用户及保存用户信息
	 */
	@Test
	public void TestSaveServiceUserInfo(){
		try{
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("loginName",53333233);
			paramData.put("passWord",1);
			paramData.put("passWord",1);
			paramData.put("jobCategory",1);
			paramData.put("cityCode",1);
			paramData.put("districtCode",1);
			paramData.put("addressDetail",1);
			paramData.put("userName","test2016/09/12");
			paramData.put("mapPositionAddress","光华护士基金");
			paramData.put("hospital","北京积水潭");
			paramData.put("offices","外科");
			paramData.put("adept","骨置换");
			paramData.put("userPosition","1");
			paramData.put("photoUrl","....");
			paramData.put("invitationCode","151119133");
			
			SendRequest.sendPost("00-17-02?appId=234&accessTiket=6d454b32bf07ec80bd7258fe341712850540ae8e72ef6b48b13746e40a90a41d5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-17-03 注册
	 * */
	@Test
	public void TestRegisterUserSaveServiceInfo(){
		
		try{
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("loginName",53333233);
			paramData.put("passWord",1);
			paramData.put("passWord",1);
			paramData.put("jobCategory",1);
			paramData.put("cityCode",1);
			paramData.put("districtCode",1);
			paramData.put("addressDetail",1);
			paramData.put("userName","test2015/11/18");
			paramData.put("mapPositionAddress","光华护士基金");
			paramData.put("hospital","北京积水潭");
			paramData.put("offices","外科");
			paramData.put("adept","骨置换");
			paramData.put("userPosition","1");
			paramData.put("photoUrl","....");
			paramData.put("invitationCode","151119133");
			
			SendRequest.sendPost("registerUserAndSaveServiceInfo?appId=234&accessTiket=6d454b32bf07ec80bd7258fe341712850540ae8e72ef6b48b13746e40a90a41d5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-17-04 查询服务人员信息
	 * */
	@Test
	public void TestGetServiceInfo(){
		
		try{
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			
			SendRequest.sendPost("00-17-04?appId=234&accessTicket=6d454b32bf07ec80bd7258fe341712850540ae8e72ef6b48b13746e40a90a41d5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@Test
	public void TestUpdateServiceInfo(){
		
		try{
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("userName", "hello World!");
			
			SendRequest.sendPost("00-17-05?appId=234&accessTicket=6d454b32bf07ec80bd7258fe341712850540ae8e72ef6b48b13746e40a90a41d5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void TestForgotPassword(){
		
		try{
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("loginName", "13716907523");
			
			SendRequest.sendPost("00-17-06?appId=234&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void TestUserNotAtSystem(){
		
		try{
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("loginName", "13716907523");
			
			SendRequest.sendPost("00-17-07?appId=234&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void TestResetPassword(){
		
		try{
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("loginName", "13661177209");
			paramData.put("password", "1");
			
			SendRequest.sendPost("00-17-08?appId=234&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-02-26 15:31
	 * 查询获取推荐列表
	 * 
	 * */
	@Test
	public void TestGetUserInfo(){
		System.out.println(Calendar.getInstance().getTime());
		try{
			Map<String,Object> paramData=new HashMap<String, Object>(); 
			paramData.put("userStatus", 0);
			for(int i=0;i<10000;i++){
				SendRequest.sendPost("00-17-09?appId=234&accessTicket=6d454b32bf07ec80bd7258fe341712850540ae8e72ef6b48b13746e40a90a41d5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Calendar.getInstance().getTime());
	}
	/**
	 * @author liushuaic
	 * @date 2016-03-25 15:31
	 * 查询获取推荐列表
	 * 
	 * */
	@Test
	public void TestGetUserInfoTwo(){
		
		try{
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("userStatus", 0);
			SendRequest.sendPost("00-17-10?appId=234&accessTicket=39fe63196e8820f2df8003a84fdbcdb4fd87be8a38a7d32e0691c30c1e4eebfb5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-03-17 16:31
	 * 查询获取推荐列表
	 * 
	 * */
	@Test
	public void TestGetUserInfoAdept(){
		
		try{
			Map<String,Object> paramData=new HashMap<String, Object>();
//			paramData.put("userStatus", 0);
			SendRequest.sendPost("00-17-10?appId=234&accessTicket=4286a50e808d04da0d39e4a83ef19f44aefb5c39877bd22903d981090d1f3b7c5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author liushuaic
	 * @date 2016-03-17 16:31
	 * 查询获取推荐列表
	 * 
	 * */
	@Test
	public void TestUpdateUserServiceAndServiceInfoTwo(){
		
		try{
			Map<String,Object> paramData=new HashMap<String, Object>();
//			paramData.put("userStatus", 0);
			Adept a=new Adept();
			a.setAdeptId(0l);
			
			Adept a2=new Adept();
			a2.setAdeptId(1l);
			
			List<Integer> adpets=new ArrayList<Integer>();
			adpets.add(1);
			adpets.add(2);
			
			paramData.put("bindMobileNumber","13716907523");
//			paramData.put("adepts", adpets);
			
			SendRequest.sendPost("00-17-12?appId=234&accessTicket=4286a50e808d04da0d39e4a83ef19f44aefb5c39877bd22903d981090d1f3b7c5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMyFollowUser(){
		try{
			Map<String,Object> paramData=new HashMap<String, Object>();
			SendRequest.sendPost("00-17-14?appId=234&accessTicket=4286a50e808d04da0d39e4a83ef19f44aefb5c39877bd22903d981090d1f3b7c5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void getUserServiceInfoByServerUserId(){
		try{
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("serverUserId", 75);
			SendRequest.sendPost("00-17-15?appId=234&accessTicket=4286a50e808d04da0d39e4a83ef19f44aefb5c39877bd22903d981090d1f3b7c5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
