<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" type="text/css">
<title>Employe</title>
</head>
<body>
	<c:forEach items="${messageError }" var="message">
		<p id="messageErreur">${message }</p>
	</c:forEach>
	<form:form modelAttribute="employe" action="employesubmit">
		<table  class="table table-condensed">
		   
		    <tr><td><form:label path="nom">Nom</form:label> </td></tr>
			<tr>
				<td><form:input path="nom" placeholder="Nom" /></td>
				<td><form:errors path="nom" cssStyle="color: red;" /></td>
			</tr>
			 <tr><td><form:label path="login">Login</form:label> </td></tr>
			<tr>
				<td><form:input path="login" placeholder="Login" /></td>
				<td><form:errors path="login" cssStyle="color: red;" /></td>
			</tr>
			 <tr><td><form:label path="password">Password</form:label> </td></tr>
			<tr>
				<td><form:password path="password" placeholder="Mot de passe" /></td>
				<td><form:errors path="password" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><strong>Simple Employé</strong> <input type="radio" name="role" value="SIMPLE"></td>
				
			</tr>
			<tr>
				<td><strong>Admin</strong> <input type="radio" name="role" value="ADMIN"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Enregistrer"
					class="btn btn-primary"></td>
			</tr>
		</table>
	</form:form>

</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>