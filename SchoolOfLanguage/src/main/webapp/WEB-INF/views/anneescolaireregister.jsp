<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Année Scolaire</title>
</head>
<body>
      <c:forEach items="${messageError }" var="message">
      <p id="messageErreur">${message }</p>
     </c:forEach>
      <form:form modelAttribute="anneeScolaire" action="anneescolairesubmit">
      <table>
            <tr><td>Rentrée</td><td><input type="date" name="dateScolaireDeb" required></td><td><form:errors path="dateScolaireDeb" cssStyle="color: red;"/></td></tr>
            <tr><td><input type="submit" value="Enregister"></td></tr>
      </table>
      </form:form>
</body>
</html>