package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.base.search.SearchUtil;
import com.yikangyiliao.base.utils.SystemProperties;
import com.yikangyiliao.pension.common.constants.YKConstants;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.page.PageParameter;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.common.utils.GenreateNumberUtils;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessageQueue;
import com.yikangyiliao.pension.entity.FormPosts;
import com.yikangyiliao.pension.entity.Taglib;
import com.yikangyiliao.pension.manager.FormPostManager;
import com.yikangyiliao.pension.manager.ForumPostTxtEditorManager;
import com.yikangyiliao.pension.manager.ForumPostsAnswerManager;
import com.yikangyiliao.pension.manager.IntegralManager;

@Service(value = "forumPostService")
public class ForumPostService {

	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private FormPostManager formPostManager;

	@Autowired
	private ForumPostsAnswerManager forumPostsAnswerManager;

	@Autowired
	private ForumPostTxtEditorManager forumPostTxtEditorManager;

	@Autowired
	private IntegralManager integralManager;

	/**
	 * @author liushuaic
	 * @date 2016-04-27 11:11
	 * @desc 获取推荐文章
	 **/
	public ResponseMessage<List<FormPosts>> getIsEssence(Map<String, Object> paramData) {

		ResponseMessage<List<FormPosts>> res = new ResponseMessage<List<FormPosts>>();

		try {
			Long userId = null;
			if (paramData.containsKey("userId")) {
				userId = Long.valueOf(paramData.get("userId").toString());
			}
			List<FormPosts> data = formPostManager.getIsEssence(userId);
			res.setData(data);
		} catch (Exception e) {
			res.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			res.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * @author liushuaic
	 * @date 2016-04-27 16:33
	 * @desc 发布帖子
	 * 
	 */
	public ResponseMessage<List<FormPosts>> publishForumPosts(Map<String, Object> paramData) {
		ResponseMessage<List<FormPosts>> res = new ResponseMessage<List<FormPosts>>();

		if (paramData.containsKey("title") && paramData.containsKey("content") && paramData.containsKey("taglibIds")) {
			String content = paramData.get("content").toString();
			List<Integer> taglibIds = (List) paramData.get("taglibIds");
			String title = paramData.get("title").toString();
			String userId = paramData.get("userId").toString();
			String[] imgs = new String[0];
			if (paramData.containsKey("images")) {
				List<String> images = (List) paramData.get("images");
				imgs = new String[images.size()];
				for (int j = 0; j < images.size(); j++) {
					imgs[j] = images.get(j);
				}
			}
			Long[] tags = new Long[taglibIds.size()];
			for (int i = 0; i < taglibIds.size(); i++) {
				tags[i] = Long.valueOf(taglibIds.get(i).toString());
			}
			FormPosts formPosts=formPostManager.insertPublishFormPosts(title, content, tags, Long.valueOf(userId), imgs);
			try{
				OperationMessage operationMessage=new OperationMessage();
				operationMessage.setContent(formPosts.getForumPostId().toString());
				operationMessage.setContentType("1");
				OperationMessageQueue.putMessage(operationMessage);
			}catch(Exception e){
				log.error("推送发生异常!"+e.getMessage());
			}
		} else {
			res.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			res.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}

		return res;
	}

	/**
	 * @author liushuaic
	 * @date 2016-04-27 16:33
	 * @desc 发布专业文章
	 *
	 */
	public ResponseMessage<List<FormPosts>> performencePublishForumPosts(Map<String, Object> paramData) {
		ResponseMessage<List<FormPosts>> res = new ResponseMessage<List<FormPosts>>();

		if (paramData.containsKey("title") && (paramData.get("title").toString().length() < 150)
				&& paramData.containsKey("forumPostDetailContent")
				&& paramData.containsKey("forumPostHtmlDetailContent") && paramData.containsKey("taglibIds")
				&& paramData.containsKey("recommendPicUrl")) {
			String forumPostDetailContent = paramData.get("forumPostDetailContent").toString();
			String forumPostHtmlDetailContent = paramData.get("forumPostHtmlDetailContent").toString();
			List<Integer> taglibIds = (List) paramData.get("taglibIds");
			String title = paramData.get("title").toString();
			String userId = paramData.get("userId").toString();
			String recommendPicUrl = paramData.get("recommendPicUrl").toString();

			String[] imgs = new String[0];
			if (paramData.containsKey("images")) {
				List<String> images = (List) paramData.get("images");
				imgs = new String[images.size()];
				for (int j = 0; j < images.size(); j++) {
					imgs[j] = images.get(j);
				}
			}
			Long[] tags = new Long[taglibIds.size()];
			for (int i = 0; i < taglibIds.size(); i++) {
				tags[i] = Long.valueOf(taglibIds.get(i).toString());
			}
			FormPosts formPosts=formPostManager.insertPerformencePublishForumPosts(title, forumPostDetailContent,
					forumPostHtmlDetailContent, tags, Long.valueOf(userId), imgs, recommendPicUrl);
			try{
				OperationMessage operationMessage=new OperationMessage();
				operationMessage.setContent(formPosts.getForumPostId().toString());
				operationMessage.setContentType("1");
				OperationMessageQueue.putMessage(operationMessage);
			}catch(Exception e){
				e.printStackTrace();
			}

			integralManager.insertIntegralAddScoreIsUsualJob("FBZJS", Byte.valueOf("2"), Long.valueOf(userId));
		
		}else {
			res.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			res.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}

		return res;
	}


    
    /**
     * @author liushuaic
     * @date 2016-04-27 17:36
     * @desc 文章支持UpAndDown
     * @param formPostId
     * @param userId
     * */
    public ResponseMessage<FormPosts> updateForumPostStar(Map<String,Object> paramData){
    	
    	ResponseMessage<FormPosts> res=new ResponseMessage<FormPosts>();
    	try{
    		if(paramData.containsKey("forumPostId")){
    			Long userId=Long.valueOf(paramData.get("userId").toString());
    			Long forumPostsId=Long.valueOf(paramData.get("forumPostId").toString());
    			formPostManager.updateForumPostStar(forumPostsId,userId);
    			FormPosts formPosts=formPostManager.getForumPostsDetail(forumPostsId, userId);
    			res.setData(formPosts);
    		}else{
    			res.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
        		res.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
    		}
    		
    	}catch(Exception e){
    		res.setStatus(ExceptionConstants.systemException.systemException.errorCode);
    		res.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
    		e.printStackTrace();
    		log.error(e.getMessage());
    	}
    	return res;
    }
    
    
    /**
     * @author liushuaic
     * @date 2016-04-27 17:36
     * @desc 文章/帖子回复
     * @param fourmPostId
     * @param answerText
     * 
     * */
    public ResponseMessage<List<FormPosts>> fourmPostAnswers(Map<String,Object> paramData){
    	ResponseMessage<List<FormPosts>> res=new ResponseMessage<List<FormPosts>>();
    	
    	try{
    		if(
    				 paramData.containsKey("content")
    				&& paramData.containsKey("formPostId")
    				&& paramData.containsKey("toUserId")
    		){
    			
    			String content=paramData.get("content").toString();
    			String createUserId=paramData.get("userId").toString();
    			String formPostId=paramData.get("formPostId").toString();
    			// 如果没有选择就是给，文章的 创建人的回复
    			Long toUserId=Long.valueOf(paramData.get("toUserId").toString());
    			
        		Byte answerTo=null;
        		if(null == toUserId){
        			answerTo=YKConstants.AnswerTo.AnswerToPersion.getValue();
        		}else{
        			answerTo=YKConstants.AnswerTo.AnswerToFormPosts.getValue();
        		}
        		forumPostsAnswerManager.insertSelective(content,Long.valueOf(createUserId),Long.valueOf(formPostId),toUserId,answerTo);
        		integralManager.insertIntegralAddScoreIsONCEJob("CCPL",Long.valueOf(createUserId));
        		integralManager.insertIntegralAddScoreIsUsualJob("PLTZ",Byte.valueOf("2"),Long.valueOf(createUserId));
    		}

    		
    	}catch(Exception e){
    		res.setStatus(ExceptionConstants.systemException.systemException.errorCode);
    		res.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
    		e.printStackTrace();
    		log.error(e.getMessage());
    	}
    	return res;
    }
    
    
    
    /**
     * @author liushuaic
     * @date 2016-04-28
     * @desc 获取文章详情
     * */
    public ResponseMessage<FormPosts> getFourmPostDetail(Map<String,Object> paramData){
    	
    	 ResponseMessage<FormPosts> res=new ResponseMessage<FormPosts>();
    	 
    	 try{
    		 
    		 if( paramData.containsKey("forumPostId")){
    			 Long forumPostId=Long.valueOf(paramData.get("forumPostId").toString());
    			 Long userId=null;
    			 if(paramData.containsKey("userId")){
    				 userId=Long.valueOf(paramData.get("userId").toString());
    			 }
    			 FormPosts fp=formPostManager.getForumPostsDetail(forumPostId,userId);
    			 res.setData(fp);
    		 }else{
    			 res.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
         		 res.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
    		 }
    		 
    	 }catch(Exception e){
    		 res.setStatus(ExceptionConstants.systemException.systemException.errorCode);
     		 res.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
    		 e.printStackTrace();
    		 log.error(e.getMessage());
    	 }
    	 return res;
    }
    
    
    /**
     * @author liushuaic
     * @date 2016-05-12 18:16
     * @desc 获取文章内容根据标签id
     * */
    public  ResponseMessage<List<FormPosts>> getForumPostsByTaglibId(Map<String,Object> paramData){

    	ResponseMessage<List<FormPosts>> res=new ResponseMessage<List<FormPosts>>();

    	try{
    		if(
    				paramData.containsKey("taglibId")
    				&& paramData.containsKey("page")
    			){

    			Long taglibId=Long.valueOf(paramData.get("taglibId").toString());
    			 Long userId=null;
    			 if(paramData.containsKey("userId")){
    				 userId=Long.valueOf(paramData.get("userId").toString());
    			 }
    			 PageParameter page=new PageParameter();
    			 if(paramData.containsKey("page")){
    				 int currentPage=Integer.valueOf(paramData.get("page").toString());
    				 page.setCurrentPage(currentPage);
    			 }
    			List<FormPosts> data=formPostManager.getForumPostsByTaglibsId(taglibId,userId,page);
    			res.setData(data);
    		}else{
       		 res.setStatus(ExceptionConstants.systemException.systemException.errorCode);
     		 res.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
    	}
    	}catch(Exception e){
    		e.printStackTrace();
    		 log.error(e.getMessage());
    	}

    	return res;

    }
    
    /**
     * @author liushuaic
     * @desc 最热文章or 帖子
     * */
    public  ResponseMessage<List<FormPosts>> getHotForumPosts(Map<String,Object> paramData){
    	ResponseMessage<List<FormPosts>> res=new ResponseMessage<List<FormPosts>>();
    	List<FormPosts> data=formPostManager.getHotForumPosts();
    	res.setData(data);
    	return res;
    } 
    
   
    
   
	/**
	 * @author liushuaic
	 * @desc 最热帖子列表 分页
	 */
	public ResponseMessage<List<FormPosts>> getHotForumPostsForPage(Map<String, Object> paramData) {
		
		ResponseMessage<List<FormPosts>> res = new ResponseMessage<List<FormPosts>>();
		if(paramData.containsKey("page")){
			int currentPage=Integer.valueOf(paramData.get("page").toString());
			PageParameter page=new PageParameter();
			page.setCurrentPage(currentPage);
			List<FormPosts> data = formPostManager.getHotForumPostsPage(page);
			res.setData(data);
		}else{
			res.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			res.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return res;
	}

	/**
	 * @author liushuaic
	 * @date 2016-06-07 10:31
	 * @desc 获取某一个人创建的帖子
	 */
	public ResponseMessage<List<FormPosts>> geForumPostsByCreateUserId(Map<String, Object> paramData) {
		ResponseMessage<List<FormPosts>> res = new ResponseMessage<List<FormPosts>>();

		if (paramData.containsKey("userId")) {
			Long userId = Long.valueOf(paramData.get("userId").toString());
			List<FormPosts> formPosts = formPostManager.geTZForumPostsByCreateUserId(userId);
			res.setData(formPosts);
		} else {
			res.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			res.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}

		return res;
	}

	/**
	 * @author liushuaic
	 * @date 2016-06-07 10:31
	 * @desc 获取某一个人创建的文章
	 */
	public ResponseMessage<List<FormPosts>> geWZForumPostsByCreateUserId(Map<String, Object> paramData) {
		ResponseMessage<List<FormPosts>> res = new ResponseMessage<List<FormPosts>>();

		if (paramData.containsKey("userId")) {
			Long userId = Long.valueOf(paramData.get("userId").toString());
			List<FormPosts> formPosts = formPostManager.geWZForumPostsByCreateUserId(userId);
			res.setData(formPosts);
		} else {
			res.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			res.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}

		return res;
	}

	/**
	 * 删除
	 **/

	public ResponseMessage<String> deleteForumPosts(Map<String, Object> paramMap) {
		ResponseMessage<String> resData = new ResponseMessage<String>();
		return resData;
	}

	/**
	 * 修改
	 */
	public ResponseMessage<String> updateForumPosts(Map<String, Object> paramMap) {
		ResponseMessage<String> resData = new ResponseMessage<String>();
		return resData;
	}

	/**
	 * @author liushuaic
	 * @date 2016-06-20 19:54
	 * @desc 获取编辑的url
	 */
	public ResponseMessage<String> getForumPostsEditorUrl(Map<String, Object> paramMap) {
		ResponseMessage<String> resData = new ResponseMessage<String>();

		if (paramMap.containsKey("userId")) {
			Long userId = Long.valueOf(paramMap.get("userId").toString());
			String uniqueCode = GenreateNumberUtils.getForumPostEditorUniqueCode();
			forumPostTxtEditorManager.insertSelective(uniqueCode, userId);
			String editUrl = SystemProperties.getPropertieValue("forumPostEditUrl") + uniqueCode;
			resData.setData(editUrl);
		}

		return resData;
	}

	/**
	 * @author liushuaic
	 * @date 2016-05-12 18:16
	 * @desc 获取专业内容
	 */
	public ResponseMessage<List<FormPosts>> getPerformenceForumPostsByTaglibId(Map<String, Object> paramData) {

		ResponseMessage<List<FormPosts>> res = new ResponseMessage<List<FormPosts>>();

		try {
			Map<String, Object> resMap = new HashMap<String, Object>();
			if (paramData.containsKey("taglibId")) {

				Long taglibId = Long.valueOf(paramData.get("taglibId").toString());
				Long userId = null;
				if (paramData.containsKey("userId")) {
					userId = Long.valueOf(paramData.get("userId").toString());
				}
				PageParameter page = new PageParameter();
				if (paramData.containsKey("page")) {
					int currentPage = Integer.valueOf(paramData.get("page").toString());
					page.setCurrentPage(currentPage);
				}
				List<FormPosts> data = formPostManager.getPerformenceForumPostsByTaglibsId(taglibId, userId, page);
				resMap.put("result", data);
				resMap.put("page", page);
				res.setData(data);
			} else {
				res.setStatus(ExceptionConstants.systemException.systemException.errorCode);
				res.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}

		return res;

	}




	
    /**
     * @author liushuaic
     * @date 2016-06-07 10:31
     * @desc 获取某一个人创建的帖子
     * */
   public  ResponseMessage<List<FormPosts>> getForumPostsByServerUserId(Map<String,Object> paramData){
	   ResponseMessage<List<FormPosts>> res=new ResponseMessage<List<FormPosts>>();
	   
	   if(paramData.containsKey("userId")){
		   Long userId=Long.valueOf(paramData.get("userId").toString());
		   List<FormPosts> formPosts=formPostManager.geTZForumPostsByCreateUserId(userId);
		   res.setData(formPosts);
	   }else{
		   res.setStatus(ExceptionConstants.systemException.systemException.errorCode);
   		   res.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
	   }
	   
	   
	   
   	   return res;
   }
   
   /**
    * @author liushuaic
    * @date 2016-06-07 10:31
    * @desc 获取某一个人创建的帖子
    * */
   public  ResponseMessage<List<FormPosts>> getForumPostsByServerUserIdPage(Map<String,Object> paramData){
	   ResponseMessage<List<FormPosts>> res=new ResponseMessage<List<FormPosts>>();
	   
	   if(paramData.containsKey("serverUserId") && paramData.containsKey("page")){
		   int currrentPage=Integer.valueOf(paramData.get("page").toString());
		   Long userId=Long.valueOf(paramData.get("serverUserId").toString());
		   PageParameter page=new PageParameter();
		   page.setCurrentPage(currrentPage);
		   List<FormPosts> formPosts=formPostManager.geTZForumPostsByCreateUserIdPage(userId,page);
		   res.setData(formPosts);
	   }else{
		   res.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
		   res.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
	   }
	   
	   return res;
   }
   
   
   /**
    * @author liushuaic
    * @date 2016-06-07 10:31
    * @desc 获取某一个人创建的帖子
    * */
  public  ResponseMessage<List<FormPosts>> getWZForumPostsByServerUserId(Map<String,Object> paramData){
	   ResponseMessage<List<FormPosts>> res=new ResponseMessage<List<FormPosts>>();
	   
	   if(paramData.containsKey("serverUserId")){
		   Long userId=Long.valueOf(paramData.get("serverUserId").toString());
		   List<FormPosts> formPosts=formPostManager.geWZForumPostsByCreateUserId(userId);
		   res.setData(formPosts);
	   }else{
		   res.setStatus(ExceptionConstants.systemException.systemException.errorCode);
  		   res.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
	   }
	   
  	   return res;
  }
  /**
   * @author liushuaic
   * @date 2016-06-07 10:31
   * @desc 获取某一个人创建的帖子
   * */
  public  ResponseMessage<List<FormPosts>> getWZForumPostsByServerUserIdPage(Map<String,Object> paramData){
	  ResponseMessage<List<FormPosts>> res=new ResponseMessage<List<FormPosts>>();
	  
	  if(paramData.containsKey("serverUserId") && paramData.containsKey("page")){
		  Long userId=Long.valueOf(paramData.get("serverUserId").toString());
		  int currentPage=Integer.valueOf(paramData.get("page").toString());
		  PageParameter page=new PageParameter();
		  page.setCurrentPage(currentPage);
		  List<FormPosts> formPosts=formPostManager.geWZForumPostsByCreateUserIdPage(userId,page);
		  res.setData(formPosts);
	  }else{
		  res.setStatus(ExceptionConstants.systemException.systemException.errorCode);
		  res.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
	  }
	  
	  return res;
  }
   
   
   
   /**
    * @author liushuaic
    * @date 2016-08-31 
    * @desc 相关性阅读推荐
    * */
   public ResponseMessage<List<FormPosts>> getFormPostRelatedReading(Map<String,Object> paramData){
	   ResponseMessage<List<FormPosts>> res=new ResponseMessage<List<FormPosts>>();
	   if(paramData.containsKey("forumPostId")){
		   Long forumPostId=Long.valueOf(paramData.get("forumPostId").toString());
		   FormPosts formPosts= formPostManager.getForumPostsDetail(forumPostId, null);
		   String title=formPosts.getTitle();
		   String content=formPosts.getContent();
		   List<Taglib> taglibs=formPosts.getTaglibs();
		   List<FormPosts> rtnData=SearchUtil.searchForumPosts(title, content, taglibs, 4);
		   res.setData(rtnData);
	   }else{
		   res.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
		   res.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
	   }
	   return res;
   }

}