<%@page import="java.nio.channels.SeekableByteChannel"%>
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
<link href="resources/css/style.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<title><decorator:title>School Of Language</decorator:title></title>
<decorator:head></decorator:head>
</head>
<body>
	<%@include file="/WEB-INF/includes/header.jsp"%>
	<div class="row">
	<c:choose>
	 <c:when test="${formateur.id != null or employe.id != null }">
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
		</c:when>
		<c:otherwise>
		<div class="container">
			<div class="col-md-12 shool-decorator-body">
				<decorator:body />
			</div>
		</div>
		</c:otherwise>
	</c:choose>	
	</div>
	<footer class="school-footer">
	<%@include file="/WEB-INF/includes/footer.jsp" %>
	</footer>
</body>

<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/angular.min.js"></script>	
</html>