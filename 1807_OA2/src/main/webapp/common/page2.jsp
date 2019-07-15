<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<base href="<%=request.getContextPath() + "/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<link rel="stylesheet" href="lib/layer/ui/css/layui.css" media="all">
	<script src="lib/layer/ui/layui.js"></script>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<body>

	<div id="test1"></div>
	<script>
		// 获取bodyId
		var bodyId = $("body").attr("id");
		var tableId = "${param.tableId}";
		if(!bodyId){
			bodyId= tableId;	
		}
		
		// 初始化分页导航条
		layui.use('laypage', function() {
			var laypage = layui.laypage;

			//执行一个laypage实例
			laypage.render({
				elem : 'test1', //注意，这里的 test1 是 ID，不用加 # 号
				count : "${page.total}", // 总条数
				limit:"${page.pageSize}", // 每页显示的条数
				curr:"${page.pageNum}", // 当前页
				layout: ['prev', 'page', 'next', 'limit','count'],
				jump: function(obj, first){
				    //首次不执行
				    if(!first){
				    	// 查询下一页的数据
						$("#" + bodyId).load("${url}pageNum=" + obj.curr + "&pageSize=" + obj.limit, getQueryParam());
					}
				}
			});
		});

		// 获取含查询条件时的模块的查询参数，仅作接口使用，需要在查询页面重写
		function getQueryParam() {
		}
	</script>
</body>
</html>