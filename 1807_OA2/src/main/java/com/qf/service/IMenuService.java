package com.qf.service;

import java.util.List;

import com.qf.entity.Menu;

public interface IMenuService extends IBaseService<Menu>{
	//初始化树
		List<Menu> getMenuList(Long parentId);

		List<Menu> getMenuByParentId(Long id);
}
