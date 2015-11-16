package be.school.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import be.school.model.DetailLocalFormation;

/**
 * Formateur class
 * 
 * @author P. Mutanda
 *
 */
@Entity
@NamedQuery(name = "Formateur.findAll", query = "Select f from Formateur f")
public class Formateur {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "Insérer le nom du formateur")
	@Size(max = 40, message = "la taille maximun requise est de 40 caractères")
	private String nom;

	@NotEmpty(message = "Insérer le prénom du formateur")
	@Size(max = 40, message = "la taille maximun requise est de 40 caractères")
	private String prenom;

	@NotEmpty(message = "Insérer le mot de passe")
	@Size(max = 50, message = "La taille maximun est de 50 caractères pour le mot de passe")
	private String password;

	@Transient
	private String confirmPassword;

	@NotEmpty(message = "insérer le login")
	private String login;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "formateur")
	private Set<DetailLocalFormation> detailLocalFormations = new HashSet<DetailLocalFormation>();

	/**
	 * 
	 * @return retourne le nom
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
		nom = nom.toUpperCase();
		this.nom = nom;
	}

	/**
	 * 
	 * @return retourne le Prénom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * 
	 * @param prenom
	 *            prenom
	 */
	public void setPrenom(String prenom) {
		prenom = prenom.toUpperCase();
		this.prenom = prenom;
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

	/**
	 * 
	 * @return
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * 
	 * @return retourne le login
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
	 * @return retourne un set de detailLocalFormation
	 */
	public Set<DetailLocalFormation> getDetailLocalFormations() {
		return detailLocalFormations;
	}

	/**
	 * 
	 * @param detailLocalFormations
	 *            detailLocalFormations
	 */
	public void setDetailLocalFormations(
			Set<DetailLocalFormation> detailLocalFormations) {
		this.detailLocalFormations = detailLocalFormations;
	}

	/**
	 * 
	 * @param detailLocalFormation
	 */
	public void addDetailLocalFormation(
			DetailLocalFormation detailLocalFormation) {
		this.detailLocalFormations.add(detailLocalFormation);
	}

	/**
	 * 
	 * @return retourne id
	 */
	public Long getId() {
		return id;
	}

}
