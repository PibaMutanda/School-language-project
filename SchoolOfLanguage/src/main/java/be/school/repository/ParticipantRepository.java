package be.school.repository;

import java.util.List;

import be.school.model.Formation;
import be.school.model.Participant;

public interface ParticipantRepository extends GenericRepository<Participant> {

	List<Participant> findAllNews();

	List<Participant> findAllOlds(Formation formation);

	Long getTotalParticipant(Long detailLocalForm);

	Participant findByEmail(String email);

	Participant findByMaticule(String matricule);

	List<Participant> getParticipantListByDetailLocalFormation(
			Long idDetailLocalForm);
}
