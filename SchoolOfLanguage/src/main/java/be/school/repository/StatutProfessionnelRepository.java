package be.school.repository;

import be.school.model.StatutProfessionnel;

/**
 * StatutProfessionnelRepository interface
 * @author P. Mutanda
 *
 */
public interface StatutProfessionnelRepository extends GenericRepository<StatutProfessionnel> {
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	StatutProfessionnel findStatutByName(String name);
}
