package be.school.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.Inscription;
import be.school.model.Participant;
import be.school.repository.InscriptionRepository;
import be.school.repository.ParticipantRepository;
import be.school.util.DateUtil;
import be.school.util.NotificationUtil;
import be.school.util.SecurityUtils;

/**
 * InscriptionController Class
 * 
 * @author P. Mutanda
 *
 */
@Controller
public class InscriptionController {

	@Autowired
	private ParticipantRepository participantRepositoryJpa;

	@Autowired
	private InscriptionRepository inscriptionRepositoryJpa;

	/**
	 * 
	 * @return retourne un formulaire pour inscription
	 */
	@RequestMapping(value = "/inscriptionregister", method = RequestMethod.GET)
	public String inscriptionregister() {
		return "inscriptionregister";
	}

	/**
	 * 
	 * @return retourne ModelAndView
	 */
	private ModelAndView prepareModelAndView() {
		ModelAndView mv = new ModelAndView("listinscription");
		Date currentDate = new Date();
		String strDate = DateUtil.formatddMMyyyyHHmm(currentDate);
		List<Inscription> listInsc = inscriptionRepositoryJpa
				.findByDate(currentDate);
		mv.addObject("listinscription", listInsc);
		mv.addObject("dateChoose", strDate);
		return mv;
	}

	/**
	 * 
	 * @param matricule
	 *            matricule de l'étudiant
	 * @param email
	 *            email de du participant
	 * @return retourne ModelAndView
	 */
	@RequestMapping(value = "/inscriptionsubmit", method = RequestMethod.POST)
	public ModelAndView inscriptionsubmit(
			@RequestParam(value = "matricule") String matricule,
			@RequestParam(value = "email") String email) {
		ModelAndView mv = new ModelAndView("inscriptionregister");

		Participant participant = participantRepositoryJpa
				.findByMaticule(matricule);
		if (participant == null) {
			mv.addObject("messageError", "Matricule incorrect");
			return mv;
		}
		if (!participant.getEmail().equals(email)) {
			mv.addObject("messageError", "Adresse email incorrecte");
			return mv;
		}
		if (email == null) {
			mv.addObject("messageError", "Saisir votre adresse email");
			return mv;
		}
		mv.setViewName("redirect:validerinscription");
		mv.addObject("id", participant.getId());
		return mv;
	}

	/**
	 * 
	 * @param id
	 *            id du participant
	 * @return retourne ModelAndView
	 */
	@RequestMapping(value = "/validerinscription", method = RequestMethod.GET)
	public ModelAndView showFormValiderInscription(
			@RequestParam(value = "id") Long id) {
		ModelAndView mv = new ModelAndView("validerinscription");
		Participant participant = participantRepositoryJpa.findById(id);
		mv.addObject("participant", participant);
		return mv;
	}

	/**
	 * 
	 * @param id
	 *            id du participant
	 * @param request
	 *            requête
	 * @return retourne ModelAndView
	 */
	@RequestMapping(value = "/validerinscriptionsubmit", method = RequestMethod.POST)
	public ModelAndView validerInscriptionSubmit(
			@RequestParam(value = "id") Long id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("home");
		Participant participant = participantRepositoryJpa.findById(id);
		String[] formations = request.getParameterValues("titre");
		double sum = 0.0;
		if (formations != null) {
			for (@SuppressWarnings("unused")
			String string : formations) {
				if (participant != null)
					sum += participant.getStatutProfessionnel().getPrix();
			}
		} else {
			mv.addObject("messageError", "Cochez au moins un cours");
		}
		if (participant != null && formations != null) {
			String communicationforPaid = participant.getMatricule()
					+ SecurityUtils.generateRandomNumber(4);
			Inscription inscription = new Inscription();
			for (String string : formations) {
				communicationforPaid += "-" + string;
			}
			inscription.setCommunicationPaie(communicationforPaid);
			inscription.setParticipant(participant);
			inscription.setMontantPaie(sum);
			inscription.setDateInscription(new Date());
			inscriptionRepositoryJpa.save(inscription);
			String message = new StringBuilder(
					"Votre r&eacute;inscription est enregistrée, Vous devez payer la somme de ")
					.append(String.valueOf(sum))
					.append("  sur le compte BE00 0000 0000 0000 en indiquant comme communication  ")
					.append("<strong>").append(communicationforPaid)
					.append("</strong>").toString();
			NotificationUtil.addCommunicationMessage(message);
		} else {
			mv.addObject(
					"messageError",
					"Un problème est survenu lors de l'enregistrement, Veuillez contacter la direction pour vous réinscrire");
		}
		return mv;
	}

	/**
	 * 
	 * @return retourne la liste d'inscription
	 */
	@RequestMapping(value = "/listinscription", method = RequestMethod.GET)
	public ModelAndView showListInscription() {
		return prepareModelAndView();
	}

	/**
	 * 
	 * @param request
	 *            requête
	 * @return retourne ModelAndView
	 */
	@RequestMapping(value = "/listinscriptionsubmit", method = RequestMethod.POST)
	public ModelAndView showListInscription(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("listinscription");
		String dateInscr = request.getParameter("dateInscription");
		Date dateInscription = DateUtil.parseyyyyMMdd(dateInscr);
		if (dateInscription.equals(""))
			mv.addObject("messageError", "Choisir une date !");
		else {
			mv.addObject("listinscription",
					inscriptionRepositoryJpa.findByDate(dateInscription));
			mv.addObject("dateChoose", DateUtil.formatddMMyyyy(dateInscription));
		}
		return mv;
	}

}