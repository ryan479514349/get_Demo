package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.entity.Page;
import com.qf.entity.User;

public interface IBaseService<T> {

	public int add(T t);
	
	public int udpate(T t);
	
	
	public int delete(Long id);
	
	//查询单个id
	public T getById(Long i);
	
	//分页
	
	public PageInfo<T> getPage(Page<T> page,T t);
	
	//批量删除
	public int batchDel(Long ids[]);
}
