package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.FormPostsDao;
import com.yikangyiliao.pension.dao.FormPostsStarListDao;
import com.yikangyiliao.pension.dao.FormPostsTaglibsMapDao;
import com.yikangyiliao.pension.dao.ForumPostsAnswerDao;
import com.yikangyiliao.pension.entity.FormPosts;
import com.yikangyiliao.pension.entity.FormPostsStarList;
import com.yikangyiliao.pension.entity.FormPostsTaglibsMap;
import com.yikangyiliao.pension.entity.ForumPostsImage;

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

	/**
	 * @author liushuaic
	 * @date 2016-04-27 11:11
	 * @desc 获取推荐文章
	 **/
	public List<FormPosts> getIsEssence() {
		return formPostsDao.getIsEssence();
	}

	/**
	 * @author liushuaic
	 * @date 2016-04-27 16:48
	 * @desc 发布项目
	 **/
	public void insertPublishFormPosts(String title, String content, Long[] taglibIds, Long userId, String[] images) {

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
		formPosts.setShareUrl("");
		formPosts.setShareNum(0);
		formPosts.setStars(0);
		formPosts.setReportComplaintsStatus(Byte.valueOf("0"));

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
		paramMap.put("forumPostsId", forumPostsId);
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
	public FormPosts getForumPostsDetail(Long forumPostId) {
		return formPostsDao.getFormPoustsDetailByForumPostId(forumPostId);
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
		} else {
			this.updateForumPostsDown(forumPostId, userId);
		}
		formPostsStarListDao.deleteForumPostStartList(paramMap);
	}

	/**
	 * @author liushuaic
	 * @date 2016-05-12 18:07 查询某一个标签一的文章
	 * TODO 添加缓存，把经常用到的数据添加入redis
	 *      在次调用时，进行判断缓存是否已经保存
	 */
	public List<FormPosts> getForumPostsByTaglibsId(Long taglibId) {
		return formPostsDao.getForumPostsByTaglibsId(taglibId);
	}

}
