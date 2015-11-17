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
	 * @return retourne l'entité par son Id
	 */
	public T findById(Long id);

	/**
	 * 
	 * @return retourne toute la liste pour l'entité
	 */
	public List<T> findAll();

	/**
	 * 
	 * @param t
	 *            t entité à sauver ou à merger
	 */
	public void save(T t);

	/**
	 * 
	 * @param t
	 *            t entité à supprimer
	 */
	public void delete(T t);

	/**
	 * 
	 * @param id
	 *            id à supprimer
	 */
	void delete(Long id);
}
