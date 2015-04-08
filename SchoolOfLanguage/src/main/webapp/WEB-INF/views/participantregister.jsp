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
     <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
     </c:forEach>
     <form:form modelAttribute="participant" action="participantsubmit">
     <table>
          <tr><td>Nom</td><td><form:input path="nom"/>&nbsp;&nbsp;<form:errors path="nom" cssStyle="color: red;"/></td></tr>
          <tr><td>Prénom</td><td><form:input path="prenom"/>&nbsp;&nbsp;<form:errors path="prenom" cssStyle="color: red;"/></td></tr>
          <tr><td>Gsm</td><td><form:input path="gsm"/>&nbsp;&nbsp;<form:errors path="gsm" cssStyle="color: red;"/></td></tr>
          <tr><td>E-Mail</td><td><form:input path="email"/>&nbsp;&nbsp;<form:errors path="email" cssStyle="color: red;"/></td></tr>
          <tr><td>Ville</td><td><form:input path="ville"/>&nbsp;&nbsp;<form:errors path="ville" cssStyle="color: red;"/>
              &nbsp;&nbsp;Rue&nbsp;&nbsp;<form:input path="rue"/>&nbsp;&nbsp;<form:errors path="rue" cssStyle="color: red;"/>
              &nbsp;&nbsp;Numéro&nbsp;&nbsp;<form:input path="numero"/>&nbsp;&nbsp;<form:errors path="numero" cssStyle="color: red;"/>&nbsp;&nbsp;
              Code Postal&nbsp;&nbsp;<form:input path="codeP"/>&nbsp;&nbsp;<form:errors cssStyle="color: red;" path="codeP"/></td></tr>
              <tr><td>Login</td><td><form:input path="login"/>&nbsp;&nbsp;<form:errors path="login" cssStyle="color: red;"/><td></tr>
              <tr><td><form:hidden path="password"/></td></tr>
              <tr><td>Sexe</td><td><form:radiobutton path="sexe" value="HOMME" />&nbsp;&nbsp;M&nbsp;&nbsp;<form:radiobutton path="sexe" value="FEMME"/>&nbsp;&nbsp;F&nbsp;&nbsp;
                 <form:errors path="sexe" cssStyle="color: red;"/></td></tr>
              <tr><td><form:hidden path="matricule"/>   
        <tr><td><input type="submit" value="Enregistrer" class="btn btn-primary"></td></tr>          
     </table>
     </form:form>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>