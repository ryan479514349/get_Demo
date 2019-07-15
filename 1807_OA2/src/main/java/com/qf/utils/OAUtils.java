package com.qf.utils;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.qf.entity.User;

public class OAUtils {

	private static Gson gson = new Gson();
	
	public static Map<String, Object> getResultInfoMap(){
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
			map.put("flag", 0);
			map.put("msg", "操作失败");
		
		return map;
	}
	
	public static String objectToJson(Object object){
		return gson.toJson(object);
	}
	/**
	 * 写死的userId需要改
	 * @return
	 */
	public static User getSessionUser(){
		User user = new User();
		user.setUserId(15L);
		user.setUserName("xhsh");
		return user;
	}
}
