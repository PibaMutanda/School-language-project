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
<title></title>
</head>
<body>
    <c:choose>
    <c:when test="${not empty employe }">
	<h3>Réinscription d'un participant pour la formation:
		${formation.titre }</h3>
	<c:forEach items="${messageError }" var="message">
		<p id="messageErreur">${message }</p>
	</c:forEach>
	<div class="table-responsive">
		<table class="table">
			<form class="form-horizontal" action="participantformationoldsubmit"
				method="post">
				<select class="form-control" name="participant">
					<option value="0">Participant</option>
					<c:forEach items="${listParticipant}" var="participant">
						<option value="${participant.id }">${participant.prenom }
							${participant.nom}</option>
					</c:forEach>
				</select> <input type="hidden" value="${formation.id }" name="formation">
				  <input type="hidden" value="${niveau }" name="niveau">
				<select class="form-control" name="local">
					<option value="0">Local</option>
					<c:forEach items="${listLocal }" var="local">
						<option value="${local.id }">${local.numLocal }</option>
					</c:forEach>
				</select> <input type="submit" value="Enregistrer" class="btn btn-primary">
			</form>
		</table>
	</div>
	</c:when>
	 <c:otherwise>
     <%@ include file="/WEB-INF/bannedfile.html" %>
     </c:otherwise>
	</c:choose>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>
</html>