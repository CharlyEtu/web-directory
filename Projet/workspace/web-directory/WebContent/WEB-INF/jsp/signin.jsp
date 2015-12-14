<%@ include file="/WEB-INF/jsp/includes/meta.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<!-- EN-TÊTE DE LA PAGE (Meta-informations) -->
	<head>
		<%@ include file="includes/stylesheets.jsp" %>
		<title>Annuaire web - Authentification</title>
	</head>
	
	<!-- CORPS DE LA PAGE -->
	<body>
		<!-- HEADER -->
		<%@ include file="includes/header.jsp" %>

		<!-- PANNEAU LATÉRAL -->
		<%@ include file="includes/side_pannel.jsp" %>
   
   		<!-- CONTENU -->
		<div id="contents">
	   		<form:form method="POST" commandName="authenticationForm">
	   			<form:errors path="*" cssClass="errorBlock" element="div" />
	   			
	   			Email<br />
	   			<form:input path="login" /><br />
	   			<form:errors path="login" cssClass="error" /><br />
	   			
	   			Mot de passe<br />
	   			<form:password path="pwd" /> <br />
	   			<form:errors path="pwd" cssClass="error" /><br />
	   			
	   			<input type="submit" value="Connexion" />		
	   		</form:form>
		</div>
   
   		<!-- FOOTER -->
		<%@ include file="includes/footer.jsp" %>	    
	</body>
</html>