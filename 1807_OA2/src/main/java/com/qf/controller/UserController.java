package com.qf.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IUserService;
import com.qf.utils.OAUtils;

@Controller
@RequestMapping(value="/userController")
public class UserController extends BaseController{
	
	@Autowired
	private IUserService userService;
	
	//日志
	private Logger log = Logger.getLogger(OrgController.class);
	
	/**
	 * 分页 加搜索用户
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/getUserPage")
	public String getUserPage(Page<User> page,User user,ModelMap map){
		
		PageInfo<User> pageInfo = userService.getPage(page,user);
		
		map.put("url", "userController/getUserPage?");
		map.put("page", pageInfo);
		
		log.debug(pageInfo);
		
		return "user/userList";
		
	}
	
	/**
	 * 去添加页面
	 * @return
	 */
	@RequestMapping(value="/toAddUser")
	public String toAddUser(){
		
		return "user/addUser";
		
	}
	
	/**
	 * 添加用户
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping(value="/addUser")
	public String addUser(User user){
		
		Map<String,Object> map =OAUtils.getResultInfoMap();
		
		
		try {
			int add = userService.add(user);
			responseInfoToMap(add, map);
		
		} catch (Exception e) {
			log.error("添加用户失败",e);
	
		}
		return OAUtils.objectToJson(map);
	}
	
	/**
	 * 查单个user
	 * @param id
	 * @param map
	 * @return
	 */
	
	@RequestMapping(value="/getUserById/{id}")
	public String getUserById(@PathVariable Long id,ModelMap map){
		
		User user = userService.getUserById(id);
		
		//System.out.println(user);
		
		map.put("user", user);
		
		return "user/updateUser";
	}
	
	
	/**
	 * 更新
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateUser")
	public String updateUser(User user){
	
		Map<String, Object> map = OAUtils.getResultInfoMap();
			
			try {
			int udpate = userService.udpate(user);
				responseInfoToMap(udpate, map);
			} catch (Exception e) {
				log.error("更新失败", e);
			}
			
			return OAUtils.objectToJson(map);
	}
	
	/**
	 * 删除
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delUser/{id}")
	public String delUser(@PathVariable Long id){
	
		// 装返回的消息
		Map<String, Object> map = OAUtils.getResultInfoMap();
		
		try {
			int delete = userService.delete(id);
			
			responseInfoToMap(delete, map);
		} catch (Exception e) {
			
			log.error("删除失败", e);
		}
		
		// 以gosn方式返回
		return OAUtils.objectToJson(map);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ResponseBody
	
	@RequestMapping(value = "/batchDelUser")
	public String batchDelUser(@RequestParam("ids[]")Long[] ids) {
		//装返回消息
		Map<String, Object> map = OAUtils.getResultInfoMap();
		
		try {
			int batchDel = userService.batchDel(ids);
			responseInfoToMap(batchDel, map);
		
		} catch (Exception e) {
			log.error("删除失败", e);
		}
		
		
		return OAUtils.objectToJson(map);
	}
	
	@RequestMapping(value = "/toSendEmail/{email}")
	public String toSendEmail(@PathVariable String email,ModelMap map) {
		
		map.put("email", email);
		
		return "user/sendEmail";
	}
	
	
}
