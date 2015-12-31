package be.school.repository.jpa;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import be.school.model.Reservation;
import be.school.repository.ReservationRepository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

/**
 * ReservationRepositoryJpaTest Class test
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
public class ReservationRepositoryJpaTest {

	@Autowired
	private ReservationRepository reservationRepository;

	@SuppressWarnings("unchecked")
	@Test
	public void testFindByEmail() {

		Reservation reservation = reservationRepository
				.findByEmail("ndalejen@live.ze");
		assertThat(
				reservation,
				allOf(hasProperty("id", is(Long.valueOf("1"))),
						hasProperty("nom", is("Ndala")),
						hasProperty("prenom", is("Jean")),
						hasProperty("gsm", is("0013245670"))));
		assertEquals("2016-01-05", reservation.getDateReserv().toString());
		assertEquals("2016-01-06", reservation.getDateRdv().toString());

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindListByDate() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateRdv = format.parse("2016-5-8");
		List<Reservation> reservations = reservationRepository
				.findListByDate(dateRdv);
		assertThat(reservations.size(), is(1));
		assertThat(
				reservations.get(0),
				allOf(hasProperty("id", is(Long.valueOf(2))),
						hasProperty("nom", is("Nauno")),
						hasProperty("prenom", is("Luc")),
						hasProperty("email", is("naunou@live.ze"))));
		assertEquals("2016-05-07", reservations.get(0).getDateReserv()
				.toString());
	}

}
