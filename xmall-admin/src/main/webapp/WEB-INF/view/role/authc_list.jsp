<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
			<title></title>
			<meta charset="UTF-8">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/bootstrap.min.css" type="text/css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/ztree/zTreeStyle.css" type="text/css">
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/ztree/jquery.ztree.core.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/ztree/jquery.ztree.excheck.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			var setting = {
				view: {
					selectedMulti: false
				},
				check: {
					enable: true
				},
				data: {
					simpleData: {
						enable: true
					}
				},
				callback: {
					onCheck: onCheck
				}
			};
			var clearFlag = false;
			function onCheck(e, treeId, treeNode) {
				count();
				if (clearFlag) {
					clearCheckedOldNodes();
				}
			}
			function clearCheckedOldNodes() {
				var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
				nodes = zTree.getChangeCheckedNodes();
				for (var i=0, l=nodes.length; i<l; i++) {
					nodes[i].checkedOld = nodes[i].checked;
				}
			}
			$(function() {
				var roleId = $("#roleId").val();
				$.ajax({
					url: "<%=request.getContextPath()%>/menu/authcList?roleId=" + roleId,
					method: "get",
					dataType: "json",
					success: function(data) {
						$.fn.zTree.init($("#treeDemo"), setting, data);
						clearFlag = $("#last").attr("checked");	
						$("#init").bind("change", createTree);
						$("#last").bind("change", createTree);
					}
				});
			});
			
			function autchRole() {
				// 获取所有的用户所选角色主键
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				//拿到所有选中的节点
				var nodes = zTree.getCheckedNodes(true);
				//给定一个空字符串
				var nodeIds = "";
				for (var i = 0; i < nodes.length; i++) {
					nodeIds = nodeIds + nodes[i].id + "-";
				}
				var roleId= $("#roldId").val();
				nodeIds = nodeIds.substring(0, nodeIds.length-1);
				$.ajax({
					url: "<%=request.getContextPath()%>/role/authc?roleId=" + roleId,
					method: "post",
					data: {
						"nodeIds": nodeIds
					},
					dataType: "json",
					success: function(data) {
						if (data) {
							alert("授权成功！");
						} else {
							alert("授权失败！");
						}
						// 关闭模态框
						parent.parent.closeModal();
						// 地址跳转
						parent.parent.openFrame("/role/1/0");
					}
				});
			}
		</script>
	</head>
<body>
		<input type="hidden" id="roleId" value="${roleId }"/>
		<div>
			<ul id="treeDemo" class="ztree" style="height: 100%"></ul>
			<button class="btn btn-success btn-xs" onclick="autchRole();">授权</button>
		</div>
		
</body>
</html>