package com.qf.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.entity.Area;
import com.qf.service.IAreaService;
import com.qf.utils.OAUtils;
import com.sun.org.glassfish.gmbal.ParameterNames;

@Controller
@RequestMapping(value="areaController")
public class AreaController {
		
	@Autowired
	private IAreaService areaService;
	
	@ResponseBody   //produces 解决服务端给客户端数据的乱码问题
	@RequestMapping(value="/getAreaListByParentId/{id}",produces="text/html;charset=utf8")
	public String getAreaListByParentId(@PathVariable Long id){

		List<Area> areaList = areaService.getAreaListByParentId(id);
		
		return OAUtils.objectToJson(areaList);
		
	}
}
