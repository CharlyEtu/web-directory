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
<h1>SUCESS !!!!!</h1>

<b> Vous �tes conneter en tant que <c:out value="${name}" default="None" /> </b>
     <br/>
	<a href="edit"> Editer une personne</a>

</body>
</html>