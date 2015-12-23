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
<title>Employe register</title>
<script type="text/javascript">
$("#notification-message").show().delay(7000).fadeOut();
</script>
</head>
<body>
<c:if test="${messageSuccess}">
<div id="notification-message">
   <div class="alert alert-success" role="alert">
         <span class="glyphicon glyphicon-thumbs-up icon-white"></span>${messageSuccess}
   </div>	
</div>
 <span class="glyphicon glyphicon-thumbs-up icon-white"></span>${messageSuccess}
</c:if>
    <table class="table table-bordered">
     <c:forEach items="${listEmploye }" var="employe">
     <tr><td>${employe.nom }</td></tr>
     </c:forEach>
    </table> 
<script src="resources/js/scriptMessage.js"></script>	 
</body>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
</html>