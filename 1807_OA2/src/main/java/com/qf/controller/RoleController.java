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
import com.qf.entity.Role;
import com.qf.service.IRoleService;
import com.qf.utils.OAUtils;

@Controller
@RequestMapping(value="/roleController")
public class RoleController extends BaseController{
	
	@Autowired
	private IRoleService roleService;
	
	//日志
	private Logger log = Logger.getLogger(OrgController.class);
	
	/**
	 * 分页 加搜索用户
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/getRolePage")
	public String getUserPage(Page<Role> page,Role role,ModelMap map){
		
		PageInfo<Role> pageInfo = roleService.getPage(page,role);
		
		map.put("url", "roleController/getRolePage?");
		map.put("page", pageInfo);
		
		log.debug(pageInfo);
		
		return "role/roleList";
		
	}
	
	/**
	 * 去添加页面
	 * @return
	 */
	@RequestMapping(value="/toAddRole")
	public String toAddUser(){
		
		return "role/addRole";
		
	}
	
	/**
	 * 添加用户
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping(value="/addRole")
	public String addUser(Role role){
		
		Map<String,Object> map =OAUtils.getResultInfoMap();
		
		
		try {
			int add = roleService.add(role);
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
	
	@RequestMapping(value="/getRoleById/{id}")
	public String getUserById(@PathVariable Long id,ModelMap map){
		
		Role role = roleService.getById(id);
		
		//System.out.println(user);
		
		map.put("role", role);
		
		return "role/updateRole";
	}
	
	
	/**
	 * 更新
	 * @param 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateRole")
	public String updateRole(Role role){
	
		Map<String, Object> map = OAUtils.getResultInfoMap();
			
			try {
			int udpate = roleService.udpate(role);
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
	@RequestMapping(value="/delRole/{id}")
	public String delUser(@PathVariable Long id){
	
		// 装返回的消息
		Map<String, Object> map = OAUtils.getResultInfoMap();
		
		try {
			int delete = roleService.delete(id);
			
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
	
	@RequestMapping(value = "/batchDelRole")
	public String batchDelUser(@RequestParam("ids[]")Long[] ids) {
		//装返回消息
		Map<String, Object> map = OAUtils.getResultInfoMap();
		
		try {
			int batchDel = roleService.batchDel(ids);
			responseInfoToMap(batchDel, map);
		
		} catch (Exception e) {
			log.error("删除失败", e);
		}
		
		
		return OAUtils.objectToJson(map);
	}
}
