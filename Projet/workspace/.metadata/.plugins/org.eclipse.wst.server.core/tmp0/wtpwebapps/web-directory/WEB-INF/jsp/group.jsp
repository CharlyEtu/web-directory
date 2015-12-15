<%@ include file="/WEB-INF/jsp/includes/meta.jsp" %>

<c:url var="webIcon" value="/resources/img/world-wide-web-24958_960_720-2.gif" />
<c:url var="sheet" value="/usersheet"/>
<c:url var="sheetIcon" value="/resources/img/user_file.jpg" />

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
    	<h2>${groupName}</h2>
    
    	<!-- Liste des personnes -->
	    <table>
	    	<tr>
	    		<th>Pr�nom</th>
	    		<th>Nom</th>
	    		<th>Web</th>
	    		<th>Affectation</th>
	    		<c:if test="${userInfo.isAuthenticated()}">
	    			<th>Fiche</th>
	    		</c:if>
	    	</tr>
	    	<!-- Listing des personnes -->
	   		<c:forEach var="p" items="${personIterator}">
	   			<tr>
	   				<td><c:out value="${p.getFirstname()}" default="None" /></td>
	   				<td><c:out value="${p.getLastname()}" default="None" /></td>
	   				<td style="text-align: center;">
	   					<a href="${p.getWebsite()}" 
	   					   title="Site web de ${p.getFirstname()} ${p.getLastname()}">
	   						<img src="${webIcon}" alt="web" />
	   					</a>
	   				</td>
	   				<td><c:out value="${p.getGroup().getName()}" default="None" /></td>
	   				<c:if test="${userInfo.isAuthenticated()}">
	   					<td style="text-align: center;">
	   						<a href="${sheet};id=${p.getId()}" title="Fiche d�taill�e de ${p.getFirstname()} ${p.getLastname()}">
	   							<img src="${sheetIcon}" alt="fiche" />
	   						</a>
	   					</td>
	   				</c:if>
	   			</tr>
	   		</c:forEach>
	    </table>
	</div>
	
    <!-- FOOTER -->
	<%@ include file="includes/footer.jsp" %>	    
  </body>
</html>