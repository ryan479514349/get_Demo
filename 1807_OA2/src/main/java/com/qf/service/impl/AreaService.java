package com.qf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.AreaMapper;
import com.qf.dao.IBaseDao;
import com.qf.entity.Area;
import com.qf.service.IAreaService;

@Service
public class AreaService extends BaseServiceImpl<Area> implements IAreaService{

	@Autowired
	private AreaMapper areaMapper;
	
	@Override
	public List<Area> getAreaListByParentId(Long id) {
		
		List<Area> areaListByParentId = areaMapper.getAreaListByParentId(id);
		
		return areaListByParentId ;
	}

	@Override
	protected IBaseDao<Area> baseDao() {
		
		return areaMapper;
	}

}
