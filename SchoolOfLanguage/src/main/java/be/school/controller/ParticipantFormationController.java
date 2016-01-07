package be.school.controller;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.DetailLocalFormation;
import be.school.model.Formation;
import be.school.model.Local;
import be.school.model.Participant;
import be.school.repository.DetailLocalFormationRepository;
import be.school.repository.FormationRepository;
import be.school.repository.LocalRepository;
import be.school.repository.ParticipantRepository;
import be.school.service.DetailLocalFormationService;
import be.school.service.ParticipantService;
import be.school.util.NotificationUtil;

/**
 * ParticipantFormationController Class
 * 
 * @author P. Mutanda
 *
 */

@Controller
public class ParticipantFormationController {

	@Autowired
	private ParticipantRepository participantRep;

	@Autowired
	private ParticipantService participantService;

	@Autowired
	private LocalRepository localRep;

	@Autowired
	private FormationRepository formationRep;

	@Autowired
	private DetailLocalFormationRepository detailLocalFormaRep;

	@Autowired
	private DetailLocalFormationService detailLocSerrv;

	/**
	 * 
	 * @param id
	 *            id du participant
	 * @param niveau
	 *            niveau participant
	 * @return retourne ModelAndView
	 */
	@RequestMapping(value = "/participantformation", method = RequestMethod.GET)
	public ModelAndView participantForm(@RequestParam(value = "id") Long id,
			@RequestParam(value = "niveau") String niveau) {
		ModelAndView mv = prepareModelAndView(id, niveau);
		return mv;
	}

	/**
	 * 
	 * @param id
	 *            id de la formation
	 * @param niveau
	 *            niveau de la formation
	 * @return retourne ModelAndView
	 */
	@RequestMapping(value = "/participantformationold", method = RequestMethod.GET)
	public ModelAndView formationList(@RequestParam(value = "id") Long id,
			@RequestParam(value = "niveau") String niveau) {
		ModelAndView mv = prepareModelAndView2(id, niveau);
		return mv;
	}

	/**
	 * 
	 * @param id
	 *            id de la formation
	 * @param niveau
	 *            niveau de la formation
	 * @return retourne ModelAndView
	 */
	private ModelAndView prepareModelAndView2(
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "niveau") String niveau) {
		ModelAndView mv = new ModelAndView("participantformationold");
		Formation formation = formationRep.findById(id);
		HashSet<Participant> listSetPart = new HashSet<Participant>();
		List<Participant> listParticipant = participantRep
				.findAllOlds(formation);
		for (Participant participant : listParticipant) {
			listSetPart.add(participant);
		}
		List<Local> listLocal = localRep.findAllbyFormation(formation.getId());
		mv.addObject("formation", formation);
		mv.addObject("listLocal", listLocal);
		mv.addObject("listParticipant", listSetPart);
		mv.addObject("niveau", niveau);
		return mv;
	}

	/**
	 * 
	 * @param id
	 *            id de la formation
	 * @param niveau
	 *            de la formation
	 * @return retourne ModelAndView
	 */
	private ModelAndView prepareModelAndView(
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "niveau") String niveau) {
		ModelAndView mv = new ModelAndView("participantformation");
		Formation formation = formationRep.findById(id);
		HashSet<Participant> listSetPart = new HashSet<Participant>();

		List<Participant> listParticipant = participantService
				.getParticipantsListForRegistration(formation);
		for (Participant participant : listParticipant) {
			listSetPart.add(participant);
		}
		List<Local> listLocal = localRep.findAllbyFormation(formation.getId());
		mv.addObject("listLocal", listLocal);
		mv.addObject("formation", formation);
		mv.addObject("listParticipant", listSetPart);
		mv.addObject("niveau", niveau);
		return mv;

	}

	/**
	 * 
	 * @return retourne ModelAndView
	 */
	@RequestMapping(value = "/participantformationlistmenu", method = RequestMethod.GET)
	public ModelAndView getListFormation2() {
		ModelAndView mv = new ModelAndView("participantformationlistmenu");
		mv.addObject("listFormation", formationRep.findAll());
		return mv;
	}

	/**
	 * 
	 * @return retourne ModelAndView
	 */
	@RequestMapping(value = "/formationlistmenu", method = RequestMethod.GET)
	public ModelAndView getListFormation() {
		ModelAndView mv = new ModelAndView("formationlistmenu");
		mv.addObject("listFormation", formationRep.findAll());
		return mv;
	}

	/**
	 * This method will be called by dispatcher to save new participant
	 * 
	 * @param participant
	 *            participant
	 * @param formation
	 *            formation
	 * @param local
	 *            local
	 * @param niveau
	 *            niveau
	 * @return retourne ModelAndView
	 */
	@RequestMapping(value = "/participantformationsubmit", method = RequestMethod.POST)
	public ModelAndView participantFormationSubmit(
			@RequestParam Long participant, @RequestParam Long formation,
			@RequestParam Long local, @RequestParam String niveau) {
		ModelAndView mv = prepareModelAndView(formation, niveau);
		if (participant.longValue() == 0 || participant == null) {
			mv.addObject("messageError", "Il faut hoisir un Participant");
			return mv;
		}
		if ("0".equals(formation) || formation == null) {
			mv.addObject("messageError", "Il faut choisir une formation");
			return mv;
		}
		if (local.longValue() == 0 || local == null) {
			mv.addObject("messagerError", "Choisir un local");
			return mv;
		}
		if (null == participantRep.findById(participant)) {
			mv.addObject("messageError", "Veuiller choisir un particpant");
			return mv;
		}
		if (participantRep.findById(participant).getDetailLocalFormations()
				.size() > 2) {
			mv.addObject("messageError",
					"Le particiipant est déjà inscrit pour les deux seances");
			return mv;
		}

		/*
		 * Vérification si dans ce local, la formation est effectivement bien
		 * donnée
		 */
		Local local2 = localRep.findById(local);
		Formation formation2 = formationRep.findById(formation);
		boolean check = detailLocSerrv.isTeached(local2, formation2, niveau);
		if (check == false) {
			mv.addObject(
					"messageError",
					"Cette formation n'est pas donnée dans ce local<br>Cliquer <a href='detaillocalformdisplay'>Ici</a> pour voir la liste des locaux liés au cours");
			return mv;
		}

		else {
			DetailLocalFormation detailLocalFormation = detailLocalFormaRep
					.findByLocalFormationNiveau(local2, formation2, niveau);
			long nbreInscri = detailLocalFormaRep.getParticipantNumber(local2,
					detailLocalFormation.getSeance(),
					detailLocalFormation.getId());
			if (Long.parseLong(detailLocalFormation.getQuota()) <= nbreInscri) {
				mv.addObject("messageError",
						"Le quota maximal est déjà atteint");
				return mv;
			}

			Participant participant2 = participantRep.findById(participant);
			if (participantService.hasCoursesForSession(participant2,
					detailLocalFormation.getSeance(),
					detailLocalFormation.getJour())) {
				mv.addObject("messageError", participant2.getNom()
						+ " est déjà inscrit pour une seance du "
						+ detailLocalFormation.getJour() + " "
						+ detailLocalFormation.getSeance());
				return mv;
			}
			participant2.setLocal(local2);
			detailLocalFormation.addParticipant(participant2);
			detailLocalFormation.setNiveau(niveau);
			participantRep.save(participant2);
			detailLocalFormaRep.save(detailLocalFormation);
			NotificationUtil
					.addNotificationMessage("Inscription enregistrée avec succès pour "
							+ participant2.getNom());
			mv.setViewName("redirect: home");
			return mv;
		}

	}

	/**
	 * Spring MVC will call this method to save old participant
	 * 
	 * @param participant
	 *            participant
	 * @param formation
	 *            formation
	 * @param local
	 *            local
	 * @param niveau
	 *            niveau
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/participantformationoldsubmit", method = RequestMethod.POST)
	public ModelAndView participantFormationOldSubmit(
			@RequestParam Long participant, @RequestParam Long formation,
			@RequestParam Long local, @RequestParam String niveau) {
		ModelAndView mv = prepareModelAndView2(formation, niveau);
		if (participant.longValue() == 0 || participant == null) {
			mv.addObject("messageError", "Choisir un Participant");
			if ("0".equals(local) || local == null) {
				mv.addObject("messagerError", "Choisir un local");
				return mv;
			}
			if (null == participantRep.findById(participant)) {
				mv.addObject("messageError", "Veuiller choisir un particpant");
				return mv;
			}
			if (participantRep.findById(participant).getDetailLocalFormations()
					.size() >= 2) {
				mv.addObject("messageError",
						"Le particiipant est déjà inscrit pour les deux seances");
				return mv;
			}
			return mv;
		}
		/*
		 * Vérification si dans ce local, la formation est effectivement bien
		 * donnée
		 */
		Local local2 = localRep.findById(local);
		Formation formation2 = formationRep.findById(formation);

		boolean check = detailLocSerrv.isTeached(local2, formation2, niveau);
		if (check == false) {
			mv.addObject(
					"messageError",
					"Cette formation n'est pas donnée dans ce local<br>Cliquer <a href='detaillocalformdisplay'>Ici</a> pour voir la liste des locaux liés au cours");
			return mv;
		} else {
			DetailLocalFormation detailLocalFormation = detailLocalFormaRep
					.findByLocalFormationNiveau(local2, formation2, niveau);
			Participant participant2 = participantRep.findById(participant);
			participant2.setLocal(local2);
			detailLocalFormation.addParticipant(participant2);
			detailLocalFormation.setNiveau(niveau);
			boolean checking = detailLocSerrv.isSameLevelForSameForm(
					detailLocalFormation, participant2, formation2, niveau);
			if (checking == false) {
				mv.addObject("messageError",
						"Pour la même formation, un participant ne doit pas avoir le même niveau");
				return mv;
			}
			participantRep.save(participant2);
			detailLocalFormaRep.save(detailLocalFormation);
			NotificationUtil
					.addNotificationMessage("Inscription enregistrée avec succès pour "
							+ participant2.getNom());
			mv.setViewName("redirect: home");
			return mv;
		}

	}
}
