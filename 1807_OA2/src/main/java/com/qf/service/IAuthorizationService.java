package com.qf.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.qf.entity.Menu;
import com.qf.entity.User;

public interface IAuthorizationService {
	
	PageInfo<User> getUserListByRoleId(Long id, Page<User> page);
	
	PageInfo<Menu> getMenuListByRoleId(Long id, Page<Menu> page);
	
	PageInfo<User> findNoRoleIdUserList(Long id, Page<User> page);
	
	//查询菜单id下的角色id
	Long[] getRoleIdByMenuId(Long menuId);
	
}
