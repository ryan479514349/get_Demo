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
<link rel="stylesheet" href="lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">

<title>管理员列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 管理员列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
		<div class="text-c">
				<div class="row cl ">
					<label class="form-label col-1">角色：</label>
					<div class="formControls col-1"> <span class="select-box" style="width:150px;">
							<select class="select" id="query_role_id" size="1">
									<option value="">请选择</option>
								<c:forEach items="${roleAll}" var="role">
									<option value="${role.roleId}">${role.roleName }</option>
								</c:forEach>
							</select>
							</span> 
					</div>
					
					<label class="form-label col-5">类型：</label>
					<div class="formControls col-5" style="left: -300px;">
						 <span class="select-box" style="width:150px;">
							<select class="select" id="query_type" size="1">
								<option value="">请选择</option>
								<option value="1">人员</option>
								<option value="0">菜单</option>
							</select>
						</span> 
					</div>
					
				</div>
				<div class="row cl">
					<div class="cl pd-5">
						<button onclick="queryauthorization()" type="button" class="btn btn-success radius" id="" name="">
							<i class="Hui-iconfont">&#xe665;</i> 搜索
						</button>
						<button type="reset" onclick="javascript:location.replace(location.href)" class="btn btn-success radius" id="" name="">
							<i class="Hui-iconfont">&#xe66b;</i> 重置
						</button>
					</div>
				</div>	
		</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l">
			<a href="javascript:;" onclick="authorizationUser()" class="btn btn-primary radius">
				<i class="Hui-iconfont">&#xe600;</i> 授权人员
			</a> 
			<a href="javascript:;" onclick="authorizationMenu()" class="btn btn-primary radius">
				<i class="Hui-iconfont">&#xe600;</i> 授权菜单
				
			</a> 		
		</span> 
	</div>
	<table class="table table-border table-bordered table-bg" id="authorizationTable">
	</table>
	
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>  
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript" src="js/oa_utils.js"></script>
<script type="text/javascript" src="lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="lib/zTree/v3/js/jquery.ztree.excheck-3.5.min.js"></script>
<script type="text/javascript">


function getSelectRoleId(){
	// 1.判断用户是否选择角色
	var roleId = $("#query_role_id").val();
	if(roleId == ""){
		alert("请先选择角色");
		return false;
	}
	return roleId;
}

function queryauthorization(){

	var roleId = getSelectRoleId();
	
	if(!roleId){
		return ;
	}
	
	
	var queryType=$("#query_type").val();
	
	// 2.判断用户查询的类型
	if(queryType == "1"){ // 查询人员
		$("#authorizationTable").load("authorizationController/getUserListByRoleId/"+roleId);
	}else if(queryType == "0"){ // 查询菜单
		$("#authorizationTable").load("authorizationController/getMenuListByRoleId/"+roleId);
	}
	
}


function authorizationUser(){
	//获取角色是否被选择
	var roleId = getSelectRoleId();
	if(!roleId){
		return ;
	}
	
	layer_show("授权用户","authorizationController/findNoRoleIdUserList/"+roleId,"800","400");
}
function authorizationMenu(){
	//获取角色是否被选择
	var roleId = getSelectRoleId();
	if(!roleId){
		return ;
	}
	
	
	// 1.首先弹一格框
	layer.open({
		  type: 1,
		  title: false,
		  area: ['300px', '300px'],
		  closeBtn: 1,
		  shadeClose: true,
		  skin: 'yourclass',
		  content: htmlString1("授权菜单")
		});
	
	
	
	// 2.初始化树
	 var setting = {   

	 check: {
			enable: true,
			chkStyle: "checkbox",
			chkboxType: { "Y": "ps", "N": "ps" }
		},
			
       data: {    
           simpleData: {    
               enable: true  //使用简单 Array格式的数据 
           }    
       },
       async: {    
           enable: true, //开启异步加载处理   
           url:"authorizationController/getMenuTreeByParentId/"+roleId,    
           autoParam:["id"],   // 传递的参数  
           dataType: "json",//默认text  
           type:"get"//请求的方式
       }
   };    
	     
    // 初始化的树
    var  zTreeObj = $.fn.zTree.init($("#QueryTree"), setting); 
}

//表单的HTML代码
function htmlString1(treeTitle){
	var htmlStr = "";
		htmlStr += '<div style="width:300px;height:200px" >';
		htmlStr += '<div style=" line-height:30px; text-indent:10px; margin-bottom:20px; background-color:#eee; position:relative;">'+treeTitle+'</div>';
		htmlStr += '<div style="display:block; padding-bottom:5px;" align="center"  >';
		htmlStr += '<div style="padding-bottom:5px"><table><tr><td><input type="hidden" id="tmp_Id"/><input type="text" id="tmp_Name" width="50px"><button onclick="getTreeNode();">确定</button></td></tr></table></div>';
		htmlStr += '<div id="QueryTree" class="ztree"></div>';
		htmlStr += '</div>';
		htmlStr += '</div>';
	return htmlStr;
}
//确定提交
function getTreeNode(){
		debugger
	  var treeObj=$.fn.zTree.getZTreeObj("QueryTree"),
      nodes=treeObj.getCheckedNodes(true);
      var menuIds =new Array();
      for(var i=0;i<nodes.length;i++){
    	  menuIds[i]=nodes[i].id
      }
      
      //获取角色id
      var roleId = $("#query_role_id").val();
      //定义一个参数对象装数组
      var param =new Object;
      //将数数据放入对象中
      param.menuIds=menuIds;
    //  param.roleId=roleId;
      
      $.post("authorizationController/updateAuthorizationMenu/"+roleId,param,function(data){
    	 
    	  //操作成功失败提示框
    	  responseMessage(data)
      },"json")
      //获取当前框
       var index =	layer.index
		//关闭当前框
       layer.close(index)
}
</script>
</body>
</html>