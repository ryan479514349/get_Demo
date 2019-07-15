package com.qf.entity;

public class WorkFlow {

	private String taskId; // taskId
	 
	private String commen; // 批注信息
	
	private String outcome; // 同意/驳回
	
	private Integer lveaveBillId; // 请假单id

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getCommen() {
		return commen;
	}

	public void setCommen(String commen) {
		this.commen = commen;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public Integer getLveaveBillId() {
		return lveaveBillId;
	}

	public void setLveaveBillId(Integer lveaveBillId) {
		this.lveaveBillId = lveaveBillId;
	}
	
	
	
}
