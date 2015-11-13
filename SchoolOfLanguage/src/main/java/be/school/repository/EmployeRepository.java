package be.school.repository;

import be.school.model.Employe;

/**
 * EmployeRepository interface
 * 
 * @author P. Mutanda
 *
 */
public interface EmployeRepository extends GenericRepository<Employe> {

	/**
	 * {@inheritDoc}
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	Employe findByLoginAndPwd(String login, String password);
}
