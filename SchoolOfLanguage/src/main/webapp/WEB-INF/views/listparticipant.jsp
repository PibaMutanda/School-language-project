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
<title>Liste Participant</title>
</head>
<body>
	<table class="table table-hover">
		<tr>
			<th>SEXE</th>
			<th>NOM</th>
			<th>PRENOM</th>
			<th>MATRICULE</th>
			<th>ADRESSE-MAIL</th>
		</tr>
		<c:forEach items="${listdeparticipant }" var="participant">
			<tr>
				<td>${participant.sexe }</td>
				<td>${participant.nom }</td>
				<td>${participant.prenom }</td>
				<td>${participant.matricule }</td>
				<td>${participant.email }</td>
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