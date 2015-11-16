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

/**
 * Classe Employe
 * 
 * @author P. Mutanda
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Employe.findAll", query = "select e from Employe e"),
		@NamedQuery(name = "Employe.findByLoginAndPwd", query = "select e from Employe e where e.login=:login and e.password=:password") })
public class Employe {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "Insérer le nom")
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

	/**
	 * 
	 * @author P. Mutanda
	 *
	 */
	public enum Role {
		SIMPLE, ADMIN
	}

	/**
	 * 
	 * @return retourne le nom de l'employé
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @param nom
	 *            nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * 
	 * @return retourne le mot de passe
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 *            mot de passe
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * 
	 * @return le login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * 
	 * @param login
	 *            login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * 
	 * @return retourne le role de l'employé
	 */
	public Role getRoleEmploye() {
		return roleEmploye;
	}

	/**
	 * 
	 * @param roleEmploye
	 *            roleEmploye
	 */
	public void setRoleEmploye(Role roleEmploye) {
		this.roleEmploye = roleEmploye;
	}

	/**
	 * 
	 * @return retourne id
	 */
	public Long getId() {
		return id;
	}

}
