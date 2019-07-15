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

<!-- 引入树插件的样式文件 -->
<link rel="stylesheet" href="lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">

<title>添加管理员</title>
</head>
<body>
<div class="pd-20">
	<form action="orgController/addOrg" method="post" class="form form-horizontal" id="form-admin-add">
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>组织名称：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="Java教学部" placeholder=""  id="orgName" name="orgName" datatype="*3-8" nullmsg="组织名称不能为空" errormsg="名称只能是3~8的字符串">
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>父组织名称：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="2" placeholder="" id="orgParentId" name="orgParentId" datatype="n" nullmsg="父组织不能为空">
				<button id="btn-star" type="button" class="btn btn-default" onclick="getParentOrg()">选择组织</button>
			</div>
			<!-- 表单验证错误信息的 -->
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>显示顺序：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="1" placeholder="" id="dispIndex" name="dispIndex" datatype="n" nullmsg="显示顺序不能为空">
			</div>
			<div class="col-4"> </div>
		</div>
		
		
		<div class="row cl">
			<label class="form-label col-3">是否可用：</label>
			<div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" name="state" size="1">
					<option value="0">禁用</option>
					<option value="1" selected="selected">可用</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3">描述：</label>
			<div class="formControls col-5">
				<textarea name="orgDesc" cols="" rows="" class="textarea"  placeholder="说点什么...100个字符以内" dragonfly="true" onKeyUp="textarealength(this,100)">描述desc</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
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
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<!-- 树插件的js文件 -->
<script type="text/javascript" src="lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	// 表单初始化，用来表单验证
	$("#form-admin-add").Validform({
		tiptype:2,
		callback:function(form){ // 表单全部验证成功后才会进入回调函数
			debugger
			form[0].submit(); // 手动提交表单
			
			// 关闭添加组织的页面(框)
			
			// 获取当前最新的弹框id
			var index = parent.layer.getFrameIndex(window.name);
// 			parent.$('.btn-refresh').click();	

			// 关闭弹框
			parent.layer.close(index);
			
			// 如果callback里明确return false，则表单不会提交，如果return true或没有return，则会提交表单。
			return false;
// 			return true;
		}
	});
	
});

// 表单的HTML代码
function htmlString(){
	var htmlStr = "";
		htmlStr += '<div style="width:300px;height:200px" >';
		htmlStr += '<div style=" line-height:30px; text-indent:10px; margin-bottom:20px; background-color:#eee; position:relative;">组织</div>';
		htmlStr += '<div style="display:block; padding-bottom:5px;" align="center"  >';
		htmlStr += '<div><table><tr><td><input type="hidden" id="tmp_orgId" width="50px"/><input type="text" id="tmp_orgName" width="50px"><button onclick="SetQueryOrgTreeParam();">确定</button></td></tr></table></div>';
		htmlStr += '<div id="QueryOrgTree" class="ztree"></div>';
		htmlStr += '</div>';
		htmlStr += '</div>';
	return htmlStr;
}


/**
 * 以树的形式列车所有部门
 */
function getParentOrg(){
	
	// 1.新打开一个框
	layer.open({
		  type: 1,
		  title: false,
		  closeBtn: 0, // 没有关闭按钮
		  shadeClose: true,
		  skin: 'yourclass',
		  content: htmlString()
		});

	// 2.在框中嵌一个树
	QueryOrgTreeObj();

}

// 初始化树插件
function QueryOrgTreeObj(){
	 
	 var setting = {   
        data: {    
            simpleData: {    
                enable: true  //使用简单 Array格式的数据 
            }    
        },
        async: {    
            enable: true, //开启异步加载处理   
            url:"orgController/getOrgList",    
            autoParam:["id"],   // 传递的参数  
            dataType: "json",//默认text  
            type:"get"//请求的方式
        }  
//         ,callback:{  
//             onClick:ClickQueryOrgTreeNodeFunc
//         }  
    };    
	     
     var zNodes=[];  
     // 初始化的树
     var  zTreeObj = $.fn.zTree.init($("#QueryOrgTree"), setting, zNodes); 
}


</script>
</body>
</html>