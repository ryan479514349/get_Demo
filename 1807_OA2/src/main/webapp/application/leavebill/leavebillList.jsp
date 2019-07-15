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
<title>请假管理</title>
</head>
<body id="userBody">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 流程管理 <span class="c-gray en">&gt;</span> 请假管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>



<div class="pd-10">
	<div class="cl pd-5 bg-1 bk-gray"> <span class="l"> 
		 <a class="btn btn-primary radius" href="javascript:;" onclick="admin_role_add('添加请假申请','application/leavebill/addLeavebill.jsp','600','580')"><i class="Hui-iconfont">&#xe600;</i> 添加请假申请</a> </span>
	 </div>
	<table class="table table-border table-bordered table-hover table-bg" id="userTable">
		<thead>
			<tr>
				<th scope="col" colspan="11">请假申请列表</th>
			</tr>
			<tr class="text-c">
				<th width="25">ID</th>
				<th width="80">请假人</th>
				<th width="50">请假天数</th>
				<th width="120">请假事由</th>
				<th width="120">请假备注</th>			
				<th width="100">请假时间</th>
				<th width="50">请假状态</th>
				<th width="80">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="leavebill">
			
			
			<tr class="text-c">
				<td>${leavebill.id}</td>
				<td>${leavebill.userName}</td>
				<td>${leavebill.days}</td>
				<td>${leavebill.content}</td>
				<td>${leavebill.remark}</td>
				<td><fmt:formatDate value="${leavebill.leavedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
					<c:if test="${leavebill.state == 0}">
						初始录入
					</c:if>
					<c:if test="${leavebill.state == 1}">
						审核中
					</c:if>
					<c:if test="${leavebill.state == 2}">
						审核完成
					</c:if>
					
				</td>
				<td class="f-14">
					<c:if test="${leavebill.state == 0}">
						<a title="启动请假流程" href="workFlowController/startProncessIns?leaveBillId=${leavebill.id}"style="text-decoration: none"><i class="Hui-iconfont">&#xe601;</i></a>
					</c:if>
					<a title="详情" class="ml-5" href="javascript:;"
					onclick="admin_role_edit('请假详情','workFlow/findHistoryInfo?leavebillId=${leavebill.id}','1','600','500')"
					style="text-decoration: none"><i class="Hui-iconfont">&#xe683;</i></a>
					<a title="删除" href="javascript:;"
					onclick="admin_role_del(this,${leavebill.id})" class="ml-5"
					style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<jsp:include page="/common/page.jsp">
		<jsp:param value="userBody" name="tableId"/>
	</jsp:include>
	</div>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/layer.js"></script>
	<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>
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
			debugger
			layer.confirm('确认要删除该请假申请吗？', function(index) {
				debugger
				//此处请求后台程序，下方是成功后的前台处理……
				var param = {};
				param.id = id;
				$.getJSON("leavebill/deleteLeavebill", param, function(data){
					if (data.flag) {
						layer.msg('删除成功', {
							icon : 1,
							time : 1000
						});
						var pageNum = "${page.pageNum}";
						location.href = "leavebill/getLeavebillPage?currentPage="+pageNum;
					}else {
						layer.msg('删除失败', {
							icon : 2,
							time : 1000
						});
					}
					
				});
				
				/* $(obj).parents("tr").remove(); */
			});
		}
		
	</script>
	
	<script type="text/javascript">
		$(function(){
			
			$("#menuQuery").click(function(){
				debugger
				var param = getQueryParam();
				$("#userBody").load("leavebill/getLeavebillPage", param, function(){
				});
			});
			
			$("#menuReset").click(function(){
				location.reload();
			});
			
		})
			
		function getQueryParam(){
				var param ={};
				
				param.userName = $("#queryMenuName").val();
				
				return param;
		}
	</script>
	
</body>
</html>