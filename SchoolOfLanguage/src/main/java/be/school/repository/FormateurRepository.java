package be.school.repository;

import be.school.model.Formateur;

/**
 * FormateurRepository interface
 * 
 * @author P. Mutanda
 *
 */
public interface FormateurRepository extends GenericRepository<Formateur> {
	/**
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	Formateur findByLoginAndPwd(String login, String password);
}
