package com.qf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.IBaseDao;
import com.qf.dao.OrgMapper;
import com.qf.entity.Org;
import com.qf.service.IOrgService;

@Service
public class OrgServiceImpl extends BaseServiceImpl<Org> implements IOrgService{

	@Autowired
	private OrgMapper orgMapper;
	
	@Override
	protected IBaseDao<Org> baseDao() {
		return orgMapper;
	}

	@Override
	public List<Org> getOrgListByParentId(Long paretnId) {
		return orgMapper.getOrgList(paretnId);
	}
/**
 * 批量查询
 */
	@Override
	public List<Org> getOrgListByParentIds(Long[] ids) {
		
		return orgMapper.getOrgListByParentIds(ids);
	}


}
