package be.school.repository.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Formation;
import be.school.repository.FormationRepository;

/**
 * 
 * FormationRepositoryJpa class
 * 
 * @author P. Mutanda
 *
 */
@Repository
@Transactional
public class FormationRepositoryJpa extends GenericRepositoryJpa<Formation>
		implements FormationRepository {

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	public Formation findByCodeFormation(String cdeFormation) {
		Formation formation = null;
		List listformation = em
				.createQuery(
						"select f from Formation f where codeFormation = :cdeFormation")
				.setParameter("cdeFormation", cdeFormation).getResultList();
		if (!listformation.isEmpty())
			formation = (Formation) listformation.get(0);
		return formation;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	public Formation findByTitre(String titre) {
		Formation formation = null;
		List listForm = em
				.createQuery("select f from Formation f where titre= :titre")
				.setParameter("titre", titre).setMaxResults(1).getResultList();
		if (!listForm.isEmpty())
			formation = (Formation) listForm.get(0);
		return formation;
	}

}
