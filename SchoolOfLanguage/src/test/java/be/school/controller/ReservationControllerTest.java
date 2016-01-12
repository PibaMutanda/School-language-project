package be.school.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.Formation;
import be.school.model.Reservation;
import be.school.repository.FormationRepository;
import be.school.repository.ReservationRepository;
import be.school.util.NotificationUtil;

/**
 * 
 * ReservationControllerTest Class test
 * 
 * @author P. Mutanda
 *
 */
@PrepareForTest({ NotificationUtil.class })
@RunWith(PowerMockRunner.class)
public class ReservationControllerTest {

	@InjectMocks
	private ReservationController reservationController = new ReservationController();

	@Mock
	private ReservationRepository reservationRepository;

	@Mock
	private FormationRepository formationRepository;

	@Test
	public void testReservationRegister() {
		Reservation mockReservation = Mockito.mock(Reservation.class);
		List<Formation> listForm = new ArrayList<Formation>();
		ModelAndView mockMV = Mockito.mock(ModelAndView.class);
		Mockito.when(mockReservation.getId()).thenReturn(3L);
		Mockito.when(reservationRepository.findById(Mockito.anyLong()))
				.thenReturn(mockReservation);
		Mockito.when(formationRepository.findAll()).thenReturn(listForm);
		Mockito.when(mockMV.getViewName()).thenReturn("reservationregister");
		ModelAndView result = reservationController.reservationRegister(3L);
		assertEquals(mockMV.getViewName(), result.getViewName());
	}

	@Test
	public void testSuccessReservationSubmit() {
		ModelAndView mockMV = Mockito.mock(ModelAndView.class);
		Reservation mockReservation = Mockito.mock(Reservation.class);
		Errors mockErros = Mockito.mock(Errors.class);
		Mockito.when(mockReservation.getDateRdv()).thenReturn(new Date());
		PowerMockito.mockStatic(NotificationUtil.class);
		HttpServletRequest mockHttpServletRequest = Mockito
				.mock(HttpServletRequest.class);
		List<Formation> listForm = new ArrayList<Formation>();
		Mockito.when(formationRepository.findAll()).thenReturn(listForm);
		Mockito.when(mockMV.getViewName()).thenReturn("redirect:home");
		Mockito.when(
				mockHttpServletRequest.getParameterValues(Mockito.anyString()))
				.thenReturn(new String[1]);
		PowerMockito.doNothing().when(NotificationUtil.class);
		NotificationUtil.addCommunicationMessage(Mockito.anyString());
		ModelAndView resultMV = reservationController.reservationSubmit(
				mockReservation, mockErros, mockHttpServletRequest);
		Mockito.verify(reservationRepository).save(mockReservation);
		assertEquals("redirect:home", resultMV.getViewName());

	}

	@Test
	public void testUnSuccessReservationSubmit() {
		ModelAndView mockMV = Mockito.mock(ModelAndView.class);
		Reservation mockReservation = Mockito.mock(Reservation.class);
		Errors mockErros = Mockito.mock(Errors.class);
		PowerMockito.mockStatic(Calendar.class);
		HttpServletRequest mockHttpServletRequest = Mockito
				.mock(HttpServletRequest.class);
		List<Formation> listForm = new ArrayList<Formation>();
		Mockito.when(formationRepository.findAll()).thenReturn(listForm);
		Mockito.when(mockMV.getViewName()).thenReturn("reservationregister");
		Mockito.when(
				mockHttpServletRequest.getParameterValues(Mockito.anyString()))
				.thenReturn(null);
		ModelAndView resultMV = reservationController.reservationSubmit(
				mockReservation, mockErros, mockHttpServletRequest);
		assertEquals("reservationregister", resultMV.getViewName());
	}

	@Test
	public void testShowlistReservation() {
		ModelAndView mockMV = Mockito.mock(ModelAndView.class);
		List<Reservation> listReserv = new ArrayList<Reservation>();
		Reservation reservation1 = new Reservation();
		listReserv.add(reservation1);
		Mockito.when(mockMV.getViewName()).thenReturn("listreservation");
		Mockito.when(
				reservationRepository.findListByDate(Mockito.any(Date.class)))
				.thenReturn(listReserv);
		ModelAndView resultView = reservationController.showlistReservation();
		assertEquals("listreservation", resultView.getViewName());
	}

}
