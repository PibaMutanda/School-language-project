<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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
   <form action="formateurformationdisplay" >
      <table  class="table table-hover">
      <c:forEach items="${formateurlist }" var="formateur">
<%--       <a href="formformateurformation?${formateur.id }" title="Associer une formation"><tr><td>${formateur.nom }</td><td>${formateur.prenom }</td></tr></a> --%>
      <tr><td><input type="submit" name="${formateur.id }" value="${formateur.nom }  ${formateur.prenom}" class="btn btn-primary btn-lg btn-block"></td></tr>
      </c:forEach>
      </table>
   </form>   
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>