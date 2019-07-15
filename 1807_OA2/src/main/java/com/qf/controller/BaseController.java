package com.qf.controller;

import java.util.Map;

public class BaseController {

	public void responseInfoToMap(int state,Map<String, Object> map){
		//根据后台返回的数据返回值
		if(state > 0){
			map.put("flag", 1);
			map.put("msg", "操作成功");
		}else{
			map.put("flag", 0);
			map.put("msg", "操作失败");
		}
	}
}
