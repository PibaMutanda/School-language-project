package be.school.repository.jpa;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import be.school.model.Inscription;
import be.school.repository.InscriptionRepository;

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
public class InscriptionRepositoryJpaTest {

	@Autowired
	private InscriptionRepository inscriptionRepository;

	@Test
	public void testFindByDate() {
		Inscription inscription = inscriptionRepository.findById(1L);
		List<Inscription> list = inscriptionRepository.findByDate(inscription
				.getDateInscription());
		assertThat(list.size(), is(2));
		assertEquals("2016-06-02", list.get(0).getDateInscription().toString());

	}

	@Test
	public void testDateNotFind() {
		List<Inscription> list = inscriptionRepository.findByDate(new Date());
		assertThat(0, is(list.size()));
		assertTrue(list.isEmpty());
	}

}
