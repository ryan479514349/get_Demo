package com.pei;

import java.util.List;

import javax.management.relation.RoleList;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.qf.dao.UserMapper;
import com.qf.entity.Leavebill;
import com.qf.entity.Org;
import com.qf.entity.Page;
import com.qf.entity.Role;
import com.qf.entity.User;
import com.qf.service.ILeavebillService;
import com.qf.service.IOrgService;
import com.qf.service.IRoleService;
import com.qf.service.IUserService;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class InitTet {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private IOrgService orgService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private ILeavebillService leavebillService;
	
	@Test
	public void testSqlSessionFactory(){
		System.out.println(sqlSessionFactory);
	}
	
	@Test
	public void testOrgService(){
		Page<Org> page = new Page<Org>();
		Org org =new Org();
		PageInfo<Org> pageInfo = orgService.getPage(page,org);
		System.out.println(pageInfo.getPageSize());
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		
		List<Org> list = pageInfo.getList();
		for (Org org1 : list) {
			System.out.println(org);
		}
	}
	@Test
	public void testuserService(){
		Page<User> page = new Page<User>();
		User user =new User();
		PageInfo<User> pageInfo = userService.getPage(page,user);
		System.out.println(pageInfo.getPageSize());
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		
		List<User> list = pageInfo.getList();
		for (User user1 : list) {
			System.out.println(user1);
		}
	}
	@Test
	public void test1(){
		Role role =new Role();
		role.setRoleName("1111sdad");
		role.setRoleDesc("2222");
		int add = roleService.add(role);
		
	}
	
	@Test
	public void test2(){
		
		Leavebill leavebill = leavebillService.getById(6L);
		
		String simpleName = leavebill.getClass().getSimpleName();
		
		System.out.println(leavebill);
		System.out.println(simpleName);
	}
}
