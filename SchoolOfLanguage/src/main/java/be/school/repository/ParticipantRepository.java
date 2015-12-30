package be.school.repository;

import java.util.List;

import be.school.model.Formation;
import be.school.model.Participant;

/**
 * ParticipantRepository interface
 * 
 * @author P. Mutanda
 *
 */
public interface ParticipantRepository extends GenericRepository<Participant> {

	/**
	 * 
	 * @return retourne la liste des participants
	 */
	List<Participant> findAllNews();

	/**
	 * 
	 * @param formation
	 *            formation
	 * @return retourne la liste des participants déjà inscrits pour une
	 *         formation
	 */
	List<Participant> findAllOlds(Formation formation);

	/**
	 * 
	 * @param detailLocalForm
	 *            detailLocalform
	 * @return retourne le nombre total des participants
	 */
	Long getTotalParticipant(Long detailLocalForm);

	/**
	 * 
	 * @param email
	 *            email
	 * @return retourne un participant par son é-mail
	 */
	Participant findByEmail(String email);

	/**
	 * 
	 * @param matricule
	 *            matricule du participant
	 * @return retourne un participant par son matricule
	 */
	Participant findByMaticule(String matricule);

	/**
	 * 
	 * @param idDetailLocalForm
	 *            id de detailLocalFormation
	 * @return retourne la liste des participants qui sont identifiés dans un
	 *         local
	 */
	List<Participant> getParticipantListByDetailLocalFormation(
			Long idDetailLocalForm);
}
