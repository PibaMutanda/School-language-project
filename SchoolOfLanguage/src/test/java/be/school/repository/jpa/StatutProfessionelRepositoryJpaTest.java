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

import be.school.model.StatutProfessionnel;
import be.school.repository.StatutProfessionnelRepository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

/**
 * StatutProfessionelRepositoryJpaTest Class test
 * 
 * @author P. Mutanda
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup(value = "/schooloflanguageDbTest.xml")
@DatabaseTearDown(value = "/schooloflanguageDbTestClean.xml")
public class StatutProfessionelRepositoryJpaTest {

	@Autowired
	private StatutProfessionnelRepository statutProfessionnelRepository;

	@SuppressWarnings("unchecked")
	@Test
	public void testFindStatutByName() {
		StatutProfessionnel statutProfessionnel = statutProfessionnelRepository
				.findStatutByName("Employe");
		assertThat(
				statutProfessionnel,
				allOf(hasProperty("id", is(Long.valueOf(1))),
						hasProperty("prix", is(Double.valueOf(200)))));
	}

}
