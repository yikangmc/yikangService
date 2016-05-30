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
    public  ResponseMessage<List<FormPosts>> insertPublishForumPosts(Map<String,Object> paramData){
    	ResponseMessage<List<FormPosts>> res=new ResponseMessage<List<FormPosts>>();
    	
    		if(
    			paramData.containsKey("title")
    			&&paramData.containsKey("content")
    			&& paramData.containsKey("taglibIds")
    		){
    			String content=paramData.get("content").toString();
    			List<Integer> taglibIds=(List)paramData.get("taglibIds");
    			String title=paramData.get("title").toString();
    			String userId=paramData.get("userId").toString();
    			String[] imgs=new String[0];
    			if(paramData.containsKey("images")){
					List<String> images=(List)paramData.get("images");
					imgs=new String[images.size()];
					for(int j=0;j<images.size();j++){
						imgs[j]=images.get(j);
					}
    			}
    			Long[] tags=new Long[taglibIds.size()];
    			for(int i=0;i<taglibIds.size();i++){
    				tags[i]=Long.valueOf(taglibIds.get(i).toString());
    			}
    			formPostManager.insertPublishFormPosts(title,content,tags,Long.valueOf(userId),imgs);
    		}else{
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
    public ResponseMessage<String> udpateForumPostStar(Map<String,Object> paramData){
    	
    	ResponseMessage<String> res=new ResponseMessage<String>();
    	try{
    		if(paramData.containsKey("forumPostId")){
    			Long userId=Long.valueOf(paramData.get("userId").toString());
    			Long forumPostsId=Long.valueOf(paramData.get("forumPostId").toString());
    			formPostManager.updateForumPostStar(userId,forumPostsId);
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
    				&& paramData.containsKey("formPostId")
    		){
    			
    			String content=paramData.get("content").toString();
    			String createUserId=paramData.get("userId").toString();
    			String formPostId=paramData.get("formPostId").toString();
    			Long toUserId=null;
    			if(paramData.containsKey("toUserId")){
    				toUserId=Long.valueOf(paramData.get("toUserId").toString());
    			}
        		Byte answerTo=null;
        		if(null == toUserId){
        			answerTo=YKConstants.AnswerTo.AnswerToPersion.getValue();
        		}else{
        			answerTo=YKConstants.AnswerTo.AnswerToFormPosts.getValue();
        		}
        		forumPostsAnswerManager.insertSelective(content,Long.valueOf(createUserId),Long.valueOf(formPostId),toUserId,answerTo);
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
    		if(paramData.containsKey("taglibId")){
    			
    			Long taglibId=Long.valueOf(paramData.get("taglibId").toString());
    			List<FormPosts> data=formPostManager.getForumPostsByTaglibsId(taglibId);
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
     * 删除
     * **/
    
    /**
     * 修改
     * */
    
    
}