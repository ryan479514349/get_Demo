<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath() + "/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<title>角色管理</title>
</head>
<body id="roleBody">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 角色管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

	<div class="pd-1">
			<div class="text-c">
				<div class="row cl pd-10 ">
					<div class="formControls col-5">
						角色名称： <input type="text" id = "queryMenuName" class="input-text" style="width: 170px" value="${role.roleName}">
					</div>
					<div class="formControls col-5">
						角色状态：
						<span class="select-box" style="width:150px;">
							<select class="select" id="queryMenuType" size="1">
								<option value="" label="请选择">
								<option value="0" label="启用">
								<option value="1" label="禁用">
							</select>
						</span>
					</div>
				</div>
				
				<div class="row cl">
					<div class="cl">
						<button type="button"
							class="btn btn-success radius" id="menuQuery" name="">
							<i class="Hui-iconfont">&#xe665;</i> 搜索
						</button>
						<button type="button"
							class="btn btn-success radius" id="menuReset" name="">
							<i class="Hui-iconfont">&#xe66b;</i> 重置
						</button>
					</div>
				</div>	
		</div>
		
	</div>
		
<div class="pd-20">
	<div class="cl pd-5 bg-1 bk-gray"> <span class="l"> <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" href="javascript:;" onclick="admin_role_add('添加角色','roleController/toAddRole','550','450')"><i class="Hui-iconfont">&#xe600;</i> 添加角色</a> </span></div>
	<table class="table table-border table-bordered table-hover table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">角色管理</th>
			</tr>
			<tr class="text-c">
				<th width="25"><input type="checkbox" value="" name=""></th>
				<th width="40">ID</th>
				<th width="100">角色名称</th>
				<th width="300">角色描述</th>
				<th width="50">角色状态</th>
				<th width="150">创建时间</th>			
				<th width="70">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="role">
		
			<tr class="text-c">
				<td><input type="checkbox" id="delRole${role.roleId}" value="${role.roleId}" name="" ></td>
				<td>${role.roleId}</td>
				<td>${role.roleName}</td>
				<td>${role.roleDesc}</td>
				<td><input type="hidden" id="roleState${role.roleId}" value="${role.state}" >
						<c:if test="${role.state==0}">
							<input id="roleStateButton1"  type="button" class="btn btn-default"  style="background-color:#00BFFF;" value="启用" onclick="roleStateClick(${role.roleId})">
						</c:if>
						<c:if test="${role.state==1}">
							<input id="roleStateButton2"  type="button" class="btn btn-default"  style="background-color:gray;" value="禁用" onclick="roleStateClick(${role.roleId})">
						</c:if>
				</td>
				<td><fmt:formatDate value="${role.createdDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td class="f-14"><a title="编辑" href="javascript:;"
					onclick="admin_role_edit('角色编辑','roleController/getRoleById/${role.roleId}','1','600','500')"
					style="text-decoration: none"><i class="Hui-iconfont">&#xe6df;</i></a>
					<a title="删除" href="javascript:;"
					onclick="admin_role_del(this,${role.roleId})" class="ml-5"
					style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			</tr>
			
			</c:forEach>
		</tbody>
	</table>
	<jsp:include page="/common/page.jsp"/>
	</div>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/layer.js"></script>
	<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/H-ui.js"></script>
	<script type="text/javascript" src="js/H-ui.admin.js"></script>
	<script type="text/javascript" src="js/oa_utils.js"></script>
	<script type="text/javascript">
		/*管理员-角色-添加*/
		function admin_role_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*管理员-角色-编辑*/
		function admin_role_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*管理员-角色-删除*/
		function admin_role_del(obj, id) {
			layer.confirm('角色删除须谨慎，确认要删除吗？', function(index) {
				$.get("roleController/delRole/"+id,function(data){
					responseMessage(data);
				},"JSON");
			});
		}
		
		function datadel(){
			debugger
			var obj = {};
			var idArray = new Array();
			var checkboxArray = $(":checkbox:checked");
			for (var i = 0; i < checkboxArray.length; i++) {
				var value = checkboxArray[i].value;
				idArray.push(value);
			}
			obj.idArray = idArray;
			
			$.get("role/deleteRole", obj, function(data){
				debugger
				var results = JSON.parse(data);
				var alertInfos = results.flag;
				for (var i = 0; i < alertInfos.length; i++) {
					alert(alertInfos[i]);
				}
				location.reload();
			}); 
		}
	</script>
	
	<script type="text/javascript">
		function roleStateClick(id){
			
				var param = {};
				param.id = id;
				param.roleState = $("#roleState"+id).val();
				
				$.getJSON("role/updateRoleState", param, function(data){
					debugger
					
					if (data.flag) {
						$("#roleState"+id).attr("style", "color:black")
					}else{
						$("#roleState"+id).attr("style", "color:red")
					}
					var currentPage = "${page.pageNum}";
					location.href='role/getRolePage?currentPage='+currentPage;
				});
		}
			
			
	</script>
	
	<script type="text/javascript">
		$(function(){
			
			$("#menuQuery").click(function(){
				debugger
				var param = getQueryParam();
				$("#roleBody").load("role/getRolePage", param, function(){
				});
			});
			
			$("#menuReset").click(function(){
				location.reload();
			});
			
			$("#queryMenuType").val("${role.state}");
		})
			
		function getQueryParam(){
				var param ={};
				
				param.roleName = $("#queryMenuName").val();
				
				param.roleState = $("#queryMenuType").val();
			
				return param;
		}
	</script>
	
</body>
</html>