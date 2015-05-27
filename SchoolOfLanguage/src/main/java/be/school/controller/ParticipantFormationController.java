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
import be.school.repository.DetailLocalFormationReposytory;
import be.school.repository.FormationRepository;
import be.school.repository.LocalRepository;
import be.school.repository.ParticipantRepository;
import be.school.service.DetailLocalFormationService;

@Controller
public class ParticipantFormationController {

	@Autowired
	private ParticipantRepository participantRep;

	@Autowired
	private LocalRepository localRep;

	@Autowired
	private FormationRepository formationRep;

	@Autowired
	private DetailLocalFormationReposytory detailLocalFormaRep;

	@Autowired
	private DetailLocalFormationService detailLocSerrv;

	@RequestMapping(value = "/participantformation", method = RequestMethod.GET)
	public ModelAndView participantForm(@RequestParam(value = "id") Long id,
			@RequestParam(value = "niveau") String niveau) {
		ModelAndView mv = prepareModelAndView(id, niveau);
		return mv;
	}

	@RequestMapping(value = "/participantformationold", method = RequestMethod.GET)
	public ModelAndView formationList(@RequestParam(value = "id") Long id,
			@RequestParam(value = "niveau") String niveau) {
		ModelAndView mv = prepareModelAndView2(id, niveau);
		return mv;
	}

	private ModelAndView prepareModelAndView2(
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "niveau") String niveau) {
		ModelAndView mv = new ModelAndView("participantformationold");
		Formation formation = formationRep.findById(id);
		HashSet<Participant>listSetPart = new HashSet<Participant>();
		List<Participant> listParticipant = participantRep
				.findAllOlds(formation);
		for (Participant participant : listParticipant) {
			listSetPart.add(participant);
		}
		List<Local> listLocal = localRep.findAll();
		mv.addObject("formation", formation);
		mv.addObject("listLocal", listLocal);
		mv.addObject("listParticipant", listSetPart);
		mv.addObject("niveau", niveau);
		return mv;
	}

	private ModelAndView prepareModelAndView(
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "niveau") String niveau) {
		ModelAndView mv = new ModelAndView("participantformation");
		Formation formation = formationRep.findById(id);
		HashSet<Participant>listSetPart = new HashSet<Participant>();
		// List<DetailLocalFormation>listDetailForm=detailLocalFormaRep.findAllByFormation(formation);
		List<Participant> listParticipant = participantRep.findAllNews();
		for (Participant participant : listParticipant) {
			listSetPart.add(participant);
		}
		List<Local> listLocal = localRep.findAll();
		mv.addObject("listLocal", listLocal);
		mv.addObject("formation", formation);
		mv.addObject("listParticipant", listSetPart);
		mv.addObject("niveau", niveau);
		return mv;

	}

	@RequestMapping(value = "/participantformationlistmenu", method = RequestMethod.GET)
	public ModelAndView getListFormation2() {
		ModelAndView mv = new ModelAndView("participantformationlistmenu");
		mv.addObject("listFormation", formationRep.findAll());
		return mv;
	}

	@RequestMapping(value = "/formationlistmenu", method = RequestMethod.GET)
	public ModelAndView getListFormation() {
		ModelAndView mv = new ModelAndView("formationlistmenu");
		mv.addObject("listFormation", formationRep.findAll());
		return mv;
	}

	/*
	 * This method will be called by dispatcher to save new participant
	 */
	@RequestMapping(value = "/participantformationsubmit", method = RequestMethod.POST)
	public ModelAndView participantFormationSubmit(
			@RequestParam Long participant, @RequestParam Long formation,
			@RequestParam Long local, @RequestParam String niveau) {
		ModelAndView mv = prepareModelAndView(formation, niveau);
		if (participant == 0 || participant == null) {
			mv.addObject("messageError", "Choisir un Participant");
			return mv;
		}
		if (formation == 0 || formation == null) {
			mv.addObject("messageError", "Choisir une formation");
			return mv;
		}
		if (local == 0 || local == null) {
			mv.addObject("messagerError", "Choisir un local");
			return mv;
		}
		if (participantRep.findById(participant).getDetailLocalFormations()
				.size() >= 2) {
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
			mv.addObject("messageError",
					"Cette formation n'est pas donnée dans ce local<br>Cliquer <a href='detaillocalformdisplay'>Ici</a> pour voir la liste des locaux liés au cours");
			return mv;
		}

		else {
			DetailLocalFormation detailLocalFormation = detailLocalFormaRep
					.findByLocalFormationNiveau(local2, formation2, niveau);
			Participant participant2 = participantRep.findById(participant);
			participant2.setLocal(local2);
			detailLocalFormation.setParticipant(participant2);
			detailLocalFormation.setNiveau(niveau);
			participantRep.save(participant2);
			detailLocalFormaRep.save(detailLocalFormation);
			mv.addObject("messageSuccess", "Inscription enregistrée pour "
					+ participant2.getNom());
			mv.setViewName("redirect: home");
			return mv;
		}

	}

	/*
	 * Spring MVC will call this method to save old participant
	 */
	@RequestMapping(value = "/participantformationoldsubmit", method = RequestMethod.POST)
	public ModelAndView participantFormationOldSubmit(
			@RequestParam Long participant, @RequestParam Long formation,
			@RequestParam Long local, @RequestParam String niveau) {
		ModelAndView mv = prepareModelAndView2(formation, niveau);
		if (participant == 0 || participant == null) {
			mv.addObject("messageError", "Choisir un Participant");
			if (local == 0 || local == null) {
				mv.addObject("messagerError", "Choisir un local");
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
			mv.addObject("messageError",
					"Cette formation n'est pas donnée dans ce local<br>Cliquer <a href='detaillocalformdisplay'>Ici</a> pour voir la liste des locaux liés au cours");
			return mv;
		} else {
			DetailLocalFormation detailLocalFormation = detailLocalFormaRep
					.findByLocalFormationNiveau(local2, formation2, niveau);
			Participant participant2 = participantRep.findById(participant);
			participant2.setLocal(local2);
			detailLocalFormation.setParticipant(participant2);
			detailLocalFormation.setNiveau(niveau);
			participantRep.save(participant2);
			detailLocalFormaRep.save(detailLocalFormation);
			mv.addObject("messageSuccess", "Inscription enregistrée pour "
					+ participant2.getNom());
			mv.setViewName("redirect: home");
			return mv;
		}

	}
}
