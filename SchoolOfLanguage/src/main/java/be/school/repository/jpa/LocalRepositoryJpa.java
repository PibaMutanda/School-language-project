package be.school.repository.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Local;
import be.school.repository.LocalRepository;

/**
 * LocalRepositoryJpa class
 * 
 * @author P. Mutanda
 *
 */
@Repository
@Transactional
public class LocalRepositoryJpa extends GenericRepositoryJpa<Local> implements
		LocalRepository {

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	public Local findByNum(String numLocal) {
		Local local = null;
		Query query = em
				.createQuery("select l from Local l where numLocal = :numLocal");
		query.setParameter("numLocal", numLocal);
		List localList = query.getResultList();
		if (!localList.isEmpty())
			local = (Local) localList.get(0);
		return local;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	public Local findByDetalLocalFormation(Long id) {
		Local local = null;
		Query query = em
				.createQuery("select lc from Local lc join lc.detailLocalFormations dlf where dlf.id= :id");
		query.setParameter("id", id);
		query.setMaxResults(1);
		List locaux = query.getResultList();
		if (!locaux.isEmpty())
			local = (Local) locaux.get(0);
		return local;

	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Local> findAllbyFormation(Long idformation) {
		List<Local> locaux=null;
		Query query = em.createNamedQuery("Local.findAllbyFormation").setParameter("id", idformation);
		locaux = query.getResultList();
		return locaux;
	}
}
