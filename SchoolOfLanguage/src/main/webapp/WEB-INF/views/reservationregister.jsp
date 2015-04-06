<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Demande Inscription</title>
</head>
<body>
     <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
     </c:forEach>
     <form:form action="reservationsubmit" modelAttribute="reservation">
     <table>
      <tr><td>Nom</td><td><input type="text" name="nom" required></td><td><form:errors path="nom" cssStyle="color: red;"/></td></tr>
      <tr><td>Prénom</td><td><input type="text" name="prenom" required></td><td><form:errors path="prenom" cssStyle="color: red;"/></td></tr>
      <tr><td>E-mail</td><td><input type="email" name="email" required></td><td><form:errors path="email" cssStyle="color:red;"/><td></tr>
      <tr><td>Gsm</td><td><input type="tel" name="gsm"></td><td><form:errors cssStyle="color:red;" path="gsm"/></td></tr>
      <tr><c:forEach items="${formations }" var="formation">
      <td>${formation.titre }&nbsp;<input type="checkbox" value="${formation.id }" name="formations"></td>
      </c:forEach></tr>
<!--       <tr><td><input type="hidden" name="dateReserv"></td><td><input type="hidden" name="dateRdv"> </td> </tr> -->
      <tr><td><input type="submit" value="Envoyer"></td></tr>
     </table> 
     </form:form>
</body>
</html>