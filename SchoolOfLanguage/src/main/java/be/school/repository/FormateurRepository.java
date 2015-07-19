package be.school.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Formateur;

@Repository
@Transactional
public class FormateurRepository {

	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Formateur formateur){
		if(formateur.getId()==null)
			em.persist(formateur);
		else
			em.merge(formateur);
	}
	
	public Formateur findById(Long id){
		return em.find(Formateur.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Formateur> findAll(){
		return em.createQuery("Select f from Formateur f").getResultList();
	}
	
	@SuppressWarnings("rawtypes")
	public Formateur findByLoginAndPwd(String login, String password){
		Formateur formateur=null;
		List formateurs = em.createQuery("select f from Formateur f where f.login=:login and f.password=:password")
				.setParameter("login", login)
				.setParameter("password", password)
				.getResultList();
		if(!formateurs.isEmpty())
			formateur=(Formateur)formateurs.get(0);
		return formateur;
	}
	
}
