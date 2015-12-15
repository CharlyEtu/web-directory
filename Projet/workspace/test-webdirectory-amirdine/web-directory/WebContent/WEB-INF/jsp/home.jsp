<%@ include file="/WEB-INF/jsp/includes/meta.jsp" %>

<html>
  <!-- EN-T�TE DE LA PAGE (Meta-informations) -->
  <head>
  	<%@ include file="includes/stylesheets.jsp" %>
    <title>Annuaire web - Accueil</title>
  </head>
  
  <!-- CORPS DE LA PAGE -->
  <body>
  	<!-- HEADER -->
  	<%@ include file="includes/header.jsp" %>
  	
  	<!-- PANNEAU LAT�RAL -->
  	<%@ include file="includes/side_pannel.jsp" %>
    
    <!-- CONTENU -->
    <div id="contents">
    	<h2>Personnes r�f�renc�es dans l'annuaire</h2>
    
    	<!-- Liste des personnes -->
	    <table>
	    	<tr>
	    		<th>Pr�nom</th>
	    		<th>Nom</th>
	    		<th>Web</th>
	    		<th>Affectation</th>
	    	</tr>
	    	<!-- Listing des personnes -->
	   		<c:forEach var="p" items="${personIterator}">
	   			<tr>
	   				<td><c:out value="${p.getFirstname()}" default="None" /></td>
	   				<td><c:out value="${p.getLastname()}" default="None" /></td>
	   				<td style="text-align: center;">
	   					<a href="https://${p.getWebsite()}" 
	   					   title="Site web de ${p.getFirstname()} ${p.getLastname()}">
	   						<img src="img/world-wide-web-24958_960_720-2.gif" alt="web" />
	   					</a>
	   				</td>
	   				<td><c:out value="${p.getGroup().getName()}" default="None" /></td>
	   			</tr>
	   		</c:forEach>
	    </table>
	</div>
    
    <b> IMPORTANT </b>
    <a href="test/login"> Connexion</a>
     <a href="test/password"> Mot de pass perdu</a>
    <!-- FOOTER -->
	<%@ include file="includes/footer.jsp" %>	    
  </body>
</html>