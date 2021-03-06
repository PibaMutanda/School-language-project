<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<link href="resources/css/style.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript">
$("#notification-message").show().delay(7000).fadeOut();
</script>	
<title>Detail Formation</title>
</head>
<body>
     <c:choose>
     <c:when test="${not empty employe }">
     <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
     </c:forEach>
     <h2 id="titre">Ajouter une formation</h2>
     <form:form action="formationsubmit" modelAttribute="formation">
      <table class="table">
      <tr><td>Formation</td></tr>
      <tr><td><form:input path="titre" placeholder="Titre Formation"/> </td><td><form:errors path="titre" cssStyle="color: red;"/></td></tr>
   <%--    <tr><td>Quota</td><td><input type="number" name="quota"></td><td><form:errors path="quota" cssStyle="color: red;"/></td></tr> --%>
    <%--   <tr><td>Code Formation</td><td><form:input path="codeFormation"/> </td><td><form:errors path="codeFormation" cssStyle="color: red;" /></td></tr>--%>
      <tr><td><input type="submit" value="Enregistrer" class="btn btn-primary"></td></tr>
      </table>
     </form:form>
      </c:when>
       <c:otherwise>
     <%@ include file="/WEB-INF/bannedfile.html" %>
     </c:otherwise>
      </c:choose>
</body>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
</html>