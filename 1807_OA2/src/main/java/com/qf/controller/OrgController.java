package com.qf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.qf.entity.Org;
import com.qf.entity.Page;
import com.qf.service.IOrgService;
import com.qf.utils.OAUtils;

@Controller
@RequestMapping(value = "/orgController")
public class OrgController extends BaseController {

	//日志
	private Logger log = Logger.getLogger(OrgController.class);

	@Autowired
	private IOrgService orgService;
	
/**
 * 分页
 * @param page
 * @param map
 * @return
 */
	@RequestMapping(value = "/getOrgPage")
	public String getOrgPage(Page<Org> page,Org org, ModelMap map) {
		PageInfo<Org> pageInfo = orgService.getPage(page,org);
		
		map.put("page", pageInfo);
		map.put("url", "orgController/getOrgPage?");
		
		log.debug(pageInfo);
		
		return "org/orgList";
	}

	/**
	 * 转到添加页面
	 * @param page
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/toAddOrg")
	public String toAddOrg() {
	
		return "org/addOrg";
	}

	/**
	 * 添加
	 * @param org
	 * @return
	 */
	@RequestMapping(value = "/addOrg")
	@ResponseBody
	public String addOrg(Org org) {
		// map用转服务端的返回信息
		Map<String, Object> map = OAUtils.getResultInfoMap();
	
		try {
			responseInfoToMap(orgService.add(org), map);
		} catch (Exception e) {
			log.error("添加组织失败", e);
		}
		
		return OAUtils.objectToJson(map);
	}
	
	
	
	/**
	 * org树的初始化
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getOrgList")
	public String getOrgList(Long id) {

		// 第一进来时候parentId没有，没有就查询最大的部门
		if (id == null) {
			id = -1L;
		}

		// 准备一个集合用来装数据
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		List<Org> orgList = orgService.getOrgListByParentId(id);

		// 把orgList中的数据放入list
		for (Org org : orgList) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", org.getOrgId());
			map.put("name", org.getOrgName());
			//有子节点就想继续往下查
			map.put("isParent", org.getSubOrgId() != null ? true : false); // ture代表有子节点
			list.add(map);
		}
		return new Gson().toJson(list);
	}
	/**
	 * 单个查询
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/getOrgById/{id}")
	public String getOrgById(@PathVariable Long id, ModelMap map) {
		
		Org org = orgService.getById(id);
		map.put("org", org);
		
		return "org/updateOrg";
	}
	
	/**
	 * 更新
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/updateOrg")
	public String updateOrg(Org org) {
		//装返回消息
		Map<String, Object> map = OAUtils.getResultInfoMap();
		
		try {
			//来自BaseController:根据返回值回馈信息
			responseInfoToMap(orgService.udpate(org), map);
		} catch (Exception e) {
			log.error("修改组织失败", e);
		}
		return OAUtils.objectToJson(map);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteOrg/{id}")
	public String deleteOrg(@PathVariable Long id) {
		//装返回的消息
		Map<String, Object> map = OAUtils.getResultInfoMap();
		
		try {
			
			// 1.判断该部门是否有子部门
			List<Org> orgList = orgService.getOrgListByParentId(id);
			
			// 2.判断这个部门是否员有工(初始定义)
			Integer userCount = 0;
			
			if(orgList.isEmpty() && userCount == 0){ // 没有子部门并且没有员工可以删除部门
				//来自BaseController:根据返回值回馈信息
				responseInfoToMap(orgService.delete(id),map);
		
			}else{
				
				//不能删除的原因反馈(它会覆盖掉工具类的"msg"消息)
				map.put("msg", "选中部门下面有子部门或者员工，不能直接删除哦!");
			}
			
		} catch (Exception e) {
			log.error("删除组织失败", e);
		}
		//以gosn方式返回
		return OAUtils.objectToJson(map);
	}

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/batchDelOrg")
	public String batchDelOrg(@RequestParam("ids[]")Long[] ids) {
		//装返回消息
		Map<String, Object> map = OAUtils.getResultInfoMap();
		
		// 1.先判断是否有子部门
		List<Org> subOrgList =orgService.getOrgListByParentIds(ids);
		
		// 2.在判断是否有员工
		Integer userCount = 0;
		
		if(subOrgList.isEmpty() && userCount ==0){
			//如果发生异常继续执行
			try {
			
			responseInfoToMap(orgService.batchDel(ids), map);

			} catch (Exception e) {
				log.error("批量删除失败哦");
			}
		}else{
			map.put("msg", "~删除的部门下有子部门或员工,不能删除~");
		}
		
		return OAUtils.objectToJson(map);
	}

}
