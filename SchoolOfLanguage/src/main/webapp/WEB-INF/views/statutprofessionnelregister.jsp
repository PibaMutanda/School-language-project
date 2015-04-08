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
     <form:form modelAttribute="statutProfessionnel" action="statutprofessionnelsubmit">
     <table>
           <tr><td> Statut Professionnel</td>
               <td><form:input path="statut"/></td>
               <td><form:errors path="statut" cssStyle="color: #ff0000;"></form:errors></td>
           </tr>
           <tr>
              <td><input type="submit" value="Enregistrer"  class="btn btn-primary"></td>
           </tr>       
     </table>
     </form:form>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>