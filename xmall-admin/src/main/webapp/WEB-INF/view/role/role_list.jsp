<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
		<head>
			<title></title>
			<meta charset="UTF-8">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/bootstrap.min.css">
  		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/font-awesome.min.css">
  		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/ionicons.min.css">
  		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/dataTables.bootstrap.min.css">
  		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/AdminLTE.min.css">
  		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/_all-skins.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
		
		<script src="<%=request.getContextPath() %>/static/js/jquery-3.3.1.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/jquery.dataTables.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/dataTables.bootstrap.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/jquery.slimscroll.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/fastclick.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/adminlte.min.js"></script>
			<script type="text/javascript">
			$(function() {
				$("button").click(function() {
					// 进行异步提交
					var loginForm = $("#loginForm").serialize();
					$.ajax({
						url: "<%=request.getContextPath()%>/user/login",
						type: "post",
						data: loginForm,
						dataType: "json",
						success: function(data) {
							alert("F**king");
						}
					});
				});
			});
		</script>
		</head>
		<body calss="hold-transion skin-biue sideddar-mini">
				<section>
				<h1>
						后台角色
						<small>后台角色信息列表</small>
				</h1>
				</section>
				<section class="content">
      		<div class="row">
        		<div class="col-xs-12">
          			<div class="box">
            			<div class="box-body">
              				<table id="roletable" class="table table-bordered table-hover">
                				<thead>
                					<tr>
                  						<th>序号</th>
                  						<th>角色名称</th>
                  						<th>操作</th>
                					</tr>
                				</thead>
                				<tbody>
                					<c:forEach var="role" items="${page.list }" varStatus="s">
                						<tr>
                							<td>${(page.pageNum - 1) * page.pageSize + s.index + 1 }</td>
                							<td>${role.roleName }</td>
                							<td>
                								<a href="javascript:getAuthcModal('${role.roleId }');" class="btn btn-success btn-xs">
                									<i class="fa fa-key"></i>
                									授权
                								</a>
                								<a href="#" class="btn btn-warning btn-xs">
                									<i class="fa fa-pencil"></i>
                									修改
                								</a>
                								<a href="#" class="btn btn-danger btn-xs">
                									<i class="fa fa-exclamation-circle"></i>
                									禁用
                								</a>
                							</td>
                						</tr>
                					</c:forEach>
                				</tbody>
	                			<tfoot>
		                			<tr>
		                  				<td align="center" colspan="3">
		                  					<ul class="pagination">
											    <li><a href="#">&laquo;</a></li>
											    <li><a href="#">1</a></li>
											    <li><a href="#">2</a></li>
											    <li><a href="#">3</a></li>
											    <li><a href="#">4</a></li>
											    <li><a href="#">5</a></li>
											    <li><a href="#">&raquo;</a></li>
											</ul>
		                  				</td>
		                			</tr>
	                			</tfoot>
              				</table>
            			</div>
          			</div>
        		</div>
			</div>
    	</section>
		</body>
</html>