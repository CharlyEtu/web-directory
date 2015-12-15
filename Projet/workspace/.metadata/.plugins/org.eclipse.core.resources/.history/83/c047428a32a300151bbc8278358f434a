<c:url var="signout" value="/signout" />
<c:url var="signin" value="/signin" />

<div id="header">
	<div id="banner">
		<h1>
			<a href="home" title="Page d'accueil">
				<!--<img id="logo" alt="Logo" src="avatar.png" />-->
				<span>Annuaire web</span>
			</a>
		</h1>
		<h2>Faculté des Sciences - Aix-Marseille Université</h2>
	</div>
	
	<div id="top-bar">
		<c:choose>
			<c:when test="${userInfo.isAuthenticated()}">
				<a href="${signout}" title="Déconnexion">Déconnexion</a>
			</c:when>
			<c:otherwise>
				<a href="${signin}" title="Connexion">Connexion</a>
			</c:otherwise>
		</c:choose>
	</div>
</div>