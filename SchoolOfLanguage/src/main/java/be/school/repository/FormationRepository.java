package be.school.repository;

import be.school.model.Formation;

/**
 * FormationRepository interface
 * 
 * @author P. Mutanda
 *
 */
public interface FormationRepository extends GenericRepository<Formation> {

	/**
	 * 
	 * @param cdeFormation
	 *            code de la formation
	 * @return retourne la formation
	 */
	Formation findByCodeFormation(String cdeFormation);

	/**
	 * 
	 * @param titre
	 *            titre de la formation
	 * @return retourne une formation
	 */
	Formation findByTitre(String titre);
}
