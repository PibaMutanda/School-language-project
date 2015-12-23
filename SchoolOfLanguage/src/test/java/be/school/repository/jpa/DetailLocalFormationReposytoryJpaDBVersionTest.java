package be.school.repository.jpa;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

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

import be.school.enumClass.Seance;
import be.school.model.DetailLocalFormation;
import be.school.model.Formateur;
import be.school.model.Local;
import be.school.repository.DetailLocalFormationRepository;

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
public class DetailLocalFormationReposytoryJpaDBVersionTest {

	@Autowired
	private DetailLocalFormationRepository detailLocalFormationRepository;

	@Test
	public void testFindAll() {
		List<DetailLocalFormation> list = detailLocalFormationRepository
				.findAll();
		assertEquals(3, list.size());
		assertEquals("10", list.get(0).getQuota());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindAllByFormateur() {
		DetailLocalFormation detailLocalFormation = detailLocalFormationRepository
				.findById(1L);
		Formateur formateur = detailLocalFormation.getFormateur();

		List<DetailLocalFormation> result = detailLocalFormationRepository
				.findAllByFormateur(formateur);
		assertEquals(2, result.size());
		assertThat(result.get(0).getFormateur().getLogin(), is("mutanda"));
		assertThat(result.get(0).getFormateur(),
				allOf(hasProperty("id", is(Long.parseLong("1")))));
	}

	@Test
	public void testGetParticipantNumber() {
		DetailLocalFormation detailLocalFormation = detailLocalFormationRepository
				.findById(2l);
		Local local = detailLocalFormation.getLocal();
		Seance seance = detailLocalFormation.getSeance();
		Long result = detailLocalFormationRepository.getParticipantNumber(
				local, seance);
		assertThat(result.longValue(), is(2l));
		System.out.println("total " + result);
	}
}
