<html>
<%
	String mySession = (String) session.getAttribute("mySession");
%>
<ul role="menu" class="nav nav-pills nav-stacked menu-nav">
	<c:choose>
	    <c:when test="${employe.roleEmploye eq 'ADMIN' }">
            <li><a href="employeregister">Ajouter employé</a></li>
			<li><a href="statutprofessionnelregister">Ajouter un Statut
					Professionnel</a></li>
			<li><a href="formateurregister">Ajouter un Formateur</a></li>
			<li><a href="formationregister">Ajouter une Formation</a></li>
			<li><a href="localregister">Ajouter un Local</a></li>
			<li><a href="participantregister">Ajouter un Participant</a></li>
			<li><a href="formationlistmenu">Inscrire un nouveau
					participant au cours</a></li>
			<li><a href="participantformationlistmenu">Réinscrire un
					participant au cours</a></li>
			<li><a href="detailformationregister">Associer un
					local à une formation</a></li>
			<li><a href="formateurlist">La liste des Formateurs</a></li>
			<li><a href="detaillocalformdisplay">La liste des Locaux &
					Formations</a></li>
			<li><a href="publishinscription">Publier les dates
					d&rsquo;inscriptions </a></li>
			<li><a href="listinscription">La liste des r&eacute;inscriptions</a></li>	
			<li><a href="listreservation">Agenda pour les inscriptions</a></li>			
		</c:when>
		<c:when test="${ not empty mySession  }">
			<li><a href="displayprofplanning?id=${formateur.id }">Mon
					planning</a></li>
			<li><a href="updateFormateur?id=${formateur.id }">changer le
					Password</a></li>
		</c:when>
		<c:when test="${employe.roleEmploye eq 'SIMPLE' }">
			<li><a href="statutprofessionnelregister">Ajouter un Statut
					Professionnel</a></li>
			<li><a href="formateurregister">Ajouter un Formateur</a></li>
			<li><a href="formationregister">Ajouter une Formation</a></li>
			<li><a href="localregister">Ajouter un Local</a></li>
			<li><a href="participantregister">Ajouter un Participant</a></li>
			<li><a href="formationlistmenu">Inscrire un nouveau
					participant au cours</a></li>
			<li><a href="participantformationlistmenu">Réinscrire un
					participant au cours</a></li>
			<li><a href="detailformationregister">Associer un
					local à une formation</a></li>
			<li><a href="formateurlist">La liste des Formateurs</a></li>
			<li><a href="detaillocalformdisplay">La liste des Locaux &
					Formations</a></li>
			<li><a href="publishinscription">Publier les dates
					d&rsquo;inscriptions </a></li>
			<li><a href="listinscription">La liste des r&eacute;inscriptions</a></li>	
			<li><a href="listreservation">Agenda pour les inscriptions</a></li>		
		</c:when>
	</c:choose>
</ul>
</body>
</html>