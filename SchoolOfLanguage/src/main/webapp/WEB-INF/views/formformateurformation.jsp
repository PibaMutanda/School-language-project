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
<title></title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty employe }">
			<h3>Associer ${formateur.prenom } ${formateur.nom} &agrave; une</h3>
			<c:forEach items="${messageError }" var="message">
				<p id="messageErreur">${message }</p>
			</c:forEach>
			<form action="formateurformsubmit" method="post">
				<input type="hidden" name="formateur" value="${formateur.id }">
				Formation: <select name="formation">
					<option value="0" selected="selected">Choix</option>
					<c:forEach items="${detailListForm}" var="formation">
						<option value="${formation.id }">${formation.formation.titre }-${formation.seance }
							local ${formation.local.numLocal }-${formation.jour }</option>
					</c:forEach>
				</select> <input type="submit" value="Enregistrer" class="btn btn-primary">
			</form>
		</c:when>
		<c:otherwise>
			<%@ include file="/WEB-INF/bannedfile.html"%>
		</c:otherwise>
	</c:choose>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>