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
<body id="">
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
						<td><input type="checkbox" class="userIds" value="${user.userId}"></td>
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
	<jsp:include page="/common/page.jsp">
		<jsp:param value="authorizationTable" name="tableId"/>
	</jsp:include>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>  
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript" src="js/oa_utils.js"></script>
<script type="text/javascript">
/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/*用户-增加*/
function user_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户删除*/
function user_delete(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.get("userController/deleteUser/"+id,function(data){
			responseMessage(data)
		},'JSON');
	});
}
/*用户-编辑*/
function user_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户批量删除*/
function batchDelUser(){
	layer.confirm('确认要删除吗？',function(index){
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
			//清理选中框
			$(".userIds:checked").each(function(){
				$(this).attr("checked",false);
			});
		},"JSON");
	});
}
/*管理员-停用*/
function admin_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		
		$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已禁用</span>');
		$(obj).remove();
		layer.msg('已停用!',{icon: 5,time:1000});
	});
}

/*管理员-启用*/
function admin_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		
		
		$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
		$(obj).remove();
		layer.msg('已启用!', {icon: 6,time:1000});
	});
}

/*按查询条件分页，此方法覆盖page.jsp中的方法，用于传查询条件参数*/
function getQueryParam(){
	debugger
	var paramObj = fromToObject("user_query_form");
	return paramObj;
}
</script>
</body>
</html>