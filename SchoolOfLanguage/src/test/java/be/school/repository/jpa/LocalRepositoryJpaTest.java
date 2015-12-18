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

import be.school.model.Local;
import be.school.repository.LocalRepository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"/test-context.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class,
	DbUnitTestExecutionListener.class})
@DatabaseSetup(value="/schooloflanguageDbTest.xml")
@DatabaseTearDown(value="/schooloflanguageDbTestClean.xml")
public class LocalRepositoryJpaTest {
	
	@Autowired
	private LocalRepository localRepository;

	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindByNum() {
		Local local = localRepository.findByNum("4F");
		assertEquals("20", local.getCapacite());
		assertThat(local, allOf(hasProperty("id", is(Long.valueOf("1"))),
				hasProperty("capacite", is("20")),
				hasProperty("estLibre", is(Boolean.valueOf("false"))),
				hasProperty("numLocal", is("4F"))
						));

	}

	@Test
	public void tesNottFindByNum() {
		Local local = localRepository.findByNum("45");
		assertThat(local, nullValue());
	}
	
	@Test
	public void testFindByDetalLocalFormation() {
		fail("Not yet implemented");
	}

}
