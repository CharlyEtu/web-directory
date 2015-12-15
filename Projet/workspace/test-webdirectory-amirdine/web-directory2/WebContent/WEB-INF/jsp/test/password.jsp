<%@ page session="false" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<style>
.error {
    color: #ff0000;
}
.errorblock{
    color: #000;
    background-color: #ffEEEE;
    border: 3px solid #ff0000;
    padding:8px;
    margin:16px;
}
</style>
</head>

<body>
<h1>Recuperation mot de pass</h1>

<form:form method="POST" commandName="userService">
    <form:errors path="id"  cssClass="errorblock" element="div"/>
    <table>
    <tr>
        <td>Entrez votre id: </td>
        <td><form:input path="id" /></td>
    </tr>
     <tr>
        <td colspan="3"><input type="submit" /></td>
     </tr>
  
    </table>
</form:form>

</body>
</html>