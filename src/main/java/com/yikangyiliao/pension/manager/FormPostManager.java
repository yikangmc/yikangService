package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.base.utils.UrlGenerateUtil;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessageQueue;
import com.yikangyiliao.pension.dao.FormPostsDao;
import com.yikangyiliao.pension.dao.FormPostsStarListDao;
import com.yikangyiliao.pension.dao.FormPostsTaglibsMapDao;
import com.yikangyiliao.pension.dao.ForumPostsAnswerDao;
import com.yikangyiliao.pension.entity.FormPosts;
import com.yikangyiliao.pension.entity.FormPostsStarList;
import com.yikangyiliao.pension.entity.FormPostsTaglibsMap;
import com.yikangyiliao.pension.entity.ForumPostsImage;
import com.yikangyiliao.pension.entity.UserServiceInfo;

@Component
public class FormPostManager {

	@Autowired
	private FormPostsDao formPostsDao;

	@Autowired
	private FormPostsTaglibsMapDao formPostsTaglibsMapDao;

	@Autowired
	private ForumPostsAnswerDao forumPostsAnswerDao;

	@Autowired
	private FormPostsStarListDao formPostsStarListDao;

	@Autowired
	private ForumPostsImageManager forumPostsImageManager;
	
	@Autowired
	private  UserManager userManager;

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
	 * @desc 发布项目
	 **/
	public void insertPublishFormPosts(String title, String content, Long[] taglibIds, Long userId, String[] images) {

		UserServiceInfo userServiceInfo=userManager.getUserServiceInfoByUserIdTwo(userId);
		
		Byte userPosition=userServiceInfo.getUserPosition();
		Date currentDate = Calendar.getInstance().getTime();

		FormPosts formPosts = new FormPosts();

		formPosts.setTitle(title);
		formPosts.setContent(content);
		formPosts.setCreateUserId(userId);
		formPosts.setIsEssence(Byte.valueOf("0"));
		if (images.length > 0) {
			formPosts.setRecommendPicUrl(images[0]);
		} else {
			formPosts.setRecommendPicUrl("");
		}
		formPosts.setAnswersNums(0);
		formPosts.setCreateTime(currentDate);
		formPosts.setUpdateTime(currentDate);
		formPosts.setShareUrl(UrlGenerateUtil.generateShareForumPostUrl());
		formPosts.setShareNum(0);
		formPosts.setStars(0);
		formPosts.setReportComplaintsStatus(Byte.valueOf("0"));
		if(null !=userPosition && userPosition>0){
			formPosts.setForumPostGroup(Byte.valueOf("1"));
		}else{
			formPosts.setForumPostGroup(Byte.valueOf("0"));
		}
		formPostsDao.insertSelective(formPosts);

		// 添加标签
		for (Long tagLibId : taglibIds) {

			FormPostsTaglibsMap fptm = new FormPostsTaglibsMap();
			fptm.setCreateTime(currentDate);
			fptm.setUpdateTime(currentDate);
			fptm.setTagLibsId(tagLibId);
			fptm.setFormPostId(formPosts.getForumPostId());
			formPostsTaglibsMapDao.insertSelective(fptm);
		}
		// 添加图片
		for (String img : images) {
			ForumPostsImage forumPostsImage = new ForumPostsImage();
			forumPostsImage.setCreateTime(currentDate);
			forumPostsImage.setForumPostsId(formPosts.getForumPostId());
			forumPostsImage.setImageUrl(img);
			forumPostsImageManager.insertSelective(forumPostsImage);
		}
		
		try{
			OperationMessage operationMessage=new OperationMessage();
			operationMessage.setContent(formPosts.getForumPostId().toString());
			operationMessage.setContentType("1");
			OperationMessageQueue.putMessage(operationMessage);
		}catch(Exception e){
			e.printStackTrace();
		}

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
	public void updateForumPostStar(Long forumPostId, Long userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("forumPostId", forumPostId);
		paramMap.put("userId", userId);
		FormPostsStarList fps = formPostsStarListDao.selectForumPostStartListByCreateUserIdAndForumPostsId(paramMap);
		if (null == fps) {
			this.updateForumPostsStarUp(forumPostId, userId);
			try{
				OperationMessage operationMessage=new OperationMessage();
				operationMessage.setContent(forumPostId.toString());
				operationMessage.setContentType("1");
				OperationMessageQueue.putMessage(operationMessage);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else {
			this.updateForumPostsDown(forumPostId, userId);
		}
		
	}

	/**
	 * @author liushuaic
	 * @date 2016-05-12 18:07 查询某一个标签一的文章
	 * TODO 添加缓存，把经常用到的数据添加入redis
	 *      在次调用时，进行判断缓存是否已经保存
	 */
	public List<FormPosts> getForumPostsByTaglibsId(Long taglibId,Long userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("taglibId", taglibId);
		paramMap.put("userId", userId);
		return formPostsDao.getForumPostsByTaglibsId(paramMap);
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
	 * @date 2016-06-07 10:52
	 * @desc 获取某一个用户创建的文章列表
	 * */
	public List<FormPosts> geForumPostsByCreateUserId(Long userId){
		return formPostsDao.geForumPostsByCreateUserId(userId);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-13 19:35 获取文章详情
	 * */
	public FormPosts selectByPrimaryKey(Long forumPostId){
		return formPostsDao.selectByPrimaryKey(forumPostId);
	}
}
