package be.school.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.DetailLocalFormation;
import be.school.model.Formation;
import be.school.model.Local;
import be.school.security.Seance;

@Repository
@Transactional
public class DetailLocalFormationReposytory {

	@PersistenceContext
	private EntityManager em;
	
	public DetailLocalFormation findById(Long id){
		return em.find(DetailLocalFormation.class, id);
	}
	
	public void save(DetailLocalFormation detailFormation){
		if(detailFormation.getId()==null)
			em.persist(detailFormation);
		else
			em.merge(detailFormation);
	}
	
	
	public List<DetailLocalFormation> findAll(){
		return em.createQuery("select nf from DetailLocalFormation nf").getResultList();
	}
	
	public List<DetailLocalFormation> findAllDistinct(){
		return em.createQuery("select distinct df from DetailLocalFormation df").getResultList();
	}
	
	public DetailLocalFormation findByLocalSession(Local local, Seance seance){
		DetailLocalFormation detailFormation=null;
		List delofos = em.createQuery("select df from DetailLocalFormation df  where df.local= :local and  df.seance= :seance")
				       .setParameter("local", local)
				       .setParameter("seance", seance)
				       .getResultList();
		if(!delofos.isEmpty())
			detailFormation = (DetailLocalFormation) delofos.get(0);
		return detailFormation;
	}
	
	@SuppressWarnings("unchecked")
	public List<DetailLocalFormation> FindAllByFormation(Formation formation){
		return em.createQuery("select dlf from DetailLocalFormation dlf where dlf.formation= :formation")
				.setParameter("formation", formation)
				.getResultList();
	}
	
	public DetailLocalFormation findByLocalFormation(Local local, Formation formation){
		DetailLocalFormation detailFormation=null;
		List<DetailLocalFormation> detailLocalFormations=em.createQuery("select df from DetailLocalFormation df where df.local= :local and df.formation= :formation")
				                                           .setParameter("local", local)
				                                           .setParameter("formation", formation)
				                                           .getResultList();
		if(!detailLocalFormations.isEmpty())
			detailFormation=detailLocalFormations.get(0);
			return detailFormation;	
	}
}
