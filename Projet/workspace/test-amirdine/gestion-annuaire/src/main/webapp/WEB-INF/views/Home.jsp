<%@ page session="false" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<html>
  <head><title> Gestion d'annuaire </title></head>
  <body>
    <h1> Gestion d'annuaire</h1> <br/>
    <p>Date:  <c:out value="${now}" default="None" /></p>
    <p>Utilisateur actuel  <c:out value="${user.id}" default="None" /></p>
  </body>
</html>