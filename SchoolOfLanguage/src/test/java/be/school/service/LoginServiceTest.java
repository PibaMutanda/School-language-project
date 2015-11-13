package be.school.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import be.school.exception.ObjectNotFoundException;
import be.school.model.Employe;
import be.school.model.Formateur;
import be.school.repository.EmployeRepository;
import be.school.repository.FormateurRepository;
import be.school.util.SecurityUtils;

/**
 * LoginServiceTest method
 * 
 * @author P. Mutanda
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	@InjectMocks
	LoginService loginService = new LoginService();

	@Mock
	FormateurRepository formmateurRepository;

	@Mock
	EmployeRepository employeRepository;

	/**
	 * teste la connexion avec succès pour un formateur
	 * 
	 * @throws ObjectNotFoundException
	 */
	@Test
	public void testLoginFormateur() throws ObjectNotFoundException {
		String passwd = SecurityUtils.md5Encode("passwdPiba");
		Formateur formateur = new Formateur();
		formateur.setLogin("loginPiba");
		formateur.setPassword("passwdPiba");
		Mockito.when(
				formmateurRepository.findByLoginAndPwd(Mockito.anyString(),
						Mockito.anyString())).thenReturn(formateur);
		Formateur formateur1 = loginService.loginFormateur("loginPiba",
				"passwdPiba");
		Mockito.verify(formmateurRepository).findByLoginAndPwd("loginPiba",
				passwd);
		assertEquals(formateur1.getLogin(), formateur.getLogin());
		assertEquals(formateur1.getPassword(), formateur.getPassword());

	}

	/**
	 * 
	 * @throws ObjectNotFoundException
	 */
	@Test
	public void tesUnKnowLoginFormateur() {
		Formateur formateur = new Formateur();
		formateur.setLogin("loginPiba");
		formateur.setPassword("passw");

		Mockito.when(
				formmateurRepository.findByLoginAndPwd(Mockito.anyString(),
						Mockito.anyString())).thenReturn(null);
		try {
			loginService.loginFormateur("loginPiba", "passwdPiba");
			fail("It can not reach this level");
		} catch (ObjectNotFoundException e) {
			assertEquals("Login ou mot de passe incorrect", e.getMessage());

		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws ObjectNotFoundException
	 */
	@Test
	public void testLoginEmploye() throws ObjectNotFoundException {

		String passwd = SecurityUtils.md5Encode("passwdAdmin");
		Employe employer = Mockito.mock(Employe.class);
		Mockito.when(employer.getLogin()).thenReturn("Admin");
		Mockito.when(employer.getPassword()).thenReturn(passwd);
		Mockito.when(
				employeRepository.findByLoginAndPwd(Mockito.anyString(),
						Mockito.anyString())).thenReturn(employer);
		Employe employe1 = loginService.loginEmploye(employer.getLogin(),
				"passwdAdmin");
		Mockito.verify(employeRepository).findByLoginAndPwd(
				employer.getLogin(), passwd);

		assertEquals(employe1.getLogin(), employer.getLogin());
		assertEquals("Admin", employe1.getLogin());
		assertEquals(employe1.getPassword(), passwd);
	}
	
	

}
