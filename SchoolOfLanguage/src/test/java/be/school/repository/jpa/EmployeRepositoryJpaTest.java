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

import be.school.model.Employe;
import be.school.repository.EmployeRepository;

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
public class EmployeRepositoryJpaTest {

	@Autowired
	private EmployeRepository employeRepository;

	@Test
	public void testFindByLoginAndPwd() {
		Employe employe = employeRepository.findByLoginAndPwd("Justine",
				"justine");
		assertEquals(2, employe.getId().longValue());
		assertThat(employe.getNom(), is("Justine"));
	}

	@Test
	public void testUnSuccessFindByLoginAndPwd() {
		Employe employe = employeRepository.findByLoginAndPwd("Julien",
				"password");
		assertEquals(null, employe);
	}
}
