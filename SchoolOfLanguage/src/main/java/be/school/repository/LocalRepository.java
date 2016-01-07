package be.school.repository;

import java.util.List;

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

	/**
	 * 
	 * @param idformation
	 *            id formation
	 * @return retourne la liste des locaux pour une formation
	 */
	List<Local> findAllbyFormation(Long idformation);

}
