package com.qf.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.qf.entity.User;
import com.qf.service.IUserService;
import com.qf.utils.OAUtils;

/**
 * 在这个监听器中给讲师审批和班主任审批赋予处理人
 * @author admin
 *
 */
public class NextTaskListenrer implements TaskListener {

	/**
	 * 
	 */

	@Override
	public void notify(DelegateTask delegateTask) {

		// 1.获取当前登录用户
		User user = OAUtils.getSessionUser();

		// 2.获取ServletRequestAttributes
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		
		// 3.通过ServletRequestAttributes获取req对象
		HttpServletRequest request = servletRequestAttribute.getRequest();
		
		// 4.通过req获取session，通过sesion获取servletContext
		ServletContext servletContext = request.getSession().getServletContext();

		// 5.通过servletContext获取Spring容器
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		
		// 6.从ctx中获取userService
		IUserService userService = ctx.getBean(IUserService.class);
		
		// 7.查询领导
		User mgr = userService.getMgrByUserId(user.getUserId());
		
		System.out.println("优秀："+mgr);
		// 8.设置处理人
		delegateTask.setAssignee(mgr.getUserName());
	}

}
