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
<title>Liste Inscription</title>
</head>
<body>
	<form action="listinscriptionsubmit" method="post">
		<strong>Choisir Une Date</strong><input type="date" name="dateInscription" required="required"><br>
		<input type="submit" value="Enregistrer" class="btn btn-primary">
	</form>
	<br><br>
	<hr>
	<c:if test="${ not empty listinscription  }">
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
				<tr>
					<td>${inscription.participant.sexe }</td>
					<td>${inscription.participant.nom }</td>
					<td>${inscription.participant.prenom }</td>
					<td>${inscription.participant.matricule }</td>
					<td>${inscription.participant.email }</td>
					<td>${inscription.montantPaie }
					<td>${inscription.communicationPaie }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>