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
<title>添加请假申请</title>
</head>
<body>
<div class="pd-20">
	<form action="" method="post" class="form form-horizontal" id="form-menu-add">
		
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>请假天数：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="" placeholder="" id="days" name="days" datatype="*1-3" nullmsg="请假天数不能为空" errorsmg="请输入1-3位请假天数">
			</div>
			<div class="col-4"> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>请假事由：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="" placeholder="" id="content" name="content" datatype="*2-50" nullmsg="请假事由不能为空" errorsmg="请假事由为2-50字">
			</div>
			<div class="col-4"> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-3">请假备注：</label>
			<div class="formControls col-5">
				<textarea id="remark" name="remark" cols="" rows="" class="textarea"  placeholder="请输入请假备注...150个字符以内" dragonfly="true" onKeyUp="textarealength(this,150)"></textarea>
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
<script type="text/javascript" src="js/oa_utils.js"></script>
<script type="text/javascript" src="js/getArea.js"></script>

<script type="text/javascript">
	$(function(){
		$('.skin-minimal input').iCheck({
			checkboxClass: 'icheckbox-blue',
			radioClass: 'iradio-blue',
			increaseArea: '20%'
		});
		
		$("#form-menu-add").Validform(
			{
				tiptype : 2,
				callback : function(form) {
				submitForm("form-menu-add","leavebillController/addLeavebill");		
				return false;
			}
		});
		
	});
	
	//
</script>
</body>
</html>