package be.school.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.exception.ObjectNotFoundException;
import be.school.model.PublicationInscription;

@Repository
@Transactional
public class PublicationInscriptionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(PublicationInscription publicationInscription) {
		if (publicationInscription.getId() == null)
			entityManager.persist(publicationInscription);
		else
			entityManager.merge(publicationInscription);
	}

	public PublicationInscription findById(Long id) {
		return entityManager.find(PublicationInscription.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<PublicationInscription> findAll(){
		return entityManager.createNamedQuery("PublicationInscription.findAll").getResultList();
	}
	@SuppressWarnings("unchecked")
	public PublicationInscription findByDate(Date dateDeb, Date dateFin) {
		PublicationInscription publicationInscription = null;
		List<PublicationInscription> listPubl = entityManager
				.createNamedQuery("PublicationInscription.findByDate")
				.setParameter("dateDebInscr", dateDeb)
				.setParameter("dateFinInscr", dateFin).getResultList();
		if (!listPubl.isEmpty())
			publicationInscription = listPubl.get(0);
		return publicationInscription;
	}
	
	public void delete(PublicationInscription publicationInscription) throws ObjectNotFoundException{
		if(publicationInscription.getId()!=null)
			entityManager.remove(publicationInscription);
		else {
			throw new ObjectNotFoundException("Publication inscription non existante !");
		}
	}
}
