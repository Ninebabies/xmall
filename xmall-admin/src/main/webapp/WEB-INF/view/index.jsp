<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title></title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  		<link rel="stylesheet" type="text/css" type="text/css" href="<%=request.getContextPath() %>/static/css/bootstrap.min.css">
  		<link rel="stylesheet" type="text/css" type="text/css" href="<%=request.getContextPath() %>/static/css/font-awesome.min.css">
  		<link rel="stylesheet" type="text/css" type="text/css" href="<%=request.getContextPath() %>/static/css/ionicons.min.css">
  		<link rel="stylesheet" type="text/css" type="text/css" href="<%=request.getContextPath() %>/static/css/AdminLTE.min.css">
  		<link rel="stylesheet" type="text/css" type="text/css" href="<%=request.getContextPath() %>/static/css/_all-skins.min.css">
  		<link rel="stylesheet" type="text/css" type="text/css" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
		<script src="<%=request.getContextPath() %>/static/js/jquery.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/jquery-ui.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/adminlte.min.js"></script>
		<script type="text/javascript">
		function openiframe(url) {
			var iframe = "<iframe onscroll='true' src='" + url + "' style='width: 100%; height: 100%; min-height:  424px; border: 0px;'></iframe>";
			$("#myframe").html(iframe);
				$("#myframe").html(iframe);
			}
			
			function showModal(title, url, width, height) {
				// 设定模态框标题
				$("#myModalTitile").html(title);
				// 设定url
				var iframe = "<iframe onscroll='true' src='" + url + "' style='width: " + width + "; height: " + height + "; min-height:  424px; border: 0px;'></iframe>";
				// 设定模态框具体内容
				$("#myModalBody").html(iframe);
				// 展示模态框
				$("#myModal").modal({
					keyboard: false
				});
			}
			
			function closeModal() {
				$("#myModal").modal("hide");
			}
		</script>
	</head>
	<body >
	   <div class="container">
       <div class="row">
		  <!-- Brand and toggle get grouped for better mobile display -->
		  <div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			  <span class="sr-only">Toggle navigation</span>
			  <span class="icon-bar"></span>
			  <span class="icon-bar"></span>
			  <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Xmall管理系统</a>
		  </div>
		  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
			  <li class="active"><a href="#">首页</a></li>
			  <li ><a href="#">关于我们</a></li>			  
			  <li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">下拉菜单<b class="caret"></b></a>
				<ul class="dropdown-menu">
				  <li><a href="#">Action</a></li>
				  <li><a href="#">Another action</a></li>
				  <li><a href="#">Something else here</a></li>
				  <li class="divider"></li>
				  <li><a href="#">Separated link</a></li>
				  <li class="divider"></li>
				  <li><a href="#">One more separated link</a></li>
				</ul>
			  </li>
			</ul>
			<form class="navbar-form navbar-left" role="search">
			  <div class="form-group">
				<input type="text" class="form-control" placeholder="请输入内容">
			  </div>
			  <button type="submit" class="btn btn-default">搜索</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
			  <li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">${user.username}<b class="caret"></b></a>
				<ul class="dropdown-menu">
				  <li><a href="#">设置</a></li>
				  <li><a href="#">个人资料</a></li>
				  <li><a href="#">账户中心</a></li>
				  <li class="divider"></li>
				  <li><a href="/user/logout">退出登录</a></li>
				</ul>
			  </li>
			</ul>
		  </div><!-- /.navbar-collapse -->
		  </div>
		  </div>

        <div class="container">
            <!-- left, vertical navbar & content -->
            <div class="row">
                <!-- left, vertical navbar -->
                <div class="col-md-2 bootstrap-admin-col-left">
                     <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side" data-widget="tree">
                        <c:forEach var="menu" items="${menuList}">
                        	<li class="treeview">
                        		<a href="#" class="dropdown-toggle" data-toggle="dropdown">
	                        		<i class="glyphicon glyphicon-chevron-right"></i>
	                        		<span>${menu.text}</span>
                        		</a>
                        		<ul class="dropdown-menu">
                        			<c:forEach var="second" items="${menu.childMenuList }">
                        				<li>
	                        				<a href="javascript:openFrame('${second.url }')">
	                        					<i class="glyphicon glyphicon-chevron-right"></i>
	                        					${second.text}
	                        				</a>
                        				</li>
                        			</c:forEach>
                        		</ul>
                        	</li>
                        </c:forEach>
                        
                        
                       
                    </ul>
                </div>

                <!-- content -->
                <div class="col-md-10">
                    <div class="row">
                        <div class="navbar navbar-default bootstrap-admin-navbar-thin">
                            <ol class="breadcrumb bootstrap-admin-breadcrumb">
                                <li>
                                    <a href="#">首页</a>
                                </li>
                                <li>
                                    <a href="#">设置</a>
                                </li>
                                <li class="active">工具</li>
                            </ol>
                        </div>
                    </div>

                    <div  class="row">
                        <div id="myFrame" class="panel panel-default bootstrap-admin-no-table-panel"
                        style="height: 600px;width: 100%">
                            
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <hr>
                <footer role="contentinfo">
                    <p>&copy; 2018 <a href="#" target="_blank">Xmall</a>-More Templates <a href="http://www.augustars.com/" target="_blank" title="Augustars">Augustars</a> - Collect from <a href="http://www.augustars.com/" title="Augustars" target="_blank">Augustars</a></p>
                </footer>
            </div>
        </div>
        
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">
		                	
		                </h4>
		            </div>
		            <div class="modal-body" id="myModalBody"></div>
		        </div>
		    </div>
		</div>
	</body>
</html>