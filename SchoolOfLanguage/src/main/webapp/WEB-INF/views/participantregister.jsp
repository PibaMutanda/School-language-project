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
   <c:when test="${not empty employe}">
	<c:forEach items="${messageError }" var="message">
		<p id="messageErreur">${message }</p>
	</c:forEach>
	<form:form modelAttribute="participant" action="participantsubmit">
		<table class="table">
		   <tr><td>Nom</td></tr>
			<tr>
				<td><form:input path="nom" placeholder="Nom" />&nbsp;&nbsp;<form:errors
						path="nom" cssStyle="color: red;" /></td>
			</tr>
			<tr><td> Pr&eacute;nom</td></tr>
			<tr>
				<td><form:input path="prenom" placeholder="Prénom" />&nbsp;&nbsp;<form:errors
						path="prenom" cssStyle="color: red;" /></td>
			</tr>
			<tr><td>Gsm</td></tr>
			<tr>
				<td><form:input path="gsm" placeholder="Gsm:+32 ou 0032" />&nbsp;&nbsp;<form:errors
						path="gsm" cssStyle="color: red;" /></td>
			</tr>
			<tr><td>E-mail</td> </tr>
			<tr>
				<td><form:input path="email" placeholder="E-Mail" />&nbsp;&nbsp;<form:errors
						path="email" cssStyle="color: red;" /></td>
			</tr>
			<tr><td>Adresse</td></tr>
			<tr>
				<td><form:input path="ville" placeholder="Ville" />&nbsp;&nbsp;<form:errors
						path="ville" cssStyle="color: red;" /> &nbsp;&nbsp;<form:input
						path="rue" placeholder="Rue" />&nbsp;&nbsp;<form:errors path="rue"
						cssStyle="color: red;" /> &nbsp;&nbsp;<form:input path="numero"
						placeholder="Numéro" />&nbsp;&nbsp;<form:errors path="numero"
						cssStyle="color: red;" />&nbsp;&nbsp; <form:input path="codeP"
						placeholder="Code Postal" />&nbsp;&nbsp;<form:errors
						cssStyle="color: red;" path="codeP" /></td>
			</tr>
			<tr>
				<td>Sexe</td>
			</tr>
			<tr>
				<td><form:radiobutton path="sexe" value="HOMME" />&nbsp;&nbsp;M&nbsp;&nbsp;<form:radiobutton
						path="sexe" value="FEMME" />&nbsp;&nbsp;F&nbsp;&nbsp; <form:errors
						path="sexe" cssStyle="color: red;" /></td>
						
			</tr>
			<tr>
			   
				<td> Statut<br><br> <form:select path="statutProfessionnel">
						<form:option value="0"></form:option>
						<c:forEach items="${listStatutProf }" var="statutProf">
							<form:option value="${statutProf.id }">${statutProf.statut }</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:hidden path="matricule" />
			<tr>
				<td><input type="submit" value="Enregistrer"
					class="btn btn-primary"></td>
			</tr>
		</table>
	</form:form>
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