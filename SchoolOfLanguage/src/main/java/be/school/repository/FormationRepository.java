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
	 * @return
	 */
	Formation findByCodeFormation(String cdeFormation);

	/**
	 * 
	 * @param titre
	 * @return
	 */
	Formation findByTitre(String titre);
}
