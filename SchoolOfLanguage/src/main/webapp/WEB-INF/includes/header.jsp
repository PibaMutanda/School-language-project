<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page import="be.school.model.Formateur"%>
<%@page import="be.school.model.Employe"%>
<html>
<head>
<link rel="stylesheet" href="resources/css/jquery-ui.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script>
	$(document).ready(function() {
		$("#notification-message").show().delay(5000).fadeOut(); // Was hidden at the beginning.

		// 	var tId;

		// 	$("#notification-message").hide().slideDown();
		// 	clearTimeout(tId);
		// 	tId=setTimeout(function(){
		// 	  $("#notification-message").hide();        
		// 	}, 5000);
	});
</script>
</head>
<nav class="navbar navbar-inverse" role="navigation">
	<div class="container-fluid">
		<a class="navbar-brand" href="home">School of Languages</a>
		<div class="navbar-header">
			<ul class="nav navbar-nav">
				<li><a href="home"><span class="glyphicon glyphicon-home"
						aria-hidden="true"></span></a></li>
				<li><a href="formationlist">Nos formations</a></li>
				<li><a href="showpublishinscription">Inscription</a></li>
				<li><a href="#">Contactez-nous</a></li>
				<li><a href="#">A Propos</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Dropdown
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="collapse navbar-collapse navHeaderCollapse">
			<ul class="nav navbar-nav navbar-right">
				<%
					Formateur formateur = (Formateur) session.getAttribute("formateur");
					Employe employe = (Employe) session.getAttribute("employe");
					if (formateur != null) {
						out.println("<li><a href='#'>" + formateur.getPrenom() + " "
								+ formateur.getNom() + "</a></li>");
				%>
				<li><a href="logout" class="glyphicon glyphicon-lock">&nbsp;D&eacute;connexion</a></li>
				<%
					} else if (employe != null) {
						out.println("<li><a href='#'>" + employe.getNom() + "</a></li>");
				%>
				<li><a href="logout" class="glyphicon glyphicon-lock">&nbsp;D&eacute;connexion</a></li>
				<%
					} else {
				%>
				<li><a href="login">Connexion</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
</nav>
<div>
	<c:if test="${!empty sessionScope.notifications}">
		<div id="notification-message">
			<div class="alert alert-success" role="alert">
				<span class="glyphicon glyphicon-thumbs-up icon-white"></span>
				<c:forEach items="${sessionScope.notifications}" var="notif">
            ${notif.text}<br />
				</c:forEach>
				<%
					session.removeAttribute("notifications");
				%>
			</div>
		</div>
	</c:if>
</div>
<div class="container">
	<div class="jumbotron">
		<h2 style="text-align: center;">Hello World</h2>
		<div style="text-align: center; background-color: buttonface;">
			<a href="#" id="lien"><img
				src="resources/images/imageLangue1.gif" alt="livre"></a>
		</div>
		<h2 style="text-align: center;">Hola mundo</h2>
	</div>
</div>
</html>