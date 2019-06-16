<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/homepage.css" media="all" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/bootstrap-table.css">
</head>
<script src="/js/jquery-3.2.1.js"></script>
<!-- <script src="webjars/jquery/3.1.1/jquery.min.js"></script> -->
<script type="text/javascript" src="/js/homepage.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>
<body>
<span>欢迎${user.param_name}</span>&nbsp;&nbsp;&nbsp;
<a href="logout">注销</a>
<div id = "data" >
	<c:if test="${user.power == 0}">
			<button id = "add">新增</button>
			<button id = "update">修改</button>
			<button id = "del">删除</button><br>
	</c:if>
	<table id="usertable" class = "table table-bordered"></table>
</div>
<div id = "drive">
	<center><br><br>
		<span id = "pai"></span><br><br><br>
		<input type="hidden" id="weiyiid">
		<span>账号</span><input type="text" id="name"><br>
		<span>密码</span><input type="text" id="pwd"><br>
		<span>权限</span>
		<select id="power">
			<option value='0'>管理员</option>
			<option value='1'>普通员工</option>
		</select><br><br>
		<button id="sum">提交</button>
		<button id="cal">取消</button>
	</center>
</div>
</body>
</html>