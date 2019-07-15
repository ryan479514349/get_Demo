package com.qf.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.impl.cmd.GetDeploymentProcessDiagramLayoutCmd;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.qf.entity.Leavebill;
import com.qf.entity.User;
import com.qf.entity.WorkFlow;
import com.qf.service.IWorkFlowService;
import com.qf.utils.OAUtils;

@Controller
@RequestMapping(value="/workFlowController")
public class WorkFlowController { 
	
	@Autowired
	private IWorkFlowService workFlowService;
	
	/**
	 * 流程图部署信息表展示
	 */
	@RequestMapping(value="/getDeploymentPage")
	public String getDeploymentPage(Page<Deployment> page,ModelMap map){
		//流程部署信息表
		//1.查询流程部署集合
		List<Deployment> deploymentList=workFlowService.getDeployMentList(page);
		
		//流程定义信息表
		//2.查询流程定义集合
		List<ProcessDefinition> processDefinitionList =workFlowService.processDefinitionList(page);
		
		//3.把数据放入map中，传递值
		map.put("deploymentList", deploymentList);
		map.put("processDefinitionList", processDefinitionList);
		
		return "workFlow/deploymentList";
	}
	
	/**
	 * 查询流程图片
	 * @param id
	 * @param name
	 * @param response
	 */
	@RequestMapping(value="/getProcessPng")
	public void getProcessPng(String id,String name,HttpServletResponse response){
		
		//1.根据部署id和资源文件名称查询资源文件
		InputStream ips = workFlowService.getProcessPng(id, name);
		
		//2.把ips流拷贝response
		try {
			IOUtils.copy(ips, response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeQuietly(ips);
		}
	}
	
	/**
	 * 添加部署
	 * @param file
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/addDeploy")
	public String addDeploy(@RequestParam("file")MultipartFile file,String name){
		
		try {
			workFlowService.addDeploy(name,file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:getDeploymentPage";
		
	}
	
	//删除部署
	
	
	//查询任务管理
	@RequestMapping(value="/getTaskListByUserId")
	public String getTaskListByUserId(ModelMap map){
		
		//1.获取当前登录用户
		User user =OAUtils.getSessionUser();
		System.out.println(user);
		//2.查询当前用户的待办任务
		List<Task> taskList=workFlowService.getTaskListByUserId(user);
		
		map.put("taskList", taskList);
		
		return "workFlow/tasakList";
	}
	
	//启动请假流程 需要传入请假id
	@RequestMapping(value="/startProncessIns")
	public String startProncessIns(Long leaveBillId){
		
		workFlowService.startProncessIns(leaveBillId);
		
		return "redirect:getTaskListByUserId";
		
	}
	
	//展示批示页面
	@RequestMapping(value="/findTaskInfoByTaskId")
	public String findTaskInfoByTaskId(String taskId,ModelMap map){
		
		// 1.拿到请假单信息
		Leavebill  leavebill = workFlowService.getLeaveBillByTaskId(taskId);
		
		// 2.连线集合  得到流程图的连线信息
		List<String> lineList = workFlowService.getLineListByTaskId(taskId);
		
		// 3.批注信息
		List<Comment> comments = workFlowService.getCommentlistByTaskId(taskId);
		
			map.put("leavebill", leavebill);
			map.put("lineList", lineList);
			map.put("comments", comments);
			map.put("taskId", taskId);
		
		return "workFlow/tasakInfo";
	}
	
	//完成我的任务
	@RequestMapping(value="/compeletMytask")
	public String compeletMytask(WorkFlow workFlow){
		
		workFlowService.compeletMytask(workFlow);
		
		return "redirect:getTaskListByUserId"; // task列表
	}
	
}
