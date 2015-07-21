package be.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQueries({
		@NamedQuery(name = "Employe.findAll", query = "select e from Employe e"),
		@NamedQuery(name = "Employe.findByLoginAndPwd", query = "select e from Employe e where e.login=:login and e.password=:password") })
public class Employe {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "Insérer le nom de l'employé")
	@Size(max = 40, message = "la taille maximun requise est de 40 caractères")
	private String nom;

	@NotEmpty(message = "Insérer le mot de passe")
	@Size(max = 50, message = "La taille maximun est de 50 caractères pour le mot de passe")
	private String password;

	@Transient
	private String confirmPassword;

	@NotEmpty(message = "insérer le login")
	private String login;

	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private Role roleEmploye;

	public enum Role {
		SIMPLE, ADMIN
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Role getRoleEmploye() {
		return roleEmploye;
	}

	public void setRoleEmploye(Role roleEmploye) {
		this.roleEmploye = roleEmploye;
	}

	public Long getId() {
		return id;
	}

}
