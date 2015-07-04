package be.school.controller;

import java.util.Date;
import java.util.Enumeration;
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
import be.school.util.SecurityUtils;

@Controller
public class InscriptionController {

	@Autowired
	private ParticipantRepository participantRepository;

	@Autowired
	private InscriptionRepository inscriptionRepository;

	@RequestMapping(value = "/inscriptionregister", method = RequestMethod.GET)
	public String insriptionregister() {
		return "inscriptionregister";
	}

	@RequestMapping(value = "/inscriptionsubmit", method = RequestMethod.POST)
	public ModelAndView inscriptionsubmit(
			@RequestParam(value = "matricule") String matricule,
			@RequestParam(value = "email") String email) {
		ModelAndView mv = new ModelAndView("inscriptionregister");

		Participant participant = participantRepository
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

	@RequestMapping(value = "/validerinscription", method = RequestMethod.GET)
	public ModelAndView showFormValiderInscription(
			@RequestParam(value = "id") Long id) {
		ModelAndView mv = new ModelAndView("validerinscription");
		Participant participant = participantRepository.findById(id);
		mv.addObject("participant", participant);
		return mv;
	}

	@RequestMapping(value = "/validerinscriptionsubmit", method = RequestMethod.POST)
	public ModelAndView validerInscriptionSubmit(
			@RequestParam(value = "id") Long id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("home");
		Participant participant = participantRepository.findById(id);
		String[] formations = request.getParameterValues("titre");
		double sum = 0.0;
		if (formations != null) {
			for (String string : formations) {
				if (participant != null)
					sum += participant.getStatutProfessionnel().getPrix();
			}
		} else
			mv.addObject("messageError", "Cochez au moins un cours");
		if (participant != null && formations != null) {
			String communicationforPaid = participant.getMatricule()
					+ SecurityUtils.generateRandomNumber(4);
			Inscription inscription = new Inscription();
			inscription.setCommunication(communicationforPaid);
			inscription.setParticipant(participant);
			inscription.setDateInscription(new Date());
			mv.addObject(
					"messageSuccess",
					"Inscription enregistrée, Vous devez payer la somme de "
							+ sum
							+ "  sur le compte BE00 0000 0000 0000 en indiquant comme communication  "
							+ communicationforPaid);
			inscriptionRepository.save(inscription);
		} else {
			mv.addObject(
					"messageError",
					"Un problème est survenu lors de l'enregistrement, Veuillez contacter la direction pour vous réinscrire");
		}
		return mv;
	}

	@RequestMapping(value = "/listinscription", method = RequestMethod.GET)
	public String showListInscription() {
		return "listinscription";
	}

	@RequestMapping(value = "/listinscriptionsubmit", method = RequestMethod.POST)
	public ModelAndView showListInscription(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("listinscription");
		String dateInscr = request.getParameter("dateInscription");
		Date dateInscription = DateUtil.parseyyyyMMdd(dateInscr);
		if (dateInscription.equals(""))
			mv.addObject("messageError", "Choisir une date !");
		else
			mv.addObject("listinscription",
					inscriptionRepository.findByDate(dateInscription));
		return mv;
	}
}