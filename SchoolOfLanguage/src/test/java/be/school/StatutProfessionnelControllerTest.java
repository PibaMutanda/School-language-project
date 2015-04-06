package be.school;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import org.junit.Ignore;
import org.junit.Test;

import be.school.controller.StatutProfessionnelController;
import be.school.model.StatutProfessionnel;
import be.school.repository.StatutProfessionelRepository;

public class StatutProfessionnelControllerTest {

	

	@Test
	@Ignore
	public void testGetList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindStatutById() {
		StatutProfessionelRepository stRepository = createMock(StatutProfessionelRepository.class);
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
