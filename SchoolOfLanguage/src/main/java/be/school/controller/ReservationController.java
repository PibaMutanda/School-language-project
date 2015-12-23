package be.school.controller;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.Formation;
import be.school.model.Reservation;
import be.school.repository.FormationRepository;
import be.school.repository.ReservationRepository;
import be.school.util.NotificationUtil;

/**
 * ReservationController Class
 * 
 * @author P. Mutanda
 *
 */
@Controller
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepositoryJpa;
	@Autowired
	private FormationRepository formationRepositoryJpa;

	@InitBinder
	protected void RegisterFormation(HttpServletRequest request,
			ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Formation.class,
				new PropertyEditorSupport() {
					public void setAsText(String text) {
						Formation formation = formationRepositoryJpa
								.findById(Long.parseLong(text));
						setValue(formation);
					}
				});
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	/**
	 * 
	 * @param id
	 *            id de la réservation
	 * @return retourne ModelAndView
	 */
	@RequestMapping(value = "/reservationregister", method = RequestMethod.GET)
	public ModelAndView reservationRegister(
			@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mv = new ModelAndView("reservationregister");
		Reservation reservation = null;
		if (id == null) {
			reservation = new Reservation();
		} else {
			reservation = reservationRepositoryJpa.findById(id);
		}
		List<Formation> formations = formationRepositoryJpa.findAll();
		mv.addObject("formations", formations);
		mv.addObject("reservation", reservation);
		return mv;
	}

	/**
	 * 
	 * @param reservation
	 *            réservation
	 * @param errors
	 *            erreurs
	 * @param request
	 *            requête
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/reservationsubmit", method = RequestMethod.POST)
	@Transactional
	public ModelAndView reservationSubmit(
			@Valid @ModelAttribute Reservation reservation, Errors errors,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("reservationregister");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		if (cal.getTime().equals(Calendar.FRIDAY))
			cal.add(Calendar.DAY_OF_WEEK, 3);
		else if (cal.getTime().equals(Calendar.SATURDAY))
			cal.add(Calendar.DAY_OF_WEEK, 2);
		else
			cal.add(Calendar.DAY_OF_WEEK, 1);
		reservation.setDateRdv(cal.getTime());

		reservation.setDateReserv(new Date());
		if (request.getParameterValues("formations") == null) {
			mv.addObject("messageError", "Aucune formation disponible");
			return mv;
		}
		if (request.getParameterValues("formations").length > 2) {
			mv.addObject("messageError",
					"Maximum deux formations sont autorisées");
			return mv;
		}
		if (request.getParameterValues("formations").length == 0) {
			mv.addObject("messageError", "Choisissez maximum deux formations");
			return mv;
		}
		if (reservationRepositoryJpa.findByEmail(reservation.getEmail()) != null) {
			mv.addObject("messageError", "L'adresse é-mail existe déjà");
			return mv;
		}
		if (errors.hasErrors()) {
			mv.addObject("reservation", reservation);

		} else {

			reservationRepositoryJpa.save(reservation);
			NotificationUtil.addNotificationMessage(reservation.getNom()
					+ " rendez-vous pour l'inscrisption est pris pour "
					+ DateFormat.getDateInstance().format(
							reservation.getDateRdv()));
			mv.setViewName("redirect:home");

		}
		return mv;
	}

	/**
	 * 
	 * @return {@inheritDoc}
	 */
	@RequestMapping(value = "/listreservation", method = RequestMethod.GET)
	public ModelAndView showlistReservation() {
		ModelAndView mv = new ModelAndView("listreservation");
		mv.addObject("listReservation",
				reservationRepositoryJpa.findListByDate(new Date()));
		return mv;
	}
	// https://www.google.be/#q=how+to+call+BatchUpdateException
	// http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html
}
