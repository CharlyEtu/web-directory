<%@ include file="/WEB-INF/jsp/includes/meta.jsp" %>

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
			<form:form method="POST" commandName="userService">
				<form:errors path="id"  cssClass="errorBlock" element="div"/>
				    Entrez votre id:<br />
				    <form:input path="id" /><br />
				    
				    <input type="submit" value="Valider" />
			</form:form>
		</div>
   
   		<!-- FOOTER -->
		<%@ include file="includes/footer.jsp" %>	    
	</body>
</html>