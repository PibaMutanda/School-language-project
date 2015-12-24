<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<title></title>
</head>
<body>
<c:if test="${!empty sessionScope.notifications}">
<c:forEach items="${sessionScope.notifications}"   var="notif">
            ${notif.text}<br/>
</c:forEach>
</c:if>
</body>
</html>