<%@ include file="/WEB-INF/jsp/includes/meta.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<!-- EN-TÊTE DE LA PAGE (Meta-informations) -->
	<head>
		<%@ include file="includes/stylesheets.jsp" %>
		<title>Annuaire web</title>
	</head>
	
	<!-- CORPS DE LA PAGE -->
	<body>
		<!-- HEADER -->
		<%@ include file="includes/header.jsp" %>

		<!-- PANNEAU LATÉRAL -->
		<%@ include file="includes/side_pannel.jsp" %>
   
   		<!-- CONTENU -->
		<div id="contents">
    		<h2>Édition de la fiche</h2>
    		
    		<form:form method="POST" commandName="person">
    			<form:errors path="*" cssClass="errorBlock" element="div" />
    			
    			Prénom<br />
    			<form:input path="firstname" value="${person.getFirstname()}" /><br />
    			<form:errors path="firstname" cssClass="error" /><br />
    			
    			Nom<br />
    			<form:input path="lastname" value="${person.getLastname()}" /><br />
    			<form:errors path="lastname" cssClass="error" /><br />
    			
    			Date de naissance<br />
    			<form:input path="birthdate" value="${person.getBirthdate()}" /><br />
    			<form:errors path="birthdate" cssClass="error" /><br />
    			
    			Email<br />
    			<form:input path="email" value="${person.getEmail()}" /><br />
    			<form:errors path="email" cssClass="error" /><br />
    			
    			Site web<br />
    			<form:input path="website" value="${person.getWebsite()}" /><br />
    			<form:errors path="website" cssClass="error" /><br />
    			
    			Groupe<br />
    			<form:input path="group" value="${person.getGroup().getName()}" /><br />
    			<form:errors path="group" cssClass="error" /><br />
    			
    			<input type="submit" value="Valider" />  			
    		</form:form>
		</div>
   
   		<!-- FOOTER -->
		<%@ include file="includes/footer.jsp" %>	    
	</body>
</html>