package com.qf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.core.appender.rolling.SizeBasedTriggeringPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.qf.entity.Menu;
import com.qf.entity.Page;
import com.qf.entity.Role;
import com.qf.service.IMenuService;
import com.qf.service.IRoleService;
import com.qf.utils.OAUtils;
import com.sun.prism.Texture;

@Controller
@RequestMapping(value="/menuController")
public class MenuController extends BaseController{
	
	@Autowired
	private IMenuService menuService;
	
	//日志
	private Logger log = Logger.getLogger(OrgController.class);
	
	/**
	 * 分页 加搜索用户
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/getMenuPage")
	public String getMenuPage(Page<Menu> page,Menu menu,ModelMap map){
		
		PageInfo<Menu> pageInfo =menuService.getPage(page, menu);
		
		map.put("url", "menuController/getMenuPage?");
		map.put("page", pageInfo);
		
		log.debug(pageInfo);
		
		return "menu/menuList";
		
	}
	
	/**
	 * 去添加页面
	 * @return
	 */
	@RequestMapping(value="/toAddMenu")
	public String toAddMenu(){
		
		return "menu/addMenu";
		
	}
	/**
	 * 初始菜单树
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="findMenuTree")
	public String findMenuTree(Long id){
		//第一次进来父类为空
		if(id ==null){
			id=-1L;
		}
		//准备一个集合来装数据
		ArrayList<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
		
		List<Menu> menuList = menuService.getMenuList(id);
		
		for(Menu menu:menuList){
			
			Map<String, Object> map =new HashMap<String,Object>();
			//传过去需要的内容(根据key值去取)
			map.put("id", menu.getMenuId());
			map.put("name", menu.getMenuName());
			map.put("isParent", menu.getSubMenuId() !=null ? true :false);
			arrayList.add(map);
		}
		
		return new Gson().toJson(arrayList);
		
	}
	/**
	 * 添加用户
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping(value="/addMenu")
	public String addMenu(Menu menu){
		
		Map<String,Object> map =OAUtils.getResultInfoMap();
		
		
		try {
			int add =menuService.add(menu);
			responseInfoToMap(add, map);
		
		} catch (Exception e) {
			log.error("添加菜单失败",e);
	
		}
		return OAUtils.objectToJson(map);
	}
	
	/**
	 * 查单个user
	 * @param id
	 * @param map
	 * @return
	 */
	
	@RequestMapping(value="/getMenuById/{id}")
	public String getUserById(@PathVariable Long id,ModelMap map){
		
		  Menu menu = menuService.getById(id);
		
		//System.out.println(user);
		
		map.put("menu", menu);
		
		return "menu/updateMenu";
	}
	
	
	/**
	 * 更新
	 * @param 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateMenu")
	public String updateMenu(Menu menu){
	
		Map<String, Object> map = OAUtils.getResultInfoMap();
			
			try {
			int udpate = menuService.udpate(menu);
				responseInfoToMap(udpate, map);
			} catch (Exception e) {
				log.error("更新失败", e);
			}
			
			return OAUtils.objectToJson(map);
	}
	
	/**
	 * 删除
	 * @param 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delMenu/{id}")
	public String delUser(@PathVariable Long id){
	
		// 装返回的消息
		Map<String, Object> map = OAUtils.getResultInfoMap();
		
		
		try {
		//判断该菜单是否有子菜单
		List<Menu>  menuList = menuService.getMenuByParentId(id);
		if(menuList.isEmpty()){
			int delete = menuService.delete(id);
			
			responseInfoToMap(delete, map);
		}else {
			//不能删除的原因反馈(它会覆盖掉工具类的"msg"消息)
			map.put("msg", "选中菜单下面有子菜单，不能直接删除哦!");
		}
			
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
	 *//*
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
	}*/
}
