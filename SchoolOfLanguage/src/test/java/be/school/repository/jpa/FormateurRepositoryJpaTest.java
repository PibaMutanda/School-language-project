package be.school.repository.jpa;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import be.school.model.Formateur;
import be.school.repository.FormateurRepository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup(value = "/schooloflanguageDbTest.xml")
@DatabaseTearDown(value = "/schooloflanguageDbTestClean.xml")
public class FormateurRepositoryJpaTest {

	@Autowired
	private FormateurRepository formateurRepository;

	@SuppressWarnings("unchecked")
	@Test
	public void testFindByLoginAndPwd() {
		Formateur formateur = formateurRepository.findByLoginAndPwd("mutanda",
				"mutandapasswd");
		assertEquals("Mutanda", formateur.getNom());
		assertThat(formateur.getId(), is(Long.parseLong("1")));
		assertThat(
				formateur,
				allOf(hasProperty("id", is(Long.parseLong("1"))),
						hasProperty("nom", is("Mutanda")),
						hasProperty("prenom", is("Piba")),
						hasProperty("password", is("mutandapasswd")),
						hasProperty("login", is("mutanda"))));
	}

	@Test
	public void testUnSuccessLogin() {
		Formateur formateur = formateurRepository.findByLoginAndPwd("login",
				"password");
		assertThat("Bad login and password", formateur, nullValue());
	}
}
