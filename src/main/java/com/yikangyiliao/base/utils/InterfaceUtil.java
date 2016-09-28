package com.yikangyiliao.base.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.yikangyiliao.base.config.YiKangServiceConfige;


/**
 * @author liushuaic
 * @date 2015/07/24 12:19
 * */
@SuppressWarnings("unused")
public class InterfaceUtil {
	
	
//	private static Map<String,String> serviceClassName=null;
//	
//	private static Map<String,String> mathodClassPath=null;
	
	private static Map<String,YiKangServiceConfige> mathodServiceConfig=null;
	
	static{
//		serviceClassName=new HashMap<String,String>();
//		mathodClassPath=new HashMap<String,String>();
		mathodServiceConfig=new HashMap<String,YiKangServiceConfige>();
		
		
		YiKangServiceConfige login=new YiKangServiceConfige();
		login.setServiceName("login");
		login.setMethodName("login");
		login.setIsFileter(false);
		mathodServiceConfig.put("login",login);
		
//		serviceClassName.put("loginForThreepartLogin", "login");
		YiKangServiceConfige loginForThreepartLogin=new YiKangServiceConfige();
		loginForThreepartLogin.setServiceName("login");
		loginForThreepartLogin.setMethodName("loginForThreepartLogin");
		loginForThreepartLogin.setIsFileter(false);
		mathodServiceConfig.put("loginForThreepartLogin",loginForThreepartLogin);
		
		
		/**
		 * @author liushuaic
		 * @date 2015/08/26 10:42
		 * 用户管理
		 * **/
		
//		serviceClassName.put("registerUser", "userService");
		YiKangServiceConfige registUser=new YiKangServiceConfige();
		registUser.setServiceName("userService");
		registUser.setMethodName("registerUser");
		registUser.setIsFileter(false);
		mathodServiceConfig.put("registerUser",registUser);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-08-08 17:46
		 * @desc 注册用户
		 * */
//		serviceClassName.put("insertRegisterUserForThreepart", "userService");
		YiKangServiceConfige insertRegisterUserForThreepart=new YiKangServiceConfige();
		insertRegisterUserForThreepart.setServiceName("userService");
		insertRegisterUserForThreepart.setMethodName("insertRegisterUserForThreepart");
		insertRegisterUserForThreepart.setIsFileter(false);
		mathodServiceConfig.put("insertRegisterUserForThreepart", insertRegisterUserForThreepart);
		
		
		
//		serviceClassName.put("registerUserAndSaveServiceInfo", "userService");
//		mathodClassPath.put("registerUserAndSaveServiceInfo", "saveRegisterUserAndSaveServiceInfo");
		YiKangServiceConfige registerUserAndSaveServiceInfo=new YiKangServiceConfige();
		registerUserAndSaveServiceInfo.setServiceName("userService");
		registerUserAndSaveServiceInfo.setMethodName("registerUserAndSaveServiceInfo");
		registerUserAndSaveServiceInfo.setIsFileter(false);
		mathodServiceConfig.put("registerUserAndSaveServiceInfo", registerUserAndSaveServiceInfo);
		
		
		
		YiKangServiceConfige registerUser=new YiKangServiceConfige();
		registerUser.setServiceName("userService");
		registerUser.setMethodName("registerUser");
		registerUser.setIsFileter(false);
		mathodServiceConfig.put("00-17-01", registerUser);
		
		
		YiKangServiceConfige registerUserAndSaveServiceInfo13=new YiKangServiceConfige();
		registerUserAndSaveServiceInfo13.setServiceName("saveServiceUserInfo");
		registerUserAndSaveServiceInfo13.setMethodName("registerUserAndSaveServiceInfo");
		registerUserAndSaveServiceInfo13.setIsFileter(false);
		mathodServiceConfig.put("00-17-03", registerUserAndSaveServiceInfo13);
		// 获取个人信息 
//		mathodClassPath.put("00-17-04", "getUserServiceInfoByUserId");
		YiKangServiceConfige getUserServiceInfoByUserId=new YiKangServiceConfige();
		getUserServiceInfoByUserId.setServiceName("userService");
		getUserServiceInfoByUserId.setMethodName("getUserServiceInfoByUserId");
		getUserServiceInfoByUserId.setIsFileter(true);
		mathodServiceConfig.put("00-17-04",getUserServiceInfoByUserId);
		
		
		
		/**
		 * @author liushuaic
		 * @date 
		 * @desc 修改个人信息
		 * */
		YiKangServiceConfige updateUserServiceAndServiceInfo=new YiKangServiceConfige();
		updateUserServiceAndServiceInfo.setServiceName("userService");
		updateUserServiceAndServiceInfo.setMethodName("updateUserServiceAndServiceInfo");
		updateUserServiceAndServiceInfo.setIsFileter(true);
		mathodServiceConfig.put("00-17-05",updateUserServiceAndServiceInfo);
//		mathodClassPath.put("00-17-05", "updateUserServiceAndServiceInfo");
		
		
		
		//忘记密码
		YiKangServiceConfige forgotPassword=new YiKangServiceConfige();
		forgotPassword.setServiceName("userService");
		forgotPassword.setMethodName("forgotPassword");
		forgotPassword.setIsFileter(false);
		mathodServiceConfig.put("00-17-06",forgotPassword);
		
		
		//查询用户是否存在
		YiKangServiceConfige isMySystemUser=new YiKangServiceConfige();
		isMySystemUser.setServiceName("userService");
		isMySystemUser.setMethodName("isMySystemUser");
		isMySystemUser.setIsFileter(false);
		mathodServiceConfig.put("00-17-07",isMySystemUser);
		
		
		//重置密码
		YiKangServiceConfige resetPassword=new YiKangServiceConfige();
		resetPassword.setServiceName("userService");
		resetPassword.setMethodName("resetPassword");
		resetPassword.setIsFileter(false);
		mathodServiceConfig.put("00-17-08",resetPassword);
		
		
		
		//获取我邀请的用户
		YiKangServiceConfige getInvationUserByUserId=new YiKangServiceConfige();
		getInvationUserByUserId.setServiceName("userService");
		getInvationUserByUserId.setMethodName("getInvationUserInfoByInvationUserId");
		getInvationUserByUserId.setIsFileter(true);
		mathodServiceConfig.put("00-17-09",getInvationUserByUserId);
		
		
		
		//获取我的信息
		YiKangServiceConfige getUserServiceInfoByUserIdTwo=new YiKangServiceConfige();
		getUserServiceInfoByUserIdTwo.setServiceName("userService");
		getUserServiceInfoByUserIdTwo.setMethodName("getUserServiceInfoByUserIdTwo");
		getUserServiceInfoByUserIdTwo.setIsFileter(true);
		mathodServiceConfig.put("00-17-10",getUserServiceInfoByUserIdTwo);
		
		
		//获取我邀请的用户
		YiKangServiceConfige getInvationUserInfoByInvationUserIdTwo=new YiKangServiceConfige();
		getInvationUserInfoByInvationUserIdTwo.setServiceName("userService");
		getInvationUserInfoByInvationUserIdTwo.setMethodName("getInvationUserInfoByInvationUserIdTwo");
		getInvationUserInfoByInvationUserIdTwo.setIsFileter(true);
		mathodServiceConfig.put("00-17-11",getInvationUserInfoByInvationUserIdTwo);
		
		//修改用户信息
		YiKangServiceConfige updateUserServiceAndServiceInfoTwo=new YiKangServiceConfige();
		updateUserServiceAndServiceInfoTwo.setServiceName("userService");
		updateUserServiceAndServiceInfoTwo.setMethodName("updateUserServiceAndServiceInfoTwo");
		updateUserServiceAndServiceInfoTwo.setIsFileter(true);
		mathodServiceConfig.put("00-17-12",updateUserServiceAndServiceInfoTwo);
		
		//提交修改用户职位的接口
		YiKangServiceConfige submitUpdateUserPosition=new YiKangServiceConfige();
		submitUpdateUserPosition.setServiceName("userService");
		submitUpdateUserPosition.setMethodName("submitUpdateUserPosition");
		submitUpdateUserPosition.setIsFileter(true);
		mathodServiceConfig.put("00-17-13",submitUpdateUserPosition);
		
		//获取我关注的用户列表
		YiKangServiceConfige getMyFollowUser=new YiKangServiceConfige();
		getMyFollowUser.setServiceName("userService");
		getMyFollowUser.setMethodName("getMyFollowUser");
		getMyFollowUser.setIsFileter(true);
		mathodServiceConfig.put("00-17-14",getMyFollowUser);
		
		
		
		
		//查询某一个服务人员的信息
		YiKangServiceConfige getUserServiceInfoByServerUserId=new YiKangServiceConfige();
		getUserServiceInfoByServerUserId.setServiceName("userService");
		getUserServiceInfoByServerUserId.setMethodName("getUserServiceInfoByServerUserId");
		getUserServiceInfoByServerUserId.setIsFileter(false);
		mathodServiceConfig.put("00-17-15",getUserServiceInfoByServerUserId);
		
		/**
		 * @author liushuaic
		 * @date 2015/09/01 14:19
		 * @desc 设备管理
		 * **/
//		serviceClassName.put("00-18", "deviceService");
		//保存设备
		YiKangServiceConfige saveDevice=new YiKangServiceConfige();
		saveDevice.setServiceName("deviceService");
		saveDevice.setMethodName("saveDevice");
		saveDevice.setIsFileter(true);
		mathodServiceConfig.put("00-18-01",saveDevice);
//		mathodClassPath.put("00-18-01", "saveDevice");
		//获取别名 需登陆
		YiKangServiceConfige getAliasByUser=new YiKangServiceConfige();
		getAliasByUser.setServiceName("deviceService");
		getAliasByUser.setMethodName("getAliasByUser");
		getAliasByUser.setIsFileter(true);
		mathodServiceConfig.put("00-18-02",getAliasByUser);
//		mathodClassPath.put("00-18-02", "getAliasByUser");
		
		
		/**
		 * 
		 * @author liushuaic
		 * @date 2015/09/18 11:58
		 * @desc 服务人员日程管理
		 * **/
		
		YiKangServiceConfige getScheduleListByMonth=new YiKangServiceConfige();
		getScheduleListByMonth.setServiceName("serviceScheduleService");
		getScheduleListByMonth.setMethodName("getScheduleListByMonth");
		getScheduleListByMonth.setIsFileter(true);
		mathodServiceConfig.put("00-19-01",getScheduleListByMonth);
//		mathodClassPath.put("00-19-01", "getScheduleListByMonth");
		
		YiKangServiceConfige getServiceScheduleDetail=new YiKangServiceConfige();
		getServiceScheduleDetail.setServiceName("serviceScheduleService");
		getServiceScheduleDetail.setMethodName("getScheduleListByMonth");
		getServiceScheduleDetail.setIsFileter(true);
		mathodServiceConfig.put("00-19-02",getServiceScheduleDetail);
//		mathodClassPath.put("00-19-02", "getServiceScheduleDetail");
		
		
		YiKangServiceConfige insertServiceScheduleDetail=new YiKangServiceConfige();
		insertServiceScheduleDetail.setServiceName("serviceScheduleService");
		insertServiceScheduleDetail.setMethodName("insertServiceScheduleDetail");
		insertServiceScheduleDetail.setIsFileter(true);
		mathodServiceConfig.put("00-19-03",insertServiceScheduleDetail);
//		mathodClassPath.put("00-19-03", "insertServiceScheduleDetail");
		
		/**
		 * @author liushuaic
		 * @date 2015/10/10 17:23
		 * 预约日期查询
		 * **/
		YiKangServiceConfige timeQuantumService=new YiKangServiceConfige();
		timeQuantumService.setServiceName("timeQuantumService");
		timeQuantumService.setMethodName("timeQuantumService");
		timeQuantumService.setIsFileter(true);
		mathodServiceConfig.put("00-20-01",timeQuantumService);
//		mathodClassPath.put("00-20-01", "getTimeQuantumsForCustomer");
		
		
		
		/**
		 * @author liushuaic
		 * @date 2015/10/12 15:11
		 * 预约管理
		 * **/
//		serviceClassName.put("00-21","appointmentOrderService");
//		mathodClassPath.put("00-21-01", "addPointmentOrder");
//		mathodClassPath.put("00-21-02", "getServiceUserByOrderId");
//		mathodClassPath.put("00-21-03", "addPointmentOrderAndSubmitAssessment");
//		// 查询我的工作日程
//		mathodClassPath.put("00-21-04", "getServicerScheduleByServiceUserId");
//		//查询我的工作日程详情
//		mathodClassPath.put("00-21-05", "getOrderServiceDetailById");
//		//保存反馈信息，设置订单服务完成
//		mathodClassPath.put("00-21-06", "saveFeedback");
		
		
		
		YiKangServiceConfige getOrderByUserId=new YiKangServiceConfige();
		getOrderByUserId.setServiceName("appointmentOrderService");
		getOrderByUserId.setMethodName("getAppointmentOrderListPageByUserId");
		getOrderByUserId.setIsFileter(true);
		mathodServiceConfig.put("00-21-07",getOrderByUserId);
		
		
		/**
		 * @author liushuaic
		 * @date 2015/10/14 20:18
		 * 服务人员服务
		 * */
		YiKangServiceConfige getAssessmentService=new YiKangServiceConfige();
		getAssessmentService.setServiceName("appointmentOrderService");
		getAssessmentService.setMethodName("getAssessmentService");
		getAssessmentService.setIsFileter(true);
		mathodServiceConfig.put("00-22-01",getAssessmentService);
//		mathodClassPath.put("00-22-01","getAssessmentService");
		
		
		/**
		 * @author liushuaic
		 * @date 2016-09-20 14:27
		 * @desc 获取某一类型的擅长
		 * */
		YiKangServiceConfige getAdeptsByType=new YiKangServiceConfige();
		getAdeptsByType.setServiceName("adeptService");
		getAdeptsByType.setMethodName("getAdeptsByType");
		getAdeptsByType.setIsFileter(true);
		mathodServiceConfig.put("00-23-01",getAdeptsByType);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-03-22 16:38
		 * @desc 获取办公室列表
		 * */
		YiKangServiceConfige getOffice=new YiKangServiceConfige();
		getOffice.setServiceName("officeService");
		getOffice.setMethodName("getOffice");
		getOffice.setIsFileter(true);
		mathodServiceConfig.put("00-24-01",getOffice);
		
		
		
		/**
		 * @author liushuaic
		 * @date 2016-03-22 15:19
		 * @desc  获取验证码
		 * */
		YiKangServiceConfige getCaptchar=new YiKangServiceConfige();
		getCaptchar.setServiceName("captchaService");
		getCaptchar.setMethodName("getCaptchar");
		getCaptchar.setIsFileter(false);
		mathodServiceConfig.put("00-25-01",getCaptchar);
		
		
		YiKangServiceConfige validateCaptchar=new YiKangServiceConfige();
		validateCaptchar.setServiceName("captchaService");
		validateCaptchar.setMethodName("validateCaptchar");
		validateCaptchar.setIsFileter(false);
		mathodServiceConfig.put("00-25-02",validateCaptchar);
		
		
		/**
		 * 轮播图
		 * 首页
		 * **/
		YiKangServiceConfige getBanerList=new YiKangServiceConfige();
		getBanerList.setServiceName("banerService");
		getBanerList.setMethodName("getBanerList");
		getBanerList.setIsFileter(false);
		mathodServiceConfig.put("00-26-01",getBanerList);
		
		/**
		 * 活动轮播图
		 * **/
		YiKangServiceConfige getActivetyBaner=new YiKangServiceConfige();
		getActivetyBaner.setServiceName("banerService");
		getActivetyBaner.setMethodName("getActivetyBaner");
		getActivetyBaner.setIsFileter(false);
		mathodServiceConfig.put("00-26-02",getActivetyBaner);
		
		
		
		
		YiKangServiceConfige getTaglibsList=new YiKangServiceConfige();
		getTaglibsList.setServiceName("searchService");
		getTaglibsList.setMethodName("getTaglibList");
		getTaglibsList.setIsFileter(false);
		mathodServiceConfig.put("00-27-01",getTaglibsList);
		
		YiKangServiceConfige getIsEssence=new YiKangServiceConfige();
		getIsEssence.setServiceName("forumPostService");
		getIsEssence.setMethodName("getIsEssence");
		getIsEssence.setIsFileter(false);
		mathodServiceConfig.put("00-28-01",getIsEssence);
		
		
		
		// 获取文章详情
		YiKangServiceConfige getFourmPostDetail=new YiKangServiceConfige();
		getFourmPostDetail.setServiceName("forumPostService");
		getFourmPostDetail.setMethodName("getFourmPostDetail");
		getFourmPostDetail.setIsFileter(false);
		mathodServiceConfig.put("00-28-02",getFourmPostDetail);
		
		
		//文章支持
		YiKangServiceConfige upForumPostStar=new YiKangServiceConfige();
		upForumPostStar.setServiceName("forumPostService");
		upForumPostStar.setMethodName("upForumPostStar");
		upForumPostStar.setIsFileter(true);
		mathodServiceConfig.put("00-28-03",upForumPostStar);
		
		
		//发布帖子
		YiKangServiceConfige publishForumPosts=new YiKangServiceConfige();
		publishForumPosts.setServiceName("forumPostService");
		publishForumPosts.setMethodName("publishForumPosts");
		publishForumPosts.setIsFileter(true);
		mathodServiceConfig.put("00-28-04",publishForumPosts);
		
		//文章回复
		YiKangServiceConfige fourmPostAnswers=new YiKangServiceConfige();
		fourmPostAnswers.setServiceName("forumPostService");
		fourmPostAnswers.setMethodName("fourmPostAnswers");
		fourmPostAnswers.setIsFileter(true);
		mathodServiceConfig.put("00-28-05",fourmPostAnswers);
		
		//根据
		YiKangServiceConfige getForumPostsByTaglibId=new YiKangServiceConfige();
		getForumPostsByTaglibId.setServiceName("forumPostService");
		getForumPostsByTaglibId.setMethodName("getForumPostsByTaglibId");
		getForumPostsByTaglibId.setIsFileter(false);
		mathodServiceConfig.put("00-28-06",getForumPostsByTaglibId);
		
		
		//获取某一个用户创建的帖子
		YiKangServiceConfige geForumPostsByCreateUserId=new YiKangServiceConfige();
		geForumPostsByCreateUserId.setServiceName("forumPostService");
		geForumPostsByCreateUserId.setMethodName("geForumPostsByCreateUserId");
		geForumPostsByCreateUserId.setIsFileter(true);
		mathodServiceConfig.put("00-28-07",geForumPostsByCreateUserId);
		
		//获取最热帖子
		YiKangServiceConfige getHotForumPosts=new YiKangServiceConfige();
		getHotForumPosts.setServiceName("forumPostService");
		getHotForumPosts.setMethodName("getHotForumPosts");
		getHotForumPosts.setIsFileter(false);
		mathodServiceConfig.put("00-28-08",getHotForumPosts);
		
		//获取专业内容 createdate: 2016-06-22
		YiKangServiceConfige getPerformenceForumPostsByTaglibId=new YiKangServiceConfige();
		getPerformenceForumPostsByTaglibId.setServiceName("forumPostService");
		getPerformenceForumPostsByTaglibId.setMethodName("getPerformenceForumPostsByTaglibId");
		getPerformenceForumPostsByTaglibId.setIsFileter(false);
		mathodServiceConfig.put("00-28-09",getPerformenceForumPostsByTaglibId);

		//发布专业内容 createdate: 2016-06-22
		YiKangServiceConfige performencePublishForumPosts=new YiKangServiceConfige();
		performencePublishForumPosts.setServiceName("forumPostService");
		performencePublishForumPosts.setMethodName("performencePublishForumPosts");
		performencePublishForumPosts.setIsFileter(true);
		mathodServiceConfig.put("00-28-10",performencePublishForumPosts);
		
		
		//获取我创建的专业文章
		YiKangServiceConfige geWZForumPostsByCreateUserId=new YiKangServiceConfige();
		geWZForumPostsByCreateUserId.setServiceName("forumPostService");
		geWZForumPostsByCreateUserId.setMethodName("geWZForumPostsByCreateUserId");
		geWZForumPostsByCreateUserId.setIsFileter(true);
		mathodServiceConfig.put("00-28-11",geWZForumPostsByCreateUserId);
		
		//获取某一个用户的专业帖子
		YiKangServiceConfige getForumPostsByServerUserId=new YiKangServiceConfige();
		getForumPostsByServerUserId.setServiceName("forumPostService");
		getForumPostsByServerUserId.setMethodName("getForumPostsByServerUserId");
		getForumPostsByServerUserId.setIsFileter(false);
		mathodServiceConfig.put("00-28-12",getForumPostsByServerUserId);
		
		//获取相关推荐数据
		YiKangServiceConfige getFormPostRelatedReading=new YiKangServiceConfige();
		getFormPostRelatedReading.setServiceName("forumPostService");
		getFormPostRelatedReading.setMethodName("getFormPostRelatedReading");
		getFormPostRelatedReading.setIsFileter(false);
		mathodServiceConfig.put("00-28-13",getFormPostRelatedReading);
		
		//获取某一个人的文章
		YiKangServiceConfige getWZForumPostsByServerUserId=new YiKangServiceConfige();
		getWZForumPostsByServerUserId.setServiceName("forumPostService");
		getWZForumPostsByServerUserId.setMethodName("getWZForumPostsByServerUserId");
		getWZForumPostsByServerUserId.setIsFileter(true);
		mathodServiceConfig.put("00-28-14",getWZForumPostsByServerUserId);
		
		
		//获取某一个人的帖子，分页
		YiKangServiceConfige getForumPostsByServerUserIdPage=new YiKangServiceConfige();
		getForumPostsByServerUserIdPage.setServiceName("forumPostService");
		getForumPostsByServerUserIdPage.setMethodName("getForumPostsByServerUserIdPage");
		getForumPostsByServerUserIdPage.setIsFileter(false);
		mathodServiceConfig.put("00-28-15",getForumPostsByServerUserIdPage);
		
		//获取料一个人的文章，分页
		YiKangServiceConfige getWZForumPostsByServerUserIdPage=new YiKangServiceConfige();
		getWZForumPostsByServerUserIdPage.setServiceName("forumPostService");
		getWZForumPostsByServerUserIdPage.setMethodName("getWZForumPostsByServerUserIdPage");
		getWZForumPostsByServerUserIdPage.setIsFileter(false);
		mathodServiceConfig.put("00-28-16",getWZForumPostsByServerUserIdPage);
		
		//获取最热帖子分页 no login
		YiKangServiceConfige getHotForumPostsForPage=new YiKangServiceConfige();
		getHotForumPostsForPage.setServiceName("forumPostService");
		getHotForumPostsForPage.setMethodName("getHotForumPostsForPage");
		getHotForumPostsForPage.setIsFileter(false);
		mathodServiceConfig.put("00-28-17",getHotForumPostsForPage);
		

		//问题处理
		YiKangServiceConfige insertQuestion=new YiKangServiceConfige();
		insertQuestion.setServiceName("questionService");
		insertQuestion.setMethodName("insertQuestion");
		insertQuestion.setIsFileter(true);
		mathodServiceConfig.put("00-29-01",insertQuestion);
		
		//更新问题支持状态
		YiKangServiceConfige upQuestionStar=new YiKangServiceConfige();
		upQuestionStar.setServiceName("questionService");
		upQuestionStar.setMethodName("upQuestionStar");
		upQuestionStar.setIsFileter(true);
		mathodServiceConfig.put("00-29-02",upQuestionStar);
		
		//问题回复
		YiKangServiceConfige addQuestionAnswer=new YiKangServiceConfige();
		addQuestionAnswer.setServiceName("questionService");
		addQuestionAnswer.setMethodName("addQuestionAnswer");
		addQuestionAnswer.setIsFileter(true);
		mathodServiceConfig.put("00-29-03",addQuestionAnswer);
		
		
		//查询问题详情
		YiKangServiceConfige getQuestionDetailByQuestionId=new YiKangServiceConfige();
		getQuestionDetailByQuestionId.setServiceName("questionService");
		getQuestionDetailByQuestionId.setMethodName("getQuestionDetailByQuestionId");
		getQuestionDetailByQuestionId.setIsFileter(false);
		mathodServiceConfig.put("00-29-04",getQuestionDetailByQuestionId);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-24 15:49
		 * @desc 查询某一个标签下的所有问题
		 * **/
		YiKangServiceConfige getQuestionsByTaglibId=new YiKangServiceConfige();
		getQuestionsByTaglibId.setServiceName("questionService");
		getQuestionsByTaglibId.setMethodName("getQuestionsByTaglibId");
		getQuestionsByTaglibId.setIsFileter(false);
		mathodServiceConfig.put("00-29-05",getQuestionsByTaglibId);
		
		
		
		/**
		 * @author liushuaic
		 * @date 2016-06-06 19:37
		 * @desc 获取精彩回答
		 * **/
		YiKangServiceConfige getHotQuestionAnswer=new YiKangServiceConfige();
		getHotQuestionAnswer.setServiceName("questionService");
		getHotQuestionAnswer.setMethodName("getHotQuestionAnswer");
		getHotQuestionAnswer.setIsFileter(false);
		mathodServiceConfig.put("00-29-06",getHotQuestionAnswer);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-06-06 19:37
		 * @desc 获取某一个人创建的所有问题
		 * **/
		YiKangServiceConfige getQuestionByCreateUserId=new YiKangServiceConfige();
		getQuestionByCreateUserId.setServiceName("questionService");
		getQuestionByCreateUserId.setMethodName("getQuestionByCreateUserId");
		getQuestionByCreateUserId.setIsFileter(true);
		mathodServiceConfig.put("00-29-07",getQuestionByCreateUserId);
		
		/**
		 * @author liushuaic
		 * @date 2016-06-06 19:37
		 * @desc 获取某一个人创建的所有问题
		 * **/
		YiKangServiceConfige getQuestionByCreateUserIdPage=new YiKangServiceConfige();
		getQuestionByCreateUserIdPage.setServiceName("questionService");
		getQuestionByCreateUserIdPage.setMethodName("getQuestionByCreateUserIdPage");
		getQuestionByCreateUserIdPage.setIsFileter(false);
		mathodServiceConfig.put("00-29-08",getQuestionByCreateUserIdPage);
		
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-12 15:03
		 * @desc 标签管理 热门标签
		 * ***/
		YiKangServiceConfige getRecommendTaglib=new YiKangServiceConfige();
		getRecommendTaglib.setServiceName("taglibService");
		getRecommendTaglib.setMethodName("getRecommendTaglib");
		getRecommendTaglib.setIsFileter(false);
		mathodServiceConfig.put("00-30-01",getRecommendTaglib);
		
		/**
		 * @author houyt
		 * @date 2016-09-23 15:03
		 * @desc 标签管理 热门标签
		 * ***/
		YiKangServiceConfige getRecommendTaglibTwo=new YiKangServiceConfige();
		getRecommendTaglibTwo.setServiceName("taglibService");
		getRecommendTaglibTwo.setMethodName("getRecommendTaglibTwo");
		getRecommendTaglibTwo.setIsFileter(false);
		mathodServiceConfig.put("00-30-08",getRecommendTaglibTwo);
		
		
		/**·
		 * @author liushuaic
		 * @date 2016-05-27 10:47
		 * @desc 获取一级标签
		 * */
		YiKangServiceConfige getFristTaglib=new YiKangServiceConfige();
		getFristTaglib.setServiceName("taglibService");
		getFristTaglib.setMethodName("getFristTaglib");
		getFristTaglib.setIsFileter(false);
		mathodServiceConfig.put("00-30-02",getFristTaglib);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-27 10:48
		 * @desc 获取二级标签
		 * **/
		YiKangServiceConfige getSecondTaglibByParentId=new YiKangServiceConfige();
		getSecondTaglibByParentId.setServiceName("taglibService");
		getSecondTaglibByParentId.setMethodName("getSecondTaglibByParentId");
		getSecondTaglibByParentId.setIsFileter(false);
		mathodServiceConfig.put("00-30-03",getSecondTaglibByParentId);
		
		/**
		 * @author liushuaic
		 * @date 2016-05-28 10:52
		 * @desc 获取一级标签与二级标签
		 * **/
		YiKangServiceConfige getAllTag=new YiKangServiceConfige();
		getAllTag.setServiceName("taglibService");
		getAllTag.setMethodName("getAllTag");
		getAllTag.setIsFileter(false);
		mathodServiceConfig.put("00-30-04",getAllTag);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-06-01 10:07
		 * @desc 获取我关注的标签
		 * */
		YiKangServiceConfige getMyWatchTaglibsByUserid=new YiKangServiceConfige();
		getMyWatchTaglibsByUserid.setServiceName("taglibService");
		getMyWatchTaglibsByUserid.setMethodName("getMyWatchTaglibsByUserid");
		getMyWatchTaglibsByUserid.setIsFileter(true);
		mathodServiceConfig.put("00-30-05",getMyWatchTaglibsByUserid);
		
		
		YiKangServiceConfige getSecondAllTaglib=new YiKangServiceConfige();
		getSecondAllTaglib.setServiceName("taglibService");
		getSecondAllTaglib.setMethodName("getSecondAllTaglib");
		getSecondAllTaglib.setIsFileter(false);
		mathodServiceConfig.put("00-30-06",getSecondAllTaglib);
		
		/**
		 * @author liushuaic
		 * @date 2016-09-22 20:47
		 * @desc 查询某一个标签的信息
		 * **/
		YiKangServiceConfige getTaglibByTaglibIdUserId=new YiKangServiceConfige();
		getTaglibByTaglibIdUserId.setServiceName("taglibService");
		getTaglibByTaglibIdUserId.setMethodName("getTaglibByTaglibIdUserId");
		getTaglibByTaglibIdUserId.setIsFileter(false);
		mathodServiceConfig.put("00-30-07",getTaglibByTaglibIdUserId);
		
		
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-12 15:03
		 * @desc 活动管理
		 **/
		YiKangServiceConfige getActivetys=new YiKangServiceConfige();
		getActivetys.setServiceName("activetyService");
		getActivetys.setMethodName("getActivetys");
		getActivetys.setIsFileter(false);
		mathodServiceConfig.put("00-31-01",getActivetys);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-13 16:27
		 * @desc 查询某一个活动详情
		 * */
		YiKangServiceConfige getActivetyByActivetyId=new YiKangServiceConfige();
		getActivetyByActivetyId.setServiceName("activetyService");
		getActivetyByActivetyId.setMethodName("getActivetyByActivetyId");
		getActivetyByActivetyId.setIsFileter(false);
		mathodServiceConfig.put("00-31-02",getActivetyByActivetyId);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-23 15:52
		 * @desc 添加活动
		 * **/
		YiKangServiceConfige insertActivety=new YiKangServiceConfige();
		insertActivety.setServiceName("activetyService");
		insertActivety.setMethodName("insertActivety");
		insertActivety.setIsFileter(true);
		mathodServiceConfig.put("00-31-03",insertActivety);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-23 15:56
		 * @desc 参与活动
		 * **/
		YiKangServiceConfige insertMyAcitivety=new YiKangServiceConfige();
		insertMyAcitivety.setServiceName("activetyService");
		insertMyAcitivety.setMethodName("insertMyAcitivety");
		insertMyAcitivety.setIsFileter(true);
		mathodServiceConfig.put("00-31-04",insertMyAcitivety);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-23 15:57
		 * @desc 活动评论
		 * 
		 * **/
		YiKangServiceConfige insertActivetyComment=new YiKangServiceConfige();
		insertActivetyComment.setServiceName("activetyService");
		insertActivetyComment.setMethodName("insertActivetyComment");
		insertActivetyComment.setIsFileter(true);
		mathodServiceConfig.put("00-31-05",insertActivetyComment);
		
		/**
		 * @author liushuaic
		 * @date 2016-05-23 16:09
		 * @desc 获取某一个活动的评论列表
		 * **/
		YiKangServiceConfige getActivetyCommentByActivetyId=new YiKangServiceConfige();
		getActivetyCommentByActivetyId.setServiceName("activetyService");
		getActivetyCommentByActivetyId.setMethodName("getActivetyCommentByActivetyId");
		getActivetyCommentByActivetyId.setIsFileter(false);
		mathodServiceConfig.put("00-31-06",getActivetyCommentByActivetyId);
		
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-23 16:20
		 * @desc 获取我参加的活动列表
		 * **/
		YiKangServiceConfige getActiveyByJoinUserId=new YiKangServiceConfige();
		getActiveyByJoinUserId.setServiceName("activetyService");
		getActiveyByJoinUserId.setMethodName("getActiveyByJoinUserId");
		getActiveyByJoinUserId.setIsFileter(true);
		mathodServiceConfig.put("00-31-07",getActiveyByJoinUserId);
		
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-23 16:20
		 * @desc 获取我参加的活动列表
		 * **/
		YiKangServiceConfige getActiveyByJoinUserIdPage=new YiKangServiceConfige();
		getActiveyByJoinUserIdPage.setServiceName("activetyService");
		getActiveyByJoinUserIdPage.setMethodName("getActiveyByJoinUserIdPage");
		getActiveyByJoinUserIdPage.setIsFileter(true);
		mathodServiceConfig.put("00-31-08",getActiveyByJoinUserIdPage);
		
		/**
		 * @author liushuaic
		 * @date 2016-09-08 11:16
		 * @desc 获取我创建的活动列表分页
		 * **/
		YiKangServiceConfige getActivetyByCreateUserIdPage=new YiKangServiceConfige();
		getActivetyByCreateUserIdPage.setServiceName("activetyService");
		getActivetyByCreateUserIdPage.setMethodName("getActivetyByCreateUserIdPage");
		getActivetyByCreateUserIdPage.setIsFileter(true);
		mathodServiceConfig.put("00-31-09",getActivetyByCreateUserIdPage);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-09-12 16:18
		 * @desc 获取某一个用户的发布的活动列表
		 ***/
		YiKangServiceConfige getActivetyByServerUserIdPage=new YiKangServiceConfige();
		getActivetyByServerUserIdPage.setServiceName("activetyService");
		getActivetyByServerUserIdPage.setMethodName("getActivetyByServerUserIdPage");
		getActivetyByServerUserIdPage.setIsFileter(false);
		mathodServiceConfig.put("00-31-10",getActivetyByServerUserIdPage);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-17 14:55
		 * @desc 获取用户的配置信息
		 * */
		YiKangServiceConfige getUserConfigrationByUserId=new YiKangServiceConfige();
		getUserConfigrationByUserId.setServiceName("userConfigrationService");
		getUserConfigrationByUserId.setMethodName("getUserConfigrationByUserId");
		getUserConfigrationByUserId.setIsFileter(true);
		mathodServiceConfig.put("00-32-01",getUserConfigrationByUserId);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-20 16:51
		 * @desc 修改用户配置信息
		 * */
		YiKangServiceConfige updateUserConfigration=new YiKangServiceConfige();
		updateUserConfigration.setServiceName("userConfigrationService");
		updateUserConfigration.setMethodName("updateUserConfigration");
		updateUserConfigration.setIsFileter(true);
		mathodServiceConfig.put("00-32-02",updateUserConfigration);
		
		
		
		/**
		 * 
		 * @author liushuaic
		 * @date 2016-05-26 14:22
		 * @desc 获取配置信息
		 * 
		 * */
		YiKangServiceConfige getMessageAlert=new YiKangServiceConfige();
		getMessageAlert.setServiceName("userConfigrationService");
		getMessageAlert.setMethodName("getMessageAlert");
		getMessageAlert.setIsFileter(true);
		mathodServiceConfig.put("00-34-01",getMessageAlert);
		
		
		
		/**
		 * @author liushuaic
		 * @date 2016-06-07 10:25
		 * @desc 获取系统消息列表
		 * */
		
		//系统消息列表
		YiKangServiceConfige getSystemMessageByUserId=new YiKangServiceConfige();
		getSystemMessageByUserId.setServiceName("messageService");
		getSystemMessageByUserId.setMethodName("getSystemMessageByUserId");
		getSystemMessageByUserId.setIsFileter(true);
		mathodServiceConfig.put("00-35-01",getSystemMessageByUserId);
		
		//动态消息列表
		YiKangServiceConfige getDynamicMessageByUserId=new YiKangServiceConfige();
		getDynamicMessageByUserId.setServiceName("messageService");
		getDynamicMessageByUserId.setMethodName("getDynamicMessageByUserId");
		getDynamicMessageByUserId.setIsFileter(true);
		mathodServiceConfig.put("00-35-02",getDynamicMessageByUserId);
		
		
		//动态消息列表,分页
		YiKangServiceConfige getDynamicMessageByUserIdPage=new YiKangServiceConfige();
		getDynamicMessageByUserIdPage.setServiceName("messageService");
		getDynamicMessageByUserIdPage.setMethodName("getDynamicMessageByUserIdPage");
		getDynamicMessageByUserIdPage.setIsFileter(true);
		mathodServiceConfig.put("00-35-06",getDynamicMessageByUserIdPage);
		
		
		// 通过消息标识标记此条状态为已读
		YiKangServiceConfige setTheMessageAsReadByMessagesId = new YiKangServiceConfige();
		setTheMessageAsReadByMessagesId.setServiceName("messageService");
		setTheMessageAsReadByMessagesId.setMethodName("setTheMessageAsReadByMessagesId");
		setTheMessageAsReadByMessagesId.setIsFileter(false);
		mathodServiceConfig.put("00-35-03", setTheMessageAsReadByMessagesId);
		
		
		// 根据登录用户ID查询他的动态/系统 消息的未读数量
		YiKangServiceConfige getMessageUnreadNumberByUserId = new YiKangServiceConfige();
		getMessageUnreadNumberByUserId.setServiceName("messageService");
		getMessageUnreadNumberByUserId.setMethodName("getMessageUnreadNumberByUserId");
		getMessageUnreadNumberByUserId.setIsFileter(true);
		mathodServiceConfig.put("00-35-04", getMessageUnreadNumberByUserId);
		
		/**
		 * @author houyt
		 * @serialData 2016/09/13 10:28
		 * @param paramMap
		 * @desc 通过用户标识和未读标识标记所有未读消息状态为已读
		 * @return
		 */
		YiKangServiceConfige setAllMessageAsRead = new YiKangServiceConfige();
		setAllMessageAsRead.setServiceName("messageService");
		setAllMessageAsRead.setMethodName("setAllMessageAsRead");
		setAllMessageAsRead.setIsFileter(false);
		mathodServiceConfig.put("00-35-05", setAllMessageAsRead);
		
		
		/**
		 * @author houyt
		 * @serialData 2016/09/21 10:28
		 * @param paramMap
		 * @desc 获取系统消息（分页）
		 * @return
		 */
		YiKangServiceConfige getSystemMessageByUserIdPage = new YiKangServiceConfige();
		getSystemMessageByUserIdPage.setServiceName("messageService");
		getSystemMessageByUserIdPage.setMethodName("getSystemMessageByUserIdPage");
		getSystemMessageByUserIdPage.setIsFileter(true);
		mathodServiceConfig.put("00-35-07", getSystemMessageByUserIdPage);
		
				
		
		
		//用户标签管理
		
		//添加关注的标签
		YiKangServiceConfige addUserTaglibMap=new YiKangServiceConfige();
		addUserTaglibMap.setServiceName("userTaglibMapService");
		addUserTaglibMap.setMethodName("addUserTaglibMap");
		addUserTaglibMap.setIsFileter(true);
		mathodServiceConfig.put("00-36-01",addUserTaglibMap);
		
		//删除关注的标签
		YiKangServiceConfige deleteUserTaglibMap=new YiKangServiceConfige();
		deleteUserTaglibMap.setServiceName("userTaglibMapService");
		deleteUserTaglibMap.setMethodName("deleteUserTaglibMap");
		deleteUserTaglibMap.setIsFileter(true);
		mathodServiceConfig.put("00-36-02",deleteUserTaglibMap);
		
		//查询我所有关注的标签
		YiKangServiceConfige getUserMyFollowTaglibByUserId=new YiKangServiceConfige();
		getUserMyFollowTaglibByUserId.setServiceName("userTaglibMapService");
		getUserMyFollowTaglibByUserId.setMethodName("getUserMyFollowTaglibByUserId");
		getUserMyFollowTaglibByUserId.setIsFileter(true);
		mathodServiceConfig.put("00-36-03",getUserMyFollowTaglibByUserId);
		
		//查询某个用户关注的标签
		YiKangServiceConfige getUserMyFollowTaglibByServerUserId=new YiKangServiceConfige();
		getUserMyFollowTaglibByServerUserId.setServiceName("userTaglibMapService");
		getUserMyFollowTaglibByServerUserId.setMethodName("getUserMyFollowTaglibByServerUserId");
		getUserMyFollowTaglibByServerUserId.setIsFileter(false);
		mathodServiceConfig.put("00-36-04",getUserMyFollowTaglibByServerUserId);
		
		//用户收藏
		
		//获取我的收藏的文章列表
		YiKangServiceConfige getStoreupsByUserId=new YiKangServiceConfige();
		getStoreupsByUserId.setServiceName("storeupService");
		getStoreupsByUserId.setMethodName("getStoreupsByUserId");
		getStoreupsByUserId.setIsFileter(true);
		mathodServiceConfig.put("00-37-01",getStoreupsByUserId);
		
		YiKangServiceConfige deleteStoreups=new YiKangServiceConfige();
		deleteStoreups.setServiceName("storeupService");
		deleteStoreups.setMethodName("deleteStoreups");
		deleteStoreups.setIsFileter(true);
		mathodServiceConfig.put("00-37-02",deleteStoreups);
		
		YiKangServiceConfige addFourmpostStoreup=new YiKangServiceConfige();
		addFourmpostStoreup.setServiceName("storeupService");
		addFourmpostStoreup.setMethodName("addFourmpostStoreup");
		addFourmpostStoreup.setIsFileter(true);
		mathodServiceConfig.put("00-37-03",addFourmpostStoreup);
		
		
		//人员收藏
		
		
		//添加关注人员
		YiKangServiceConfige addFolloUser=new YiKangServiceConfige();
		addFolloUser.setServiceName("followUserMapService");
		addFolloUser.setMethodName("addFolloUser");
		addFolloUser.setIsFileter(true);
		mathodServiceConfig.put("00-38-01",addFolloUser);
		
		//获取关注用户
		YiKangServiceConfige getMyFollowUseByUserId=new YiKangServiceConfige();
		getMyFollowUseByUserId.setServiceName("followUserMapService");
		getMyFollowUseByUserId.setMethodName("getMyFollowUseByUserId");
		getMyFollowUseByUserId.setIsFileter(true);
		mathodServiceConfig.put("00-38-02",getMyFollowUseByUserId);
		
		//删除关注用户
		YiKangServiceConfige deleteMyFollowUser=new YiKangServiceConfige();
		deleteMyFollowUser.setServiceName("followUserMapService");
		deleteMyFollowUser.setMethodName("deleteMyFollowUser");
		deleteMyFollowUser.setIsFileter(true);
		mathodServiceConfig.put("00-38-03",deleteMyFollowUser);
		
		
		//获取某一个服务人员关注的用户
		YiKangServiceConfige getFollowUseByServerUserId=new YiKangServiceConfige();
		getFollowUseByServerUserId.setServiceName("followUserMapService");
		getFollowUseByServerUserId.setMethodName("getFollowUseByServerUserId");
		getFollowUseByServerUserId.setIsFileter(true);
		mathodServiceConfig.put("00-38-04",getFollowUseByServerUserId);
		
		
		 
		/**
		 * @author liushuaic
		 * @date 2016-06-29 10:35
		 * @desc 获取某个用户的所有回复
		 * */
		YiKangServiceConfige getQuestionAnswerByCreateUserId=new YiKangServiceConfige();
		getQuestionAnswerByCreateUserId.setServiceName("questionAnswerService");
		getQuestionAnswerByCreateUserId.setMethodName("getQuestionAnswerByCreateUserId");
		getQuestionAnswerByCreateUserId.setIsFileter(true);
		mathodServiceConfig.put("00-39-01",getQuestionAnswerByCreateUserId);
		
		/**
		 * @author liushuaic
		 * @date 2016-06-29 10:31
		 * @desc 获取问题回复详情
		 * **/
		YiKangServiceConfige getQuestionAnswerDetail=new YiKangServiceConfige();
		getQuestionAnswerDetail.setServiceName("questionAnswerService");
		getQuestionAnswerDetail.setMethodName("getQuestionAnswerDetail");
		getQuestionAnswerDetail.setIsFileter(false);
		mathodServiceConfig.put("00-39-02",getQuestionAnswerDetail);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-06-29 10:31
		 * @desc 获取某一个人回答
		 * **/
		YiKangServiceConfige getQuestionAnswerByServerUserId=new YiKangServiceConfige();
		getQuestionAnswerByServerUserId.setServiceName("questionAnswerService");
		getQuestionAnswerByServerUserId.setMethodName("getQuestionAnswerByServerUserId");
		getQuestionAnswerByServerUserId.setIsFileter(false);
		mathodServiceConfig.put("00-39-03",getQuestionAnswerByServerUserId);
		
		
		
		// 获取番号
		YiKangServiceConfige getDesignations=new YiKangServiceConfige();
		getDesignations.setServiceName("designationService");
		getDesignations.setMethodName("getDesignations");
		getDesignations.setIsFileter(false);
		mathodServiceConfig.put("00-40-01", getDesignations);
		
		// 获取推荐用户列表
		YiKangServiceConfige queryRecommedUserInfo=new YiKangServiceConfige();
		queryRecommedUserInfo.setServiceName("recommendDataService");
		queryRecommedUserInfo.setMethodName("queryRecommedUserInfo");
		queryRecommedUserInfo.setIsFileter(false);
		mathodServiceConfig.put("00-41-01", queryRecommedUserInfo);
		
		YiKangServiceConfige queryRecommendTaglibsInfo=new YiKangServiceConfige();
		queryRecommendTaglibsInfo.setServiceName("recommendDataService");
		queryRecommendTaglibsInfo.setMethodName("queryRecommendTaglibsInfo");
		queryRecommendTaglibsInfo.setIsFileter(false);
		mathodServiceConfig.put("00-41-02", queryRecommendTaglibsInfo);
		
		
		YiKangServiceConfige insertFeedbackData=new YiKangServiceConfige();
		insertFeedbackData.setServiceName("feedbackInfoService");
		insertFeedbackData.setMethodName("insertFeedbackData");
		insertFeedbackData.setIsFileter(true);
		mathodServiceConfig.put("00-42-01", insertFeedbackData);
		
		
		//修改文章的所属用户
		YiKangServiceConfige updateForumPostTxtEditorOwnUserIdByUniqueCode=new YiKangServiceConfige();
		updateForumPostTxtEditorOwnUserIdByUniqueCode.setServiceName("forumPostTextEditorService");
		updateForumPostTxtEditorOwnUserIdByUniqueCode.setMethodName("updateForumPostTxtEditorOwnUserIdByUniqueCode");
		updateForumPostTxtEditorOwnUserIdByUniqueCode.setIsFileter(true);
		mathodServiceConfig.put("00-43-01", updateForumPostTxtEditorOwnUserIdByUniqueCode);
		
		/**
		 * @author liushuaic
		 * @date 2016-07-22 14:26
		 * @desc 查询某一个唯一码下的
		 * **/
		YiKangServiceConfige getForumPostTextByUniqueCode=new YiKangServiceConfige();
		getForumPostTextByUniqueCode.setServiceName("forumPostTextEditorService");
		getForumPostTextByUniqueCode.setMethodName("getForumPostTextByUniqueCode");
		getForumPostTextByUniqueCode.setIsFileter(true);
		mathodServiceConfig.put("00-43-02", getForumPostTextByUniqueCode);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-09-20 19:09
		 * @desc 获取某一类型手机下的最新版本号
		 * **/
		YiKangServiceConfige getUpdateVersionById = new YiKangServiceConfige();
		getUpdateVersionById.setServiceName("updateVersionService");
		getUpdateVersionById.setMethodName("selectUpdateVersionById");
		getUpdateVersionById.setIsFileter(false);
		mathodServiceConfig.put("00-44-01", getUpdateVersionById);
		
		YiKangServiceConfige addQuestionAnswersCommentDetail = new YiKangServiceConfige();
		addQuestionAnswersCommentDetail.setServiceName("questionAnswerComent");
		addQuestionAnswersCommentDetail.setMethodName("addQuestionAnswersCommentDetail");
		addQuestionAnswersCommentDetail.setIsFileter(true);
		mathodServiceConfig.put("00-45-01", addQuestionAnswersCommentDetail);
		
		YiKangServiceConfige getQuestionAnswersCommentDetail = new YiKangServiceConfige();
		getQuestionAnswersCommentDetail.setServiceName("questionAnswerComent");
		getQuestionAnswersCommentDetail.setMethodName("getQuestionAnswersCommentDetail");
		getQuestionAnswersCommentDetail.setIsFileter(false);
		mathodServiceConfig.put("00-45-02", getQuestionAnswersCommentDetail);
		
		/**
		 * 
		 * @author liushuaic
		 * @date 2016-09-28 15:52
		 * @desc 获取文章帖子回复列表
		 * 00-46
		 * */
		YiKangServiceConfige getForumPostAnswerList=new YiKangServiceConfige();
		getForumPostAnswerList.setServiceName("forumPostAnswerService");
		getForumPostAnswerList.setMethodName("getForumPostsAnswerList");
		getForumPostAnswerList.setIsFileter(false);
		mathodServiceConfig.put("00-46-01", getForumPostAnswerList);
		
	}
	
	
	
	public void loadConfigInterface(String filePath){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
			SAXParser saxParser = factory.newSAXParser();
	        InputStream is = InterfaceUtil.class.getClassLoader().getResourceAsStream("student.xml");
	        //saxParser.parse(is);
	        // TODO 后期添加本功能
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	/**
	 * @author liushuaic
	 * @date 2015/11/26 11:06
	 * 获取method config
	 * 
	 * **/
	public static YiKangServiceConfige getMethodYikangServiceConfigByServiceCode(String serviceCode){
		return mathodServiceConfig.get(serviceCode);
	}
	
	
}
