package be.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.DetailLocalFormation;
import be.school.model.Formateur;
import be.school.model.Formation;
import be.school.repository.DetailLocalFormationRepository;
import be.school.repository.FormateurRepository;
import be.school.repository.FormationRepository;
import be.school.service.DetailLocalFormationService;
import be.school.util.NotificationUtil;

/**
 * FormateurFormationController class
 * 
 * @author P. Mutanda
 *
 */
@Controller
public class FormateurFormationController {

	@Autowired
	FormateurRepository formateurRepositoryJpa;
	@Autowired
	DetailLocalFormationRepository detailLocalFormationReposytoryJpa;
	@Autowired
	FormationRepository formationRep;
	@Autowired
	DetailLocalFormationService detailLocalFormService;

	/**
	 * 
	 * @param id
	 *            id formateur
	 * @return retourne un formulaire pour associer un formateur à une formation
	 */
	@RequestMapping(value = "/formateurformationdisplay", method = RequestMethod.GET)
	public ModelAndView formateurFormationDisplay(@RequestParam Long id) {
		ModelAndView mv = prepareModelAndView();
		Formateur formateur = formateurRepositoryJpa.findById(id);
		mv.addObject("formateur", formateur);

		return mv;
	}

	/**
	 * 
	 * @return retourne ModelAndView
	 */
	private ModelAndView prepareModelAndView() {
		ModelAndView mv = new ModelAndView("formformateurformation");
		List<DetailLocalFormation> detailListForm = detailLocalFormationReposytoryJpa
				.findAllDistinct();
		mv.addObject("detailListForm", detailListForm);
		return mv;
	}

	/**
	 * 
	 * @param id
	 *            id du formateur
	 * @return retourne la page detail formation
	 */
	@RequestMapping(value = "/formateurdetaildisplay", method = RequestMethod.GET)
	public ModelAndView displayDetailFormateur(
			@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("formateurdetaildisplay");
		if (id == null) {
			mv.setViewName("formationlistdisplay");
			mv.addObject("messageError",
					"Aucun formateur n'est associé pour cette formation");
			List<Formation> listFormation = formationRep.findAll();
			mv.addObject("listformations", listFormation);
			return mv;
		} else {
			Formateur formateur = formateurRepositoryJpa.findById(id);
			mv.addObject("formateur", formateur);
			return mv;
		}

	}

	/**
	 * 
	 * @param formateur
	 *            formateur du formation
	 * @param formation
	 *            formation donnée
	 * @return retourne soit le formulaire en cas de failure ou succ
	 */
	@RequestMapping(value = "/formateurformsubmit", method = RequestMethod.POST)
	public ModelAndView formformateurformationSubmit(
			@RequestParam Long formateur, @RequestParam Long formation) {
		ModelAndView mv = prepareModelAndView();
		if (formation == 0) {
			mv.addObject("messageError", "Choisir une formation");
			return mv;
		} else {

			Formateur formateur2 = formateurRepositoryJpa.findById(formateur);
			Formation formation2 = formationRep.findById(formation);
			DetailLocalFormation detailFormation = detailLocalFormationReposytoryJpa
					.findById(formation);
			if (detailFormation.getFormateur() == null) {
				detailFormation.setFormateur(formateur2);
				detailFormation.setFormation(formation2);
				detailLocalFormationReposytoryJpa.save(detailFormation);
			}

			else {
				if (detailLocalFormService.isAlreadyAffected(detailFormation,
						formateur2, detailFormation.getSeance(),
						detailFormation.getJour()) == true) {
					mv.addObject("messageError",
							formateur2.getNom()
									+ " est déjà pris pour une séance de "
									+ detailFormation.getJour() + " "
									+ detailFormation.getSeance());
					return mv;
				}
				if (formateur2.getId() != detailFormation.getFormateur()
						.getId()) {
					mv.addObject("messageError",
							"Cette formation est déjà donnée par "
									+ detailFormation.getFormateur().getNom());
					return mv;
				}
			}
			NotificationUtil.addNotificationMessage(formateur2.getNom()
					+ " est affecté(e) avec succès au cours de "
					+ formation2.getTitre());
			mv.setViewName("redirect:formateurlist");
			return mv;
		}

	}

	/**
	 * 
	 * @param id
	 *            id du formateur
	 * @return retourne le formateur
	 */
	@ModelAttribute
	public Formateur findFormateur(
			@RequestParam(value = "formateur", required = false) Long id) {
		Formateur formateur = null;
		if (id == null)
			formateur = new Formateur();
		else
			formateur = formateurRepositoryJpa.findById(id);
		return formateur;
	}
}
