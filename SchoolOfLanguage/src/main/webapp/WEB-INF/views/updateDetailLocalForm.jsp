<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
<c:choose>
 <c:when test="${not empty employe }">
	<c:forEach items="${messageError }" var="message">
		<p id="messageErreur">${message }</p>
	</c:forEach>
 <div class="table-responsive">
   <form class="form-horizontal" action="updatedetaillocalformsubmit" method="post">
    <table class="table">
    <tr><td><input type="hidden" name="id" value="${detailLocalFormation.id }"></td></tr>
    <tr><td>Formation</td><td>
    <select class="form-control" name="formation">
    <option value="${detailLocalFormation.formation.id }">${detailLocalFormation.formation.titre }</option>
    <c:forEach items="${formations }" var="formation">
    <option value="${formation.id }">${formation.titre }</option>
    </c:forEach>
    </select></td></tr>
    <tr><td>Local</td><td><select class="form-control" name="local">
    <option value="${detailLocalFormation.local.id }">${detailLocalFormation.local.numLocal }</option>
    <c:forEach items="${locaux }" var="local">
    <option value="${local.id }">${local.numLocal}</option>
    </c:forEach>
    </select> </td></tr>
    <tr><td>Jour</td><td><select  class="form-control" name="jour">
    <option value="${detailLocalFormation.jour }">${detailLocalFormation.jour }</option>
    <c:forEach items="${jours }" var="jour">
    <option value="${jour }">${jour }</option>
    </c:forEach>
    </select></td></tr>
    <tr><td>S&eacute;ance</td><td><select name="seance" class="form-control">
    <option value="${detailLocalFormation.seance }">${detailLocalFormation.seance }</option>
    <c:forEach items="${seances }" var="seance">
    <option value="${seance }">${seance }</option>
    </c:forEach>
    </select></td>
    <tr><td>Niveau</td><td><input type="number" value="${detailLocalFormation.niveau }" name="niveau"> </td>
    </tr>
    <tr><td>Quota</td><td><input type="number" name="quota" value="${detailLocalFormation.quota }"></td></tr>
    </table>
     <input type="submit" value="Enregistrer" class="btn btn-primary">
   </form>
  
 </div>
 </c:when>
  <c:otherwise>
     <%@ include file="/WEB-INF/bannedfile.html" %>
     </c:otherwise>
 </c:choose>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>