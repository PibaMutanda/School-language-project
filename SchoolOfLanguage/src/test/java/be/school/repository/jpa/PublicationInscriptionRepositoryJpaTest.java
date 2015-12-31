package be.school.repository.jpa;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import be.school.model.Employe.Role;
import be.school.model.PublicationInscription;
import be.school.repository.PublicationInscriptionRepository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

/**
 * PublicationInscriptionRepositoryJpaTest class test
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
public class PublicationInscriptionRepositoryJpaTest {

	@Autowired
	private PublicationInscriptionRepository publicationInscriptionRepository;

	@SuppressWarnings("unchecked")
	@Test
	public void testFindByDate() throws ParseException {
		String dateFinInscrStr = "2016-8-25";
		String dateDebInscr = "2016-8-10";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDeb = format.parse(dateDebInscr);
		Date dateFin = format.parse(dateFinInscrStr);
		PublicationInscription publicationInscription = publicationInscriptionRepository
				.findByDate(dateDeb, dateFin);
		assertThat(
				publicationInscription,
				allOf(hasProperty("id", is(Long.valueOf("2"))),
						hasProperty(
								"messageInscription",
								is("les inscriptions commencent à partir de..."))));
		assertEquals(2, publicationInscription.getEmploye().getId().longValue());
		assertEquals(Role.ADMIN, publicationInscription.getEmploye()
				.getRoleEmploye());
		assertEquals("Justine", publicationInscription.getEmploye().getNom());

	}

}
