<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<link href="resources/css/style.css"
	rel="stylesheet" type="text/css">
<title>Employe</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty employe}">
			<c:forEach items="${messageError }" var="message">
				<p id="messageErreur">${message }</p>
			</c:forEach>
            <h2 id="titre">Ajouter un employ&eacute;</h2>
			<form:form modelAttribute="employe" action="employesubmit">
				<table class="table table-condensed">

					<tr>
						<td><form:label path="nom">Nom</form:label></td>
					</tr>
					<tr>
						<td><form:input path="nom" placeholder="Nom" /></td>
						<td><form:errors path="nom" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td><form:label path="login">Login</form:label></td>
					</tr>
					<tr>
						<td><form:input path="login" placeholder="Login" /></td>
						<td><form:errors path="login" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td><form:label path="password">Password</form:label></td>
					</tr>
					<tr>
						<td><form:password path="password" placeholder="Mot de passe" /></td>
						<td><form:errors path="password" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td><strong>Simple Employé </strong> <form:radiobutton
								path="roleEmploye" value="SIMPLE" /></td>

					</tr>
					<tr>
						<td><strong>Admin</strong> <form:radiobutton
								path="roleEmploye" value="ADMIN" /></td>
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
<script src="resources/js/jquery.js"></script>
<script
	src="resources/js/jquery-ui.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
</html>