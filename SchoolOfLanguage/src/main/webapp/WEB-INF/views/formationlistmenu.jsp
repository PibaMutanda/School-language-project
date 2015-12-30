<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<link href="resources/css/style.css"
	rel="stylesheet" type="text/css">
 <link rel="stylesheet" href="resources/css/jquery-ui.css">	
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
<title></title>
</head>
<body>
<script>
  $(function() {
    $( "#accordion" ).accordion();
  });
</script>
<div id="accordion">
<c:forEach items="${listFormation }" var="formation">
 
  <h3>${formation.titre }</h3>
  <div>
    <p>
    Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
    purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
    velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
    suscipit faucibus urna.
    </p>
      <ul>
      <li><a href="participantformation?niveau=1&id=${formation.id}">${formation.titre }</a> 1</li>
      <li><a href="participantformation?niveau=2&id=${formation.id}">${formation.titre }</a> 2</li>
      <li><a href="participantformation?niveau=3&id=${formation.id}">${formation.titre }</a> 3</li>
      <li><a href="participantformation?niveau=4&id=${formation.id}">${formation.titre }</a> 4</li>
      <li><a href="participantformation?niveau=5&id=${formation.id}">${formation.titre }</a> 5</li>
      <li><a href="participantformation?niveau=6&id=${formation.id}">${formation.titre }</a> 6</li>
      <li><a href="participantformation?niveau=7&id=${formation.id}">${formation.titre }</a> 7</li>
      <li><a href="participantformation?niveau=8&id=${formation.id}">${formation.titre }</a> 8</li>
      <li><a href="participantformation?niveau=9&id=${formation.id}">${formation.titre }</a> 9</li>
    </ul>
  </div>
   </c:forEach>
</div>
</body>
</html>