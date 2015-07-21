package be.school.repository;

import be.school.model.StatutProfessionnel;

public interface StatutProfessionnelRepository extends GenericRepository<StatutProfessionnel> {
	
	StatutProfessionnel findStatutByName(String name);
}
