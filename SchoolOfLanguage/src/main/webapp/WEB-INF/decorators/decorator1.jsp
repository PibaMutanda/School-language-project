<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<html>
<head>
<!--    http://www.luckyryan.com/2013/02/06/setup-a-simple-spring-mvc-site-with-maven/  -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<title><decorator:title>School Of Language</decorator:title></title>
<decorator:head></decorator:head>
</head>
<body>
	<%@include file="/WEB-INF/includes/header.jsp"%>
	<div class="row">
		<div class="container-fluid">
			<div class="col-md-3">
				<nav>
					<%@include file="/WEB-INF/includes/menu.jsp"  %>
				</nav>
			</div>
		</div>
		<div class="container">
			<div class="col-md-9 shool-decorator-body">
				<decorator:body />
			</div>
		</div>
	</div>

	<footer class="school-footer">
	<%@include file="/WEB-INF/includes/footer.jsp" %>
	</footer>
</body>
<script>
	$(document).ready(function() {
		$("#notification-message").show().delay(5000).fadeOut();
	});
</script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>