package com.qf.dao;

import java.util.List;

public interface IBaseDao<T> {
	//删除
    int deleteByPrimaryKey(Long id);
	//插入
    int insert(T t);
    //有选择的插入
    int insertSelective(T t);
    //查询
    T selectByPrimaryKey(Long id);
    //有选择的更新
    int updateByPrimaryKeySelective(T t);
    //更新
    int updateByPrimaryKey(T t);
    //分页查询当前页数据 及查询
    public List<T> getList(T t);
    //批量删除
    public int batchDel(Long[] ids);
}
