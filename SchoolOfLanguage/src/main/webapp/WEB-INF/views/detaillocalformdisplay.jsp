<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<link href="resources/css/style.css"
	rel="stylesheet" type="text/css">
<title></title>
</head>
<body>
<c:choose>
<c:when test="${not empty employe }">
	<table class="table table-striped">
		<tr>
			<th>Formation</th>
			<th>Local</th>
			<th>Libre</th>
			<th>Jour</th>
			<th>S&eacute;ance</th>
			<th>Niveau</th>
			<th>Quota</th>
			<th>Places Disponible</th>
			<th></th>
			<th></th>
		</tr>
		<%
			int i = 0;
			Long tab[] = (Long[]) request.getAttribute("tabDispo");
		%>
		<c:forEach items="${listDetLocalForm }" var="detLocalForm">

			<tr>
				<td>${detLocalForm.formation.titre }</td><
				<td>${detLocalForm.local.numLocal }</td>
				<td>${detLocalForm.local.estLibre }</td>
				<td>${detLocalForm.jour }</td>
				<td>${detLocalForm.seance }</td>
				<td>${detLocalForm.niveau }</td>
				<td>${detLocalForm.quota }</td>
				<td><%=tab[i++]%></td>
				<td><a href="updateDetailLocalForm?id=${detLocalForm.id }"><span
						class="glyphicon glyphicon-pencil" title="Modifier"></span></a></td>
				<td><a
					href="javascript:deleteDetailLocalFunction('deleteDetailLocalForm?id=${detLocalForm.id }')"><span
						class="glyphicon glyphicon-trash" title="Supprimer"></span></a></td>
			</tr>

		</c:forEach>
	</table>
	<script type="text/javascript">
		function deleteDetailLocalFunction(delUrl) {
			if (confirm("Voulez-vous supprimer l'élément sélectionné ?")) {
				document.location = delUrl;
			}
		}
	</script>
	</c:when>
	 <c:otherwise>
     <%@ include file="/WEB-INF/bannedfile.html" %> 
     </c:otherwise>
	</c:choose>
</body>
<script src="resources/js/jquery.js"></script>
<script
	src="resources/js/jquery-ui.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
</html>