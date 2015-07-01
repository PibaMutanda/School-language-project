package be.school.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Inscription;

@Repository
@Transactional
public class InscriptionRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Inscription inscription){
		if(inscription.getId()==null)
			em.persist(inscription);
		else {
			em.merge(inscription);
		}
	}
	
	public Inscription findById(Long id){
		return em.find(Inscription.class, id);
	}
	
	public List<Inscription> findByDate(Date dateInsc){
		return em.createNamedQuery("Inscription.findByDate")
				.setParameter("dateInscr", dateInsc)
				.getResultList();
	}
}
