package be.school.repository;

import be.school.model.Employe;

public interface EmployeRepository extends GenericRepository<Employe> {

   Employe findByLoginAndPwd(String login, String password);
}
