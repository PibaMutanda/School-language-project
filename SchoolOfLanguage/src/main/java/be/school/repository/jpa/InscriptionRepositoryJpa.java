package be.school.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Inscription;
import be.school.repository.InscriptionRepository;

/**
 * InscriptionRepositoryJpa class
 * 
 * @author P. Mutanda
 *
 */
@Repository
@Transactional
public class InscriptionRepositoryJpa extends GenericRepositoryJpa<Inscription>
		implements InscriptionRepository {

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Inscription> findByDate(Date dateInsc) {
		return em.createNamedQuery("Inscription.findByDate")
				.setParameter("dateInscr", dateInsc).getResultList();
	}
}
