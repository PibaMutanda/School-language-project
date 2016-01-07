<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<title>Valider Inscription</title>
</head>
<body>
	<div>
		<h2 id="titre">Vos Donn&eacute;es enregistr&eacute;es</h2>
		<strong>Identit&eacute;: </strong> ${participant.prenom }
		${participant.nom }<br> <strong>E-mail: </strong>
		${participant.email }<br> <strong>Gsm: </strong>
		${participant.gsm }<br> <strong>Adresse: </strong>
		${participant.rue } ${participant.codeP } ${participant.ville }
	</div>

	<form action="validerinscriptionsubmit" method="post">
		<input type="hidden" name="id" value="${participant.id }">
		<c:forEach items="${participant.detailLocalFormations }"
			var="detailLocalForm">
       ${detailLocalForm.formation.titre } <input type="checkbox"
				name="titre" value="${detailLocalForm.formation.codeFormation }">
			<br>
		</c:forEach>
		<input type="submit" value="Valider" class="btn btn-primary">
	</form>
</body>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</html>