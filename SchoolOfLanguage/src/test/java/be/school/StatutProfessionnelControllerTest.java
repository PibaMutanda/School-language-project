package be.school;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import org.junit.Ignore;
import org.junit.Test;

import be.school.controller.StatutProfessionnelController;
import be.school.model.StatutProfessionnel;
import be.school.repository.jpa.StatutProfessionelRepositoryJpa;

/**
 * test for StatutProfessionnelController class
 * @author P. Mutanda
 *
 */
public class StatutProfessionnelControllerTest {


	/**
	 * {@inheritDoc}
	 */
	@Test
	public void testFindStatutById() {
		StatutProfessionelRepositoryJpa stRepository = createMock(StatutProfessionelRepositoryJpa.class);
		StatutProfessionnel stpr = new StatutProfessionnel();
		stpr.setStatut("ANGLAIS");
		expect(stRepository.findStatutByName("ANGLAIS")).andReturn(stpr);
		replay(stRepository);
		StatutProfessionnelController stprctrl = new StatutProfessionnelController();
		stprctrl.setStaRepos(stRepository);
		
		assertEquals("ANGLAIS", stpr.getStatut());
		//null pcq id est null, le setter pour Id n'est pas défini pour laisser JPA le gérer. 
		assertNull(stpr.getId());
	}

}
