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
<title></title>
</head>
<body>
     <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
     </c:forEach>
     <form:form action="reservationsubmit" modelAttribute="reservation">
     <table>
      <tr><td><input type="text" name="nom" placeholder="Nom" required></td><td><form:errors path="nom" cssStyle="color: red;"/></td></tr>
      <tr><td><input type="text" name="prenom" placeholder="Prénom" required></td><td><form:errors path="prenom" cssStyle="color: red;"/></td></tr>
      <tr><td><input type="email" name="email" placeholder="E-Mail" required></td><td><form:errors path="email" cssStyle="color:red;"/><td></tr>
      <tr><td><input type="tel" name="gsm" placeholder="Gsm"></td><td><form:errors cssStyle="color:red;" path="gsm"/></td></tr>
      <tr><c:forEach items="${formations }" var="formation">
      <td>${formation.titre }&nbsp;<input type="checkbox" value="${formation.id }" name="formations"></td>
      </c:forEach></tr>
<!--       <tr><td><input type="hidden" name="dateReserv"></td><td><input type="hidden" name="dateRdv"> </td> </tr> -->
      <tr><td><input type="submit" value="Enregistrer" class="btn btn-primary"></td></tr>
     </table> 
     </form:form>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>