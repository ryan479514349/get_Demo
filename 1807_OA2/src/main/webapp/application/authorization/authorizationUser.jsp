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
<LINK rel="Bookmark" href="/favicon.ico" >
<LINK rel="Shortcut Icon" href="/favicon.ico" />
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<title>管理员列表</title>
</head>
<body id="authorizationUserBody">
<div class="">
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="10">员工列表</th>
			</tr>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="40">ID</th>
				<th width="80">姓名</th>
				<th width="90">手机</th>
				<th width="150">邮箱</th>
				<th  width="40">性别</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="user">
					<tr class="text-c">
						<td><input type="checkbox" class="userIds" value="${user.userId}">
						</td>
						<td>${user.userId}</td>
						<td>${user.userName}</td>
						<td>${user.mobilePhone}</td>
						<td>${user.email}</td>
						<td>${user.userSex eq '1' ?"男":"女"}</td>
						<td class="td-manage">
							<a title="删除" href="javascript:;" onclick="user_delete(this,'${user.userId}')" class="ml-5" style="text-decoration:none">
								<i class="Hui-iconfont">&#xe6e2;</i>
							</a>
						</td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
				<!-- 包含页面的时候传递一个参数过去 -->
	<jsp:include page="/common/page2.jsp">
		<jsp:param value="authorizationUserBody" name="tableId"/>
	</jsp:include>
	
	<div class="cl pd-5">
			<button type="button" onclick="addRoleToUser()" class="btn btn-success radius" id="" name="">
				<i class="Hui-iconfont">&#xe62c;</i> 搜索
			</button>
	</div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>  
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript" src="js/oa_utils.js"></script>
<script type="text/javascript">
function addRoleToUser(){
	var roleId = "${au_roleId}";
	var idArray = new Array();
	
	// 2.获取用于选中的id
	$(".userIds:checked").each(function(){
		idArray.push($(this).val());
	});
	
	if(idArray.length == 0){
		alert("请选择用户。。。");
	}
	debugger
	alert("用户【"+idArray+"】授予角色【"+roleId+"】");
	layer_close();
}
</script>
</body>
</html>