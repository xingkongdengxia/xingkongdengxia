function login() { 
	var ming = $("#ming").val();  
	var mi = $("#mi").val();  
	
	var value = {"ming":ming,"mi":mi};
	$.ajax({        
		url: '/weiyiuserControler/index/login',        
		type: 'post',        
		contentType: 'application/json;charset=utf-8',        
		data: JSON.stringify(value),
//		dataType:'json',
		cache: false,//文件不设置缓存
		success: function (result) {
			 var xiao=$.parseJSON(result).xiaoxi;
			 if(xiao != undefined){
				 $("#xiaoxi").html(xiao);
			 }else{
				 window.location.href = "http://localhost:8080/weiyiuserControler/zhuye";
			 }
			console.log("success!");        
			},        
		error: function () { 
			console.log("change room fail!");        
			}    
		});
	}


function qingxiaoxi() { 
	$("#xiaoxi").html("");  
	}


