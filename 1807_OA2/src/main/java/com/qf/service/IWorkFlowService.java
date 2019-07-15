package com.qf.service;

import java.io.InputStream;
import java.util.List;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;

import com.github.pagehelper.Page;
import com.qf.entity.Leavebill;
import com.qf.entity.User;
import com.qf.entity.WorkFlow;

public interface IWorkFlowService {
	//流程部署信息表
	List<Deployment> getDeployMentList(Page<Deployment> page);
	//流程定义信查询
	List<ProcessDefinition> processDefinitionList(Page<Deployment> page);
	
	//查询流程图片
	InputStream getProcessPng(String id, String name);
	
	//添加部署
	void addDeploy(String name, InputStream inputStream);
	
	//查询当前用户的任务
	List<Task> getTaskListByUserId(User user);
	//启动请假流程
	void startProncessIns(Long leaveBillId);
	
	//拿到请假单信息根据任务id
	Leavebill getLeaveBillByTaskId(String taskId);
	
	//连线集合
	
	List<String> getLineListByTaskId(String taskId);
	
	// 3.批注信息
	List<Comment> getCommentlistByTaskId(String taskId);
	
	void compeletMytask(WorkFlow workFlow);

	
}
