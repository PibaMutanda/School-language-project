package be.school.repository;

import be.school.model.StatutProfessionnel;

/**
 * StatutProfessionnelRepository interface
 * 
 * @author P. Mutanda
 *
 */
public interface StatutProfessionnelRepository extends
		GenericRepository<StatutProfessionnel> {

	/**
	 * 
	 * @param name
	 *            nom du statut
	 * @return retourne un statut professionnel
	 */
	StatutProfessionnel findStatutByName(String name);
}
