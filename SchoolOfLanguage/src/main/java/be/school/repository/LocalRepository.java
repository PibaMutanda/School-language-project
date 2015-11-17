package be.school.repository;

import be.school.model.Local;

/**
 * LocalRepository interface
 * 
 * @author P. Mutanda
 *
 */
public interface LocalRepository extends GenericRepository<Local> {
	/**
	 * 
	 * @param numLocal
	 *            numéro du local
	 * @return retourne un local
	 */
	Local findByNum(String numLocal);

	/**
	 * 
	 * @param id
	 *            id local
	 * @return retourne un local
	 */
	Local findByDetalLocalFormation(Long id);
}
