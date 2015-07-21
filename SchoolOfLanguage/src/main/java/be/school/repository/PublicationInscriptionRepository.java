package be.school.repository;

import java.util.Date;

import be.school.model.PublicationInscription;

public interface PublicationInscriptionRepository extends GenericRepository<PublicationInscription> {
	
	PublicationInscription findByDate(Date dateDeb, Date dateFin);
	

}
