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

	@RequestMapping(value = "/formateurformationdisplay", method = RequestMethod.POST)
	public ModelAndView formateurFormationDisplay(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("formformateurformation");
		Formateur formateur = formateurRepositoryJpa.findById(id);
		List detailListForm = detailLocalFormationReposytoryJpa
				.findAllDistinct();
		mv.addObject("formateur", formateur);
		mv.addObject("detailListForm", detailListForm);
		return mv;
	}

	@RequestMapping(value = "/formateurdetaildisplay", method = RequestMethod.GET)
	public ModelAndView displayDetailFormateur(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("formateurdetaildisplay");
		Formateur formateur = formateurRepositoryJpa.findById(id);
		mv.addObject("formateur", formateur);
		return mv;
	}

	@RequestMapping(value = "/formateurformsubmit", method = RequestMethod.POST)
	public ModelAndView formformateurformationSubmit(
			@RequestParam Long formateur, @RequestParam Long formation) {
		ModelAndView mv = new ModelAndView("formformateurformation");
		if (formation == 0) {
			mv.addObject("messageError", "Choisir une formation");
			return mv;
		} else {

			Formateur formateur2 = formateurRepositoryJpa.findById(formation);
			Formation formation2 = formationRep.findById(formation);
			DetailLocalFormation detailFormation = detailLocalFormationReposytoryJpa
					.findById(formation);
			if(detailFormation.getFormateur()==null){
				detailFormation.setFormateur(formateur2);
				detailFormation.setFormation(formation2);
				detailLocalFormationReposytoryJpa.save(detailFormation);
			}
			
			else{
			if (detailLocalFormService.isAlreadyAffected(detailFormation, formateur2,
					detailFormation.getSeance(), detailFormation.getJour()) == true) {
				mv.addObject("messageError",
						formateur2.getNom()
								+ " est déjà pris pour une séance du "
								+ detailFormation.getJour() + " "
								+ detailFormation.getSeance());
				return mv;
			}
			}
			// formateur2.addDetailLocalFormation(detailLocalFormationReposytoryJpa.findById(formation));

			// formateurRepositoryJpa.save(formateur2);
			mv.setViewName("redirect:formateurlist");
			return mv;
		}

	}

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
