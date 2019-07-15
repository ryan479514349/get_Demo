package com.qf.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.IBaseDao;
import com.qf.dao.LeavebillMapper;
import com.qf.entity.Leavebill;
import com.qf.service.ILeavebillService;

@Service
public class LeavebillService  extends BaseServiceImpl<Leavebill> implements ILeavebillService{
	@Autowired
	private LeavebillMapper leavebillMapper;
	
	@Override
	protected IBaseDao<Leavebill> baseDao() {
		
		
		return leavebillMapper;
	}

	@Override
	public void udpateLeavebill(Map<String, Object> leaveMap) {
		
		leavebillMapper.udpateLeavebill(leaveMap);
		
	}



}
