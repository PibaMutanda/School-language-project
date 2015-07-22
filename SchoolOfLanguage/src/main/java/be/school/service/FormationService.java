package be.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import be.school.exception.ObjectAlreadyExistsException;
import be.school.model.Formation;
import be.school.repository.FormationRepository;

@Service
@Scope("singleton")
public class FormationService {
	
	@Autowired
	private FormationRepository foRepository;

	public Formation registerFormation(String code, String titre)throws ObjectAlreadyExistsException{
		if(foRepository.findByCodeFormation(code)!=null)
			throw new ObjectAlreadyExistsException(titre);
		if(foRepository.findByTitre(titre)!=null)
			throw new ObjectAlreadyExistsException(titre);
		Formation newFormation = new Formation();
		newFormation.setCodeFormation(code);
		newFormation.setTitre(titre);
		foRepository.save(newFormation);
		return newFormation;
	}
}
