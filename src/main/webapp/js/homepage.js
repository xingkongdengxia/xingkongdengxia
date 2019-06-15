$(function(){//加载
	//$("#drive").hide();//隐藏
	
	//$dataTableHot.bootstrapTable('refresh');
	$("#datajstl").load("http://localhost:8080/weiyiuserControler/usertablejstl #datajstl");
	
	//新增
	$("#add").click(function(){
		$("#pai").html("新增");
		$("#drive").show();//显示
	});
	
	//修改
	$("#update").click(function(){
		//获取复选框选中个数
		var tabledata= $("#usertable").bootstrapTable('getSelections');
		if(tabledata.length != 1){//判断有没有选择数据
			alert("请选中一条数据!");
		}else{
//			var id = "";//获取数据id
//			var checkid=$("input[name='checkid']").each(function(){//遍历每一个名字为checkid的复选框，其中选中的执行函数    
//				id=$(this).val();    
//	        });
			 $("#weiyiid").val(tabledata[0].id);
			 $("#name").val(tabledata[0].param_name);
			 $("#pwd").val(tabledata[0].param_value);
			 $("#pai").html("修改");
			 $("#drive").show();//显示
			
		}
	});
	
	//删除
	$("#del").click(function(){
		
		  //获取复选框
		var weiyiuser ="";
		var tabledata= $("#usertable").bootstrapTable('getSelections');
		if(tabledata.length >= 0){//判断有没有选择数据
			for(var i = 0;i<tabledata.length;i++){
				var string=tabledata[i].id;
				if(weiyiuser==""){
					weiyiuser=string
				}else{
					weiyiuser = weiyiuser+","+string;
				}
			}
		}
        if(confirm("确定编号为"+weiyiuser+"的客户吗?")){
        	//提交数据
    		$.ajax({        
    			url: "/weiyiuserControler/WeiyiuserBydel",        
    			type: 'post',        
    			contentType: 'application/json;charset=utf-8',        
    			data: JSON.stringify(weiyiuser),
//    			dataType:'json',
    			cache: false,//文件不设置缓存
    			success: function (result) {
    				if(result == 'true'){
    			        /*$("#data").load("/weiyiuserControler/zhuye #data",null,function(){alert("加载成功")});*/
//    					$.get('/weiyiuserControler/zhuye#flsh',function(data){$("#flsh").html(data)});
    					$("#drive").hide();//隐藏
    					$("#usertable").bootstrapTable('refresh');
    				}
    				console.log("success!");        
    				},        
    			error: function () { 
    				console.log("change room fail!");        
    				}    
    			});
        	}
     
	});
	
	//提交
	$("#sum").click(function(){
		
		var id = $("#weiyiid").val();  
		var param_name = $("#name").val();  
		var param_value = $("#pwd").val();  
		var url;
		var string=$("#pai").html();
		var value;
		if(string == '修改'){
			value = {"id":id,"param_name":param_name,"param_value":param_value};
			url = '/weiyiuserControler/WeiyiuserByupdate';
		}
		if(string == '新增'){
			value = {"param_name":param_name,"param_value":param_value};
			url = '/weiyiuserControler/WeiyiuserByinsert';
		}
		 
		
		//提交数据
		$.ajax({        
			url: url,        
			type: 'post',        
			contentType: 'application/json;charset=utf-8',        
			data: JSON.stringify(value),
//			dataType:'json',
			cache: false,//文件不设置缓存
			success: function (result) {
				if(result == 'true'){
			        /*$("#data").load("/weiyiuserControler/zhuye #data",null,function(){alert("加载成功")});*/
//					$.get('/weiyiuserControler/zhuye#flsh',function(data){$("#flsh").html(data)});
					$("#drive").hide();//隐藏
					 $("#usertable").bootstrapTable('refresh');
				}
				console.log("success!");        
				},        
			error: function () { 
				console.log("change room fail!");        
				}    
			});
		
	});
	$("#cal").click(function(){
		//清空表格
		$("#weiyiid").val("");
		$("#name").val("");
		$("#pwd").val("");
		 
		$("#drive").hide();//隐藏
	});
	
	
	   $("#usertable").bootstrapTable({
         search: false,
         pagination: true,
         pageSize: 10,
         pageList: [10, 15, 20],
         //showColumns: true,
         locale: "zh-CN",
         striped: true,
         toggle:true,
         idField:"id",
         ajax:function(request) {
             $.ajax({
                 url:"http://localhost:8080/weiyiuserControler/usertableData",
                 type:"GET",
                 dataType:"json",
                 //data:{},
                 success:function(result){
                	 
                     request.success({
                         row : result
                     });
                     $('#usertable').bootstrapTable('load', result);
                 },
                 error:function(error){
                     console.log(error);
                 }
             })
         },
         columns: [{                
			 checkbox: true            
			 }, {                
				 field: 'id',                
				 title: '用户编号',                
				 align: 'left'           
			 }, {                
				 field: 'param_name',                
				 title: '用户名称',                
				 align: 'left'            
			 }, {                
				 field: 'param_value',                
				 title: '用户密码',                
				 align: 'left'            
			 }, {                
				 field: 'power',                
				 title: '权限',                
				 align: 'left' ,
				 formatter: function (value, row, index) {
					 var option;
					 option = "<select class='form-control' id='power'"+index+"'  disabled='disabled'>"
					 var headOption ="<option value='' >未设置</option>";
					 if(value =='0'){
						 headOption = headOption + "<option value='"+value+"' selected>管理员</option>";
					 }
					 if(value =='1'){
						 headOption = headOption + "<option value='"+value+"' selected>普通员工</option>";
					 }
					 option = option+headOption+'</select>'
					 return option;
				}
		}]
     });
	
});