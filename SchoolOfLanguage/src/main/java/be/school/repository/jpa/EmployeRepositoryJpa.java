package be.school.repository.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Employe;
import be.school.repository.EmployeRepository;

@Repository
@Transactional
public class EmployeRepositoryJpa extends GenericRepositoryJpa<Employe> implements EmployeRepository{

//	public void save(Employe employe){
//		if(employe.getId()==null)
//			em.persist(employe);
//		else
//			em.merge(employe);
//	}
//	
	@SuppressWarnings("rawtypes")
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
