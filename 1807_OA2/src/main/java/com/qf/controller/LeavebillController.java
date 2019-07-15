package com.qf.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.qf.entity.Leavebill;
import com.qf.entity.User;
import com.qf.service.ILeavebillService;
import com.qf.utils.OAUtils;

@Controller
@RequestMapping(value="/leavebillController")
public class LeavebillController extends BaseController{
	
	@Autowired
	private ILeavebillService leavebillService;
	
	private Logger logger = Logger.getLogger(MenuController.class);
	
	/**
	 * 请假流程
	 * @param page
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getLeavebillPage")
	public String getLeavebillPage(com.qf.entity.Page<Leavebill> page,ModelMap map){
	
		Leavebill leavebill = new Leavebill();
		
		PageInfo<Leavebill> pageInfo = leavebillService.getPage(page, leavebill);
		
		map.put("page", pageInfo);
		map.put("url", "leavebillController/getLeavebillPage?");
		
		
		return "leavebill/leavebillList";
		
	}
	
	/**
	 * 添加请假单
	 */
	@ResponseBody
	@RequestMapping("/addLeavebill")
	public String addLeavebill(Leavebill leavebill){
		
		Map<String, Object> map = OAUtils.getResultInfoMap();
		
		//弄登录后，此处将做修改
		try {
			User user = OAUtils.getSessionUser();
			leavebill.setUserId(user.getUserId());
			
			int add = leavebillService.add(leavebill);
			
			responseInfoToMap(add, map);
		} catch (Exception e) {
			logger.error("添加失败",e);
		}
		
		return new Gson().toJson(map);
		
	}
}
