<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Enregistrement Formateur</title>
</head>
<body>
      <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
     </c:forEach>
      <form:form modelAttribute="formateur" action="formateursubmit">
      <table>
            <tr><td>Nom</td><td><form:input path="nom"/></td><td><form:errors path="nom" cssStyle="color: red;"/></td></tr>
            <tr><td>Prénom</td><td><form:input path="prenom"/></td><td><form:errors path="prenom" cssStyle="color: red;" /></td></tr>
       <%--      <tr><td>Adresse</td><td><form:input path="adresse"/></td><td><form:errors path="adresse" cssStyle="color: red;"/></td></tr> --%>
            <tr><td>Mot de passe</td><td><form:password path="password"  /></td><td><form:errors path="password" cssStyle="color: red;"/></td></tr>
            <tr><td>Login</td><td><form:input path="login" /></td><td><form:errors path="login" cssStyle="color: red;"/></td></tr>
       <%--      <tr><td>Formation</tr>
            <tr><c:forEach items="${formations }" var="formation"><td>${formation.titre }</td><td><form:checkbox path="formations"/></td>
            </c:forEach></tr> --%>
            <tr><td><input type="submit" value="Enregistrer"></td></tr>
      </table>
      </form:form>
</body>
</html>