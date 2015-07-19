package be.school.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@SuppressWarnings("rawtypes")
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
	
	@SuppressWarnings("rawtypes")
	public Local findByDetalLocalFormation(Long id){
		Local local=null;
		List locaux= em.createQuery("select lc from Local lc join lc.detailLocalFormations dlf where dlf.id= :id")
				.setParameter("id", id)
				.setMaxResults(1)
				.getResultList();
		if(!locaux.isEmpty())
			local = (Local) locaux.get(0);
		return local;

	}
}
