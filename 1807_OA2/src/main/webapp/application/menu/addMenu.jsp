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
<link rel="stylesheet" href="lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<title>添加菜单</title>
</head>
<body>
<div class="pd-20">
	<form action="menuController/addMenu" method="post" class="form form-horizontal" id="form-menu-add">
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>菜单名称：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="" placeholder="" id="menuName" name="menuName" datatype="*2-16" nullmsg="菜单名称不能为空">
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>所属目录：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" value="" placeholder=""
						id="parentName" name="menuParentName" datatype="*2-8"
						nullmsg="所属菜单不能为空" errormsg="所属菜单的长度必须是2~8位" readonly="readonly">
					
					<input type="hidden" id="parentId" name="menuParentId" >
					
					<input type="button" class="btn btn-default" value="菜单" onclick="getModeTree('menuController/findMenuTree')">
				</div>
				<div class="col-4"></div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red"></span>路径：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="" placeholder="" id="menuPath" name="menuPath" >
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red"></span>permissionCode：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="" placeholder="" id="permissionCode" name="permissionCode" >
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>类型：</label>
				<div class="formControls col-5"> 
					<span class="select-box" style="width:150px;">
						<select class="select" id="menuType" name="menuType" size="1" datatype="*" nullmsg="类型不能为空">
							<option value="1" label="目录">
							<option value="2" label="菜单">
						</select>
					</span>
				</div>
				<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>状态：</label>
				<div class="formControls col-5"> 
					<span class="select-box" style="width:150px;">
						<select class="select" id="isPublish" name="isPublish" size="1" datatype="*" nullmsg="状态不能为空">
							<option value="0" label="启用">
							<option value="1" label="禁用">
						</select>
					</span>
				</div>
				<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3">菜单描述：</label>
			<div class="formControls col-5">
				<textarea id="descContent" name="descContent" cols="" rows="" class="textarea"  placeholder="请输入邮件内容...150个字符以内" dragonfly="true" onKeyUp="textarealength(this,150)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/150</p>
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<div class="col-9 col-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
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
	<script type="text/javascript" src="lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="js/oa_utils.js"></script>
<script type="text/javascript" src="js/getArea.js"></script>

<script type="text/javascript">
	$(function(){
		$('.skin-minimal input').iCheck({
			checkboxClass: 'icheckbox-blue',
			radioClass: 'iradio-blue',
			increaseArea: '20%'
		});
		//树表单初始化
		$("#form-menu-add").Validform(
			{
				tiptype : 2,
				callback : function(form) {
				submitForm("form-menu-add","menuController/addMenu");
				return false;
			}
		});
		
	});
	
	//
</script>
</body>
</html>