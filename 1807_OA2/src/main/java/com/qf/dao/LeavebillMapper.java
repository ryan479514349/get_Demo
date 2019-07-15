package com.qf.dao;

import java.util.Map;

import com.qf.entity.Leavebill;

public interface LeavebillMapper  extends IBaseDao<Leavebill>{

	void udpateLeavebill(Map<String, Object> leaveMap);
   
}