package be.school.controller;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import be.school.controller.StatutProfessionnelController;
import be.school.model.StatutProfessionnel;
import be.school.repository.StatutProfessionnelRepository;
import be.school.repository.jpa.StatutProfessionelRepositoryJpa;
import be.school.util.NotificationUtil;


/**
 * test for StatutProfessionnelController class
 * @author P. Mutanda
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class StatutProfessionnelControllerTest {


	@InjectMocks
	private StatutProfessionnelController statutProfessionnelController = new StatutProfessionnelController();
	  

	 @Mock
	 private StatutProfessionnelRepository statutProfessionnelRepository;

	    
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
		//null pcq id est null. Le setter pour Id n'est pas défini pour laisser JPA le gérer. 
		assertNull(stpr.getId());
	}

	
	@Test
	public void testStatutProfessionnelRegister(){
		ModelAndView mockMv = Mockito.mock(ModelAndView.class);
		StatutProfessionnel mockStatutProfessionnel = Mockito.mock(StatutProfessionnel.class);
		Mockito.when(mockStatutProfessionnel.getId()).thenReturn(1L);
		Mockito.when(statutProfessionnelRepository.findById(Mockito.anyLong())).thenReturn(mockStatutProfessionnel);
		Mockito.when(mockMv.getViewName()).thenReturn("statutprofessionnelregister");
		ModelAndView resultMv = statutProfessionnelController.statutProfessionnelRegister(1l);
		assertEquals(mockMv.getViewName(), resultMv.getViewName());
		assertEquals("statutprofessionnelregister", resultMv.getViewName());
	}
	
	@SuppressWarnings("static-access")
	@Test
	@Ignore
	public void testSuccessStatutProfessionnelSubmit(){
		
		StatutProfessionnel statutProfessionnel = new StatutProfessionnel();
		statutProfessionnel.setPrix(200D);
		statutProfessionnel.setStatut("Employe");
		ModelAndView mockMv = Mockito.mock(ModelAndView.class);
		Errors mockErrors = Mockito.mock(Errors.class);
		Mockito.when(mockMv.getViewName()).thenReturn("redirect:home");
		Mockito.when(statutProfessionnelRepository.findStatutByName(Mockito.anyString())).thenReturn(null);
	    NotificationUtil notificationUtil = new NotificationUtil();
	    NotificationUtil spyNotificationUtil = Mockito.spy(notificationUtil);
	    Mockito.doNothing().when(spyNotificationUtil).addNotificationMessage(statutProfessionnel
						.getStatut() + " est enregistré avec succès");
		
		ModelAndView result = statutProfessionnelController.statutProfessionnelSubmit(statutProfessionnel, mockErrors);
		Mockito.verify(statutProfessionnelRepository).save(statutProfessionnel);
		assertEquals("redirect:home", result.getViewName());
	}
	
	
	@Test
	public void testUnSuccessStatutProfessionnelSubmit(){
		StatutProfessionnel statutProfessionnel = new StatutProfessionnel();
		statutProfessionnel.setPrix(200D);
		statutProfessionnel.setStatut("Employe");
		ModelAndView mockMv = Mockito.mock(ModelAndView.class);
		Errors mockErrors = Mockito.mock(Errors.class);
		Mockito.when(mockMv.getViewName()).thenReturn("statutprofessionnelregister");
		Mockito.when(statutProfessionnelRepository.findStatutByName(Mockito.anyString())).thenReturn(statutProfessionnel);
		ModelAndView resut = statutProfessionnelController.statutProfessionnelSubmit(statutProfessionnel, mockErrors);
		assertEquals("statutprofessionnelregister", resut.getViewName());
	}
	
}
