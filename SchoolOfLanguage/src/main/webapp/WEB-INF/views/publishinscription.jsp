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
<title>Inscription</title>
</head>
<body>
	<c:forEach items="${messageError }" var="message">
		<p id="messageErreur">${message }</p>
	</c:forEach>
	<form action="publishinscriptionsubmit" method="post"
		class="form-horizontal">
		<input type="hidden" name="id" value="${employe.id }">
		<div class="form-group">
			<label for="inputDateDeb" class="col-sm-2 control-label">D&eacute;but
				inscription</label>
			<div class="col-sm-10">
				<input type="date" class="form-control" id="inputDateDeb"
					name="dateDeb" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="inputDateFin" class="col-sm-2 control-label">Fin
				inscription</label>
			<div class="col-sm-10">
				<input type="date" class="form-control" id="inputDateFin"
					name="dateFin" required="required">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Enregistrer</button>
			</div>
		</div>
	</form>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/angular.min.js"></script>
</html>