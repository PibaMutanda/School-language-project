<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<link href="resources/css/style.css"
	rel="stylesheet" type="text/css">
<title>Inscription</title>
</head>
<body>
	<c:forEach items="${messageError }" var="message">
		<p id="messageErreur">${message }</p>
	</c:forEach>
	<form action="inscriptionsubmit" method="post">
		<table class="table table-condensed">
			<tr>
				<td><strong>Matricule</strong></td>
			</tr>
			<tr>
				<td><input type="text" name="matricule" placeholder="Matricule"></td>
			</tr>
			<tr>
				<td><strong>E-mail</strong></td>
			</tr>
			<tr>
				<td><input type="email" name="email" placeholder="Adresse mail">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="M'identifier"
					class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
</body>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/angular.min.js"></script>	
</html>