package com.qf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.qf.entity.Menu;
import com.qf.entity.Role;
import com.qf.entity.User;
import com.qf.service.IAuthorizationService;
import com.qf.service.IMenuService;
import com.qf.service.IRoleService;
import com.qf.service.impl.RoleServiceImpl;
import com.qf.utils.OAUtils;

@Controller
@RequestMapping(value = "/authorizationController")
public class AuthorizationController extends BaseController {

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IAuthorizationService authorizationService;
	
	@Autowired
	private IMenuService menuService;
	

	private Logger logger = Logger.getLogger(MenuController.class);

	@RequestMapping(value = "/toAuthorizationPage")
	public String toAuthorizationPage(ModelMap map) {

		// 1.查询所有的角色
		List<Role> roleList = roleService.getRoleList();

		// 2.把list存到ModelMap
		map.put("roleAll", roleList);

		return "authorization/authorization";
	}

	/**
	 * 根据角色查询用户
	 * 
	 * @param id
	 * @param map
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/getUserListByRoleId/{id}")
	public String getUserListByRoleId(@PathVariable Long id, ModelMap map, Page<User> page) {

		// 1.查询具备拥有某个角色的所有用户
		PageInfo<User> pageInfo = authorizationService.getUserListByRoleId(id, page);

		map.put("page", pageInfo);
		map.put("url", "authorizationController/getUserListByRoleId/" + id + "?");

		return "authorization/authorizationUserList";
	}

	/**
	 * 根据角色查询菜单
	 * 
	 * @param id
	 * @param map
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/getMenuListByRoleId/{id}")
	public String getMenuListByRoleId(@PathVariable Long id, ModelMap map, Page<Menu> page) {

		PageInfo<Menu> pageInfo = authorizationService.getMenuListByRoleId(id, page);

		map.put("page", pageInfo);
		map.put("url", "authorizationController/getMenuListByRoleId/" + id + "?");

		return "authorization/authorizationMenuList";
	}

	/**
	 * 查询没有某个角色的用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findNoRoleIdUserList/{id}")
	public String findNoRoleIdUserList(@PathVariable Long id, ModelMap map, Page<User> page) {

		PageInfo<User> pageInfo = authorizationService.findNoRoleIdUserList(id, page);

		map.put("page", pageInfo);
		map.put("url", "authorizationController/findNoRoleIdUserList/" + id + "?");
		map.put("au_roleId", id);
		
		return "authorization/authorizationUser";
	}
	
	/**
	 * 初始化树菜单
	 * @param roleId
	 * @param id

	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getMenuTreeByParentId/{roleId}")
	public String getMenuTreeByParentId(Long id,@PathVariable Long roleId) {
		
		if (id == null) {
			id = -1L;
		}
		//查询数据
		List<Menu> menus =menuService.getMenuByParentId(id);

		//用 List集合装数据
		List<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();

		// 把orgList中的数据放入list
		for (Menu menu : menus) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
				map.put("id", menu.getMenuId());
				map.put("name", menu.getMenuName());
				map.put("isParent", menu.getSubMenuId() != null ? true : false); // ture代表有子节点
				
				//标识
				boolean flag =false;
				//根据菜单id得到角色id,如果跟当前角色一致就选中
				Long[] roleIds = authorizationService.getRoleIdByMenuId(menu.getMenuId());
				//比较
				for(int i=0;i<roleIds.length;i++){
					
					if(roleId==roleIds[i]){
						flag=true;
						break;
					}
				}
				map.put("checked", flag);
			
				arrayList.add(map);
		}

		return OAUtils.objectToJson(arrayList);
	}
	
	//修改授权树菜单
	@ResponseBody
	@RequestMapping(value="/updateAuthorizationMenu/{roleId}")
	public String updateAuthorizationMenu(@RequestParam("menuIds[]") Long[] ids,@PathVariable Long roleId){
		
		Map<String, Object> map = OAUtils.getResultInfoMap();
		
		try {
			//修改之前先清空数据中间表角色下的菜单
			roleService.delMenuIdByRoleId(roleId);
			
			//重新角色下的菜单
			int addMenuIdByRoleId = roleService.addMenuIdByRoleId(ids,roleId);

			responseInfoToMap(addMenuIdByRoleId, map);
		
		}catch (Exception e) {
			logger.error("插入或者删除出现异常", e);
			
		}
		return OAUtils.objectToJson(map);
		
	}


}

