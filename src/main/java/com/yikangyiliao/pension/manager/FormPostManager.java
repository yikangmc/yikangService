package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.base.utils.UrlGenerateUtil;
import com.yikangyiliao.pension.common.page.PageParameter;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessageQueue;
import com.yikangyiliao.pension.dao.FormPostsDao;
import com.yikangyiliao.pension.dao.FormPostsStarListDao;
import com.yikangyiliao.pension.dao.FormPostsTaglibsMapDao;
import com.yikangyiliao.pension.dao.ForumPostDetailDao;
import com.yikangyiliao.pension.dao.JobDao;
import com.yikangyiliao.pension.dao.TaglibDao;
import com.yikangyiliao.pension.entity.FormPosts;
import com.yikangyiliao.pension.entity.FormPostsStarList;
import com.yikangyiliao.pension.entity.FormPostsTaglibsMap;
import com.yikangyiliao.pension.entity.ForumPostDetail;
import com.yikangyiliao.pension.entity.ForumPostsImage;
import com.yikangyiliao.pension.entity.Job;
import com.yikangyiliao.pension.entity.Taglib;
import com.yikangyiliao.pension.entity.UserServiceInfo;

@Component
public class FormPostManager {

	@Autowired
	private FormPostsDao formPostsDao;

	@Autowired
	private FormPostsTaglibsMapDao formPostsTaglibsMapDao;

	@Autowired
	private FormPostsStarListDao formPostsStarListDao;

	@Autowired
	private ForumPostsImageManager forumPostsImageManager;
	
	@Autowired
	private ForumPostDetailDao forumPostDetailDao;
	
	@Autowired
	private TaglibDao taglibDao;
	
	@Autowired
	private JobDao jobDao;

	@Autowired
	private IntegralManager integralManager;
	
	private Logger logger=LoggerFactory.getLogger(FormPostManager.class);
	
	/**
	 * @author liushuaic
	 * @date 2016-04-27 11:11
	 * @desc 获取推荐文章
	 **/
	public List<FormPosts> getIsEssence(Long userId) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("userId", userId);
		return formPostsDao.getIsEssence(paramMap);
	}

	/**
	 * @author liushuaic
	 * @date 2016-04-27 16:48
	 * @desc 发布帖子
	 **/
	public FormPosts insertPublishFormPosts(String title, String content, Long[] taglibIds, Long userId, String[] images) {

		//UserServiceInfo userServiceInfo=userManager.getUserServiceInfoByUserIdTwo(userId);
		logger.info("添加帖子"+"用户id:"+userId+" 标题："+title);
		
		Date currentDate = Calendar.getInstance().getTime();

		FormPosts formPosts = new FormPosts();

		formPosts.setTitle(title);
		formPosts.setContent(content.length()>100?content.substring(0,100):content);
		formPosts.setCreateUserId(userId);
		formPosts.setIsEssence(Byte.valueOf("0"));
		if (null != images && images.length > 0) {
			formPosts.setRecommendPicUrl(images[0]);
		} else {
			formPosts.setRecommendPicUrl("");
		}
		formPosts.setAnswersNums(0);
		formPosts.setCreateTime(currentDate);
		formPosts.setUpdateTime(currentDate);
		
		String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		formPosts.setForumPostsUuid(uuid); //设置文件唯一标识
		formPosts.setShareUrl(UrlGenerateUtil.generateShareForumPostUrl(uuid)); //设置文章分享连接
		
		formPosts.setShareNum(0);
		formPosts.setStars(0);
		formPosts.setReportComplaintsStatus(Byte.valueOf("0"));
		formPosts.setForumPostGroup(Byte.valueOf("0"));
		
		formPostsDao.insertSelective(formPosts);
		
		ForumPostDetail forumPostDetail=new ForumPostDetail();
		forumPostDetail.setForumPostDetailContent(content);
		forumPostDetail.setForumPostHtmlDetailContent("");
		forumPostDetail.setForumPostId(formPosts.getForumPostId());
		forumPostDetail.setCreateTime(currentDate);
		forumPostDetail.setUpdateTime(currentDate);
		forumPostDetailDao.insertSelective(forumPostDetail);
		// 添加标签
		for (Long tagLibId : taglibIds) {

			FormPostsTaglibsMap fptm = new FormPostsTaglibsMap();
			fptm.setCreateTime(currentDate);
			fptm.setUpdateTime(currentDate);
			fptm.setTagLibsId(tagLibId);
			fptm.setFormPostId(formPosts.getForumPostId());
			formPostsTaglibsMapDao.insertSelective(fptm);
			//标签下的帖子数量加1
			taglibDao.updateForumPostsTZNumberAddByTaglibId(tagLibId);
			Taglib taglib=new Taglib();
			taglib.setTaglibId(tagLibId);
			taglib.setForumPostsTzUpdateTime(currentDate);//修改帖子更新时间
			taglibDao.updateByPrimaryKeySelective(taglib);
		}
		// 添加图片
		for (String img : images) {
			ForumPostsImage forumPostsImage = new ForumPostsImage();
			forumPostsImage.setCreateTime(currentDate);
			forumPostsImage.setForumPostsId(formPosts.getForumPostId());
			forumPostsImage.setImageUrl(img);
			forumPostsImageManager.insertSelective(forumPostsImage);
		}
		
		integralManager.insertIntegralAddScoreIsONCEJob("CSFT", Long.valueOf(userId));
		integralManager.insertIntegralAddScoreIsUsualJob("FGTZ", Byte.valueOf("2"), Long.valueOf(userId));
		
		return formPosts;
		
	}


	/**
	 * @author liushuaic
	 * @date 2016-06-22 11:38
	 * @desc 发布专业内容
	 **/
	public FormPosts insertPerformencePublishForumPosts(String title, String forumPostDetailContent,String forumPostHtmlDetailContent ,Long[] taglibIds, Long userId, String[] images,String recommendPicUrl) {

		//UserServiceInfo userServiceInfo=userManager.getUserServiceInfoByUserIdTwo(userId);

		Date currentDate = Calendar.getInstance().getTime();

		FormPosts formPosts = new FormPosts();

		formPosts.setTitle(title);
		formPosts.setContent(forumPostDetailContent.length()>100?forumPostDetailContent.substring(0,100):forumPostDetailContent);
		formPosts.setCreateUserId(userId);
		formPosts.setIsEssence(Byte.valueOf("0"));
		formPosts.setRecommendPicUrl(recommendPicUrl);
		formPosts.setAnswersNums(0);
		formPosts.setCreateTime(currentDate);
		formPosts.setUpdateTime(currentDate);
		
		
		String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		formPosts.setForumPostsUuid(uuid);
		formPosts.setShareUrl(UrlGenerateUtil.generateShareForumPostUrl(uuid));
		
		formPosts.setShareNum(0);
		formPosts.setStars(0);
		formPosts.setReportComplaintsStatus(Byte.valueOf("0"));
		formPosts.setForumPostGroup(Byte.valueOf("1"));
		formPostsDao.insertSelective(formPosts);
		
		ForumPostDetail forumPostDetail=new ForumPostDetail();
		forumPostDetail.setForumPostDetailContent(forumPostDetailContent);
		forumPostDetail.setForumPostHtmlDetailContent(forumPostHtmlDetailContent);
		forumPostDetail.setCreateTime(currentDate);
		forumPostDetail.setUpdateTime(currentDate);
		forumPostDetail.setForumPostId(formPosts.getForumPostId());
		forumPostDetailDao.insertSelective(forumPostDetail);

		// 添加标签
		for (Long tagLibId : taglibIds) {

			FormPostsTaglibsMap fptm = new FormPostsTaglibsMap();
			fptm.setCreateTime(currentDate);
			fptm.setUpdateTime(currentDate);
			fptm.setTagLibsId(tagLibId);
			fptm.setFormPostId(formPosts.getForumPostId());
			formPostsTaglibsMapDao.insertSelective(fptm);
			
			
			//标签下的帖子数量加1
			taglibDao.updateForumPostsNumberAddByTaglibId(tagLibId);
			Taglib taglib=new Taglib();
			taglib.setTaglibId(tagLibId);
			taglib.setForumPostsUpdateTime(currentDate);//修改帖子更新时间
			taglibDao.updateByPrimaryKeySelective(taglib);
		}
		// 添加图片
		if(null != images && images.length>0){
			for (String img : images) {
				ForumPostsImage forumPostsImage = new ForumPostsImage();
				forumPostsImage.setCreateTime(currentDate);
				forumPostsImage.setForumPostsId(formPosts.getForumPostId());
				forumPostsImage.setImageUrl(img);
				forumPostsImageManager.insertSelective(forumPostsImage);
			}
		}
		
		return formPosts;
	}

	/**
	 * @author liushuaic
	 * @date 2016-04-27 18:32
	 * @desc 文章支持
	 */
	public void updateForumPostsStarUp(Long forumPostsId, Long userId) {

		Date currentDate = Calendar.getInstance().getTime();

		FormPostsStarList fpsl = new FormPostsStarList();
		fpsl.setCreateTime(currentDate);
		fpsl.setCreateUserId(userId);
		fpsl.setForumPostsId(forumPostsId);
		formPostsStarListDao.insertSelective(fpsl);
		formPostsDao.formPostsStarsUpByForumPostId(forumPostsId);
	}

	/**
	 * @author liushuaic
	 * @date 2016-05r-06 11:23 支持-1
	 **/
	public void updateForumPostsDown(Long forumPostsId, Long userId) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("forumPostId", forumPostsId);
		paramMap.put("userId", userId);
		formPostsStarListDao.deleteForumPostStartList(paramMap);
		formPostsDao.formPostsStarsDownByForumPostId(forumPostsId);

	}

	/**
	 * @author liushuaic
	 * @date 2016-04-27 16:39
	 * @desc 获取某一个文章的详情
	 * 
	 */
	public FormPosts getForumPostsDetail(Long forumPostId,Long userId) {
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("forumPostId", forumPostId);
		paramData.put("userId", userId);
		return formPostsDao.getFormPoustsDetailByForumPostId(paramData);
	}

	/**
	 * @author liushuaic
	 * @date 2016-05-05 17:53 文章支持+1
	 */
	public void updateFormPostsStarsUpByForumPostId(Long forumPostId) {
		formPostsDao.formPostsStarsUpByForumPostId(forumPostId);
	}

	/**
	 * @author liushuaic
	 * @date 2016-05-05 17:53 文章支持-1
	 */
	public void updateFormPostsStarsDownByForumPostId(Long forumPostId) {
		formPostsDao.formPostsStarsDownByForumPostId(forumPostId);
	}

	/**
	 * @author liushuaic
	 * @date 2016-05-05 19:08 删除我的支持
	 */
	public int deleteForumPostStartList(Long forumPostId, Long userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("forumPostId", forumPostId);
		paramMap.put("userId", userId);
		return formPostsStarListDao.deleteForumPostStartList(paramMap);
	}

	/**
	 * @author liushuaic
	 * @date 2016-05-06 11:50
	 * @desc 修改文章支持
	 **/
	public int updateForumPostStar(Long forumPostId, Long userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("forumPostId", forumPostId);
		paramMap.put("userId", userId);
		FormPostsStarList fps = formPostsStarListDao.selectForumPostStartListByCreateUserIdAndForumPostsId(paramMap);
		if (null == fps) {
			this.updateForumPostsStarUp(forumPostId, userId);
			return 1;
		} else {
			this.updateForumPostsDown(forumPostId, userId);
		}
		return 0;
	}

	/**
	 * @author liushuaic
	 * @date 2016-05-12 18:07 查询某一个标签一的文章
	 * TODO 添加缓存，把经常用到的数据添加入redis
	 *      在次调用时，进行判断缓存是否已经保存
	 */
	public List<FormPosts> getForumPostsByTaglibsId(Long taglibId,Long userId,PageParameter page) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("taglibId", taglibId);
		paramMap.put("userId", userId);
		paramMap.put("forumPostGroup", 0);
		paramMap.put("page", page);
		return formPostsDao.getForumPostsByTaglibsIdPage(paramMap);
	}

	/**
	 * @author liushuaic
	 * @date 2016-05-12 18:07 查询某一个标签一的文章
	 * TODO 添加缓存，把经常用到的数据添加入redis
	 *      在次调用时，进行判断缓存是否已经保存
	 */
	public List<FormPosts> getPerformenceForumPostsByTaglibsId(Long taglibId,Long userId,PageParameter page) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("taglibId", taglibId);
		paramMap.put("userId", userId);
		paramMap.put("forumPostGroup", 1);
		paramMap.put("page",page);
		paramMap.put("statusData", 3);
		return formPostsDao.getForumPostsByTaglibsIdPage(paramMap);
	}

	/**
     * @author liushuaic
     * @date 2016-06-06 19:18
     * @desc 获取最热帖子
     * **/
	public List<FormPosts> getHotForumPosts(){
		return formPostsDao.getHotForumPosts();
	}
	
	
    /**
     * @author liushuaic
     * @date 2016-09-07 10:41
     * @desc 获取最热帖子分页
     * **/
    public List<FormPosts> getHotForumPostsPage(PageParameter page){
    		Map<String,Object> paramMap=new HashMap<String,Object>();
    		paramMap.put("page", page);
    		return formPostsDao.getHotForumPostsPage(paramMap);
    }
	
	/**
	 * @author liushuaic
	 * @date 2016-06-07 10:52
	 * @desc 获取某一个用户创建的帖子列表
	 * */
	public List<FormPosts> geTZForumPostsByCreateUserId(Long userId){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("createUserId", userId);
		paramMap.put("forumPostGroup", 0);
		return formPostsDao.geForumPostsByCreateUserIdAndForumPostGroup(paramMap);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-06-07 10:52
	 * @desc 获取某一个用户创建的帖子列表
	 * */
	public List<FormPosts> geTZForumPostsByCreateUserIdPage(Long userId,PageParameter page){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("createUserId", userId);
		paramMap.put("forumPostGroup", 0);
		paramMap.put("page", page);
		return formPostsDao.geForumPostsByCreateUserIdAndForumPostGroupPage(paramMap);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-07 10:52
	 * @desc 获取某一个用户创建的文章列表
	 * */
	public List<FormPosts> geWZForumPostsByCreateUserId(Long userId){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("createUserId", userId);
		paramMap.put("forumPostGroup", 1);
		return formPostsDao.geForumPostsByCreateUserIdAndForumPostGroup(paramMap);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-07 10:52
	 * @desc 获取某一个用户创建的文章列表
	 * */
	public List<FormPosts> geWZForumPostsByCreateUserIdPage(Long userId,PageParameter page){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("createUserId", userId);
		paramMap.put("forumPostGroup", 1);
		paramMap.put("page", page);
		return formPostsDao.geForumPostsByCreateUserIdAndForumPostGroupPage(paramMap);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-13 19:35 获取文章详情
	 * */
	public FormPosts selectByPrimaryKey(Long forumPostId){
		return formPostsDao.selectByPrimaryKey(forumPostId);
	}
	
	public UserServiceInfo getUserServiceInfoByForumPostId(Long forumPostId){
		return null;
	}
	
	public List<FormPosts> getFormPostsALL(){
		return formPostsDao.getFormPostsAll();
	}
	
}
