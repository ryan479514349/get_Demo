package com.qf.dao;

import org.apache.ibatis.annotations.Param;

import com.qf.entity.Role;

public interface RoleMapper extends IBaseDao<Role>{

	//根据菜单id查角色id中间表查询
	Long[] getRoleIdByMenuId(Long menuId);
	
	//删除角色id下的所有菜单id
	int delMenuIdByRoleId(Long roleId);
	
	//添加菜单id和角色Id
	int addMenuIdByRoleId(@Param("array") Long[] ids, @Param("roleId")Long roleId);
   
}