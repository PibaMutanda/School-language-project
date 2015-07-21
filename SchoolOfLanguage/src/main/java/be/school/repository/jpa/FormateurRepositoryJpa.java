package be.school.repository.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Formateur;
import be.school.repository.FormateurRepository;

@Repository
@Transactional
public class FormateurRepositoryJpa extends GenericRepositoryJpa<Formateur>
		implements FormateurRepository {

	@SuppressWarnings("rawtypes")
	public Formateur findByLoginAndPwd(String login, String password) {
		Formateur formateur = null;
		List formateurs = em
				.createQuery(
						"select f from Formateur f where f.login=:login and f.password=:password")
				.setParameter("login", login)
				.setParameter("password", password).getResultList();
		if (!formateurs.isEmpty())
			formateur = (Formateur) formateurs.get(0);
		return formateur;
	}

}
