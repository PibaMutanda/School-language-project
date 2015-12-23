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
<title></title>
</head>
<body>
    <c:choose>
    <c:when test="${not empty employe }">
     <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
     </c:forEach>
     <form:form modelAttribute="statutProfessionnel" action="statutprofessionnelsubmit">
     <table class="table">
           <tr><td>
              Statut Professionnel
           </td></tr>
           <tr>
               <td><form:input path="statut" placeholder="Statut Professionnel"/></td>
               <td><form:errors path="statut" cssStyle="color: #ff0000;"></form:errors></td>
           </tr>
           <tr><td>
              Prix
           </td></tr>
           <tr><td><form:input path="prix" placeholder="Prix"/></td>
               <td><form:errors path="prix" cssStyle="color: #ff0000;"></form:errors></td>
           <tr>
              <td><input type="submit" value="Enregistrer"  class="btn btn-primary"></td>
           </tr>       
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