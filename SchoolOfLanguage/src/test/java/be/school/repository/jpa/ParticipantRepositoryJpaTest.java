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

import be.school.model.Formation;
import be.school.model.Participant;
import be.school.model.Participant.Sexe;
import be.school.repository.FormationRepository;
import be.school.repository.ParticipantRepository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

/**
 * ParticipantRepositoryJpaTest Class test
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
public class ParticipantRepositoryJpaTest {

	@Autowired
	private ParticipantRepository participantRepository;

	@Autowired
	private FormationRepository formationRepository;

	@SuppressWarnings("unchecked")
	@Test
	public void testFindAllNews() {
		List<Participant> listPart = participantRepository.findAllNews();
		assertEquals(1, listPart.size());
		Participant participant = listPart.get(0);
		assertThat(
				participant,
				allOf(hasProperty("id", is(Long.valueOf("4"))),
						hasProperty("matricule", is("623")),
						hasProperty("email", is("myemail@live.com")),
						hasProperty("gsm", is("7013256480")),
						hasProperty("nom", is("Yaya")),
						hasProperty("prenom", is("Emerine")),
						hasProperty("ville", is("Saint-gilles")),
						hasProperty("codeP", is("1040")),
						hasProperty("numero", is("22")),
						hasProperty("rue", is("Victoire")),
						hasProperty("sexe", is(Sexe.FEMME))));

	}

	@Test
	public void testFindAllOlds() {
		Formation formation = formationRepository.findById(1l);
		List<Participant> listPart = participantRepository
				.findAllOlds(formation);
		assertEquals(2, listPart.size());
		assertThat(listPart.get(0).getGsm(), is("0174588888"));
		assertThat(listPart.get(0).getEmail(), is("jgfpiutnda@live.com"));
		assertThat(listPart.get(0).getLocal().getNumLocal(), is("3G"));
		assertThat(listPart.get(0).getDetailLocalFormations().size(), is(1));
		System.out.println(listPart.get(0).getGsm());
	}

	@Test
	public void testGetTotalParticipant() {
		Long total = participantRepository.getTotalParticipant(1l);
		assertThat(total, is(2L));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindByEmail() {
		Participant participant = participantRepository
				.findByEmail("myemail@live.com");
		assertThat(
				participant,
				allOf(hasProperty("id", is(Long.valueOf("4"))),
						hasProperty("matricule", is("623")),
						hasProperty("gsm", is("7013256480")),
						hasProperty("nom", is("Yaya")),
						hasProperty("prenom", is("Emerine")),
						hasProperty("ville", is("Saint-gilles")),
						hasProperty("codeP", is("1040")),
						hasProperty("numero", is("22")),
						hasProperty("rue", is("Victoire")),
						hasProperty("sexe", is(Sexe.FEMME))));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindByMaticule() {
		Participant participant = participantRepository.findByMaticule("245");
		assertThat(
				participant,
				allOf(hasProperty("id", is(Long.valueOf("2"))),
						hasProperty("email", is("piutnda@live.com")),
						hasProperty("gsm", is("0174585234")),
						hasProperty("nom", is("Patou")),
						hasProperty("prenom", is("Charles")),
						hasProperty("ville", is("Brussels")),
						hasProperty("codeP", is("1050")),
						hasProperty("numero", is("2")),
						hasProperty("rue", is("Panthere")),
						hasProperty("sexe", is(Sexe.HOMME))));

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetParticipantListByDetailLocalFormation() {
		List<Participant> listPart = participantRepository
				.getParticipantListByDetailLocalFormation(2l);
		assertEquals(2, listPart.size());
		assertThat(
				listPart.get(0),
				allOf(hasProperty("id", is(Long.valueOf("1"))),
						hasProperty("email", is("piautanda@live.com")),
						hasProperty("gsm", is("0111145234")),
						hasProperty("nom", is("Mutanda")),
						hasProperty("prenom", is("Piba")),
						hasProperty("ville", is("Brussels")),
						hasProperty("codeP", is("1050")),
						hasProperty("numero", is("220F")),
						hasProperty("matricule", is("451L")),
						hasProperty("rue", is("Adolphhe Buyl")),
						hasProperty("sexe", is(Sexe.HOMME))));
	}

}
