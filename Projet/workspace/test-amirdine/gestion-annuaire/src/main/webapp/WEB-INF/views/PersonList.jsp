<%@ page session="false" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<html>
<head>
<title>Gestion annuaire</title>
</head>
<body>
    <h1>Liste de personnes</h1>
    <table border='1'>
    <c:forEach items="${persons}" var="pers">
        <tr>
           <td><a href="/"> <c:out value="${pers.lastname}" /></a> </td>
           
           <c:if test="${user.id > 0}">
           <td>   <c:out value="${pers.firstname}"/> </td>
           </c:if>
        
        </tr>
    </c:forEach>
    </table>
</body>
</html>