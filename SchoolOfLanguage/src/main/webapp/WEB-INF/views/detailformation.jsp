<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" type="text/css">
<title>Detail Formation</title>
</head>
<body>
   <table class="table table-hover">
   <tr><th>Titre</th><th>Local</th><th>Niveau</th><th>S&eacute;ance<th>Capacité</th><th>Quota</th></tr>
   <c:forEach items="${detailLocalFormations }" var="detailLocalFormation">
   <tr><td>${formation.titre }</td><td>${local.numLocal }</td><td>${detailLocalFormation.niveau }</td><td>${detailLocalFormation.seance } <td>${local.capacite }</td><td>${detailLocalFormation.quota }</td></tr>
   </c:forEach>
   </table>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>