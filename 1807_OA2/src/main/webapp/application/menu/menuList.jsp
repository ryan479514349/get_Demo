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
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<!-- <link rel="stylesheet" href="lib/layer/ui/css/layui.css" media="all"> -->
<title>菜单管理</title>
</head>
<body id="menuBody">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 菜单管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="pd-1">
			<div class="text-c">
				<div class="row cl pd-10 ">
					<%-- <div class="formControls col-3">
						所属目录: <input type="text" id ="parentName" name="menuParentName" class="input-text" style="width: 100px " value="${menu.menuParentName}">
								<input type="hidden" id="parentId" name="menuId"  value="${menu.menuParentId}">
								<input type="button" class="btn btn-default" value="菜单" onclick="getModeTree('menu/findMenuTree')">
					</div> --%>
					<div class="formControls col-4">
						菜单名称： <input type="text" id = "queryMenuName" class="input-text" style="width: 170px" value="${menu.menuName}">
					</div>
					<div class="formControls col-5">
						是否发布：
						<span class="select-box" style="width:150px;">
							<select class="select" id="queryMenuType" size="1">
								<option value="" label="请选择">
								<option value="0" label="是">
								<option value="1" label="否">
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
<div class="pd-10">
	<div class="cl pd-5 bg-1 bk-gray"> 
	<span class="l"> <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
	<a class="btn btn-primary radius" href="javascript:;" onclick="admin_menu_add('添加菜单','menuController/toAddMenu','600','580')"><i class="Hui-iconfont">&#xe600;</i> 添加菜单</a> </span></div>
	<table class="table table-border table-bordered table-hover table-bg" id="menuTable">
		<thead>
			<tr>
				<th scope="col" colspan="11">菜单管理</th>
			</tr>
			<tr class="text-c">
				<th width="25"><input type="checkbox" value="" name=""></th>
				<th width="25">ID</th>
				<th width="80">菜单名称</th>
				<th width="160">描述</th>
				<th width="25">类型</th>
				<th width="30">是否发布</th>
				<th width="100">路径</th>
				<th width="120">创建时间</th>
				<th width="80">操作</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${page.list}" var="menu">
			
			<tr class="text-c">
				<td><input type="checkbox" id="delMenu${menu.menuId}" value="${menu.menuId}" name="menuId" ></td>
				<td>${menu.menuId}</td>
				<td>${menu.menuName}</td>
				<td>${menu.descContent}</td>
				<c:if test="${menu.menuType==1}">
					<td>目录</td>
				</c:if>
				<c:if test="${menu.menuType==2}">
					<td>菜单</td>
				</c:if>
				<c:if test="${menu.menuType==3}">
					<td>菜单</td>
				</c:if>
				<c:if test="${menu.isPublish==0}">
					<td>是</td>
				</c:if>
				<c:if test="${menu.isPublish==1}">
					<td>否</td>
				</c:if>
				<td>${menu.menuPath}</td>
				<td><fmt:formatDate value="${menu.createdDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td class="f-14">
					<a title="详情" class="ml-5" href="javascript:;"
					onclick="admin_role_edit('人员详情','menuController/getMenuById/${menu.menuId}','1','500','400')"
					style="text-decoration: none"><i class="Hui-iconfont">&#xe683;</i></a>
					<a title="编辑" class="ml-5" href="javascript:;"
					onclick="admin_menu_edit('菜单编辑','menuController/getMenuById/${menu.menuId}','1','550','600')"
					style="text-decoration: none"><i class="Hui-iconfont">&#xe6df;</i></a>
					<a title="删除" href="javascript:;"
					onclick="admin_menu_del(this,${menu.menuId})" class="ml-5"
					style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a>
					</td>
			</tr>
			
			</c:forEach>
		</tbody>
	</table>
	
	<jsp:include page="/common/page.jsp"/>
	</div>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/layer.js"></script>
	<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>
	<script type="text/javascript" src="js/H-ui.js"></script>
	<script type="text/javascript" src="js/H-ui.admin.js"></script>
	<script type="text/javascript" src="lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="js/oa_utils.js"></script>
	
	<script type="text/javascript">
		/*管理员-角色-添加*/
		function admin_menu_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*管理员-角色-编辑*/
		function admin_menu_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*管理员-角色-删除*/
		function admin_menu_del(obj, id) {
			
			layer.confirm('菜单删除须谨慎，确认要删除吗？', function(index) {
				$.get("menuController/delMenu/"+id,function(data){
					
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
			
			$.get("menu/deleteMenu", obj, function(data){
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
		$(function(){
			
			$("#menuQuery").click(function(){
				debugger
				var param = getQueryParam();
				$("#menuBody").load("menu/getMenuPage", param, function(){
				});
			});
			
			$("#menuReset").click(function(){
				location.reload();
			});
			
			$("#queryMenuType").val("${menu.isPublish}");
		})
			
		/* function getQueryParam(){
				var param ={};
				param.menuParentName = $("#parentName").val();
				param.menuParentId = $("#parentId").val();
				
				param.menuName = $("#queryMenuName").val();
				
				param.isPublish = $("#queryMenuType").val();
			
				return param;
		} */
	</script>
</body>
</html>