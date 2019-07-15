// 表单的HTML代码
function htmlString(){
	var htmlStr = "";
		htmlStr += '<div style="width:300px;height:200px" >';
		htmlStr += '<div style=" line-height:30px; text-indent:10px; margin-bottom:20px; background-color:#eee; position:relative;">组织</div>';
		htmlStr += '<div style="display:block; padding-bottom:5px;" align="center"  >';
		htmlStr += '<div><table><tr><td><input type="hidden" id="tmp_id" width="50px"/><input type="text" id="tmp_name" width="50px"><button onclick="SetQueryOrgTreeParam();">确定</button></td></tr></table></div>';
		htmlStr += '<div id="QueryTree" class="ztree"></div>';
		htmlStr += '</div>';
		htmlStr += '</div>';
	return htmlStr;
}


/**
 * 以树的形式列车所有部门
 */
function getModeTree(url){
	
	// 1.新打开一个框
	layer.open({
		  type: 1,
		  title: false,
		  area: ['300px', '300px'],
		  closeBtn: 0, // 没有关闭按钮
		  shadeClose: true,
		  skin: 'yourclass',
		  content: htmlString()
		});

	// 2.在框中嵌一个树
	initTreeObj(url); // 初始化树插件

}

// 初始化树插件
function initTreeObj(url){
	 
	// 参数对象
	 var setting = {   
        data: {    
            simpleData: {    
                enable: true  //使用简单 Array格式的数据 
            }    
        },
        async: {    
            enable: true, //开启异步加载处理   
            url:url,    
            autoParam:["id"],   // 传递的参数  
            dataType: "json",//默认text  
            type:"get"//请求的方式
        }  
        ,callback:{  
            onClick:ClickQueryTreeNodeFunc
        }  
    };    
	     
     // 初始化的树
     var  zTreeObj = $.fn.zTree.init($("#QueryTree"), setting); 
}

// 点击树节点触发的函数
function ClickQueryTreeNodeFunc(event, treeId, treeNode){
// 	console.info("用户点击了[name]:"+treeNode.name);
// 	console.info("用户点击了[id]:"+treeNode.id);
	//来自树插件表单隐藏域 
	$("#tmp_name").val(treeNode.name);
	$("#tmp_id").val(treeNode.id);
}

// 把用户选择的父部门给表单赋值
function SetQueryOrgTreeParam(){
	$("#parentId").val($("#tmp_id").val());
	$("#parentName").val($("#tmp_name").val());
	
	// 关闭弹出框
	debugger
// 	layer_close();
	// 获取最新框的索引
	var index = layer.index;
	
	// 关闭框
	layer.close(index);
}

//异步提交,取得返回值
function submitForm(fromId,url){
	
	// 1.把对象中的参数封装成一个对象
	var param = fromToObject(fromId);
	
	// 2.提交表单
	$.post(url,param,function(data){ // 表单异步提交
		responseMessage(data);
	},"JSON");
	
}

// 提示用户成功或者失败
function responseMessage(data){
	if(data.flag){
		layer.msg(data.msg, {icon: 1,time: 1000},function(){
			layer_close();
			location.reload();
		});
	}else{
		layer.msg(data.msg, {icon: 2,time: 1000},function(){
			layer_close();
			location.reload();
		});
	}
	
}
//获取表单属性和值
function fromToObject(fromId){
	
	// 1.创建一个对象
	var param = new Object();  // 创建一个对象用来装表单参数
	
	// 返回的就是表单的对象数组
	var paramArray = $("#"+fromId).serializeArray(); 
	for(var i =0;i<paramArray.length;i++){
		var name = paramArray[i].name; // 表单中的属性名称
		var value = paramArray[i].value; // 表单中的属性值
		
		param[name]= value; // 表单属性和属性值放入param对象中
	}
	return param;
}
//时间工具
Date.prototype.format = function(fmt) { 
    var o = { 
       "M+" : this.getMonth()+1,                 //月份 
       "d+" : this.getDate(),                    //日 
       "h+" : this.getHours(),                   //小时 
       "m+" : this.getMinutes(),                 //分 
       "s+" : this.getSeconds(),                 //秒 
       "q+" : Math.floor((this.getMonth()+3)/3), //季度 
       "S"  : this.getMilliseconds()             //毫秒 
   }; 
   if(/(y+)/.test(fmt)) {
           fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
   }
    for(var k in o) {
       if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
   return fmt; 
}
