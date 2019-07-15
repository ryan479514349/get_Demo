package com.qf.dao;

import java.util.List;

import com.qf.entity.Org;

public interface OrgMapper extends IBaseDao<Org> {
	//根据父类id查部门
	List<Org> getOrgList(Long paretnId);
	
	//批量查询
	List<Org> getOrgListByParentIds(Long[] ids);
	
}