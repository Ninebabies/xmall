<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/reset.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/supersized.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/style.css">
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/supersized.3.2.7.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/supersized-init.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/scripts.js"></script>
		<!--  <ul id="supersized" class="quality" style="visibility: visible;">
		<li class="slide-0" style="visibility: visible; opacity: 1;"><a target="_blank"><img src="<%=request.getContextPath() %>/static/img/backgrounds/1.jpg" style="width: 1583px; left: 0px; top: -313.5px; height: 1108.1px;"></a></li>
		<li class="slide-1 prevslide" style="visibility: visible; opacity: 1;"><a target="_blank"><img src="<%=request.getContextPath() %>/static/img/backgrounds/2.jpg" style="width: 1583px; left: 0px; top: -313.5px; height: 1108.1px;"></a></li>
		<li class="slide-2 activeslide" style="visibility: visible; opacity: 1;"><a target="_blank"><img src="<%=request.getContextPath() %>/static/img/backgrounds/3.jpg" style="width: 1583px; height: 1060.61px; left: 0px; top: -290px;"></a></li>
		</ul>-->
		   <link rel='stylesheet' href='<%=request.getContextPath() %>/http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/reset.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/supersized.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/style.css">
	</head>
	<body>
		 <div class="page-container">
            <h1>Xamll后台登录系统</h1>
            <form  action="/user/userLogin" method="post">
                <input type="text" name="username" class="username" placeholder="用户名">
                <input type="password" name="password" class="password" placeholder="密码">
                <button type="submit">登录</button>
            </form>
        </div>
        <div align="center">Collect from <a href="http://www.augustars.com/" target="_blank" title="Xamll">管理平台</a></div>
	</body>
</html>