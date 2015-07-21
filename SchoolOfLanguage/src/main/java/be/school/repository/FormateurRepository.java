package be.school.repository;

import be.school.model.Formateur;

public interface FormateurRepository extends GenericRepository<Formateur> {
	
	Formateur findByLoginAndPwd(String login, String password);
}
