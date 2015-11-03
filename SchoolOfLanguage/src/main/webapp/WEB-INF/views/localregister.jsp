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
<title>Detail Formation</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty employe }">
			<c:forEach items="${messageError }" var="message">
				<p id="messageErreur">${message }</p>
			</c:forEach>
			<form:form modelAttribute="local" action="localsubmit">
				<table class="table">
					<tr>
						<td>Local</td>
					</tr>
					<tr>
						<td><form:input path="numLocal" placeholder="Numéro Local" /></td>
						<td><form:errors path="numLocal" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>Capacit&eacute;</td>
					</tr>
					<tr>
						<td><input type="number" name="capacite"
							placeholder="Capacité"></td>
						<td><form:errors path="capacite" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Enregistrer"
							class="btn btn-primary"></td>
					</tr>
				</table>
			</form:form>
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