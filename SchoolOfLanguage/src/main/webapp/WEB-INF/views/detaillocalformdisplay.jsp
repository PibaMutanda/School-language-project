<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" type="text/css">
<title></title>
</head>
<body>
	<table class="table table-striped">
		<tr>
			<th>Formation</th>
			<th>Local</th>
			<th>Libre</th>
			<th>Jour</th>
			<th>S&eacute;ance</th>
			<th>Niveau</th>
			<th>Quota</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${listDetLocalForm }" var="detLocalForm">
			<tr>
				<td>${detLocalForm.formation.titre }</td><
				<td>${detLocalForm.local.numLocal }</td>
				<td>${detLocalForm.local.estLibre }</td>
				<td>${detLocalForm.jour }</td>
				<td>${detLocalForm.seance }</td>
				<td>${detLocalForm.niveau }</td>
				<td>${detLocalForm.quota }</td>
				<td><a href="updateDetailLocalForm?id=${detLocalForm.id }"><span class="glyphicon glyphicon-pencil" title="Modifier"></span></a></td>
				<td><a href="deleteDetailLocalForm?id=${detLocalForm.id }"><span class="glyphicon glyphicon-trash" title="Supprimer"></span></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>