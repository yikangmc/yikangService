package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.constants.YKConstants;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.FormPosts;
import com.yikangyiliao.pension.manager.FormPostManager;
import com.yikangyiliao.pension.manager.ForumPostsAnswerManager;

@Service(value="forumPostService")
public class ForumPostService {
	
	private Logger log=LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private FormPostManager formPostManager;
	
	@Autowired
	private ForumPostsAnswerManager forumPostsAnswerManager;
	
	
	
	
    /**
     * @author liushuaic
     * @date 2016-04-27 11:11
     * @desc 获取推荐文章
     * **/
    public ResponseMessage<List<FormPosts>> getIsEssence(Map<String,Object> paramData){
    	
    	ResponseMessage<List<FormPosts>> res=new ResponseMessage<List<FormPosts>>();
    	
    	try{
    		List<FormPosts> data=formPostManager.getIsEssence();
    		res.setData(data);
    	}catch(Exception e){
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
     * @desc 发布文章
     * 
     * */
    public  ResponseMessage<List<FormPosts>> publishForumPosts(Map<String,Object> paramData){
    	ResponseMessage<List<FormPosts>> res=new ResponseMessage<List<FormPosts>>();
    	
    	try{
    		
    		if(
    			paramData.containsKey("content")
    			&& paramData.containsKey("taglibIds")
    		){
    			String content=paramData.get("content").toString();
    			Long[] taglibIds=(Long[])paramData.get("taglibIds");
    			String userId=paramData.get("userId").toString();
    			formPostManager.insertPublishFormPosts(content, taglibIds,Long.valueOf(userId));
    			
    			
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
     * @desc 文章支持
     * @param formPostId
     * @param userId
     * */
    public ResponseMessage forumPostStar(Map<String,Object> paramData){
    	ResponseMessage<List<FormPosts>> res=new ResponseMessage<List<FormPosts>>();
    	
    	try{
    		if( paramData.containsKey("formPostId")
    			){
    			String userId=paramData.get("userId").toString();
    			String forumPostsId=paramData.get("forumPostsId").toString();
    			formPostManager.forumPostsStar(Long.valueOf(forumPostsId), Long.valueOf(userId));
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
     * @desc 文章回复
     * @param fourmPostId
     * @param answerText
     * 
     * */
    public ResponseMessage<List<FormPosts>> fourmPostAnswers(Map<String,Object> paramData){
    	ResponseMessage<List<FormPosts>> res=new ResponseMessage<List<FormPosts>>();
    	
    	try{
    		if(
    				 paramData.containsKey("content")
    				&& paramData.containsKey("createUserId")
    				&& paramData.containsKey("formPostId")
    				&& paramData.containsKey("toUserId")
    		){
    			
    			String content=paramData.get("content").toString();
    			String createUserId=paramData.get("userId").toString();
    			String formPostId=paramData.get("formPostId").toString();
    			String toUserId=paramData.get("toUserId").toString();
        		Byte answerTo=null;
        		if(null == toUserId){
        			answerTo=YKConstants.AnswerTo.AnswerToPersion.getValue();
        		}else{
        			answerTo=YKConstants.AnswerTo.AnswerToFormPosts.getValue();
        		}
        		forumPostsAnswerManager.insertSelective(content,Long.valueOf(createUserId),Long.valueOf(formPostId),Long.valueOf(toUserId),answerTo);
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
    			 FormPosts fp=formPostManager.getForumPostsDetail(forumPostId);
    			 res.setData(fp);
    		 }
    		 
    	 }catch(Exception e){
    		 res.setStatus(ExceptionConstants.systemException.systemException.errorCode);
     		 res.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
    		 e.printStackTrace();
    		 log.error(e.getMessage());
    	 }
    	 return res;
    }
    
    
    
    
}