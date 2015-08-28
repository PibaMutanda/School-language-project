package be.school.repository;

import java.util.List;

import be.school.enumClass.Jour;
import be.school.enumClass.Seance;
import be.school.model.DetailLocalFormation;
import be.school.model.Formateur;
import be.school.model.Formation;
import be.school.model.Local;

public interface DetailLocalFormationRepository extends GenericRepository<DetailLocalFormation> {
	
	 List<DetailLocalFormation> findAllDistinct();
	 List<DetailLocalFormation> findAllByFormateur(Formateur formateur);
     DetailLocalFormation findByLocalSession(Local local, Seance seance, Jour jour);
     List<DetailLocalFormation> findByFormationFormateur(Formation formation, Formateur formateur);
     List<DetailLocalFormation> findAllByFormation(Formation formation);
     DetailLocalFormation findByLocalFormationNiveau(Local local,Formation formation, String niveau);
     DetailLocalFormation findByLocalFormation(Local local,Formation formation);
     Long getParticipantNumber(Local local, Seance seance);

}
