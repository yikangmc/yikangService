package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.AppointmentOrder;
import com.yikangyiliao.pension.entity.AppointmentOrderServiceModel;

public interface AppointmentOrderDao {
    int deleteByPrimaryKey(Long appointmentOrderId);

    int insert(AppointmentOrder record);

    int insertSelective(AppointmentOrder record);

    AppointmentOrder selectByPrimaryKey(Long appointmentOrderId);

    int updateByPrimaryKeySelective(AppointmentOrder record);

    int updateByPrimaryKey(AppointmentOrder record);
    
    
    /**
     * @author liushuaic
     * @date 2015/10/08 15:14 
     * 修改定单状态
     * @param   orderStatus 定单状态
     * 			0：未进行
				1：进行中
				2：已完成
				3：已评价
				4：已结束
				5：退回
     * 			appointmentOrderId
     * **/
    int updateAppointmentOrderStatus(Map<String,Object> param);
    
    
    
    
    
    /**
     * @author liushuaic
     * @date 2015/10/09 18:08
     * @desc 查询某一个定单的评估师
     * 
     * ***/
    Map<String,Object> getUserServiceInfoByOrderId(Long orderId);
    
    
    /**
     * @author liushuaic
     * @date 2015/11/18 17:36
     * @desc 查询的我工作日程
     * **/
    List<Map<String,Object>> getServicerScheduleByServiceUserId(Map<String,Object> paramData);
    
    
    
    
    /**
     * @author liushuaic
     * @date 2016/02/25 16:56
     * @desc 获取订单列表
     * */
    List<AppointmentOrderServiceModel> getAppointmentOrderListPageByUserId(Map<String,Object> paramData);
}


