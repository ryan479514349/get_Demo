package com.qf.dao;

import java.util.List;

import com.qf.entity.User;

public interface UserMapper extends IBaseDao<User>{
	//查询单个id
	public User getUserById(Long userId);
	
	List<User> getUserListByRoleId(Long id);

	List<User> findNoRoleIdUserList(Long id);
	
	//查询领导
	public User getMgrByUserId(Long userId);
		
}