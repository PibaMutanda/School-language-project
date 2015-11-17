package be.school.repository.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.StatutProfessionnel;
import be.school.repository.StatutProfessionnelRepository;

/**
 * StatutProfessionelRepositoryJpa class
 * 
 * @author P. Mutanda
 *
 */
@Repository
@Transactional
public class StatutProfessionelRepositoryJpa extends
		GenericRepositoryJpa<StatutProfessionnel> implements
		StatutProfessionnelRepository {

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	public StatutProfessionnel findStatutByName(String name) {
		StatutProfessionnel statutProfessionnel = null;
		List listStatut = em
				.createQuery(
						"select sp from StatutProfessionnel sp where statut= :statut")
				.setParameter("statut", name).getResultList();
		if (!listStatut.isEmpty())
			statutProfessionnel = (StatutProfessionnel) listStatut.get(0);
		return statutProfessionnel;

	}
}
