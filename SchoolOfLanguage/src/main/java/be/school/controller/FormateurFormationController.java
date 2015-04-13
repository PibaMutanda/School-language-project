package be.school.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@Autowired
	FormateurRepository formateurRepository;
	@Autowired
	DetailLocalFormationReposytory detailLocalFormationReposytory;
	@Autowired
	FormationRepository formationRep;
	@Autowired
	LocalRepository localRep;

	@RequestMapping(value = "/formateurformationdisplay", method = RequestMethod.POST)
	public ModelAndView formateurFormationDisplay(
			@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("formformateurformation");
		Formateur formateur = formateurRepository.findById(id);
		List detailListForm = detailLocalFormationReposytory.findAllDistinct();
		mv.addObject("formateur", formateur);
		mv.addObject("detailListForm", detailListForm);
		return mv;
	}


	@RequestMapping(value="/formateurformsubmit", method=RequestMethod.POST)
	public ModelAndView formformateurformationSubmit(@RequestParam Long formateur, @RequestParam Long formation){
		ModelAndView mv=new ModelAndView("formformateurformation");
		if(formation==0)
		{
			mv.addObject("messageError", "Choisir une formation");
			return mv;
		}
		else{	
		
		Formateur formateur2 = formateurRepository.findById(formation);
		          formateur2.addDetailLocalFormation(detailLocalFormationReposytory.findById(formation));
		          formateurRepository.save(formateur2);
		          mv.setViewName("redirect:formateurlist");
		return mv;
		}
			
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
