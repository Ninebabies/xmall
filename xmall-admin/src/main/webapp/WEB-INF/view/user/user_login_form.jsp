<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/bootstrap.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/login.css"/>
	
	</head>
		<body>
		<div style="height:1px;"></div>
  <div class="login">
     <header>
	    <h1>登录</h1>
	 </header>
	 <div class="sr">
	    <form  action="/user/userLogin" method="post">
		    <div >
				<label>
				<i class="sublist-icon glyphicon glyphicon-user"></i>
				</label>
				<input type="text"  name="username" class="username" placeholder="请输入登录名" >
			</div>
			 <div>
				<label>
				<i class="sublist-icon glyphicon glyphicon-pencil"></i>
				</label>
				<input type="password" name="password" class="password" placeholder="请输入密码">
			</div>
			<button class="submit">登录</button>
		</form>
	 </div>
  </div>
	</body>
</html>