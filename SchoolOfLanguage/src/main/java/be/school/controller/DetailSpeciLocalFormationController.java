package be.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.DetailLocalFormation;
import be.school.model.Formation;
import be.school.model.Local;
import be.school.repository.DetailLocalFormationReposytory;
import be.school.repository.FormationRepository;
import be.school.repository.LocalRepository;

@Controller
public class DetailSpeciLocalFormationController {
	
   @Autowired
   private DetailLocalFormationReposytory dReposytory;
   
   @Autowired FormationRepository formationRep;
   
   @Autowired LocalRepository localRep;
   
   @RequestMapping(value="/detailFormation", method=RequestMethod.GET)
   public @ResponseBody ModelAndView detailSpeciLocalFormation(@RequestParam String titre){
	   ModelAndView mv = new ModelAndView("detailformation");
	   Local local=null;
	  Formation formation = formationRep.findByTitre(titre);
	   List<DetailLocalFormation> detailLocalFormations =dReposytory.findAllByFormation(formation);
	   if(detailLocalFormations.size()>0){
	      local = localRep.findByDetalLocalFormation(detailLocalFormations.get(0).getId());
	      mv.addObject("local", local);
	   }
	   mv.addObject("detailLocalFormations", detailLocalFormations);
	   mv.addObject("formation", formation);
	  
	   return mv;
   }
   
   @ModelAttribute
	public Formation findFormation(
			@RequestParam(value = "formation", required = false) String titre) {
		Formation formation = null;
		if (titre == null)
			formation = new Formation();
		else
			formation = formationRep.findByTitre(titre);
		return formation;
	}
}
