package be.school.controller;

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
	
	@RequestMapping(value="/participantformation",method=RequestMethod.GET)
	public ModelAndView participantForm(){
		 ModelAndView mv = prepareModelAndView();
		 return mv;
	}

	 private ModelAndView prepareModelAndView(){
		 ModelAndView mv = new ModelAndView("participantformation");
			List<Participant>listPart=participantRep.findAll();
			List<Local>listLoca=localRep.findAll();
			List<Formation>listForm=formationRep.findAll();
			mv.addObject("listParticipant", listPart);
			mv.addObject("listLocal", listLoca);
			mv.addObject("listFormation", listForm);
			return mv;
		 
	 }
	@RequestMapping(value="/participantformationsubmit",method=RequestMethod.POST)
	public ModelAndView participantFormationSubmit(@RequestParam Long participant,
			@RequestParam Long formation,
			@RequestParam Long local){
		ModelAndView mv = prepareModelAndView();
		boolean flag=true;
		if(participant==0){
			mv.addObject("messageError", "Choisir un Participant");
			flag=false;
		}
		if(formation==0){
			mv.addObject("messageError", "Choisir une formation");
			flag=false;
		}
		if(local==0){
			mv.addObject("messagerError", "Choisir un local");
			flag=false;
		}
		if(participantRep.findById(participant).getDetailLocalFormations().size()>=2){
			mv.addObject("messageError","Le particiipant est déjà inscrit pour les deux seances");
			flag=false;
		}
		/*
		 * Vérification si dans ce local, la formation
		 *  est effectivement bien donnée
		 *  */
		Local local2=localRep.findById(local);
		Formation formation2= formationRep.findById(formation);
		boolean check = detailLocSerrv.isTeached(local2,formation2 );
		if(check==false){
			mv.addObject("messageError", "Cette formation n'est pas donnée dans ce local");
			flag=false;
		}
		if(flag==false)
			return mv;
		else
		{
			DetailLocalFormation detailLocalFormation=detailLocalFormaRep.findByLocalFormation(local2, formation2);
			Participant participant2=participantRep.findById(participant);
			detailLocalFormation.addPartcipant(participant2);
		    detailLocalFormaRep.save(detailLocalFormation);
			mv.addObject("messageSuccess", "Inscription enregistrée pour "+participant2.getNom());
			mv.setViewName("redirect: home");
			return mv;
		}
		

	}
}
