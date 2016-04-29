package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.FormPostsDao;
import com.yikangyiliao.pension.dao.FormPostsStarListDao;
import com.yikangyiliao.pension.dao.FormPostsTaglibsMapDao;
import com.yikangyiliao.pension.dao.ForumPostsAnswerDao;
import com.yikangyiliao.pension.entity.FormPosts;
import com.yikangyiliao.pension.entity.FormPostsStarList;
import com.yikangyiliao.pension.entity.FormPostsTaglibsMap;

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
	
    /**
     * @author liushuaic
     * @date 2016-04-27 11:11
     * @desc 获取推荐文章
     * **/
    public List<FormPosts> getIsEssence(){
    	return formPostsDao.getIsEssence();
    }
	
    
    
    /**
     * @author liushuaic
     * @date 2016-04-27 16:48
     * @desc 发布项目
     * **/
    public void insertPublishFormPosts(String content,Long[] taglibIds,Long userId){
    	
    	Date currentDate=Calendar.getInstance().getTime();
    	
    	FormPosts formPosts=new FormPosts();
    	
    	formPosts.setContent(content);
    	formPosts.setCreateUserId(userId);
    	formPosts.setIsEssence(Byte.valueOf("0"));
    	formPosts.setRecommendPicUrl("");
    	formPosts.setAnswersNums(0);
    	formPosts.setCreateTime(currentDate);
    	formPosts.setUpdateTime(currentDate);
    	formPosts.setShareUrl("");
    	formPosts.setStartNums(0);
    	formPosts.setShareNum(0);
    	formPosts.setReportComplaintsStatus(Byte.valueOf("0"));
    	
    	formPostsDao.insertSelective(formPosts);
    	
    	for(Long tagLibId:taglibIds){
    		
    		FormPostsTaglibsMap fptm=new FormPostsTaglibsMap();
    		fptm.setCreateTime(currentDate);
    		fptm.setUpdateTime(currentDate);
    		fptm.setTagLibsId(tagLibId);
    		fptm.setFormPostId(formPosts.getForumPostId());
    		formPostsTaglibsMapDao.insertSelective(fptm);
    	}
    	
    	
    }
    
    
	/**
	 * @author liushuaic
	 * @date 2016-04-27 18:32
	 * @desc 文章支持
	 * */
    public void forumPostsStar(Long forumPostsId,Long userId){
    	
    	Date currentDate=Calendar.getInstance().getTime();
    	
    	FormPostsStarList fpsl=new FormPostsStarList();
    	fpsl.setCreateTime(currentDate);
    	fpsl.setCreateUserId(userId);
    	fpsl.setForumPostsId(forumPostsId);
    	formPostsStarListDao.insert(fpsl);
    }
    
    /**
     * @author liushuaic
     * @date 2016-04-27 16:39
     * @desc 获取某一个文章的详情
     * 
     * */
    public FormPosts getForumPostsDetail(Long forumPostId){
    	
    	return formPostsDao.selectByPrimaryKey(forumPostId);    	
    	
    }
	
	
}
