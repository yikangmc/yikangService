package com.yikangyiliao.base.utils.messageUtil;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.PushPayload.Builder;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;



/**
 * @author liushuaic
 * @date 2015/08/31 15:30
 * 
 * 推送工具
 * 
 * 
 * */
public class MessageUtils {

	/**
	 * 推送渠道
	 * JPUSH 极光推送
	 * OTHER
	 * **/
	private static String accessWay="JPUSH";
	
	/**
	 * apid
	 * */
	
	/**
	 * appk
	 * */
	private static String appKey="9de890837df54fce0b818cc4";
	
	/**
	 * 安全密钥
	 * 
	 * **/
	private static String masterSecret="16fb21e870c56e506a71f59c";
	
	/**
	 * 
	 * 重连时间
	 * 
	 * */
	private static int retryTimes=3;
	
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/06 16:38
	 * **/
	public static Boolean sendMessage(String message){
		
		
		if(accessWay.equals("JPUSH")){
			
			
			JPushClient jpushClient=new JPushClient(masterSecret, appKey,retryTimes);
			PushPayload pushPayLoad=buildPushObject_all_all_alert(message);
			
			try {
				PushResult pushResult=jpushClient.sendPush(pushPayLoad);
				if(pushResult.isResultOK()){
					return true;
				}
				
			} catch (APIConnectionException e) {
				e.printStackTrace();
				return false;
			} catch (APIRequestException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		
		return false;
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/09/06 16:31
	 * 所有平台，所有设备
	 * **/
    public static PushPayload buildPushObject_all_all_alert(String message) {
        return PushPayload.alertAll(message);
    }
    
    
    /**
     * @author liushuaic
     * @date 2015/09/06 19:08
     * 创建所有平台的信息通知
     * 
     * 
     * ***/
    public static PushPayload buildPushObject_all_all_alert(String alias,String title,String message) {
    	Builder builder=  PushPayload.newBuilder();
    	builder.setPlatform(Platform.all());
    	builder.setAudience(Audience.alias(alias));
    	builder.setNotification(Notification.android(title, message, null));
    	return	builder.build();
    	
    }
    
    /**
     * @author liushuaic
     * @date 2015/09/06 17:11
     * 所有平台别名为  alias 的设备
     * @param alias 别名
     * @param message 信息内容
     * **/
    public static PushPayload buildPushObject_all_alias_alert(String alias,String message) {
       
    	Options options=Options.newBuilder().setApnsProduction(true).build();
    	return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias(alias))
                .setNotification(Notification.alert(message)).setOptions(options)
                .build();
    }
    
    
    
    /**
     * 
     * @author liushuaic
     * @date 2015/09/06 17:17
     * IOS 平台别名为  alias 的设备
     * @param alias 别名
     * @param message 信息内容
     * */
    public static PushPayload buildPushObject_IOS_alias_alert(String alias,String message) {
    	Options options=Options.newBuilder().setApnsProduction(true).build();
        return PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.alias(alias)).setNotification(Notification.alert(message)).setOptions(options).build();
    }
    
    
    /**
     * 
     * @author liushuaic
     * @date 2015/09/06 17:17
     * ANDROID 平台别名为  alias 的设备
     * @param alias 别名
     * @param message 信息内容
     * 
     * */
    public static PushPayload buildPushObject_ANDORID_alias_alert(String alias,String message) {
    	Options options=Options.newBuilder().setApnsProduction(true).build();
        return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.alias(alias)).setNotification(Notification.alert(message)).setOptions(options).build();
    }
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/06 16:38
	 **/
	public static Boolean sendMessageByPushPayLoad(PushPayload pushPayLoad) {

		if (accessWay.equals("JPUSH")) {

			JPushClient jpushClient = new JPushClient(masterSecret, appKey, retryTimes);

			try {
				PushResult pushResult = jpushClient.sendPush(pushPayLoad);
				if (pushResult.isResultOK()) {
					return true;
				}

			} catch (APIConnectionException e) {
				e.printStackTrace();
				return false;
			} catch (APIRequestException e) {
				e.printStackTrace();
				return false;
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		return false;
	}
}
