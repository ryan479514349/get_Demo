package com.qf.service;

import java.util.List;

import com.qf.entity.Org;

public interface IOrgService extends IBaseService<Org>{
	
	//查询单个
	List<Org> getOrgListByParentId(Long parentId);
	
	//批量查询数组
	List<Org> getOrgListByParentIds(Long[] ids);

}
