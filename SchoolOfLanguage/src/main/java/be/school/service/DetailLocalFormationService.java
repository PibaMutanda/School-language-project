package be.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import be.school.enumClass.Jour;
import be.school.enumClass.Seance;
import be.school.model.DetailLocalFormation;
import be.school.model.Formateur;
import be.school.model.Formation;
import be.school.model.Local;
import be.school.model.Participant;
import be.school.repository.DetailLocalFormationRepository;

@Service
@Scope("singleton")
public class DetailLocalFormationService {

	@Autowired
	private DetailLocalFormationRepository detailLocalFormationReposytoryJpa;

	public boolean isTeached(Local local, Formation formation, String niveau) {
		DetailLocalFormation detailLocalFormation = null;
		detailLocalFormation = detailLocalFormationReposytoryJpa
				.findByLocalFormationNiveau(local, formation, niveau);
		if (detailLocalFormation != null)
			return true;
		else
			return false;
	}

	public boolean isCheckForUpdate(Local local, Formation formation,
			Jour jour, Seance seance) {
		DetailLocalFormation detailLocalFormation = null;
		detailLocalFormation = detailLocalFormationReposytoryJpa
				.findByLocalFormation(local, formation);
		if (detailLocalFormation == null)
			return false;

		// revoir le code ici
		// if (detailLocalFormation.getJour() == jour
		// && detailLocalFormation.getSeance() == seance)
		// return false;
		else
			return true;
	}

	public boolean isSameLevelForSameForm(
			DetailLocalFormation detailLocalFormation, Participant participant,
			Formation formation, String niveau) {
		boolean ok = false;
		if (detailLocalFormation.getParticipant().equals(participant)
				&& detailLocalFormation.getFormation().equals(formation)) {
			if (detailLocalFormation.getNiveau().equals(niveau))
				ok = true;
		}
		return ok;
	}

	public boolean isAlreadyAffected(DetailLocalFormation detailLocalFormation, Formateur formateur,
			Seance seance, Jour jour) {
		boolean ok = false;
		if (detailLocalFormation.getFormateur().equals(formateur)
				&& detailLocalFormation.getSeance() == seance
				&& detailLocalFormation.getJour() == jour)
			ok = true;
		return ok;
	}
}
