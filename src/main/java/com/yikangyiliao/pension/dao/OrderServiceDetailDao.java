package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.OrderServiceDetail;

public interface OrderServiceDetailDao {
    int deleteByPrimaryKey(Long orderServiceDetailId);

    int insert(OrderServiceDetail record);

    int insertSelective(OrderServiceDetail record);

    OrderServiceDetail selectByPrimaryKey(Long orderServiceDetailId);

    int updateByPrimaryKeySelective(OrderServiceDetail record);

    int updateByPrimaryKey(OrderServiceDetail record);
    
    
    /**
     * @author liushuaic
     * @date 2015/10/12 11:03
     * @desc 获取某一个定单的评估人员
     * */
    OrderServiceDetail getEstimateOrderServiceDetailByOrderId(Long orderId);
    /**
     * @author liushuaic
     * @date 2015/10/12 11:03
     * @desc 获取某一个定单的评估人员
     * */
    List<Map<String,Object>> getMyServiceScheduleByUserIdServiceDetailId(Map<String,Object> paramData);

    
    /**
     * 
     * @author liushuaic
     * @date 2015/10/12 11:03
     * @desc
     * 修改定单反馈，状态为反馈完成，已结束
     * **/
    void updateFeedbackDetailStatus5FeedBackByOrderServiceDetailIdAndServiceUserId(Map<String,Object> paramData);
    
    
    /**
     * @author liushuaic
     * @date 2015/11/16 10:52
     * @param orderServiceDetailId
     * @param serviceUserId
     * 查询某一个订单详情
     * **/
    Map<String,Object> getOrderServiceDetailByOrderServiceDetailIdAndUserId(Map<String,Object> paramData);
}