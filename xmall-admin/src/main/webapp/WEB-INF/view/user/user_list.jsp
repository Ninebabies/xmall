<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/bootstrap.min.css">
  		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/role/font-awesome.min.css">
  		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/role/ionicons.min.css">
  		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/role/dataTables.bootstrap.min.css">
  		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/role/AdminLTE.min.css">
  		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/role/_all-skins.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
		
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/role/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/role/dataTables.bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/role/jquery.slimscroll.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/role/fastclick.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/role/adminlte.min.js"></script>
		<script type="text/javascript">
			$(function() {
		    	$('#roletable').DataTable({
		      		'paging'      : true,
		      		'lengthChange': false,
		      		'searching'   : false,
		      		'ordering'    : true,
		      		'info'        : true,
		      		'autoWidth'   : false
		    	});
			});
			function getAuthcModal(roleId) {
				var width = "600px";
				var height = "700px";
				var url = "<%=request.getContextPath()%>/role/authcList?roleId=" + roleId;
				var title = "角色授权";	
				//对于JavaScript来说parent代表父类元素
				parent.openModal(title, url, width, height);
			}
		</script>
	</head>
	<body class="hold-transition skin-blue sidebar-mini">
		<section class="content-header">
  			<h1>
    		后台用户信息
  			</h1>
		</section>
		<section class="content">
  			<div class="row">
    			<div class="col-xs-12">
      				<div class="box">
        				<div class="box-header form-inline" style="margin-bottom: 5px; margin-left: 15px;">
			              	<form class="bs-example bs-example-form" role="form"	>
			              		<a href="javascript:openadduser();" class="btn btn-success btn-md">
				              		<span class="glyphicon glyphicon-plus"></span>
				              		新增后台用户
				              	</a>
			              		<div class="input-group" style="margin-left: 60%;">
	        						<input type="text" id="username" value="${userName }" class="form-control" style="width: 220px;" placeholder="请输入用户名称">
	    							<a class="input-group-addon btn btn-primary">
	    								<span class="glyphicon glyphicon-search"></span>
	   									搜索
	    							</a>
	    						</div>
			              	</form>
			            </div>
			            <div class="box-body">
          				<table id="example2" class="table table-bordered table-hover">
            				<thead>
            					<tr>
              						<th>序号</th>
              						<th>用户编号</th>
              						<th>用户姓名</th>
              						<th>登录名</th>
              						<th>性别</th>
              						<th>身份证号码</th>
              						<th>出生日期</th>
              						<th>角色</th>
              						<th>联系电话</th>
              						<th>电子邮件</th>
              						<th>状态</th>
              						<th>操作</th>
            					</tr>
            				</thead>
            				<tbody>
            					<c:forEach var="user" items="${page.list }" varStatus="s">
            						<tr>
            							<td>${(pageNum - 1) * pageSize + s.index + 1 }</td>
            							<td>${user.userNo }</td>
            							<td>${user.username }</td>
            							<td>${user.loginName }</td>
            							<td>
            								<c:choose>
            									<c:when test="${user.gender eq 'M' }">
            										男
            									</c:when>
            									<c:otherwise>
            										女
            									</c:otherwise>
            								</c:choose>
            							</td>
            							<td>${user.idCard }</td>
            							<td>${user.birthday }</td>
            							<td>${user.role.roleName }</td>
            							<td>${user.cellphone }</td>
            							<td>${user.email }</td>
            							<td>${user.status.statusName }</td>
            							<td>
            								<a href="#" class="btn btn-xs">
            									<span class="glyphicon glyphicon-list-alt"></span>
            									详情
            								</a>
            								<a href="#" class="btn btn-primary btn-xs">
            									<span class="glyphicon glyphicon-wrench"></span>
            									修改
            								</a>
            								<c:choose>
            									<c:when test="${user.status.statusCode eq 'ENABLE' }">
            										<a href="javascript:changestatus('${user.userId }', 'DISABLE', '${user.username }', '${page.pageNum }', '${user.username }');"
            										class="btn btn-danger btn-xs">
            											<span class="glyphicon glyphicon-pause"></span>
            											禁用
            										</a>
            									</c:when>
            									<c:otherwise>
            										<a href="javascript:changestatus('${user.userId }', 'ENABLE', '${user.username }', '${page.pageNum }', '${user.username }');"
            										class="btn btn-success btn-xs">
            											<span class="glyphicon glyphicon-play"></span>
            											启用
            										</a>
            									</c:otherwise>
            								</c:choose>
            							</td>
            						</tr>
            					</c:forEach>
            				</tbody>
                			<tfoot>
	                				<tr>
	            						<td colspan="12" align="center">
	            							<ul class="pagination" style="margin: 0px;">
												<li><a href="<%=request.getContextPath() %>/user/list/1/${username }">首页</a></li>
												<li>
													<c:choose>
														<c:when test="${page.pageNum eq '1' }">
															<a href="#">&laquo;上一页</a>
														</c:when>
														<c:otherwise>
															<a href="<%=request.getContextPath() %>/user/list/${page.pageNum - 1 }/${username }">&laquo;上一页</a>
														</c:otherwise>
													</c:choose>
												</li>
												<li>
													<a href="#">
														
														共有数据条，共分为页，当前是第页
													</a>
												</li>
										    	<li>
										    		<c:choose>
														<c:when test="${page.pageNum eq page.totalPage }">
															<a href="#">下一页&raquo;</a>
														</c:when>
														<c:otherwise>
															<a href="<%=request.getContextPath() %>/user/list/${page.pageNum + 1 }/${username }">下一页&raquo;</a>
														</c:otherwise>
													</c:choose>
										    	</li>
										    	<li><a href="<%=request.getContextPath() %>/user/list/${page.totalPage }/${username }">尾页</a></li>
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