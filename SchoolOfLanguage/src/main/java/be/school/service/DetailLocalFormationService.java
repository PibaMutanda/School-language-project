package be.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import be.school.model.DetailLocalFormation;
import be.school.model.Formation;
import be.school.model.Local;
import be.school.repository.DetailLocalFormationReposytory;

@Service
@Scope("singleton")
public class DetailLocalFormationService {

	@Autowired
	private DetailLocalFormationReposytory detailLocalFormationReposytory;
	
	
	public boolean isTeached(Local local, Formation formation,String niveau){
		DetailLocalFormation detailLocalFormation=null;
		detailLocalFormation = detailLocalFormationReposytory.findByLocalFormationNiveau(local, formation,niveau);
		if(detailLocalFormation!=null)
			return true;
		else
			return false;
	}
	
	
}
