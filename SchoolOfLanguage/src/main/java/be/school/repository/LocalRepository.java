package be.school.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.DetailLocalFormation;
import be.school.model.Local;

@Repository
@Transactional
public class LocalRepository {
   
	@PersistenceContext
	private EntityManager em;
	
	public void save(Local local){
	   if(local.getId()==null)
		   em.persist(local);
	   else
		   em.merge(local);
	}
	
	public Local findById(Long id){
		return em.find(Local.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Local> findAll(){
		return em.createQuery("select l from Local l").getResultList();
	}
	
	public Local findByNum(String numLocal){
		Local local=null;
		List localList=em
				.createQuery(
						"select l from Local l where numLocal = :numLocal")
				.setParameter("numLocal", numLocal).getResultList();
		if(!localList.isEmpty())
			local = (Local) localList.get(0);
		return local;
	}
	
	public Local findByDetalLocalFormation(DetailLocalFormation detailLocalFormation){
		Local local=null;
		List locaux= em.createQuery("select lc from Local lc join lc.detaiLocalFormations dlf where dlf.id= :id")
				.setParameter("id", detailLocalFormation.getId())
				.getResultList();
		if(!locaux.isEmpty())
			local = (Local) locaux.get(0);
		return local;

	}
}
