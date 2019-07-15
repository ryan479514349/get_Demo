package com.qf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.IBaseDao;
import com.qf.dao.RoleMapper;
import com.qf.entity.Role;
import com.qf.service.IRoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService{
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	protected IBaseDao<Role> baseDao() {
		
		return roleMapper ;
	}

	@Override
	public List<Role> getRoleList() {
		
		return roleMapper.getList(null);
	}

	@Override
	public int delMenuIdByRoleId(Long roleId) {
		
		int delMenuIdByRoleId = roleMapper.delMenuIdByRoleId(roleId);
		
		return delMenuIdByRoleId;
	}

	@Override
	public int addMenuIdByRoleId(Long[] ids, Long roleId) {
		
		int addMenuIdByRoleId = roleMapper.addMenuIdByRoleId(ids,roleId);
		
		return addMenuIdByRoleId;
		
	}

}
