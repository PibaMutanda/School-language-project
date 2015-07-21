package be.school.repository;

import java.util.List;

public interface GenericRepository<T> {

	public T findById(Long id);

	public List<T> findAll();

	public void save(T t);

	public void delete(T t);

	void delete(Long id);
}
