<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<link href="resources/css/style.css"
	rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
 <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
 </c:forEach>
<form action="detailFormation" method="get">
<table class="table table-hover">
    <c:forEach items="${listformations}" var="formation">
    <tr>
       <td><input type="submit" value="${formation.titre }" name="titre" class="btn btn-primary btn-lg btn-block"></td>
    </tr>
    </c:forEach>
</table> 
</form>   
</body>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</html>