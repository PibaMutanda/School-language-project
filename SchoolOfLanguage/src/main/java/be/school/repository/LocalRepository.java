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
	 * @return
	 */
	Local findByNum(String numLocal);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Local findByDetalLocalFormation(Long id);
}
