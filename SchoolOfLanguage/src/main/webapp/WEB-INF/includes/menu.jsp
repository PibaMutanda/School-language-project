<%@page import="be.school.model.Formateur"%>
<%@page import="be.school.model.Employe"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>

<ul role="menu">
	<li><a href="displayprofplanning?id=${formateur.id }">Mon
			planning</a></li>
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
	<li><a href="detailformationregister">Associer local-formation</a></li>
	<li><a href="formateurlist">Liste Formateur</a></li>
	<li><a href="detaillocalformdisplay">Liste Locaux & Formations</a>
	<li><a href="anneescolaireregister">Date Rentrée</a></li>
	<li><a href="reservationregister">Soumettre une demande pour
			inscription</a></li>
</ul>
</body>
</html>