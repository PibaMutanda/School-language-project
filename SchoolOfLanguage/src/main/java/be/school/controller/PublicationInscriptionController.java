package be.school.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.Employe;
import be.school.model.PublicationInscription;
import be.school.repository.EmployeRepository;
import be.school.repository.PublicationInscriptionRepository;
import be.school.util.DateUtil;
import be.school.util.NotificationUtil;

/**
 * PublicationInscriptionController Class
 * 
 * @author P. Mutanda
 *
 */
@Controller
public class PublicationInscriptionController {

	@Autowired
	private EmployeRepository employeResository;

	@Autowired
	private PublicationInscriptionRepository publicationInscrRepo;

	/**
	 * 
	 * @return retourne la page vue
	 */
	@RequestMapping(value = "/publishinscription", method = RequestMethod.GET)
	public String publishInscription() {
		return "publishinscription";
	}

	/**
	 * 
	 * @return retourne ModelAndView
	 */
	@RequestMapping(value = "/showpublishinscription", method = RequestMethod.GET)
	public ModelAndView showPublishInscription() {
		ModelAndView mv = new ModelAndView("showpublishinscription");
		Date currentDate = new Date();
		List<PublicationInscription> listeDates = publicationInscrRepo
				.findAll();
		for (PublicationInscription publicationInscription : listeDates) {
			if (publicationInscription.getDateFinInscr().after(currentDate))
				mv.addObject("publications",
						publicationInscription.getMessageInscription());
		}

		return mv;
	}

	/**
	 * 
	 * @param id
	 *            id de l'employé qui publie la date d'inscription
	 * @param request
	 *            requête
	 * @return retourne ModelAndView
	 */
	@RequestMapping(value = "/publishinscriptionsubmit", method = RequestMethod.POST)
	public ModelAndView publishInscriptionSubmit(
			@RequestParam(value = "id") Long id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("publishinscription");
		List<String> messageErrors = new ArrayList<String>();
		Date dateDeb = null;
		Date dateFin = null;
		Date dateCourant = new Date();
		String dateDebStr = request.getParameter("dateDeb");
		String dateFinStr = request.getParameter("dateFin");
		if (dateDebStr.trim() == null)
			messageErrors.add("Saisir la date du début d'inscription");
		if (dateFinStr.trim() == null)
			messageErrors.add("Saisir la date de fin d'inscription");
		if (dateDebStr.trim() != null && dateFinStr.trim() != null) {
			dateDeb = DateUtil.parseddMMyyyy(dateDebStr);
			dateFin = DateUtil.parseddMMyyyy(dateFinStr);
			if (dateDeb.before(dateCourant))
				messageErrors
						.add("La date doit être postérieure à la date courante");
			if (dateDeb.after(dateFin))
				messageErrors.add("Saisir correctement l'ordre de dates");
		}
		if (messageErrors.size() > 0) {
			mv.addObject("messageError", messageErrors);
			return mv;
		} else {
			Employe employe = employeResository.findById(id);
			PublicationInscription publicationInscription = new PublicationInscription();
			publicationInscription.setDateDebInscr(dateDeb);
			publicationInscription.setDateFinInscr(dateFin);
			publicationInscription
					.setMessageInscription("Les inscriptions vont du "
							+ DateUtil.formatddMMyyyy(dateDeb) + " au  " + DateUtil.formatddMMyyyy(dateFin));
			publicationInscription.setEmploye(employe);
			employeResository.save(employe);
			publicationInscrRepo.save(publicationInscription);
			NotificationUtil
					.addNotificationMessage("Les dates pour les inscriptions sont publiées!!");
			mv.setViewName("showpublishinscription");
			return mv;
		}

	}
}
