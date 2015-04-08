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
<title>Detail Formation</title>
</head>
<body>
     <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
     </c:forEach>
     <form:form modelAttribute="detailFormation" action="detailformationsubmit">
      Formation&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="formation" class="form-control" ><option value="-1" selected="selected">Choix</option>
     <c:forEach items="${listFormation }" var="formation">
     <option value="${formation.id }">${formation.titre }</option>
     </c:forEach>
     </select>&nbsp;&nbsp;<br><br>
     Local&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="local" class="form-control"><option value="" selected="selected">Choix</option>
     <c:forEach items="${listLocal }" var="local">
     <option value="${local.id }">${local.numLocal }</option>
     </c:forEach>
     </select><br><br>
     Ann&eacute;e Scolaire&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="rentreeScolaires"><option value="" selected="selected">Choix</option>
     <c:forEach items="${listAnnee }" var="annee">
     <option value="${annee.id }">${annee.dateScolaireDeb }</option>
     </c:forEach>
     </select><br><br>
     Matin&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="seance" value="MATIN"> &nbsp;&nbsp;&nbsp;&nbsp;Soir&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="seance" value="SOIR"/>
     <table>            
           <tr><td>Niveau</td><td><input type="number" name="niveau" >&nbsp;&nbsp;<form:errors path="niveau" cssStyle="color: red;"/></td></tr>
           <tr><td>Quota</td><td><input type="number" name="quota" >&nbsp;&nbsp;<form:errors path="quota" cssStyle="color: red;"/></td></tr>
           <tr><td><input type="submit" value="Enregistrer" class="btn btn-primary"></td></tr>
     </table>
     </form:form>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>