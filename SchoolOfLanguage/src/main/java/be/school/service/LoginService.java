package be.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import be.school.exception.ObjectNotFoundException;
import be.school.model.Employe;
import be.school.model.Formateur;
import be.school.repository.EmployeRepository;
import be.school.repository.FormateurRepository;
import be.school.util.SecurityUtils;

@Service
@Scope("singleton")
public class LoginService {
	
	@Autowired
	private FormateurRepository formateurRepository;
	
	@Autowired
	private EmployeRepository employeRepository;
	
	public Formateur loginFormateur(String login, String password)throws ObjectNotFoundException{
		Formateur formateur=formateurRepository.findByLoginAndPwd(login, SecurityUtils.md5Encode(password));
		if (formateur==null)
			throw new  ObjectNotFoundException("Login ou mot de passe incorrect");
		else
			return formateur;
		
	}
	
  public Employe loginEmploye(String login,String password)throws ObjectNotFoundException{
	  Employe employe= employeRepository.findByLoginAndPwd(login, SecurityUtils.md5Encode(password));
	  if(employe==null)
		  throw new ObjectNotFoundException("Login ou mot de passe incorrect");
	  else
		  return employe;
  }

}
