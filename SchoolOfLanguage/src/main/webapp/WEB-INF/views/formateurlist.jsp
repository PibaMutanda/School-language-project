<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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
      <table  class="table table-hover">
      <c:forEach items="${formateurlist}" var="formateur">
      <tr><td><a href="formateurformationdisplay?id=${formateur.id}" class="btn btn-primary btn-lg btn-block" title="Associer à une formation">${formateur.prenom}  ${formateur.nom }</a></tr>
      </c:forEach>
      </table>
</body>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
<script
	src="resources/js/angular.min.js"></script>	
 <script src="resources/js/scriptMessage.js"></script>	 

</html>