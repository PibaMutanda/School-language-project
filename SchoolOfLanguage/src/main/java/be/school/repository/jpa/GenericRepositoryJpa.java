package be.school.repository.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.school.exception.RepositoryException;
import be.school.repository.GenericRepository;

/**
 * @author P. Mutanda
 * 
 *         Interface générique pour partager les mêmes méthodes entre chaque
 *         session bean
 */
public abstract class GenericRepositoryJpa<T> implements GenericRepository<T> {

	// Initialisation implicite de l'EntityManager (voir définition dans
	// persistence.xml)
	@PersistenceContext(unitName = "schooloflanguage")
	protected EntityManager em;

	private Class<T> persistenceClass;

	@SuppressWarnings("unchecked")
	public GenericRepositoryJpa() {
		// Exemple avec Local
		// getClass() => LocalRepositoryJpa
		// getGenericSuperclass() => GenericRepositoryJpa
		// getActualTypeArguments() => <T>
		// [0] => T
		this.persistenceClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T findById(Long id) {
		return em.find(persistenceClass, id);
	}

	@Override
	public List<T> findAll() {
		return em
				.createNamedQuery(
						persistenceClass.getSimpleName() + ".findAll",
						persistenceClass).getResultList();
	}

	@Override
	public void save(T t) {
		if (t == null)
			throw new RepositoryException("Invalid entity");
		em.merge(t);

	}

	@Override
	public void delete(T t) {
		if (t == null)
			throw new RepositoryException("Invalid entity");

		// faire em.remove(em.merge(Local));,
		// c'est mieux que em.remove(Local); parce que si jamais
		// Local a été modifié avant le remove, il ne serait pas supprimé de la
		// DB sans le merge
		em.remove(em.merge(t));

	}

	@Override
	public void delete(Long id) {
		T entity = em.find(persistenceClass, id);
		if (entity == null)
			throw new RepositoryException("Invalid entity");
		em.remove(entity);
		
	}

}
