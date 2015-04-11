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
     <form action="formateurformsubmit" method="post">
        ${formateur.nom }<br><br>
     S&eacute;ance
     <select name="seance">
     <option value="">Choix</option>
     <c:forEach items="${detailListForm.seance }" var="seance">
     <option value="${detailListForm.id}">${seance }</option>
     </c:forEach>   
     </select>
     Niveau:
     <select name="niveau">
     <option value="">Choix</option>
     <c:forEach items="${detailListForm.niveau}" var="niveau">
     <option value="${detailListForm.id}">${niveau}</option>
     </c:forEach>
     </select>
     Local:
     <select name="local">
     <option value="">Choix</option>
     <c:forEach items="detailListForm.local" var="local">
     <option value="${detailListForm.id }">${local.numLocal }</option>
     </c:forEach>
     </select>
     <input type="submit" value="Enregistrer" class="btn btn-primary">
     </form>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>