package com.qf.service;

import com.qf.entity.User;

public interface IUserService extends IBaseService<User>{
	
	public User getUserById(Long userId);

	public User getMgrByUserId(Long userId);
}
