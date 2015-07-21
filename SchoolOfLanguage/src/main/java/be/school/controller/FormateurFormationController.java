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
import be.school.repository.jpa.DetailLocalFormationReposytoryJpa;
import be.school.repository.jpa.FormateurRepositoryJpa;
import be.school.repository.jpa.FormationRepositoryJpa;

@Controller
public class FormateurFormationController {

	@Autowired
	FormateurRepositoryJpa formateurRepositoryJpa;
	@Autowired
	DetailLocalFormationReposytoryJpa detailLocalFormationReposytoryJpa;
	@Autowired
	FormationRepositoryJpa formationRep;

	@RequestMapping(value = "/formateurformationdisplay", method = RequestMethod.POST)
	public ModelAndView formateurFormationDisplay(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("formformateurformation");
		Formateur formateur = formateurRepositoryJpa.findById(id);
		List detailListForm = detailLocalFormationReposytoryJpa.findAllDistinct();
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
			detailFormation.setFormation(formation2);
			detailFormation.setFormateur(formateur2);
			detailLocalFormationReposytoryJpa.save(detailFormation);
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
