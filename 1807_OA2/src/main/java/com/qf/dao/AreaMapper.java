package com.qf.dao;

import java.util.List;

import com.qf.entity.Area;

public interface AreaMapper extends IBaseDao<Area>{
	
	public List<Area> getAreaListByParentId(Long id);
}