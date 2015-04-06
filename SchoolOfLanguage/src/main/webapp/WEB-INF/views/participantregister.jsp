<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ajout Participant</title>
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
        <tr><td><input type="submit" value="Enregistrer"></td></tr>          
     </table>
     </form:form>
</body>
</html>