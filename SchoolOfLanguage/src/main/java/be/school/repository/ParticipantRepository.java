package be.school.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Participant;
import be.school.model.Reservation;

@Repository
@Transactional
public class ParticipantRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Participant participant){
		if(participant.getId() == null){
			em.persist(participant);
		}
		else
		{
			em.merge(participant);
		}
	}
	
	public Participant findById(Long id){
		return em.find(Participant.class, id);
	}

	public List<Participant> findAll(){
		return em.createQuery("select p from Participant p").getResultList();
	}
	public Participant findByEmail(String email){
		Participant participant=null;
		List participantList=em
				.createQuery(
						"select p from Participant p where email = :email")
				.setParameter("email", email).getResultList();
		if(!participantList.isEmpty())
			participant = (Participant) participantList.get(0);
		return participant;
	}
	
	public Participant findByMaticule(String matricule){
		Participant participant=null;
		List participantList=em
				.createQuery(
						"select p from Participant p where matricule = :matricule")
				.setParameter("matricule", matricule).getResultList();
		if(!participantList.isEmpty())
			participant = (Participant) participantList.get(0);
		return participant;
	}
}
