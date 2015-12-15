<%@ include file="/WEB-INF/jsp/includes/meta.jsp" %>

<c:url var="webIconMini" value="resources/img/world-wide-web-24958_960_720-2-mini.gif" />
<c:url var="editSheet" value="/usersheet/edit" />
<c:url var="changePwd" value="/usersheet/changepwd" />

<html>
	<!-- EN-TÊTE DE LA PAGE (Meta-informations) -->
	<head>
		<%@ include file="includes/stylesheets.jsp" %>
		<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/sheet.css" />"/>
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
    		<h2>${person.getFirstname()} ${person.getLastname()}</h2>
    		<p>
    			Né le : ${person.getBirthdate()}
    			<span id="affect">
    				${person.getGroup().getName()}
    			</span>
    		</p>
    		<p>Email : ${person.getEmail()}
    		<p>
    			<img id="webIconMini" src="${webIconMini}" />
    			<a href="${person.getWebsite()}"
    			  title="Site web de ${person.getFirstname()} ${person.getLastname()}">
    				Site web personnel
    			</a> 
    		</p>
    		<c:if test="${userInfo.isAuthenticated() &&
    					(person.getId() == userInfo.getId())}">
    			<p id="editLinks">
    				<a href="${editSheet}" title="Éditer votre fiche">
    					Éditer ma fiche
    				</a>
    				<a href="${changePwd}" title="Modifier votre mot de passe">
    					Modifier mon mot de passe
    				</a>
    			</p>
    		</c:if>
		</div>
   
   		<!-- FOOTER -->
		<%@ include file="includes/footer.jsp" %>	    
	</body>
</html>