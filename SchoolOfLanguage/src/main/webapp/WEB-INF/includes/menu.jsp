<html>
<ul role="menu">
<c:choose>
    <c:when test="${formateur.id !=null }">
	<li><a href="displayprofplanning?id=${formateur.id }">Mon
			planning</a></li>
	</c:when>	
	<c:when test="${employe.id !=null }">	
	<li><a href="statutprofessionnelregister">Ajout Statut
			Professionnel</a></li>
	<li><a href="formateurregister">Ajout Formateur</a></li>
	<li><a href="formationregister">Ajout Formation</a></li>
	<li><a href="localregister">Ajout Local</a></li>
	<li><a href="participantregister">Ajout Participant</a></li>
	<li><a href="formationlistmenu">Inscrire un nouveau
			participant au cours</a></li>
	<li><a href="participantformationlistmenu">R�inscrire un
			participant au cours</a></li>
	<li><a href="detailformationregister">Associer local-formation</a></li>
	<li><a href="formateurlist">Liste Formateur</a></li>
	<li><a href="detaillocalformdisplay">Liste Locaux & Formations</a>
	<li><a href="anneescolaireregister">Date Rentr�e</a></li>
	<li><a href="reservationregister">Soumettre une demande pour
			inscription</a></li>
   </c:when>			
</c:choose>			
</ul>
</body>
</html>