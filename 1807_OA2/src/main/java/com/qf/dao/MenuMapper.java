package com.qf.dao;

import java.util.List;

import com.qf.entity.Menu;
import com.qf.entity.User;

public interface MenuMapper extends IBaseDao<Menu>{
    //初始化树
	List<Menu> getMenuList(Long parentId);
	
	//根据角色查菜单
	List<Menu> getMenuListByRoleId(Long id);
	
	//查询单个id
}