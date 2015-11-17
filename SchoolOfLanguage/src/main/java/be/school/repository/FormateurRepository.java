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
	 * @param login login formateur
	 * @param password mot de passe formateur
	 * @return retourne un formateur
	 */
	Formateur findByLoginAndPwd(String login, String password);
}
