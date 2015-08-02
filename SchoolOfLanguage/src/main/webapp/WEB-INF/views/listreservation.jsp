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
<title>Liste Reservation</title>
</head>
<body>
      <c:if test="${not empty listReservation }">
      <table class="table table-hover">
      <tr><th>NOM</th><th>PR&Eacute;NOM</th><th>E-MAIL</th><th>GSM</th><th>DATE RDV</th></tr>
      <c:forEach items="${listReservation }" var="reserv">
      <tr><td>${reserv.nom }</td><td>${reserv.prenom }</td><td>${reserv.email }</td><td>${reserv.gsm }</td><td>${reserv.dateReserv }</td></tr>
      </c:forEach>
      </table>
      </c:if>
      <c:if test="${empty listReservation }">
      <h3>Aucun Rendez-vous pr&eacute;vu </h3><br>
      <hr>
      </c:if>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>