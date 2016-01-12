package be.school.controller;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.Employe;
import be.school.model.PublicationInscription;
import be.school.repository.EmployeRepository;
import be.school.repository.PublicationInscriptionRepository;
import be.school.util.DateUtil;
import be.school.util.NotificationUtil;

/**
 * 
 * PublicationInscriptionControllerTest Class test
 * 
 * @author P. Mutanda
 *
 */
@PrepareForTest({ NotificationUtil.class, DateUtil.class })
@RunWith(PowerMockRunner.class)
public class PublicationInscriptionControllerTest {

	@InjectMocks
	private PublicationInscriptionController publicationInscriptionController = new PublicationInscriptionController();

	@Mock
	private PublicationInscriptionRepository publicationInscriptionRepository;

	@Mock
	private EmployeRepository employeRepository;

	@Test
	public void testShowPublishInscription() {
		ModelAndView mockMV = Mockito.mock(ModelAndView.class);
		PublicationInscription mockPublicationInscription = Mockito
				.mock(PublicationInscription.class);
		List<PublicationInscription> listPub = new ArrayList<PublicationInscription>();
		listPub.add(mockPublicationInscription);
		Mockito.when(publicationInscriptionRepository.findAll()).thenReturn(
				listPub);
		Mockito.when(mockMV.getViewName()).thenReturn("showpublishinscription");
		Mockito.when(mockPublicationInscription.getDateFinInscr()).thenReturn(
				new Date());
		ModelAndView resultTest = publicationInscriptionController
				.showPublishInscription();
		assertEquals("showpublishinscription", resultTest.getViewName());
	}

	@Test
	public void testUnSuccessPublishInscriptionSubmit() {
		ModelAndView mockMv = Mockito.mock(ModelAndView.class);
		HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
		Mockito.when(mockRequest.getParameter(Mockito.anyString())).thenReturn(
				null);
		Mockito.when(mockMv.getViewName()).thenReturn("publishinscription");
		ModelAndView resultMV = publicationInscriptionController
				.publishInscriptionSubmit(Mockito.anyLong(), mockRequest);
		assertThat(resultMV.getViewName(), is("publishinscription"));
		assertEquals(resultMV.getViewName(), mockMv.getViewName());
	}

	@Test
	public void testSuccessPublishInscriptionSubmit() {
		Date mockDateDeb = Mockito.mock(Date.class);
		Date mockDateFin = Mockito.mock(Date.class);
		String dateDebStr = new String("2016-01-11");
		String dateFinStr = new String("2016-01-13");
		ModelAndView mockMV = Mockito.mock(ModelAndView.class);
		HttpServletRequest mockHttpServletRequest = Mockito
				.mock(HttpServletRequest.class);
		Employe mockemploye = Mockito.mock(Employe.class);
		Mockito.when(mockMV.getViewName()).thenReturn("showpublishinscription");
		Mockito.when(employeRepository.findById(Mockito.anyLong())).thenReturn(
				mockemploye);
		Mockito.when(mockHttpServletRequest.getParameter("dateDeb"))
				.thenReturn(dateDebStr);
		Mockito.when(mockHttpServletRequest.getParameter("dateFin"))
				.thenReturn(dateFinStr);
		PowerMockito.spy(DateUtil.class);
		PowerMockito.when(DateUtil.parseyyyyMMdd(dateDebStr)).thenReturn(
				mockDateDeb);
		PowerMockito.when(DateUtil.parseyyyyMMdd(dateFinStr)).thenReturn(
				mockDateFin);
		PowerMockito.mockStatic(NotificationUtil.class);
		PowerMockito.doNothing().when(NotificationUtil.class);
		NotificationUtil.addNotificationMessage(Mockito.anyString());
		ModelAndView resultMV = publicationInscriptionController
				.publishInscriptionSubmit(Mockito.anyLong(),
						mockHttpServletRequest);
		Mockito.verify(employeRepository, Mockito.times(1)).save(mockemploye);
		assertThat(resultMV.getViewName(), is("showpublishinscription"));
	}

}
