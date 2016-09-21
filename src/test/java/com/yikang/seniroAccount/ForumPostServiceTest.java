package com.yikang.seniroAccount;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class ForumPostServiceTest {
	
	
	
	@Test
	public void getIsEssenceTest(){
		
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("", "");
			//paramData.put(key, value)
			SendRequest.sendPost("00-28-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 获取文章详情
	 * 
	 * */
	@Test
	public void getForumPostDetailTest(){
		
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("forumPostId",171);
			
			SendRequest.sendPost("00-28-02?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
 //udpateForumPostStar

	/**
	 * @author liushuaic
	 * @date 获取文章详情
	 * 
	 * */
	@Test
	public void udpateForumPostStarTest(){
		
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("forumPostId",1);
			
			SendRequest.sendPost("00-28-03?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 获取文章详情
	 * 
	 * */
	@Test
	public void publishForumPostTest(){
		
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("forumPostId",2);
			Long[] ids={1l,2l};
			String[] imgs={"34343","3434"};
			paramData.put("taglibIds",ids);
			paramData.put("images",imgs);
			paramData.put("title","我的测试内容，只是这些了。");
			paramData.put("content","我的测试内容，只是这些了。我的测试内容我的测试内容，只是这些了。我的测试内容，只是这些了。我的测试内容，只是这些了。我的测试内容，只是这些了。我的测试内容，只是这些了。，只是这些了。我的测试内容，只是这些了。测试内容，只是这些了。我的测试内容，只是这些了。");
			
			SendRequest.sendPost("00-28-04?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void getForumPostByTaglibId(){
		
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("taglibId",89);
			paramData.put("page",1);
			SendRequest.sendPost("00-28-06?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void  testAddQuestionAnswer(){
		
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("content",1);
			paramData.put("formPostId","sfsdfsdfs");
			SendRequest.sendPost("00-28-05?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
		
	//获取热门文章
	@Test
	public void  geForumPostsByCreateUserId(){
		
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			SendRequest.sendPost("00-28-07?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//获取热门文章
	@Test
	public void  testGetHotForumPosts(){
			
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			SendRequest.sendPost("00-28-08?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}
	//获取热门文章
	@Test
	public void  testPerfermenceForumPosts(){

		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("taglibId",2);
			paramData.put("page",1);
			SendRequest.sendPost("00-28-09?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	
	
	@Test
	public void publishPerfaceForumPostTest(){
		
		try{
			
//			paramData.containsKey("title")
//			&& paramData.containsKey("forumPostDetailContent")
//			&& paramData.containsKey("forumPostHtmlDetailContent")
//			&& paramData.containsKey("taglibIds")
//			&& paramData.containsKey("recommendPicUrl")
			
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("forumPostId",1);
			Long[] ids={1l,2l};
			String[] imgs={"34343","3434"};
			paramData.put("taglibIds",ids);
			paramData.put("images",imgs);
			paramData.put("title","我的测试内容，只是这些了。");
			paramData.put("recommendPicUrl","http://static.oschina.net/uploads/user/89/178392_100.jpg?t=1444358263000");
			paramData.put("forumPostDetailContent","我的测试内容，只是这些了。我的测试内容我的测试内容，只是这些了。我的测试内容，只是这些了。我的测试内容，只是这些了。我的测试内容，只是这些了。我的测试内容，只是这些了。，只是这些了。我的测试内容，只是这些了。测试内容，只是这些了。我的测试内容，只是这些了。");
			paramData.put("forumPostHtmlDetailContent","我的测试内容，只是这些了。我的测试内容我的测试内容，只是这些了。我的测试内容，只是这些了。我的测试内容，只是这些了。我的测试内容，只是这些了。我的测试内容，只是这些了。，只是这些了。我的测试内容，只是这些了。测试内容，只是这些了。我的测试内容，只是这些了。");
			
			SendRequest.sendPost("00-28-10?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	//我创建的专业文章
	@Test
	public void  testMyCreatePerfermenceForumPosts(){

		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			SendRequest.sendPost("00-28-11?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	//我创建的专业文章
	@Test
	public void  testGetFormPostRelatedReading(){
		
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("forumPostId", 246);
			SendRequest.sendPost("00-28-13?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	//获取某一个人创建的人员的文章
	@Test
	public void  testGetFormPostByUserServerUserid(){
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("serverUserId", 139);
			SendRequest.sendPost("00-28-14?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	//获取某一个人创建的人员的文章
	@Test
	public void  getForumPostsByServerUserIdPage(){
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("serverUserId", 139);
			paramData.put("page", 1);
			SendRequest.sendPost("00-28-15?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//获取某一个人创建的人员的文章
	@Test
	public void  getWZForumPostsByServerUserIdPage(){
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("serverUserId", 139);
			paramData.put("page", 1);
			SendRequest.sendPost("00-28-16?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//获取某一个人创建的人员的文章
	@Test
	public void  getHotForumPostsForPage(){
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("page", 1);
			SendRequest.sendPost("00-28-17?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ForumPostServiceTest fpst=new ForumPostServiceTest();
		fpst.testAddQuestionAnswer();
	}
}
