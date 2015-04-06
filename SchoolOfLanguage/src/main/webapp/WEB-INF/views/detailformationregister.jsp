<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Detail Formation</title>
</head>
<body>
     <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
     </c:forEach>
     <form:form modelAttribute="detailFormation" action="detailformationsubmit">
      Formation&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="formation"><option value="-1" selected="selected">Choix</option>
     <c:forEach items="${listFormation }" var="formation">
     <option value="${formation.id }">${formation.titre }</option>
     </c:forEach>
     </select>&nbsp;&nbsp;<br><br>
     Local&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="local"><option value="" selected="selected">Choix</option>
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
           <tr><td><input type="submit" value="Enregistrer"></td></tr>
     </table>
     </form:form>
</body>
</html>