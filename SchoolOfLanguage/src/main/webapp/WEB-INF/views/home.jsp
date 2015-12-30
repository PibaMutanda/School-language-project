<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/jquery-ui.css">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<script>
	$(window).load(function() {
		$('#myModal').modal('show');
	});
</script>
<title>Home</title>
</head>
<body>
	<c:if test="${!empty sessionScope.communications}">
		<div class="modal fade" tabindex="-1" role="dialog" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">COMMUNICATION</h4>
					</div>
					<div class="modal-body">
						<p>
							<c:forEach items="${sessionScope.communications}" var="notif">
            ${notif.text}<br />
							</c:forEach>
							<%
								session.removeAttribute("communications");
							%>&hellip;
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</c:if>
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			<li data-target="#carousel-example-generic" data-slide-to="3"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="resources/images/livre.gif" alt="livre">
				<div class="carousel-caption">...</div>
			</div>
			<div class="item">
				<img src="resources/images/imageLangue2.gif" alt="langue">
				<div class="carousel-caption">...</div>
			</div>
			<div class="item">
				<img src="resources/images/salleLangue.jpg" alt="sale">
				<div class="carousel-caption">...</div>
			</div>
			...
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<h1>Hello world!</h1>
	<c:forEach items="${messageError }" var="message">
		<p id="messageErreur">${message }</p>
	</c:forEach>
	${controllerMessage}
</body>
<script src="resources/js/jquery.bpopup.min.js"></script>
</html>
