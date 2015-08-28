<html>
<%
	String mySession = (String) session.getAttribute("mySession");
%>
<ul role="menu" class="nav nav-pills nav-stacked menu-nav">
	<c:choose>
		<c:when test="${ not empty mySession  }">
			<li><a href="displayprofplanning?id=${formateur.id }">Mon
					planning</a></li>
			<li><a href="updateFormateur?id=${formateur.id }">changer le
					Password</a></li>
		</c:when>
		<c:when test="${employe.roleEmploye eq 'SIMPLE' }">
			<li><a href="statutprofessionnelregister">Ajout Statut
					Professionnel</a></li>
			<li><a href="formateurregister">Ajout Formateur</a></li>
			<li><a href="formationregister">Ajout Formation</a></li>
			<li><a href="localregister">Ajout Local</a></li>
			<li><a href="participantregister">Ajout Participant</a></li>
			<li><a href="formationlistmenu">Inscrire un nouveau
					participant au cours</a></li>
			<li><a href="participantformationlistmenu">Réinscrire un
					participant au cours</a></li>
			<li><a href="detailformationregister">Associer
					local-formation</a></li>
			<li><a href="formateurlist">La liste des Formateurs</a></li>
			<li><a href="detaillocalformdisplay">La liste Locaux &
					Formations</a></li>
			<li><a href="publishinscription">Publier les dates
					d&rsquo;inscriptions </a></li>
			<li><a href="listinscription">La liste des r&eacute;inscriptions</a></li>	
			<li><a href="listreservation">Agenda pour inscription</a></li>		
		</c:when>

		<c:when test="${employe.roleEmploye eq 'ADMIN' }">

			<li><a href="statutprofessionnelregister">Ajout Statut
					Professionnel</a></li>
			<li><a href="formateurregister">Ajout Formateur</a></li>
			<li><a href="formationregister">Ajout Formation</a></li>
			<li><a href="localregister">Ajout Local</a></li>
			<li><a href="participantregister">Ajout Participant</a></li>
			<li><a href="employeregister">Ajout employé</a></li>
			<li><a href="formationlistmenu">Inscrire un nouveau
					participant au cours</a></li>
			<li><a href="participantformationlistmenu">Réinscrire un
					participant au cours</a></li>
			<li><a href="detailformationregister">Associer
					local-formation</a></li>
			<li><a href="formateurlist">La liste des Formateurs</a></li>
			<li><a href="detaillocalformdisplay">Liste Locaux &
					Formations</a></li>
			<li><a href="publishinscription">Publier les dates
					d&rsquo;inscriptions </a></li>
			<li><a href="listinscription">La liste des r&eacute;inscriptions</a></li>	
			<li><a href="listreservation">Agenda pour inscription</a></li>		
		</c:when>
	</c:choose>
</ul>
</body>
</html>