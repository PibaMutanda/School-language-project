package be.school.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.Participant;
import be.school.model.StatutProfessionnel;
import be.school.repository.ParticipantRepository;
import be.school.repository.StatutProfessionelRepository;
import be.school.util.SecurityUtils;

@Controller
public class ParticipantController {

	@Autowired
	private ParticipantRepository participantRepository;

	@Autowired
	private StatutProfessionelRepository statutprofRepo;
	
	@InitBinder
	protected void RegisterFormation(HttpServletRequest request,
			ServletRequestDataBinder binder) {
		binder.registerCustomEditor(StatutProfessionnel.class,
				new PropertyEditorSupport() {
					public void setAsText(String text) {
						StatutProfessionnel statutProfessionnel = statutprofRepo.findById(Long
								.parseLong(text));
						setValue(statutProfessionnel);
					}
				});
	}
	
	@RequestMapping(value = "/participantregister", method = RequestMethod.GET)
	public ModelAndView participantRegister(
			@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mv = new ModelAndView("participantregister");
		List listStatutProf = statutprofRepo.findAll();
		Participant participant = null;
		if (id == null) {
			participant = new Participant();
		} else
			participant = participantRepository.findById(id);
		mv.addObject("participant",participant);
		mv.addObject("listStatutProf", listStatutProf);
		return mv;
	}

	@RequestMapping(value = "/participantsubmit", method = RequestMethod.POST)
	public ModelAndView participantSubmit(
			@Valid @ModelAttribute Participant participant, Errors errors) {
		ModelAndView mv = new ModelAndView("participantregister");
		if (errors.hasErrors()) {
			mv.addObject("participant", participant);
		} else {
			participant.setPassword(SecurityUtils.md5Encode(participant
					.getEmail()));
			System.out.println("mot de passe " + participant.getPassword());
			char[] matrCode = new char[2];
			try {
				/*
				 * ce morceau de code volontairement implementé ainsi pour attribuer un matriule.
				 * Supposant qu'un participant a un nom ou prenom dont la taille est sup à 3 char*/
				if(participant.getNom().length()>=3)
				matrCode = participant.getNom().substring(0, 3).toCharArray();
				else
					matrCode=participant.getPrenom().substring(0,3).toCharArray();

			} catch (Exception e) {
				mv.addObject("messageError", "Saisir le nom du  Participant");
				return mv;
			}
			String buffMatr = null;
			do {
				buffMatr = String.valueOf(matrCode)
						+ SecurityUtils.generateRandomNumber(5);
			} while (participantRepository.findByMaticule(buffMatr) != null);
			Participant participant2 = participantRepository
					.findByEmail(participant.getEmail());

			if (participant2 != null) {
				mv.addObject("messageError", "Cette adresse email existe déjà");
				return mv;
			}
			if(participant.getStatutProfessionnel().equals("0")){
				mv.addObject("messageError", "Renseignez le statut professionnel");
				return mv;
			}
			participant.setMatricule(buffMatr);
			System.out.println("Matricule " + participant.getMatricule());
			participantRepository.save(participant);
			mv.addObject("messageSuccess", "Le particiant est enregistré avec succès!");
			mv.setViewName("redirect:home");
		}
		return mv;
	}
}
