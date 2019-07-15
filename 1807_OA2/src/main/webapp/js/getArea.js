/*
 * author:xu.hongsheng
 */

var getArea = new GetArea();
//初始化下拉框参数
//参数顺序：省份id，地市id、区县id、省份元素id，地市元素id、区县元素id
function CascadeArea(provinceId,cityId,countyId,eprovinceId,ecityId,ecountyId) {	
		getArea.getProvinces('1',provinceId,eprovinceId,ecityId);
      	getArea.getCity(provinceId,cityId,ecityId,ecountyId);
      	getArea.getCounty(cityId,countyId,ecountyId);      	 
      	
	    $("#"+ecityId).click(
			function() {
				
				var pGeoId = $("#"+eprovinceId+"  option:selected").val();
				if (!pGeoId) {
					alert("请选择省份！");
					return;
				}
			});

    	$("#"+ecountyId).click(
			function() {
				var pGeoId = $("#"+eprovinceId+"  option:selected").val();
				if (!pGeoId) {
					alert("请选择省份！");
					return;
				}
				var cGeoId = $("#"+ecityId+"  option:selected").val();
				if (!cGeoId) {
					alert("请选择地市！");
					return;
				}

			});
    	
//    	//省份下拉框志改变，清空地市、区县数据
    	$("#"+eprovinceId).change(function() {
    		$("#"+ecityId+" option").remove();
    		$("#"+ecountyId+" option").remove();
    		

    		// 给省隐藏于赋值
    		$("#provinceName").val($("#provinceId").find("option:selected").text());
    		//查询下一级区域
    		var pId=$("#"+eprovinceId).val();
    		//预加载地市
    		getArea.getCity(pId,null,ecityId);
    		//初始化区县
    		getArea.getCounty(null,null,ecountyId);
    	});
    	//地市下拉框值改变，清空区县数据
    	$("#"+ecityId).change(function() {
    		$("#"+ecountyId+" option").remove(); 
    		//查询下一级区域
    		var cId=$("#"+ecityId).val();
    		//给城市赋值
    		$("#cityName").val($("#cityId").find("option:selected").text());
    		
    		//预加载区县
    		getArea.getCounty(cId,null,ecountyId);
    	});		
    	
    	$("#"+ecountyId).change(function() {
    		//给县辅助
    		$("#contryName").val($("#contryId").find("option:selected").text());
    	});		
}

function GetArea(){
	
	// 初始化省级区域
	this.getProvinces = function(chId,provinceId,eprovinceId,ecityId){
		// 初始化省级区域
		var len = $("#"+eprovinceId+"  option").length;
		if (len <= 1) {
			var areaId = chId;
			$.getJSON("/1807_OA2/areaController/getAreaListByParentId/"+areaId,function(data) {
				var pObj = $("#"+eprovinceId);
				$.each(data, function(keyi, items) {
					pObj.append("<option value='" + items.areaId + "'>"
							+ items.areaName + "</option>");
				});
				 //初始化下拉框
				if(provinceId){
					 $("#"+eprovinceId).val(provinceId); 
					//预加载地市
			    	getArea.getCity(provinceId,null,ecityId); 
				}
			});// getJson
		}
	}
	
	this.getCity = function(provinceId,cityId,ecityId,ecountyId){
		var cObj = $("#"+ecityId);
		var len = $("#"+ecityId+"  option").length;
		if (len < 1) {
	     	cObj.append("<option value=''>请选择:</option>");  
		}
		if(provinceId){
			if (len <= 1) {
				$.getJSON("/1807_OA2/areaController/getAreaListByParentId/"+provinceId, function(data) {
					$.each(data, function(keyi, items) {
						cObj.append("<option value='" + items.areaId + "'>"
								+ items.areaName + "</option>");
					});
					if(cityId){
						 $("#"+ecityId).val(cityId); 
						//预加载区县
				    	getArea.getCounty(cityId,null,ecountyId);
					}
	
				});// getJson
			}
		}
	}
	
    this.getCounty = function(cityId,countyId,ecountyId){
    	var coObj = $("#"+ecountyId);
    	var len = $("#"+ecountyId+"  option").length;
    	if (len < 1) {
    		coObj.append("<option value=''>请选择:</option>");  
		}
		if(cityId){
			if (len <= 1) {
				$.getJSON("/1807_OA2/areaController/getAreaListByParentId/"+cityId, function(data) {
					$.each(data, function(keyi, items) {
						coObj.append("<option value='" + items.areaId
								+ "'>" + items.areaName + "</option>");
					});
					if(countyId){
						 $("#"+ecountyId).val(countyId); 
					}
				});// getJson
			}
		}
	}
	

}
