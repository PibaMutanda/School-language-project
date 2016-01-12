<%@page import="java.util.Date"%>
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
<title>Liste Reservation</title>
</head>
<body>
	<c:if test="${not empty listReservation }">
	        <h3 style="text-align: center; background-color: fuchsia; font-family: cursive;" >RDV POUR INSCRIPTION</h3>
		<table class="table table-hover">
			<tr>
				<th>NOM</th>
				<th>PR&Eacute;NOM</th>
				<th>E-MAIL</th>
				<th>GSM</th>
				<th>DATE RESERVATION</th>
				<th>DATE RDV</th>
				<th>FORMATION(S)</th>
			</tr>
			<c:forEach items="${listReservation }" var="reserv">
				<tr>
					<td>${reserv.nom }</td>
					<td>${reserv.prenom }</td>
					<td>${reserv.email }</td>
					<td>${reserv.gsm }</td>
					<td>${reserv.dateReserv }</td>
					<td>${reserv.dateRdv }</td>
					<td><c:forEach items="${reserv.formations }" var="formation">${formation.titre }<br></c:forEach></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty listReservation }">
		<h3 style="text-align: center; background-color: fuchsia; font-family: cursive;">Aucun Rendez-vous pr&eacute;vu</h3>
		<br>
		<hr>
	</c:if>
</body>
<script src="resources/js/jquery.js"></script>
<script
	src="resources/js/jquery-ui.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
</html>