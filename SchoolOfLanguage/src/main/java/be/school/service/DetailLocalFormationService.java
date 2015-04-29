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
	
	
	public boolean isTeached(Local local, Formation formation){
		DetailLocalFormation detailLocalFormation=null;
		detailLocalFormation = detailLocalFormationReposytory.findByLocalFormation(local, formation);
		if(detailLocalFormation!=null)
			return true;
		else
			return false;
	}
	
}
