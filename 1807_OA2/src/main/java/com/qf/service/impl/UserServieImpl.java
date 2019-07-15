package com.qf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.IBaseDao;
import com.qf.dao.UserMapper;
import com.qf.entity.User;
import com.qf.service.IUserService;

@Service
public class UserServieImpl extends BaseServiceImpl<User> implements IUserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	protected IBaseDao<User> baseDao() {
		
		return userMapper;
	}
	
	@Override
	public User getUserById(Long userId) {
		User user = userMapper.getUserById(userId);
		return user;
	}

	@Override
	public User getMgrByUserId(Long userId) {
	
		return userMapper.getMgrByUserId(userId);
	}
	
}
