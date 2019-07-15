package com.qf.service;

import java.util.List;

import com.qf.entity.Area;

public interface IAreaService extends IBaseService<Area>{
	
	public List<Area> getAreaListByParentId(Long id);
}
