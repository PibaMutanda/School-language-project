<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
<head>
<title>Enregistrer une Formation</title>
</head>
<body>
     <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
     </c:forEach>
     <form:form action="formationsubmit" modelAttribute="formation">
      <table>
      <tr><td>Formation</td><td><form:input path="titre"/> </td><td><form:errors path="titre" cssStyle="color: red;"/></td></tr>
   <%--    <tr><td>Quota</td><td><input type="number" name="quota"></td><td><form:errors path="quota" cssStyle="color: red;"/></td></tr> --%>
    <%--   <tr><td>Code Formation</td><td><form:input path="codeFormation"/> </td><td><form:errors path="codeFormation" cssStyle="color: red;" /></td></tr>--%>
      <tr><td><input type="submit" value="Enregistrer"></td></tr>
      </table>
     </form:form>
</body>
</html>