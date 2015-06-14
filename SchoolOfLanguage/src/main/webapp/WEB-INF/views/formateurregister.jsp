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
      <form:form modelAttribute="formateur" action="formateursubmit">
      <table>
            <tr><td><form:input path="nom" placeholder="Nom"/></td><td><form:errors path="nom" cssStyle="color: red;"/></td></tr>
            <tr><td><form:input path="prenom" placeholder="Prénom"/></td><td><form:errors path="prenom" cssStyle="color: red;" /></td></tr>
       <%--      <tr><td>Adresse</td><td><form:input path="adresse"/></td><td><form:errors path="adresse" cssStyle="color: red;"/></td></tr> --%>
            <tr><td><form:password  path="password"  placeholder="Mot de passe"/></td><td><form:errors path="password" cssStyle="color: red;"/></td></tr>
            <tr><td><form:input path="login"  placeholder="Login"/></td><td><form:errors path="login" cssStyle="color: red;"/></td></tr>
<!--             <tr><td>Formation</tr> -->
<%--             <tr><c:forEach items="${formations }" var="formation"><td>${formation.titre }</td><td><form:checkbox path="formations"/></td> --%>
<%--             </c:forEach></tr>  --%>
            <tr><td><input type="submit" value="Enregistrer" class="btn btn-primary"></td></tr>
      </table>
      </form:form>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>