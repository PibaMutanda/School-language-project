package be.school.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Formation;
import be.school.model.Participant;

@Repository
@Transactional
public class ParticipantRepository {

	@PersistenceContext
	private EntityManager em;

	public void save(Participant participant) {
		if (participant.getId() == null) {
			em.persist(participant);
		} else {
			em.merge(participant);
		}
	}

	public Participant findById(Long id) {
		return em.find(Participant.class, id);
	}

	public List<Participant> findAll() {
		return em.createQuery("select p from Participant p").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Participant> findAllNews() {
		return em.createQuery(
				"select p from Participant p where p.local is null")
				.getResultList();
	}

	public List<Participant> findAllOlds(Formation formation) {
		return em
				.createQuery(
						"select p from Participant p join p.detailLocalFormations dlf where dlf.formation = :formation")
				.setParameter("formation", formation).getResultList();
	}

	public Long getTotalParticipant(Long detailLocalForm) {
		return (Long) em
				.createQuery(
						"select count(p) from Participant p join p.detailLocalFormations pdlf where pdlf.id=:id")
				.setParameter("id", detailLocalForm).getSingleResult();
	}

	public Participant findByEmail(String email) {
		Participant participant = null;
		List participantList = em
				.createQuery("select p from Participant p where email = :email")
				.setParameter("email", email).getResultList();
		if (!participantList.isEmpty())
			participant = (Participant) participantList.get(0);
		return participant;
	}

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

	public List<Participant> getParticipantListByDetailLocalFormation(
			Long idDetailLocalForm) {
		return em
				.createQuery(
						"select d.participant from Participant p join p.detailLocalFormations d  where d.id=:id")
				.setParameter("id", idDetailLocalForm).getResultList();
	}
}
