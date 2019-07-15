package com.qf.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.IBaseDao;
import com.qf.entity.Page;
import com.qf.service.IBaseService;

public abstract class BaseServiceImpl<T> implements IBaseService<T>{

	protected abstract IBaseDao<T> baseDao();
	
	@Override
	public int add(T t) {
		return baseDao().insertSelective(t);
	}

	@Override
	public int udpate(T t) {
		return baseDao().updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(Long id) {
		return baseDao().deleteByPrimaryKey(id);
	}

	@Override
	public T getById(Long id) {
		return baseDao().selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<T> getPage(Page<T> page,T t) {
		
		// 1.设置分页参数
		PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
		
		// 2.查询当前页的数据
		List<T> list = baseDao().getList(t);
		
		// 3.转成PageInfo
		return new PageInfo<>(list);
	}

	@Override
	public int batchDel(Long[] ids) {
		return baseDao().batchDel(ids);
	}

}
