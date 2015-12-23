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
<title></title>
</head>
<body>
	<c:forEach items="${messageError }" var="message">
		<p id="messageErreur">${message }</p>
	</c:forEach>

	<form action="loginsubmit" method="post">
		<div class="form-group">
			<label for="login">Login</label> <input type="text"
				class="form-control" id="exampleInputEmail1" placeholder="Login"
				name="login">
		</div>
		<div class="form-group">
			<label for="password">Mot de Passe</label> <input type="password"
				class="form-control" id="exampleInputPassword1"
				placeholder="Password" name="password">
		</div>
		<div class="checkbox">
			<label> <input type="checkbox" name="admin" value="">Secrétariat
			</label>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form><br><br>
</body>
<script src="resources/js/jquery.js"></script>
<script
	src="resources/js/jquery-ui.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
</html>