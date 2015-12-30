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

/**
 * DetailLocalFormationService class
 * @author P. Mutanda
 *
 */
@Service
@Scope("singleton")
public class DetailLocalFormationService {

	@Autowired
	private DetailLocalFormationRepository detailLocalFormationReposytoryJpa;

	/**
	 * 
	 * @param local local
	 * @param formation formation
	 * @param niveau niveau
	 * @return retourne vrai si la formation du niveau x est  donnée dans ce local sinon faux
	 */
	public boolean isTeached(Local local, Formation formation, String niveau) {
		DetailLocalFormation detailLocalFormation = null;
		detailLocalFormation = detailLocalFormationReposytoryJpa
				.findByLocalFormationNiveau(local, formation, niveau);
		if (detailLocalFormation != null)
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param local local
	 * @param formation formation
	 * @param jour jour
	 * @param seance séance
	 * @return 
	 */
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

	/**
	 * 
	 * @param detailLocalFormation
	 * @param participant
	 * @param formation
	 * @param niveau
	 * @return
	 */
	public boolean isSameLevelForSameForm(
			DetailLocalFormation detailLocalFormation, Participant participant,
			Formation formation, String niveau) {
		boolean ok = false;

		for (Participant part: detailLocalFormation.getParticipants()) {
			if(part.getId()==participant.getId() && detailLocalFormation.getFormation().equals(formation)){
				if (detailLocalFormation.getNiveau().equals(niveau))
					ok = true;
				    break;
			}
		}
//		if (detailLocalFormation.getParticipant().equals(participant)
//				&& detailLocalFormation.getFormation().equals(formation)) {
//			if (detailLocalFormation.getNiveau().equals(niveau))
//				ok = true;
//		}
		return ok;
	}

	/**
	 * 
	 * @param detailLocalFormation
	 * @param formateur
	 * @param seance
	 * @param jour
	 * @return
	 */
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
