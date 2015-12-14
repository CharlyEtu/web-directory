<%@ include file="/WEB-INF/jsp/includes/meta.jsp" %>

<html>
	<!-- EN-T�TE DE LA PAGE (Meta-informations) -->
	<head>
		<%@ include file="includes/stylesheets.jsp" %>
		<title>Annuaire web - Erreur</title>
	</head>
	
	<!-- CORPS DE LA PAGE -->
	<body>
		<!-- HEADER -->
		<%@ include file="includes/header.jsp" %>

		<!-- PANNEAU LAT�RAL -->
		<%@ include file="includes/side_pannel.jsp" %>
   
   		<!-- CONTENU -->
		<div id="contents">
    		<h2>/!\ Attention</h2>
    		<p>${warnMsg}</p>
		</div>
   
   		<!-- FOOTER -->
		<%@ include file="includes/footer.jsp" %>	    
	</body>
</html>