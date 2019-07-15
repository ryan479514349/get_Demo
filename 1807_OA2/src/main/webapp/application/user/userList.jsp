<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>     
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<base href="<%=request.getContextPath()+"/"%>">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<title>角色管理</title>
</head>
<!-- 查询分页 -->
<body id="user_list_body">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 管理员列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<form action="userController/getUserPage" method="post" id="query_user_from">
		<div class="text-c">
				<div class="row cl ">
					<div class="formControls col-3">
						登录名: <input type="text" name="userName" value="${user.userName}" class="input-text" style="width: 220px">
					</div>
					<div class="formControls col-4">
						邮箱： <input type="text" name="email" value="${user.email}" class="input-text" style="width: 250px">
					</div>
					<div class="formControls col-5">
						手机： <input type="text" name="mobilePhone" value="${user.mobilePhone}" class="input-text" style="width: 250px">
					</div>
				</div>
				<div class="row cl">
					<div class="cl pd-5">
						<button type="submit"
							class="btn btn-success radius" id="" name="">
							<i class="Hui-iconfont">&#xe665;</i> 搜用户
						</button>
						<button type="reset" onclick="javascript:location.replace(location.href);;"
							class="btn btn-success radius" id="" name="">
							<i class="Hui-iconfont">&#xe66b;</i> 重置
						</button>
					</div>
				</div>	
		</div>
	</form>
	</div>
<div class="">
	<div class="cl pd-5 bg-1 bk-gray"> 
		<span class="l"> 
		
			<a href="javascript:;" onclick="batchDelUser()" class="btn btn-danger radius">
				<i class="Hui-iconfont">&#xe6e2;</i> 批量删除
			</a> 
			
			<a class="btn btn-primary radius" href="javascript:;" onclick="user_add('添加用户','userController/toAddUser','700','500')">
				<i class="Hui-iconfont">&#xe600;</i> 添加用户
			</a> 
			
		</span>  
	</div>
	<table class="table table-border table-bordered table-hover table-bg">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" value="" name=""></th>
				<th width="40">ID</th>
				<th width="200">用户名</th>
				<th width="100">手机号码</th>
				<th width="200">部门</th>
				<th width="60">邮箱</th>
				<th width="70">性别</th>
				<th width="150">生日</th>
				<th width="220">家乡</th>
				<th width="70">操作</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${page.list}" var="user">
				<tr class="text-c">
					<td><input type="checkbox"  value="${user.userId}"  class="userIds" name=""  ></td>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.mobilePhone}</td>
					<td>${user.orgName}</td>
					<td>${user.email}</td>
					<td>${user.userSex eq '1' ?"男":"女"}</td>
					<td><fm:formatDate value="${user.userBirthday}" /></td>
					<td>${user.provinceName}${user.cityName}${user.contryName}</td>
					<td class="f-14">
						
						<a title="邮件" href="javascript:;" onclick="user_sendEmail('发送邮件','userController/toSendEmail/${user.email}','700','500')" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe63b;</i>
						</a> 
						
						<a title="编辑" href="javascript:;" onclick="org_edit('用户编辑','userController/getUserById/${user.userId}','700','500')" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe6df;</i>
						</a> 
						
						<a title="删除" href="javascript:;" onclick="user_del(this,'${user.userId}')" class="ml-5" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe6e2;</i>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<jsp:include page="/common/page.jsp"/>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript" src="js/oa_utils.js"></script> 
<script type="text/javascript">
/*管理员-角色-添加*/
function user_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-角色-编辑*/
function user_sendEmail(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*管理员-角色-编辑*/
function org_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*管理员-角色-删除*/
function user_del(obj,id){
	layer.confirm('确定是否删除该该员工？',function(index){
		$.get("userController/delUser/"+id,function(data){
			
			responseMessage(data);
		},"JSON");
	});
}
//批量删除
function batchDelUser(){
	
	// 1.创建一个数组
	var idArray = new Array();
	
	// 2.获取用于选中的id
	$(".userIds:checked").each(function(){
		idArray.push($(this).val());
	});
	
	// 3.把数组封装到对象
	var param = new Object();
	param.ids = idArray;
	
	// 4.调用服务端删除
	$.post("userController/batchDelUser",param,function(data){
		responseMessage(data);
	},"JSON");
}
//获取模块查询参数(返回给page工具类类)
function getQueryParam(){
	//来自oa_js的方法获取表单内容
	var paramObj=fromToObject("query_user_from")
	return paramObj;
}
</script>
</body>
</html>