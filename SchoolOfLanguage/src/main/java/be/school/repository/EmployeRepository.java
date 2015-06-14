package be.school.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Employe;

@Repository
@Transactional
public class EmployeRepository {

	@PersistenceContext
	private EntityManager em;
	
	public List<Employe> findAll(){
		return em.createNamedQuery("Employe.findAll").getResultList();
	}
	
	public Employe findById(Long id){
		return (Employe) em.createNamedQuery("Employe.findById").setParameter("id", id).getSingleResult();
	}
	
	public void save(Employe employe){
		if(employe.getId()==null)
			em.persist(employe);
		else
			em.merge(employe);
	}
	
	public Employe findByLoginAndPwd(String login, String password){
		Employe employe=null;
		List listEmpl = em.createNamedQuery("Employe.findByLoginAndPwd")
				.setParameter("login", login)
				.setParameter("password", password)
				.getResultList();
		if(!listEmpl.isEmpty())
			employe=(Employe)listEmpl.get(0);
		return employe;
				
	}
}
