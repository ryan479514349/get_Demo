package com.qf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.AreaMapper;
import com.qf.dao.IBaseDao;
import com.qf.dao.MenuMapper;
import com.qf.dao.RoleMapper;
import com.qf.dao.UserMapper;
import com.qf.entity.Area;
import com.qf.entity.Menu;
import com.qf.entity.User;
import com.qf.service.IAreaService;
import com.qf.service.IAuthorizationService;

@Service
public class AuthorizationService implements IAuthorizationService{
	
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public PageInfo<User> getUserListByRoleId(Long id, Page<User> page) {
		// 1.设置分页参数
		PageHelper.startPage(page.getPageNum() == 0 ? 1 : page.getPageNum(), 5);
		

		List<User> userList = userMapper.getUserListByRoleId(id);
		
		return new PageInfo(userList);
	}

	@Override
	public PageInfo<Menu> getMenuListByRoleId(Long id, Page<Menu> page) {
		
		PageHelper.startPage(page.getPageNum() == 0 ? 1 : page.getPageNum(), 5);
		
		List<Menu> menuList = menuMapper.getMenuListByRoleId(id);
		
		return new PageInfo<Menu>(menuList);
	}

	@Override
	public PageInfo<User> findNoRoleIdUserList(Long id, Page<User> page) {
		
		PageHelper.startPage(page.getPageNum() == 0 ? 1 : page.getPageNum(), 5);
		
		List<User> users = userMapper.findNoRoleIdUserList(id);
		
		return new PageInfo<User>(users);
	}

	@Override
	public Long[] getRoleIdByMenuId(Long menuId) {
		
		Long[] roleIds = roleMapper.getRoleIdByMenuId(menuId);
		
		return roleIds;
	}

}
