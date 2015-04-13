package be.school.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import be.school.model.DetailLocalFormation;

@Entity
public class Formateur {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message="Insérer le nom du formateur")
	@Size(max=40, message="la taille maximun requise est de 40 caractères")
	private String nom;
	
	@NotEmpty(message="Insérer le prénom du formateur")
	@Size(max=40, message="la taille maximun requise est de 40 caractères")
	private String prenom;
	
	@NotEmpty(message="Insérer le mot de passe")
	@Size(max=50, message="La taille maximun est de 50 caractères pour le mot de passe")
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@NotEmpty(message="insérer le login")
	private String login;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn
	private Set<DetailLocalFormation>detailLocalFormations= new HashSet<DetailLocalFormation>();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		nom=nom.toUpperCase();
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		prenom=prenom.toUpperCase();
		this.prenom = prenom;
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

	public Set<DetailLocalFormation> getDetailLocalFormations() {
		return detailLocalFormations;
	}

	public void setDetailLocalFormations(
			Set<DetailLocalFormation> detailLocalFormations) {
		this.detailLocalFormations = detailLocalFormations;
	}

	public void addDetailLocalFormation(DetailLocalFormation detailLocalFormation){
		this.detailLocalFormations.add(detailLocalFormation);
	}
	public Long getId() {
		return id;
	}
	
}
