<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath() + "/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="lib/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<title>添加角色</title>
</head>
<body>
	<div class="pd-20">
		<form action="roleController/addRole" method="post" class="form form-horizontal"
			id="form-role-add">
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>角色名称：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" value="" placeholder=""
						id="roleName" name="roleName" datatype="*2-8" nullmsg="角色名不能为空"
						errormsg="角色名称的长度必须是2~8位">
				</div>
				<div class="col-4"></div>
			</div>
			<!-- <div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>父组织名称：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" value="" placeholder=""
						id="parentOrgName" name="parentOrgName" datatype="*2-8"
						nullmsg="用户名不能为空" errormsg="组织名称的长度必须是2~8位" readonly="readonly">
					
					<input type="hidden" id="parentOrgid" name="parentOrgid" >
					
					<input type="button" class="btn btn-default" value="父组织" onclick="selectParentOrg()">
				</div>
				<div class="col-4"></div>
			</div> -->
			<div class="row cl">
				<div class="row cl">
					<label class="form-label col-3"><span class="c-red"></span>是否可用：</label>
					<div class="formControls col-5">
						<span class="select-box" style="width: 150px;"> <select
							class="select" name="state" size="1">
								<!-- option -->
								<option value="0">是
								<option value="1">否
						</select>
						</span>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-3">角色描述：</label>
					<div class="formControls col-5">
						<textarea id="roleDesc" name="roleDesc" cols="" rows="" class="textarea"
							dragonfly="true" onKeyUp="textarealength(this,100)" placeholder="说点什么...100个字符以内"></textarea>
						<p class="textarea-numberbar">
							<em class="textarea-length">0</em>/100
						</p>
					</div>
					<div class="col-4"></div>
				</div>
				<div class="row cl">
					<div class="col-9 col-offset-3">
						<input class="btn btn-primary radius" type="submit"
							value="&nbsp;&nbsp;添加&nbsp;&nbsp;">
					</div>
				</div>
		</form>
	</div>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script>
	<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>
	<script type="text/javascript" src="lib/layer/layer.js"></script>
	<script type="text/javascript" src="js/H-ui.js"></script>
	<script type="text/javascript" src="js/H-ui.admin.js"></script>
	<script type="text/javascript" src="lib/zTree/js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="js/oa_utils.js"></script>
	<script type="text/javascript">
		$(function() {
			$('.skin-minimal input').iCheck({
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue',
				increaseArea : '20%'
			});

			$("#form-role-add").Validform(
				{
					tiptype : 2,
					callback : function(form) {
					debugger
					submitForm("form-role-add", "roleController/addRole");
					return false;
				}
			});
		});
		
		//
		

	</script>
</body>
</html>