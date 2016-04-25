package com.yikangyiliao.pension.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.OrderServiceDetailDao;
import com.yikangyiliao.pension.entity.OrderServiceDetail;



@Component
public class OrderServiceDetailManager {
	
	
	@Autowired
	private OrderServiceDetailDao orderServiceDetailDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/10 14:28
	 * 获取某一个定单的评估人员
	 * ***/
	public OrderServiceDetail getEstimateOrderServiceDetailByOrderId(Long orderId){
		return	orderServiceDetailDao.getEstimateOrderServiceDetailByOrderId(orderId);
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/10/10 16:55
	 * 修改orderDetail 信息
	 * */
	public int updateOrderServiceDetailSelective(OrderServiceDetail orderServiceDetail){
		
		return orderServiceDetailDao.updateByPrimaryKeySelective(orderServiceDetail);
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/12 14:53
	 * 添加定单详情
	 * 
	 * **/
	public int insertSelective(OrderServiceDetail record){
		return orderServiceDetailDao.insertSelective(record);
	}

	
	
	/**
	 * @author liushuaic
	 * @date 2015/11/13 16:39
	 * @desc 查询我的服务日程
	 * **/
	public List<Map<String,Object>> getMyServiceScheduleByUserIdServiceDetailId(Long serviceUserId,Long orderServiceDetailId){
		
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("serviceUserId", serviceUserId);
		paramData.put("orderServiceDetailId", orderServiceDetailId);
		
		return orderServiceDetailDao.getMyServiceScheduleByUserIdServiceDetailId(paramData);
	}
	
	
	/**
	 * @author liushuaic
     * @date 2015/10/12 11:03
     * @desc
     * 修改定单反馈，状态为反馈完成，已结束
	 * */
	public void updateFeedbackDetailStatus5FeedBackByOrderServiceDetailIdAndServiceUserId(String feedback,Long serviceUserId,Long orderServiceDetailId){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("serviceUserId", serviceUserId);
		paramData.put("feedback", feedback);
		paramData.put("orderServiceDetailId",  orderServiceDetailId);
		orderServiceDetailDao.updateFeedbackDetailStatus5FeedBackByOrderServiceDetailIdAndServiceUserId(paramData);
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/11/16 10:56
	 * @desc 
	 * 查询某一个日程的详情
	 * @param orderServiceDetailId
     * @param serviceUserId
	 * **/
	public Map<String,Object> getOrderServiceDetailByOrderServiceDetailIdAndUserId(Long orderServiceDetailId,Long serviceUserId){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("orderServiceDetailId", orderServiceDetailId);
		paramData.put("serviceUserId", serviceUserId);
		return orderServiceDetailDao.getOrderServiceDetailByOrderServiceDetailIdAndUserId(paramData);
	}
	
}
