package be.school.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Formation;

@Repository
@Transactional
public class FormationRepository {

	@PersistenceContext
	private EntityManager em;

	public void save(Formation formation) {
		if(formation.getId()==null)
			em.persist(formation);
		else
			em.merge(formation);
	}

	public Formation findById(long id) {
		return em.find(Formation.class, id);
	}

	public Formation findByCodeFormation(String cdeFormation) {
        Formation formation=null;
		List listformation = em
				.createQuery(
						"select f from Formation f where codeFormation = :cdeFormation")
				.setParameter("cdeFormation", cdeFormation).getResultList();
		if(!listformation.isEmpty())
			 formation = (Formation)listformation.get(0);
		return formation;
	}

	public Formation findByTitre(String titre) {
		Formation formation=null;
		List listForm = em
				.createQuery("select f from Formation f where titre= :titre")
				.setParameter("titre", titre)
				.setMaxResults(1)
				.getResultList();
		if(!listForm.isEmpty())
			formation = (Formation) listForm.get(0);
		return formation;
	}

	

	@SuppressWarnings("unchecked")
	public List<Formation> findAll() {
		return em.createQuery(" select f from Formation f").getResultList();
	}
	
	
}
