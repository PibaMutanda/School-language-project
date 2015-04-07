package be.school.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.DetailLocalFormation;
import be.school.model.Formation;
import be.school.model.Local;
import be.school.repository.DetailLocalFormationReposytory;
import be.school.repository.FormationRepository;
import be.school.repository.LocalRepository;

@Controller
@RequestMapping("/detailformation")
public class DetailSpeciLocalFormationController {
	
   @Autowired
   private DetailLocalFormationReposytory dReposytory;
   
   @Autowired FormationRepository formationRep;
   
   @Autowired LocalRepository localRep;
   
   @RequestMapping(value="/", method=RequestMethod.GET)
   public ModelAndView detailSpeciLocalFormation(HttpServletRequest request){
	   ModelAndView mv = new ModelAndView("detailformation");
	   String id = request.getParameter("id");
	   Local local=null;
	   Formation formation = formationRep.findById(Long.parseLong(id));
	   List<DetailLocalFormation> detailLocalFormations =dReposytory.FindAllByFormation(formation);
	   if(detailLocalFormations.size()>0){
	      local = localRep.findByDetalLocalFormation(detailLocalFormations.get(0));
	      mv.addObject("local", local);
	   }
	   mv.addObject("detailLocalFormations", detailLocalFormations);
	   mv.addObject("formation", formation);
	  
	   return mv;
   }
}
