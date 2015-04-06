package be.school.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.StatutProfessionnel;

@Repository
@Transactional
public class StatutProfessionelRepository {

	@PersistenceContext 
	private EntityManager em;
	
	
	public void save(StatutProfessionnel pStatutProfessionel){
		if(pStatutProfessionel.getId()==null)
		em.persist(pStatutProfessionel);
		else
			em.merge(pStatutProfessionel);
	}
	

	public List<StatutProfessionnel> getList(){
		return em.createQuery("select sp from StatutProfessionnel sp").getResultList();
	}
	
	public StatutProfessionnel findById(Long id){
		return em.find(StatutProfessionnel.class, id);
	}
	
	public StatutProfessionnel findStatutByName(String name){
		StatutProfessionnel statutProfessionnel=null;
		List listStatut = em.createQuery("select sp from StatutProfessionnel sp where statut= :statut").setParameter("statut", name).getResultList();
		if(!listStatut.isEmpty())
			statutProfessionnel = (StatutProfessionnel) listStatut.get(0);
		return statutProfessionnel;
		
	}
}
