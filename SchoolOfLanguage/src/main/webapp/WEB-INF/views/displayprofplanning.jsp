<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" type="text/css">
<title>Planning Formateur</title>
</head>
<body>
	<%
		int idx = 0;
		Long[] totalPart = (Long[]) request.getAttribute("totalPart");
	%>
	<table class="table table-striped">
		<tr>
			<th>Formation</th>
			<th>Local</th>
			<th>Niveau</th>
			<th>S&eacute;ance</th>
			<th>Jour</th>
			<th>Nombre Participant</th>
		</tr>
		<c:forEach items="${planningProf }" var="unPlanning">
			<tr>
				<td>${unPlanning.formation.titre }</td>
				<td>${unPlanning.local.numLocal }</td>
				<td>${unPlanning.niveau }</td>
				<td>${unPlanning.seance }</td>
				<td>${unPlanning.jour }</td>
				<td><%=totalPart[idx++]%></td>
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