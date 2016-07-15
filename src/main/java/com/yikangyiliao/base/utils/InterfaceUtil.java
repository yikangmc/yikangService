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
	
	
	private static Map<String,String> serviceClassName=null;
	
	private static Map<String,String> mathodClassPath=null;
	
	private static Map<String,YiKangServiceConfige> mathodServiceConfig=null;
	
	static{
		serviceClassName=new HashMap<String,String>();
		mathodClassPath=new HashMap<String,String>();
		mathodServiceConfig=new HashMap<String,YiKangServiceConfige>();
		
		
		serviceClassName.put("0-0","test");
		mathodClassPath.put("0-0-1","test");
		
		/**
		 * 老人管理
		 * */
		serviceClassName.put("00-01", "seniorAccountService");
		/**
		 * 保存老人信息
		 * */
		mathodClassPath.put("00-01-01","saveSeniorAccount");
		/**
		 * @author liushuaic
		 * 获取某一个老人的信息
		 * */
		mathodClassPath.put("00-01-02","getSeniorAccountById");
		
		/**
		 * 查询某一个用户下的所有人
		 * */
		mathodClassPath.put("00-01-03","getSeniorAccountByUserId");
		
		/**
		 * @author liushuaic
		 * 查询邀请患者
		 * */
		mathodClassPath.put("00-01-04","getSeniorAccountInfoByInvitationUserId");
		
		
		
		/**
		 * @author liushuaic
		 * @date 2015/12/29  10:33
		 * @desc 获取某一个用户创建的患者
		 * 
		 * **/
		YiKangServiceConfige getSeniorAccountByClentUserId=new YiKangServiceConfige();
		getSeniorAccountByClentUserId.setServiceName("seniorAccountService");
		getSeniorAccountByClentUserId.setMethodName("getSeniorAccountByClentUserId");
		getSeniorAccountByClentUserId.setIsFileter(false);
		mathodServiceConfig.put("00-01-05",getSeniorAccountByClentUserId);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-03-18 15:48
		 * @desc 获取我邀请的用户
		 * */
		YiKangServiceConfige getMyInvitationUserByUserId=new YiKangServiceConfige();
		getMyInvitationUserByUserId.setServiceName("seniorAccountService");
		getMyInvitationUserByUserId.setMethodName("getMyinvitationUserByUserId");
		getMyInvitationUserByUserId.setIsFileter(true);
		mathodServiceConfig.put("00-01-06",getMyInvitationUserByUserId);
		
		
		
		//量表
		serviceClassName.put("00-02", "scaleService");
		//档案袋
		mathodClassPath.put("00-02-01", "saveAssessment");
		
		
		/**
		 * 生活护理评估
		 * */
		serviceClassName.put("00-03", "lifeNurseAssessmentService");
		mathodClassPath.put("00-03-01", "getQuestionCrosswiseByTableName");
		mathodClassPath.put("00-03-02", "getQuestionUnitAnswerMapByQuetionCrosswiseId");
		
		
		/**
		 * 数据保存
		 * */
		serviceClassName.put("00-04", "answerService");
		mathodClassPath.put("00-04-01", "saveAnswer");
		mathodClassPath.put("00-04-02", "saveAnswerForQuestion");
		
		/**
		 * 老年人跌倒风险评估
		 * */
		serviceClassName.put("00-05", "oldManTumbleService");
		mathodClassPath.put("00-05-01", "getTable");
		
		
		/**
		 * 疾病评估
		 * */
		serviceClassName.put("00-06", "sicknessAssessmentService");
		mathodClassPath.put("00-06-01", "getTable");
		
		/**
		 * 抑郁评估
		 * **/
		serviceClassName.put("00-07", "depressionAssessmentService");
		mathodClassPath.put("00-07-01", "getTable");
		
		
		/**
		 * 抑郁自测
		 * **/
		serviceClassName.put("00-08", "depressionSelfTestingService");
		mathodClassPath.put("00-08-01", "getTable");
		
		
		/**
		 * 老年人常见问题
		 * **/
		serviceClassName.put("00-09", "oldManCommonQuestionService");
		mathodClassPath.put("00-09-01", "getTable");
		
		
		/**
		 * 感知与沟通
		 * */ 
		serviceClassName.put("00-10", "pserceptionCommunicationsService");
		mathodClassPath.put("00-10-01", "getTable");
		
		/**
		 * 社会参与
		 * */
		serviceClassName.put("00-11", "socialParticipationService");
		mathodClassPath.put("00-11-01", "getTable");
		
		/**
		 * 日常生活
		 * */
		serviceClassName.put("00-12", "dailyIndexesService");
		mathodClassPath.put("00-12-01", "getTable");
		
		/**
		 * 精神状态
		 */
		serviceClassName.put("00-13", "mentalIndexesService");
		mathodClassPath.put("00-13-01", "getTable");
		
		/**
		 * 长谷川
		 * **/
		serviceClassName.put("00-14", "alzheimerDiseaseService");
		mathodClassPath.put("00-14-01", "getTable");
		
		
		/**
		 * 档案袋管理
		 * 
		 * */
		
		serviceClassName.put("00-15", "assessmentService");
		mathodClassPath.put("00-15-01", "saveAssessment");
		mathodClassPath.put("00-15-02", "getAssessmentBySeniorId");
		
		
		serviceClassName.put("login", "login");
		mathodClassPath.put("login", "login");
		
		/**
		 * @author liushuaic
		 * @date 2015/08/18 18:03
		 * 评估表管理
		 * */
		serviceClassName.put("00-16", "surveyTableService");
		mathodClassPath.put("00-16-01", "getTableList");
		mathodClassPath.put("00-16-02", "getQuestionsAndAnswersIsCheck");
		mathodClassPath.put("00-16-03", "getQuestionAndAnswersIsCheckTwo");
		mathodClassPath.put("00-16-04", "getQuestionAndAnswersIsCheckThree");
		
		
		/**
		 * @author liushuaic
		 * @date 2015/08/26 10:42
		 * 用户管理
		 * 
		 * **/
		
		serviceClassName.put("registerUser", "userService");
		YiKangServiceConfige registUser=new YiKangServiceConfige();
		registUser.setServiceName("userService");
		registUser.setMethodName("registerUser");
		registUser.setIsFileter(false);
		mathodServiceConfig.put("registerUser",registUser);
		
		serviceClassName.put("registerUserAndSaveServiceInfo", "userService");
		mathodClassPath.put("registerUserAndSaveServiceInfo", "saveRegisterUserAndSaveServiceInfo");
		
		serviceClassName.put("00-17", "userService");
		mathodClassPath.put("00-17-01", "registerUser");
		mathodClassPath.put("00-17-02", "saveServiceUserInfo");
		mathodClassPath.put("00-17-03", "registerUserAndSaveServiceInfo");
		// 获取某一个服务人员信息 
		mathodClassPath.put("00-17-04", "getUserServiceInfoByUserId");
		mathodClassPath.put("00-17-05", "updateUserServiceAndServiceInfo");
		
		
		
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
		getInvationUserByUserId.setServiceName("userService");
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
		getUserServiceInfoByServerUserId.setIsFileter(true);
		mathodServiceConfig.put("00-17-15",getUserServiceInfoByServerUserId);
		
		/**
		 * @author liushuaic
		 * @date 2015/09/01 14:19
		 * @desc 设备管理
		 * **/
		serviceClassName.put("00-18", "deviceService");
		//保存设备
		mathodClassPath.put("00-18-01", "saveDevice");
		//获取别名
		mathodClassPath.put("00-18-02", "getAliasByUser");
		
		
		/**
		 * 
		 * @author liushuaic
		 * @date 2015/09/18 11:58
		 * @desc 服务人员日程管理
		 * **/
		
		serviceClassName.put("00-19", "serviceScheduleService");
		mathodClassPath.put("00-19-01", "getScheduleListByMonth");
		mathodClassPath.put("00-19-02", "getServiceScheduleDetail");
		mathodClassPath.put("00-19-03", "insertServiceScheduleDetail");
		
		/**
		 * @author liushuaic
		 * @date 2015/10/10 17:23
		 * 预约日期查询
		 * **/
		serviceClassName.put("00-20", "timeQuantumService");
		mathodClassPath.put("00-20-01", "getTimeQuantumsForCustomer");
		
		
		
		/**
		 * @author liushuaic
		 * @date 2015/10/12 15:11
		 * 预约管理
		 * **/
		serviceClassName.put("00-21","appointmentOrderService");
		mathodClassPath.put("00-21-01", "addPointmentOrder");
		mathodClassPath.put("00-21-02", "getServiceUserByOrderId");
		mathodClassPath.put("00-21-03", "addPointmentOrderAndSubmitAssessment");
		// 查询我的工作日程
		mathodClassPath.put("00-21-04", "getServicerScheduleByServiceUserId");
		//查询我的工作日程详情
		mathodClassPath.put("00-21-05", "getOrderServiceDetailById");
		//保存反馈信息，设置订单服务完成
		mathodClassPath.put("00-21-06", "saveFeedback");
		
		
		
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
		serviceClassName.put("00-22","servicerService");
		mathodClassPath.put("00-22-01","getAssessmentService");
		
		
		
		serviceClassName.put("00-23","adeptService");
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
		serviceClassName.put("00-24","officeService");
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
		serviceClassName.put("00-25","captchaService");
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
		serviceClassName.put("00-26","banerService");
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
		
		
		
		
		serviceClassName.put("00-27","searchService");
		YiKangServiceConfige getTaglibsList=new YiKangServiceConfige();
		getTaglibsList.setServiceName("searchService");
		getTaglibsList.setMethodName("getTaglibList");
		getTaglibsList.setIsFileter(false);
		mathodServiceConfig.put("00-27-01",getTaglibsList);
		
		
		serviceClassName.put("00-28","forumPostService");
		YiKangServiceConfige getIsEssence=new YiKangServiceConfige();
		getIsEssence.setServiceName("forumPostService");
		getIsEssence.setMethodName("getIsEssence");
		getIsEssence.setIsFileter(false);
		mathodServiceConfig.put("00-28-01",getIsEssence);
		
		
		
		// 获取文章详情
		serviceClassName.put("00-28","forumPostService");
		YiKangServiceConfige getFourmPostDetail=new YiKangServiceConfige();
		getFourmPostDetail.setServiceName("forumPostService");
		getFourmPostDetail.setMethodName("getFourmPostDetail");
		getFourmPostDetail.setIsFileter(false);
		mathodServiceConfig.put("00-28-02",getFourmPostDetail);
		
		
		//定单支持
		YiKangServiceConfige updateForumPostStar=new YiKangServiceConfige();
		updateForumPostStar.setServiceName("forumPostService");
		updateForumPostStar.setMethodName("updateForumPostStar");
		updateForumPostStar.setIsFileter(true);
		mathodServiceConfig.put("00-28-03",updateForumPostStar);
		
		
		//发布文章
		YiKangServiceConfige publishForumPosts=new YiKangServiceConfige();
		publishForumPosts.setServiceName("forumPostService");
		publishForumPosts.setMethodName("insertPublishForumPosts");
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
		
		
		//获取某一个用户创建的所有文章
		YiKangServiceConfige geForumPostsByCreateUserId=new YiKangServiceConfige();
		geForumPostsByCreateUserId.setServiceName("forumPostService");
		geForumPostsByCreateUserId.setMethodName("geForumPostsByCreateUserId");
		geForumPostsByCreateUserId.setIsFileter(false);
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
		YiKangServiceConfige insertPerformencePublishForumPosts=new YiKangServiceConfige();
		insertPerformencePublishForumPosts.setServiceName("forumPostService");
		insertPerformencePublishForumPosts.setMethodName("insertPerformencePublishForumPosts");
		insertPerformencePublishForumPosts.setIsFileter(false);
		mathodServiceConfig.put("00-28-10",insertPerformencePublishForumPosts);
		
		
		//获取某一个用户创建的专业文章
		YiKangServiceConfige geWZForumPostsByCreateUserId=new YiKangServiceConfige();
		geWZForumPostsByCreateUserId.setServiceName("forumPostService");
		geWZForumPostsByCreateUserId.setMethodName("geWZForumPostsByCreateUserId");
		geWZForumPostsByCreateUserId.setIsFileter(true);
		mathodServiceConfig.put("00-28-11",geWZForumPostsByCreateUserId);
		
		//获取某一个用户的专业帖子
		YiKangServiceConfige geForumPostsByServerUserId=new YiKangServiceConfige();
		geForumPostsByServerUserId.setServiceName("forumPostService");
		geForumPostsByServerUserId.setMethodName("geForumPostsByServerUserId");
		geForumPostsByServerUserId.setIsFileter(true);
		mathodServiceConfig.put("00-28-12",geWZForumPostsByCreateUserId);


		
		
		//问题处理
		serviceClassName.put("00-29","questionService");
		YiKangServiceConfige insertQuestion=new YiKangServiceConfige();
		insertQuestion.setServiceName("questionService");
		insertQuestion.setMethodName("insertQuestion");
		insertQuestion.setIsFileter(true);
		mathodServiceConfig.put("00-29-01",insertQuestion);
		
		//更新问题支持状态
		YiKangServiceConfige updateQuestionStar=new YiKangServiceConfige();
		updateQuestionStar.setServiceName("questionService");
		updateQuestionStar.setMethodName("updateQuestionStar");
		updateQuestionStar.setIsFileter(true);
		mathodServiceConfig.put("00-29-02",updateQuestionStar);
		
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
		getQuestionByCreateUserId.setIsFileter(false);
		mathodServiceConfig.put("00-29-07",getQuestionByCreateUserId);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-12 15:03
		 * @desc 标签管理 热门标签
		 * ***/
		serviceClassName.put("00-30","taglibService");
		YiKangServiceConfige getRecommendTaglib=new YiKangServiceConfige();
		getRecommendTaglib.setServiceName("taglibService");
		getRecommendTaglib.setMethodName("getRecommendTaglib");
		getRecommendTaglib.setIsFileter(false);
		mathodServiceConfig.put("00-30-01",getRecommendTaglib);
		
		
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
		 * @date 2016-05-12 15:03
		 * @desc 活动管理
		 **/
		serviceClassName.put("00-31","activetyService");
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
		getActivetyByActivetyId.setIsFileter(true);
		mathodServiceConfig.put("00-31-02",getActivetyByActivetyId);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-23 15:52
		 * @desc 添加活动
		 * **/
		YiKangServiceConfige insertActivety=new YiKangServiceConfige();
		insertActivety.setServiceName("activetyService");
		insertActivety.setMethodName("insertActivety");
		insertActivety.setIsFileter(false);
		mathodServiceConfig.put("00-31-03",insertActivety);
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-23 15:56
		 * @desc 参与活动
		 * **/
		YiKangServiceConfige insertMyAcitivety=new YiKangServiceConfige();
		insertMyAcitivety.setServiceName("activetyService");
		insertMyAcitivety.setMethodName("insertMyAcitivety");
		insertMyAcitivety.setIsFileter(false);
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
		insertActivetyComment.setIsFileter(false);
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
		getActiveyByJoinUserId.setIsFileter(false);
		mathodServiceConfig.put("00-31-07",getActiveyByJoinUserId);
		
		
		
		
		/**
		 * @author liushuaic
		 * @date 2016-05-17 14:55
		 * @desc 获取用户的配置信息
		 * */
		serviceClassName.put("00-32","userConfigrationService");
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
		serviceClassName.put("00-35", "messageService");
		
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
		
		//用户标签管理
		serviceClassName.put("00-36", "userTaglibMapService");
		
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
		getUserMyFollowTaglibByServerUserId.setIsFileter(true);
		mathodServiceConfig.put("00-36-04",getUserMyFollowTaglibByServerUserId);
		
		//用户收藏
		serviceClassName.put("00-37", "storeupService");
		
		//获取收藏的文章列表
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
		serviceClassName.put("00-38", "followUserMapService");
		
		
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
		
		
		
		serviceClassName.put("00-39", "questionAnswerService");
		
		
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
		getQuestionAnswerDetail.setIsFileter(true);
		mathodServiceConfig.put("00-39-02",getQuestionAnswerDetail);
		
		
		
		serviceClassName.put("00-40", "designationService");
		
		YiKangServiceConfige getDesignations=new YiKangServiceConfige();
		getDesignations.setServiceName("designationService");
		getDesignations.setMethodName("getDesignations");
		getDesignations.setIsFileter(true);
		mathodServiceConfig.put("00-40-01", getDesignations);
		
		serviceClassName.put("00-41", "recommendDataService");
		
		YiKangServiceConfige queryRecommedUserInfo=new YiKangServiceConfige();
		queryRecommedUserInfo.setServiceName("recommendDataService");
		queryRecommedUserInfo.setMethodName("queryRecommedUserInfo");
		queryRecommedUserInfo.setIsFileter(true);
		mathodServiceConfig.put("00-41-01", queryRecommedUserInfo);
		
		YiKangServiceConfige queryRecommendTaglibsInfo=new YiKangServiceConfige();
		queryRecommendTaglibsInfo.setServiceName("recommendDataService");
		queryRecommendTaglibsInfo.setMethodName("queryRecommendTaglibsInfo");
		queryRecommendTaglibsInfo.setIsFileter(true);
		mathodServiceConfig.put("00-41-02", queryRecommendTaglibsInfo);
		
		serviceClassName.put("00-42", "feedbackInfoService");
		
		YiKangServiceConfige insertFeedbackData=new YiKangServiceConfige();
		insertFeedbackData.setServiceName("feedbackInfoService");
		insertFeedbackData.setMethodName("insertFeedbackData");
		insertFeedbackData.setIsFileter(false);
		mathodServiceConfig.put("00-42-01", insertFeedbackData);
		
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
	 *
	 *@author liushuaic
	 *@date 2015/07/24 15:33
	 *@desc 返回serviceName
	 *
	 ***/
	public static String getBeanNameByServiceCode(String serviceCode){
		if(serviceCode.indexOf('-')!=-1){
			serviceCode=serviceCode.substring(0,serviceCode.lastIndexOf('-'));
		}
		return serviceClassName.get(serviceCode);
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
	
	/***
	 *@author liushuaic
	 *@date 2015/07/24 15:32
	 *返回方法名称
	 * */
	public static String getMethodNameByServiceCode(String serviceCode){
		return mathodClassPath.get(serviceCode);
	}
	
	
	public static void main(String[] args) {
		String codeStr="00-02-01";
		System.out.println(codeStr.substring(0,codeStr.lastIndexOf('-')));
	}
	
	
}
