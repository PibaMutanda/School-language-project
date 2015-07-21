package be.school.repository;

import be.school.model.Formation;

public interface FormationRepository extends GenericRepository<Formation> {

	Formation findByCodeFormation(String cdeFormation);
	
	Formation findByTitre(String titre);
}
