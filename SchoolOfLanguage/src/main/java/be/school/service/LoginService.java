package be.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import be.school.exception.ObjectNotFoundException;
import be.school.model.Employe;
import be.school.model.Formateur;
import be.school.repository.EmployeRepository;
import be.school.repository.FormateurRepository;
import be.school.util.SecurityUtils;

/**
 * login service class
 * 
 * @author P. Mutanda
 *
 */
@Service
@Scope("singleton")
public class LoginService {

	@Autowired
	private FormateurRepository formateurRepositoryJpa;

	@Autowired
	private EmployeRepository employeRepositoryJpa;

	/**
	 * 
	 * @param login
	 * @param password
	 * @return
	 * @throws ObjectNotFoundException
	 */
	public Formateur loginFormateur(String login, String password)
			throws ObjectNotFoundException {
		Formateur formateur = formateurRepositoryJpa.findByLoginAndPwd(login,
				SecurityUtils.md5Encode(password));
		if (formateur == null)
			throw new ObjectNotFoundException("Login ou mot de passe incorrect");
		else
			return formateur;

	}

	/**
	 * 
	 * @param login
	 * @param password
	 * @return
	 * @throws ObjectNotFoundException
	 */
	public Employe loginEmploye(String login, String password)
			throws ObjectNotFoundException {
		Employe employe = employeRepositoryJpa.findByLoginAndPwd(login,
				SecurityUtils.md5Encode(password));
		if (employe == null)
			throw new ObjectNotFoundException("Login ou mot de passe incorrect");
		else
			return employe;
	}

}
