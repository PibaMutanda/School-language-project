<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ajout local</title>
</head>
<body>
    <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
     </c:forEach>
     <form:form modelAttribute="local" action="localsubmit">
     <table>
        <tr><td>Numéro Local</td><td><form:input path="numLocal"/></td><td><form:errors path="numLocal" cssStyle="color: red;"/></td></tr>
        <tr><td>Capacité</td><td><input type="number" name="capacite"></td><td><form:errors path="capacite" cssStyle="color: red;"/></td></tr>
        <tr><td><input type="submit" value="Enregistrer"></td></tr>
     </table>
     </form:form>
</body>
</html>