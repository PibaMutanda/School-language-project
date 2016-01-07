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
<title>Liste Inscription</title>
</head>
<body>
<c:choose>
 <c:when test="${not empty employe }">
	<form action="listinscriptionsubmit" method="post">
		<strong>Choisir Une Date</strong><input type="date" name="dateInscription" required="required"><br>
		<input type="submit" value="Voir la liste" class="btn btn-primary">
	</form>
	<br><br>
	<hr>
	<c:if test="${ not empty listinscription  }">
	  <span style="text-align: right; color: green; font-size: large;" >La liste du : ${dateChoose }</span>
		<table class="table table-hover">
			<tr>
				<th>SEXE</th>
				<th>NOM</th>
				<th>PRENOM</th>
				<th>MATRICULE</th>
				<th>E-MAIL</th>
				<th>MONTANT PAYEMENT</th>
				<th>COMMUNICATION  PAYEMENT</th>
			</tr>
			<c:forEach items="${listinscription}" var="inscription">
			<c:set var="tabDet">${inscription.participant.detailLocalFormations }</c:set>
				<tr>
					<td>${inscription.participant.sexe }</td>
					<td>${inscription.participant.nom }</td>
					<td>${inscription.participant.prenom }</td>
					<td>${inscription.participant.matricule }</td>
					<td>${inscription.participant.email }</td>
					<td>${inscription.montantPaie } €</td>
					<td>${inscription.communicationPaie }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
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