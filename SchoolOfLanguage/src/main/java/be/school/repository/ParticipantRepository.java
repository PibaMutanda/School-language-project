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
	 * @return
	 */
	List<Participant> findAllNews();

	/**
	 * 
	 * @param formation
	 * @return
	 */
	List<Participant> findAllOlds(Formation formation);

	/**
	 * 
	 * @param detailLocalForm
	 * @return
	 */
	Long getTotalParticipant(Long detailLocalForm);

	/**
	 * 
	 * @param email
	 * @return
	 */
	Participant findByEmail(String email);

	/**
	 * 
	 * @param matricule
	 * @return
	 */
	Participant findByMaticule(String matricule);

	/**
	 * 
	 * @param idDetailLocalForm
	 * @return
	 */
	List<Participant> getParticipantListByDetailLocalFormation(
			Long idDetailLocalForm);
}
