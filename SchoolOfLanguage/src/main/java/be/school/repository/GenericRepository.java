package be.school.repository;

import java.util.List;

/**
 * GenericRepository interface définit les méthodes communes à toutes les
 * 'repositories'
 * 
 * @author P. Mutanda
 *
 * @param <T>
 */
public interface GenericRepository<T> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public T findById(Long id);

	/**
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 
	 * @param t
	 */
	public void save(T t);

	/**
	 * 
	 * @param t
	 */
	public void delete(T t);

	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
