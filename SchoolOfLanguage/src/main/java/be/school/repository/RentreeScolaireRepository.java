package be.school.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.RentreeScolaire;

@Repository
@Transactional
public class RentreeScolaireRepository {

	@PersistenceContext
	private EntityManager em;

	public void save(RentreeScolaire rentreeScolaire) {
		if (rentreeScolaire.getId() == null)
			em.persist(rentreeScolaire);
		else
			em.merge(rentreeScolaire);
	}

	public RentreeScolaire findById(Long id) {
		return em.find(RentreeScolaire.class, id);
	}

	@SuppressWarnings("rawtypes")
	public RentreeScolaire findByDateDeb(Date dateDeb) {
		RentreeScolaire rentreeScolaire = null;
		List listDates = em
				.createQuery(
						"select asl from RentreeScolaire asl where dateScolaireDeb = :dateDeb")
				.setParameter("dateDeb", dateDeb).getResultList();
		if (!listDates.isEmpty())
			rentreeScolaire = (RentreeScolaire) listDates.get(0);
		return rentreeScolaire;

	}
	

	@SuppressWarnings("unchecked")
	public List<RentreeScolaire> findAll(){
		return em.createQuery("select asl from RentreeScolaire asl").getResultList();
	}
}
