package be.school.repository.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Local;
import be.school.repository.LocalRepository;

@Repository
@Transactional
public class LocalRepositoryJpa extends GenericRepositoryJpa<Local> implements LocalRepository{
   
	
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
