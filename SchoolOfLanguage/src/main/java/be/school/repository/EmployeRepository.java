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
	 * 
	 * 
	 * @param login login employe
	 * @param password mot de passe employe
	 * @return retourne employe
	 */
	Employe findByLoginAndPwd(String login, String password);
}
