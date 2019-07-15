package com.qf.service;

import java.util.List;

import com.qf.entity.Role;

public interface IRoleService extends IBaseService<Role>{

	List<Role> getRoleList();
	//清楚角色下的菜单的Id
	int delMenuIdByRoleId(Long roleId);

	//插入角色id下所有菜单Id
	int addMenuIdByRoleId(Long[] ids, Long roleId);


}
