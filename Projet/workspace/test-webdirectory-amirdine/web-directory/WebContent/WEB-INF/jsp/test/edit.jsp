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
<h1>Edit Personne</h1>

<form:form method="POST" commandName="person">
    <form:errors path="*" cssClass="errorblock" element="div"/>
    <table>
    <tr>
        <td>Prénom: </td>
        <td><form:input path="firstname" value="${firstname}" /></td>
        <td><form:errors path="firstname" cssClass="error" /></td>
    </tr>
    <tr>
        <td>Nom : </td>
        <td><form:input path="lastname" value="${lastname}"  /></td>
        <td><form:errors path="lastname" cssClass="error" /></td>
    </tr>
     <tr>
        <td>Email : </td>
        <td><form:input path="email" value="${email}" /></td>
        <td><form:errors path="lastname" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td>Date : </td>
        <td><form:input path="" name="date" value="${birthdate}" /></td>
        <td><form:errors path="" name="birthdate" cssClass="error" /></td>
    </tr>
    
    <tr>
    <td>Groupe: </td>
    <td>
        <form:select path="" name="group_" multiple="false">
            <form:option value="" label="--- Select ---" />
            <form:options items="${groups}" />
        </form:select>
    </td>
  </tr>
    
    <tr>
        <td colspan="3"><input type="submit" /></td>
    </tr>
    
  
    
    
    </table>
</form:form>

</body>
</html>