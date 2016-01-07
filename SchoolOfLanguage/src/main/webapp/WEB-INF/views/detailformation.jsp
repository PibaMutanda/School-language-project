<%@page import="java.util.ArrayList"%>
<%@page import="be.school.model.Local"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<title>Detail Formation</title>
</head>
<body>
<c:if test="${not empty employe}">
   <%
   int cpt=0;
   ArrayList<Local> locaux=(ArrayList) request.getAttribute("local");
   %>
   
	<table class="table table-hover">
		<tr>
			<th>Titre</th>
			<th>Local</th>
			<th>Niveau</th>
			<th>S&eacute;ance 
					<th>Capacité</th>
					<th>Quota</th>
				
		</tr>
		<c:forEach items="${detailLocalFormations }"
			var="detailLocalFormation">
			<tr>
				<td><a
					href="formateurdetaildisplay?id=${detailLocalFormation.formateur.id }"
					title='Voir le formateur'>${formation.titre }</a></td>
				<td><%=locaux.get(cpt).getNumLocal() %></td>
				<td>${detailLocalFormation.niveau }</td>
				<td>${detailLocalFormation.seance }</td><c:if
						test="${not empty employe}">
						<td><%=locaux.get(cpt).getCapacite() %></td>
						<td>${detailLocalFormation.quota }</td>
						<%cpt++; %>
					</c:if>
			</tr>
		</c:forEach>
	</table>
</c:if>
<c:if test="${empty employe}">
<h1>Accès r&eacute;serv&eacute; aux administrateurs</h1>
</c:if>	
</body>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</html>