package be.school.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Formateur;

@Repository
@Transactional
public class FormateurRepository {

	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Formateur formateur){
		if(formateur.getId()==null)
			em.persist(formateur);
		else
			em.merge(formateur);
	}
	
	public Formateur findById(Long id){
		return em.find(Formateur.class, id);
	}
	
	public List<Formateur> findAll(){
		return em.createQuery("Select f from Formateur f").getResultList();
	}
	
}
