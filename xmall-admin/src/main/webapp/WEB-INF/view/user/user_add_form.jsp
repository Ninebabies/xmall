<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/role/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/role/ionicons.min.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/role/AdminLTE.min.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/role/_all-skins.min.css">
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/role/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/role/adminlte.min.js"></script>
		<script type="text/javascript">
			$(function() {
				//	使用异步的方式获得角色信息列表
				$.ajax({
					url:"<%=request.getContextPath()%>/role/list/1/0",
					type:"get",
					dataType:"json",
					success:function(data){
						var options = "";
						for (var i = 0; i < data.length; i++) {
							var option = "<option value='" + data[i].roleId + "'>" 
											+ data[i].roleName + "</option>";
							options = options + option;
						}
						//	向select标签添加选项
						$("#roleId").html(options)
					}
				});
			});
			function saveUser() {
				//	将表单中的数据进行序列化
				var userForm = $("#userForm").serialize();
	
				//	进行异步添加
				$.ajax({
					url:"<%=request.getContextPath()%>/user/userAdd",
					type:"post",
					data:userForm,
					dataType:"json",
					success:function(data){
						if (data) {
							alert("添加成功！");
						}else {
							alert("添加失败！");
						}
						//	关闭模态框
						parent.closeModal();
						//	地址跳转
						parent.openFrame("/user/list/1/0");
					}
				});
			}
		</script>
	</head>
	<body>
		<form id="userForm">
			<table style="border-collapse: separate; border-spacing: 0px 10px;">
				<tr>
					<td align="right">
						<i class="fa fa-key"></i>&nbsp;
						用户编号：
					</td>
					<td>
						<input type="text" id="userNo" name="userNo" class="form-control" value="${userNo }" style="width: 220px;" readonly/>
					</td>
					<td style="padding-left: 5px;">
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr style="margin-bottom: 5px;">
					<td align="right">
						<i class="fa fa-user"></i>&nbsp;
						用户姓名：
					</td>
					<td>
						<input type="text" id="username" name="username" class="form-control" style="width: 220px;" placeholder="请填写用户真实姓名"/>
					</td>
					<td style="padding-left: 5px;">
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr style="margin-bottom: 5px;">
					<td align="right">
						<i class="fa fa-info"></i>&nbsp;
						登录名：
					</td>
					<td>
						<input type="text" id="loginName" name="loginName" class="form-control" style="width: 220px;" placeholder="请填写登录名"/>
					</td>
					<td style="padding-left: 5px;">
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr style="margin-bottom: 5px;">
					<td align="right">
						<i class="fa fa-lock"></i>&nbsp;
						性别：
					</td>
					<td>
						<select id="gender" name="gender" class="form-control" style="width: 220px;">
							<option value="M" selected>男</option>
							<option value="F">女</option>
						</select>
					</td>
					<td style="padding-left: 5px;">
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr style="margin-bottom: 5px;">
					<td align="right">
						<i class="fa fa-lock"></i>&nbsp;
						角色：
					</td>
					<td>
						<select id="roleId" name="roleId" class="form-control" style="width: 220px;">
							<c:forEach var="role" items="${roleList }">
								<option value="${role.roleId }">${role.roleName }</option>
							</c:forEach>
						</select>
					</td>
					<td style="padding-left: 5px;">
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr style="margin-bottom: 5px;">
					<td align="right">
						<i class="fa fa-cc"></i>&nbsp;
						身份证号码：
					</td>
					<td>
						<input type="text" id="idCard" name="idCard" class="form-control" style="width: 220px;" placeholder="请填写身份证号码"/>
					</td>
					<td style="padding-left: 5px;">
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr style="margin-bottom: 5px;">
					<td align="right">
						<i class="fa fa-phone"></i>&nbsp;
						联系电话：
					</td>
					<td>
						<input type="text" id="cellphone" name="cellphone" class="form-control" style="width: 220px;" placeholder="请填写联系电话"/>
					</td>
					<td style="padding-left: 5px;">
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr style="margin-bottom: 5px;">
					<td align="right">
						<i class="fa fa-envelope-o"></i>&nbsp;
						电子邮件：
					</td>
					<td>
						<input type="text" id="email" name="email" class="form-control" style="width: 220px;" placeholder="请填写电子邮件"/>
					</td>
					<td style="padding-left: 5px;">
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<a href="javascript:saveUser();" class="btn btn-success">
							<i class="fa fa-plus"></i>&nbsp;
							添加用户信息
						</a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>