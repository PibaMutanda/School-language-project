package be.school.controller;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.DetailLocalFormation;
import be.school.model.Formateur;
import be.school.model.Formation;
import be.school.model.Local;
import be.school.repository.DetailLocalFormationReposytory;
import be.school.repository.FormateurRepository;
import be.school.repository.FormationRepository;
import be.school.repository.LocalRepository;
import be.school.security.Seance;

@Controller
public class FormateurFormationController {

	FormateurRepository formateurRepository;
	DetailLocalFormationReposytory detailLocalFormationReposytory;
	FormationRepository formationRep;
	LocalRepository localRep;

	@RequestMapping(value = "/formateurformationdisplay", method = RequestMethod.POST)
	public ModelAndView formateurFormationDisplay(
			@RequestParam("id") Long id) {
		ModelAndView mv = new ModelAndView("formformateurformation");
		Formateur formateur = formateurRepository.findById(id);
		List detailListForm = detailLocalFormationReposytory.findAll();
		Set<Local> setLocal = null;
		Set<Formation> setformation = null;

		for (Object dformation : detailListForm) {
			setformation.add(formationRep
					.findById(((DetailLocalFormation) dformation)
							.getFormation().getId()));
			setLocal.add(localRep.findById(((DetailLocalFormation) dformation)
					.getLocal().getId()));
		}

		mv.addObject("formateur", formateur);
		mv.addObject("setFormation", setformation);
		mv.addObject("detailListForm", detailListForm);
		mv.addObject("setLocal", setLocal);
		return mv;
	}

	@ModelAttribute
	public Formateur findFormateur(
			@RequestParam(value="formateur", required = false) Long id) {
		Formateur formateur = null;
		if (id == null)
			formateur = new Formateur();
		else
			formateur = formateurRepository.findById(id);
		return formateur;
	}
}
