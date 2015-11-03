package be.school.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.Employe;
import be.school.repository.EmployeRepository;
import be.school.util.SecurityUtils;


@Controller
public class EmployeController {
	
	@Autowired
	private EmployeRepository employeRepo;
	
	@RequestMapping(value="/employeregister",method=RequestMethod.GET )
	public ModelAndView employeRegister(@RequestParam(value="id",required=false)Long id){
		ModelAndView mv = new ModelAndView("employeregister");
		Employe employe=null;
		if(id==null)
			employe = new Employe();
		else
			employe = employeRepo.findById(id);
		mv.addObject("employe", employe);
		return mv;
			
	}

	@RequestMapping(value="/employesubmit", method=RequestMethod.POST)
	public ModelAndView employeSubmit(@Valid @ModelAttribute Employe employe, Errors errors){
		ModelAndView mv = new ModelAndView("employeregister");
		if(errors.hasErrors()){
			mv.addObject("employe", employe);
			return mv;
		}
		else
		{
			employe.setPassword(SecurityUtils.md5Encode(employe.getPassword()));
		//	employe.setRoleEmploye(role);
			employeRepo.save(employe);
			mv.addObject("messageSuccess",
					"Employé est  enregistré avec succès");
			mv.setViewName("redirect:employelist");
			return mv;		
		}
	}
	
	@RequestMapping(value="/employelist", method=RequestMethod.GET)
	public ModelAndView employeList(){
		ModelAndView  mv = new ModelAndView("employelist");
		mv.addObject("listEmploye", employeRepo.findAll());
		return mv;
	}
}
