<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta name="description" content="">
    	<meta name="author" content="">
    
    	<!-- Le styles -->
    	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oxygen|Marck+Script" rel="stylesheet" type="text/css">
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/bootstrap.css" rel="stylesheet">
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/font-awesome.css" rel="stylesheet">
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/admin.css" rel="stylesheet">
    	
    	<script src="<%=request.getContextPath() %>/static/js/jquery.min.js"></script>   	
		<script src="<%=request.getContextPath() %>/static/js/bootstrap.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/excanvas.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/jquery.flot.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/jquery.flot.resize.js"></script>
		<script type="text/javascript">
			
			function openFrame(url) {
				// 组装请求路径，发出请求
				var iframe="<iframe height='100%' width='100%' onscroll='true' src='<%=request.getContextPath()%>" + url + "' style='border: 0px; min-height: 531px;'></iframe>";
				$("#myFrame").html(iframe);
			}
			
			
			function openModal(title, url, width, height) {
				$("#myModalLabel").html(title);
				var iframe='<iframe width="' + width +'" height="' + height + '" onscroll="true" style="border: 0px;" src="'+ url +'"></iframe>';
				$("#myModalBody").html(iframe);
				$("#myModal").modal("show");
			}
			
			function closeModal(){
				$("#myModal").modal("hide");
			}
		</script>
	</head>
	<body>
		<div class="container">
		
		<div class="row">
		
			<div class="span2">
		
			<div class="main-left-col">
		
				<h1><i class="icon-shopping-cart icon-large"></i> ${user.username}</h1>
			
				<ul class="side-nav">
					<c:forEach var="menu" items="${menuList}">
					<li class="dropdown">
						<i class="panel panel-default"/>
							<i class="panel-heading"/>
						<a data-toggle="collapse" data-parent="#accordion" 
				   			href="#kk${menu.menuId }">
						<span>${menu.text}</span>
						</a>
						<ul id="kk${menu.menuId }" class="panel-collapse collapse in">
							<c:forEach var="second" items="${menu.childMenuList}">
								<li>
									<a href="javascript:openFrame('${second.url}')">
										${second.text}
									</a>
								</li>
							</c:forEach>
						</ul>
						
					</li>
					</c:forEach>
				</ul>
		
			</div> 
		</div> 
	
		<div class="span10">
		
	
		<div class="main-area dashboard">

			<div class="row">
		
				<div class="span10">
					<div id="myFrame">
				
					</div>
				</div>
			</div>
	
		</div>
	
		</div> <!-- end span10 -->
		
		</div> <!-- end row -->
		
	</div> <!-- end container -->



	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-dialog">
        	<div class="modal-content">
            	<div class="modal-header">
                	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                	<h4 class="modal-title" id="myModalLabel"></h4>
            	</div>
            	<div class="modal-body" id="myModalBody"></div>
          
        	</div>
    	</div>
	</div>


	</body>
</html>