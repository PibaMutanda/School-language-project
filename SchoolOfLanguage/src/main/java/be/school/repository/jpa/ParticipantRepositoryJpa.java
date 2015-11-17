package be.school.repository.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Formation;
import be.school.model.Participant;
import be.school.repository.ParticipantRepository;

/**
 * ParticipantRepositoryJpa class
 * 
 * @author P. Mutanda
 *
 */
@Repository
@Transactional
public class ParticipantRepositoryJpa extends GenericRepositoryJpa<Participant>
		implements ParticipantRepository {

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Participant> findAllNews() {
		return em.createQuery(
				"select p from Participant p where p.local is null")
				.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Participant> findAllOlds(Formation formation) {
		return em
				.createQuery(
						"select p from Participant p join p.detailLocalFormations dlf where dlf.formation = :formation")
				.setParameter("formation", formation).getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	public Long getTotalParticipant(Long detailLocalForm) {
		return (Long) em
				.createQuery(
						"select count(p) from Participant p join p.detailLocalFormations pdlf where pdlf.id=:id")
				.setParameter("id", detailLocalForm).getSingleResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	public Participant findByEmail(String email) {
		Participant participant = null;
		List participantList = em
				.createQuery("select p from Participant p where email = :email")
				.setParameter("email", email).getResultList();
		if (!participantList.isEmpty())
			participant = (Participant) participantList.get(0);
		return participant;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	public Participant findByMaticule(String matricule) {
		Participant participant = null;
		List participantList = em
				.createQuery(
						"select p from Participant p where matricule = :matricule")
				.setParameter("matricule", matricule).getResultList();
		if (!participantList.isEmpty())
			participant = (Participant) participantList.get(0);
		return participant;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Participant> getParticipantListByDetailLocalFormation(
			Long idDetailLocalForm) {
		return em
				.createQuery(
						"select d.participant from Participant p join p.detailLocalFormations d  where d.id=:id")
				.setParameter("id", idDetailLocalForm).getResultList();
	}
}
