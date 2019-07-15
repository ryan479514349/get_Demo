package com.qf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.IBaseDao;
import com.qf.dao.MenuMapper;
import com.qf.entity.Menu;
import com.qf.service.IMenuService;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService{
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	protected IBaseDao<Menu> baseDao() {
		
		return menuMapper;	
	}
	//初始化树
	@Override
	public List<Menu> getMenuList(Long parentId) {
		
		List<Menu> menuList = menuMapper.getMenuList(parentId);
		
		return menuList;
	}
	@Override
	public List<Menu> getMenuByParentId(Long id) {
		
		List<Menu> menuList = menuMapper.getMenuList(id);
		
		return menuList;
	}
	
	

}
