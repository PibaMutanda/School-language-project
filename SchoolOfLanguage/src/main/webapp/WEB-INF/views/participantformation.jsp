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
<h3>Ajout Participant</h3>
     <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
     </c:forEach>
     <div class="table-responsive">
     <table class="table">
     <form class="form-horizontal" action="participantformationsubmit" method="post">
      <select class="form-control" name="participant">
      <option value="0">Participant</option>
      <c:forEach items="${listParticipant}" var="participant">
      <option value="${participant.id }" >${participant.prenom }   ${participant.nom}</option>
      </c:forEach>
      </select>
       <select class="form-control" name="formation">
       <option value="0">Formation</option>
       <c:forEach items="${listFormation }" var="formation">
       <option value="${formation.id }">${formation.titre }</option>
       </c:forEach>
       </select>
       <select class="form-control" name="local">
       <option value="0">Local</option>
       <c:forEach items="${listLocal }" var="local">
       <option value="${local.id }">${local.numLocal }</option>
       </c:forEach>
       </select>
       <input type="submit" value="Enregistrer" class="btn btn-primary">
      </form>
     </table>
     </div>
     
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>