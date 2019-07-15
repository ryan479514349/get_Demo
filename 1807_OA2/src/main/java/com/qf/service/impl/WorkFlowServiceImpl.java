package com.qf.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ScopeImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.qf.entity.Leavebill;
import com.qf.entity.User;
import com.qf.entity.WorkFlow;
import com.qf.service.ILeavebillService;
import com.qf.service.IWorkFlowService;
import com.qf.utils.OAUtils;

@Service
public class WorkFlowServiceImpl implements IWorkFlowService {
		
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private ILeavebillService leavebillService;
	
	//设置初始化页码
		public void initPage(Page<Deployment> page){
			if(page.getPageNum() == 0){
				//从0开始
				page.setPageNum(0);
			}
			
			if(page.getPageSize() == 0){
				page.setPageSize(5);
			}
		}
	
	//流程部署查询
	@Override
	public List<Deployment> getDeployMentList(Page<Deployment> page) {
		initPage(page);
		//创建个查询对象
		DeploymentQuery DeploymentQuery = repositoryService.createDeploymentQuery();
		
		List<Deployment> listPage = DeploymentQuery.orderByDeploymentId().desc().listPage(page.getPageNum(), page.getPageSize());
		
		return listPage;
	}
	
	//流程定义查询
	@Override
	public List<ProcessDefinition> processDefinitionList(Page<Deployment> page) {
		initPage(page);
		
		ProcessDefinitionQuery pro = repositoryService.createProcessDefinitionQuery();
		
		List<ProcessDefinition> page2 = pro.orderByProcessDefinitionId().desc().listPage(page.getPageNum(), page.getPageSize());
		
		return page2;
	}
	
	//查询流程图片
	@Override
	public InputStream getProcessPng(String id, String name) {
	
		InputStream resourceAsStream = repositoryService.getResourceAsStream(id, name);
			
		return resourceAsStream;
	}
	
	//添加部署
	@Override
	public void addDeploy(String name, InputStream inputStream) {
		//创建部署对象
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
		
		//资源名称
		deploymentBuilder.name(name);
		
		deploymentBuilder.addZipInputStream(new ZipInputStream(inputStream));
		
		deploymentBuilder.deploy();//部署操作
	
	}
	
	//查询当前用户的任务管理
	@Override
	public List<Task> getTaskListByUserId(User user) {
		
		List<Task> list = taskService.createTaskQuery().taskAssignee(user.getUserName()).orderByTaskCreateTime().desc().list();
		
		return list;
	}
	
	//启动请假流程
	@Override
	public void startProncessIns(Long leaveBillId) {
		
		
		//1.根据请假id查询请假单对象
		Leavebill leavebill = leavebillService.getById(leaveBillId);
		
		//2.获取启动流程key 获取当前类型
		String key = leavebill.getClass().getSimpleName();
		
		Map<String, Object> map = new HashMap<String,Object>();
		// 设置处理人(map中key要和$中的名称要保持一致)
		map.put("username", OAUtils.getSessionUser().getUserName());
		
		
		//3.启动流程，设置业务字段key
		//工作流那边保留我们的业务信息
		String businessKey = key +"_"+leaveBillId;
		
		runtimeService.startProcessInstanceByKey(key, businessKey, map);
		
		//4.修改请假单状态，从出事录入改为审批中
		Map<String,Object> leaveMap = new HashMap<String,Object>();
			leaveMap.put("leavebillId", leavebill.getId());
			leaveMap.put("state", 1);
		
		leavebillService.udpateLeavebill(leaveMap);
	
	}
	
	//拿请假单信息
	@Override
	public Leavebill getLeaveBillByTaskId(String taskId) {
		
		//1.根据taskId查询task对象
		TaskQuery taskQuery = taskService.createTaskQuery();
		Task task = taskQuery.taskId(taskId).singleResult();
		
		//2.从task对象中获取流程实例id
		String processInstanceId = task.getProcessInstanceId();
		
		//3.根据流程实例id查询流程实例对象
		ProcessInstance processInsutance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
		
		//4.业务字段的key(模块名称_id)
		String businessKey = processInsutance.getBusinessKey();
		
		//5.截取id并且在类型中转换
		Long id = Long.parseLong(businessKey.split("_")[1]);
		
		// 6.根据请假单id查询请假单对象
		Leavebill leavebill = leavebillService.getById(id);
		
		return leavebill;
	}
	
	//连线集合（流程图的连线）
	@Override
	public List<String> getLineListByTaskId(String taskId) {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		//1.根据taskId查询task对象
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		
		//2.根据流程实例id得到流程实例对象
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
		
		//3.通过流程实例对象获取流程定义id，
		String processDefinitionId = processInstance.getProcessDefinitionId();
		
		//4.根据流程定义id查询流程定义对象并且转为子类（通过注意此处不能创建对象去查（），只能createProcessDefinitionQuery()）
		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processDefinitionId);
		
		//5.通过流程实例对象获取节点的活动对象id
		String activityId = processInstance.getActivityId();
		
		// 6.通过得到活动对象
		ActivityImpl findActivity =processDefinition.findActivity(activityId);
				
		// 7.获取的连线(获得当前节点的连线)
		List<PvmTransition> outgoingTransitions = findActivity.getOutgoingTransitions();
				
			for (PvmTransition pvmTransition : outgoingTransitions) {
			
				Object name = pvmTransition.getProperty("name");
					if(name !=null ){
						arrayList.add(name.toString()); // 把连线的名称添加到集合中
					}
				}

		return arrayList;
	}
	
	
	//展示批注信息
	@Override
	public List<Comment> getCommentlistByTaskId(String taskId) {
				// 1.根据taskid得到流程实例id
				String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
				
				// 2.根据流程实例id查询批注信息
				return taskService.getProcessInstanceComments(processInstanceId);
	}
	
	//完成我的任务
	@Override
	public void compeletMytask(WorkFlow workFlow) {
		// 1.根据taskid查询流程实例id
		String processInstanceId = taskService.createTaskQuery().taskId(workFlow.getTaskId()).singleResult().getProcessInstanceId();
			
		// 2.设置添加批注的处理人
		Authentication.setAuthenticatedUserId(OAUtils.getSessionUser().getUserName());
				
		// 3.添加批注信息
		taskService.addComment(workFlow.getTaskId(), processInstanceId, workFlow.getCommen());
				
		// 4.完成我的任务
		Map<String, Object>map = new HashMap<String,Object>();
		
			map.put("outcome", workFlow.getOutcome().trim());
			taskService.complete(workFlow.getTaskId(), map);
				
		// 5.根据流程实例id查询流程实例对象
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
				
			// 6.判断流程是否走完了
			if(processInstance == null){ // 流程实例为空流程走完了
					
			// 7.把请假单的状态从审批中改成审批完成
			Map<String, Object> leaveMap= new HashMap<String,Object>();
				leaveMap.put("leavebillId", workFlow.getLveaveBillId());
				leaveMap.put("state", 2);
				leavebillService.udpateLeavebill(leaveMap);
				}
				
			}
		
}
