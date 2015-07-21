package be.school.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.RentreeScolaire;
import be.school.repository.jpa.RentreeScolaireRepository;

@Controller
public class RentreeScolaireController {

	@Autowired
	private RentreeScolaireRepository anneeScolRep;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/anneescolaireregister", method = RequestMethod.GET)
	public ModelAndView anneeScolaireRegister(
			@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mv = new ModelAndView("anneescolaireregister");
		RentreeScolaire rentreeScolaire = null;
		if (id == null)
			rentreeScolaire = new RentreeScolaire();
		else
			anneeScolRep.findById(id);
		mv.addObject("anneeScolaire", rentreeScolaire);

		return mv;
	}
	
	/*
	 * Cette partie du code gére la publication du debut de l'année
	 * et le système se charge de gérer l'année de fin */
	@RequestMapping(value="/anneescolairesubmit", method = RequestMethod.POST)
	public ModelAndView anneeScolaireSubmit(@Valid @ModelAttribute RentreeScolaire rentreeScolaire, Errors errors){
		ModelAndView mv = new ModelAndView("anneescolaireregister");
	
		if(anneeScolRep.findByDateDeb(rentreeScolaire.getDateScolaireDeb())!=null)
		{
			mv.addObject("messageError","Année "+rentreeScolaire.getDateScolaireDeb()+" est déjà publiée");
			return mv;
		}

		if(rentreeScolaire.getDateScolaireDeb().before(new Date())){
			mv.addObject("messageError", "Choisir correctement la date pour la rentrée");
			return mv;
		}
		if(errors.hasErrors()){
			mv.addObject("anneeScolaire",rentreeScolaire);
		}
		else{
			Calendar cal = Calendar.getInstance();
			   
			         cal.setTime(rentreeScolaire.getDateScolaireDeb());
			         cal.add(Calendar.YEAR, 1);
			         cal.set(Calendar.MONTH, 5); 
			         cal.set(Calendar.DAY_OF_MONTH, 30);
			         rentreeScolaire.setDateScolaireFin(cal.getTime());
			         anneeScolRep.save(rentreeScolaire);
			         System.out.println(rentreeScolaire.getDateScolaireDeb()+" et "+rentreeScolaire.getDateScolaireFin());
			         mv.addObject("messageSuccess","Année Scolaire est enregistrée avec succées");
			         mv.setViewName("redirect:home");
		}
		return mv;
	}

}
