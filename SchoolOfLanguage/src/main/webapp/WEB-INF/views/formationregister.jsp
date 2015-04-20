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
<title>Detail Formation</title>
</head>
<body>
     <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
     </c:forEach>
     <form:form action="formationsubmit" modelAttribute="formation">
      <table>
      <tr><td><form:input path="titre" placeholder="Titre Formation"/> </td><td><form:errors path="titre" cssStyle="color: red;"/></td></tr>
   <%--    <tr><td>Quota</td><td><input type="number" name="quota"></td><td><form:errors path="quota" cssStyle="color: red;"/></td></tr> --%>
    <%--   <tr><td>Code Formation</td><td><form:input path="codeFormation"/> </td><td><form:errors path="codeFormation" cssStyle="color: red;" /></td></tr>--%>
      <tr><td><input type="submit" value="Enregistrer" class="btn btn-primary"></td></tr>
      </table>
     </form:form>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>