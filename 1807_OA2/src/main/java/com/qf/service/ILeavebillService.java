package com.qf.service;

import java.util.Map;

import com.qf.entity.Leavebill;

public interface ILeavebillService extends IBaseService<Leavebill>{
	//修改请假单状态
	void udpateLeavebill(Map<String, Object> leaveMap);
}
