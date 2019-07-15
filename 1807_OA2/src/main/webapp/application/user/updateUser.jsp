<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>     
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
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">

<title>添加用户</title>
</head>
<body>
<div class="pd-20">
	<form action="userController/updateUser" method="post" class="form form-horizontal" id="form-user-update">
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-5">
				<input type="hidden" name="userId" value="${user.userId}"/>
				<input type="text" class="input-text" value="${user.userName}" placeholder="" id="userName" name="userName" datatype="*2-16" nullmsg="用户名不能为空">
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>部门：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text"  placeholder="" value="${user.orgName}" id="parentName" name="orgName" disabled="disabled" datatype="*" nullmsg="父组织不能为空">
				<input type="hidden" name="orgId" id="parentId" value="${user.orgId}"/>
				<button id="btn-star" type="button" class="btn btn-default" onclick="getModeTree('orgController/getOrgList')">选择组织</button>
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>生日：</label>
			<div class="formControls col-5">
				<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'userBirthday\')}',maxDate:'%y-%M-%d'})" value="${user.userBirthday}" name="userBirthday" id="userBirthday" class="input-text Wdate" style="width:120px;">
			</div>
			<div class="col-4"> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>性别：</label>
			<div class="formControls col-5 skin-minimal">
				<div class="radio-box">
					<input type="radio" id="sex-1"  value="1" name="userSex" datatype="*" nullmsg="请选择性别！">
					<label for="sex-1">男</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="sex-2"  value="0" name="userSex">
					<label for="sex-2">女</label>
				</div>
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>手机：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="${user.mobilePhone}" placeholder="" id="user-tel" name="mobilePhone"  datatype="m" nullmsg="手机不能为空">
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>邮箱：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="${user.email}" placeholder="@" name="email" id="email" datatype="e" nullmsg="请输入邮箱！">
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3">家乡：</label>
			<div class="formControls"> 
				<span class="select-box" style="width:100px;">
					<input type="hidden" name="provinceName" id="provinceName" value="${user.provinceName}">
					<select class="select" name="provinceId" id="provinceId" size="1">
					</select>
				</span> 
				<span class="select-box" style="width:100px;">
					<input type="hidden" name="cityName" id="cityName" value="${user.cityName}"/>
					<select class="select" name="cityId" id="cityId" size="1">
					</select>
				</span> 
				<span class="select-box" style="width:100px;">
					<input type="hidden" name="contryName" id="contryName"  value="${user.contryName}">
					<select class="select" name="countryId" id="contryId" size="1">
					</select>
				</span> 
			</div>
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
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script>
 
<script type="text/javascript" src="js/oa_utils.js"></script> 
<script type="text/javascript" src="js/getArea.js"></script> 
<script type="text/javascript" src="lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script>

<!-- 日期的插件 -->
<script type="text/javascript" src="/1807_OA2/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	//初始化树 方法在oa.js中
	$("#form-user-update").Validform({
		tiptype:2,
		callback:function(form){
			//参数1:表单id 参数2:url
			submitForm("form-user-update","userController/updateUser");			
			return false;
		}
	});
	
	//处理时间类型回显示
	//获取时间数据
	debugger
	var userBrithday ="${user.userBirthday}";
	
	//把字符串转为long类型
	var longDate = Date.parse(userBrithday);
	debugger
	//把long类型的时间转换成date,并且格式化(调的是OA.js里的时间格式化工具)
	var foramtUserBirthday =  new Date(longDate).format("yyyy-MM-dd");
	//赋值
	$("#userBirthday").val(foramtUserBirthday);
	
	
	//处理性别
	var userSex = "${user.userSex}";
	
	if(userSex=="1"){
		$("#sex-1").iCheck("check");
	}else{
		$("#sex-2").iCheck("check");
	}
	
	//处理初始化省市县
	var provinceId="${user.provinceId}";
	var cityId ="${user.cityId}";
	var contryId="${user.countryId}";
	
	//在加载时初始化省 调用getArea
	// 初始化省市县 provinceName,cityName,contryName 
	CascadeArea(provinceId,cityId,contryId,"provinceId","cityId","contryId");
});
</script>
</body>
</html>