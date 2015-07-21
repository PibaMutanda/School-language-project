package be.school.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQuery(name="Participant.findAll",query="select p from Participant p")
public class Participant {

	@Id
	@GeneratedValue
	private Long id;

	/* Matricule est géré par l'application */
	@Column(unique=true)
	private String matricule;

	@NotNull(message = "entrez votre mail")
	@Column(unique = true)
	@Pattern(message = "Invalide adresse mail", regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
	private String email;
	@Pattern(message = "invalide Numéro de Gsm , commencez par 0032 ou +32 sans espace", regexp = "^[0]{2}[32]{1}[0-9]{10}$|^[+]{1}[32]{1}[0-9]{10}$")
	private String gsm;
	@NotEmpty(message = "Insérez le nom")
	private String nom;
	@NotNull(message = "Insérez le prénom")
	private String prenom;
	@NotEmpty(message = "Indiquez la ville")
	private String ville;
	@Pattern(regexp = "^[0-9]{4}$", message = "Le code Postal invalide")
	private String codeP;
	@NotEmpty(message = "Indiquez le numéro")
	private String numero;
	@NotEmpty(message = "Indiquez la rue")
	private String rue;
	

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Indiquez le sexe")
	private Sexe sexe;

	public enum Sexe {
		HOMME, FEMME;
	}

	@OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
	private List<Inscription> inscriptions = new ArrayList<Inscription>();

	@ManyToOne
	@JoinColumn
	private StatutProfessionnel statutProfessionnel;

	@OneToMany(mappedBy = "participant",fetch=FetchType.EAGER)
	private Set<DetailLocalFormation> detailLocalFormations = new HashSet<DetailLocalFormation>();

	@ManyToOne
	@JoinColumn
	private Local local;
	
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	

	public String getCodeP() {
		return codeP;
	}

	public void setCodeP(String codeP) {
		this.codeP = codeP;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGsm() {
		return gsm;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public StatutProfessionnel getStatutProfessionnel() {
		return statutProfessionnel;
	}

	public void setStatutProfessionnel(StatutProfessionnel statutProfessionnel) {
		this.statutProfessionnel = statutProfessionnel;
	}

	public Set<DetailLocalFormation> getDetailLocalFormations() {
		return detailLocalFormations;
	}

	public void setDetailLocalFormations(
			Set<DetailLocalFormation> detailLocalFormations) {
		this.detailLocalFormations = detailLocalFormations;
	}

	public void addDetailLocalFormation(
			DetailLocalFormation detailLocalFormation) {
		detailLocalFormations.add(detailLocalFormation);
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Long getId() {
		return id;
	}

}
