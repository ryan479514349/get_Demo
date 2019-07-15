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
<!-- <link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" /> -->
<title>管理员列表</title>
</head>
<body id="user_list_body">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 管理员列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<div class="pd-20">
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="4">流程部署信息表</th>
			</tr>
			<tr class="text-c">
				<th width="40">部署ID</th>
				<th width="80">部署名称</th>
				<th width="80">发布时间</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${deploymentList}" var="deployment">
					<tr class="text-c">
						<td>${deployment.id}</td>
						<td>${deployment.name}</td>
						<td><fm:formatDate value="${deployment.deploymentTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td class="td-manage">
							<a title="删除" href="javascript:;" onclick="user_delete(this,'${user.userId}')" class="ml-5" style="text-decoration:none">
								<i class="Hui-iconfont">&#xe6e2;</i>
							</a>
						</td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div class="pd-20">
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="8">流程定义信息表</th>
			</tr>
			
			<tr class="text-c">
				<th width="40">流程定义ID</th>
				<th width="80">名称</th>
				<th width="80">流程定义Key</th>
				<th width="80">流程定义版本</th>
				<th width="80">流程定义规则文件名称</th>
				<th width="80">流程定义规则图片名名</th>
				<th width="80">流程定义部署ID</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${processDefinitionList}" var="pd">
					<tr class="text-c">
						<td>${pd.id}</td>
						<td>${pd.name}</td>
						<td>${pd.key}</td>
						<td>${pd.version}</td>
						<td>${pd.resourceName}</td>
						<td>${pd.diagramResourceName}</td>
						<td>${pd.deploymentId}</td>
						<td class="td-manage">
							<a title="" target="_blank" href="workFlowController/getProcessPng?id=${pd.deploymentId}&name=${pd.diagramResourceName}"  class="ml-5" style="text-decoration:none">
							查看流程图
							</a>
						</td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div class="pd-20">
	<form action="workFlowController/addDeploy" method="post" class="form form-horizontal" enctype="multipart/form-data">
		<div class="row cl">
			<label class="form-label col-3">名称：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" name="name" datatype="*2-16" nullmsg="角色名不能为空">
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-2">流程图：</label>
			<span class="btn-upload form-group">
			<input class="input-text upload-url" type="text" name="uploadfile-2" id="uploadfile-2" readonly  datatype="*" nullmsg="请添加附件！" style="width:200px">
				<a href="javascript:void();" class="btn btn-primary upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
				<input type="file" multiple name="file" class="input-file">
			</span> 
		</div>
		
		<div class="row cl">
			<div class="col-9 col-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</div>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>  
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script> 
<!-- <script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script> --> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript" src="js/oa_utils.js"></script>
<script type="text/javascript">
</script>
</body>
</html>