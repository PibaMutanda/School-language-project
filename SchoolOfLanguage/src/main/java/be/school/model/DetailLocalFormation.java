package be.school.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import be.school.security.Seance;

@Entity
public class DetailLocalFormation {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "Saisir le niveau")
	@Pattern(message = "Valeur invalide", regexp = "^[0-9]*$")
	private String niveau;

	@Pattern(message = "Valeur non valide", regexp = "^[0-9]*$")
	@NotEmpty(message = "Saisir le quota")
	private String quota;

	@ManyToOne
	@JoinColumn
	Formation formation;

	@ManyToOne
	@JoinColumn
	private Local local;

	@OneToMany
	@JoinColumn
	private Set<RentreeScolaire> rentreeScolaires = new HashSet<RentreeScolaire>();

	
	@JoinTable(name="Local_Seance")
	@Enumerated(EnumType.ORDINAL)
	private Seance seance;

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public String getQuota() {
		return quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
	}

	
	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public Set<RentreeScolaire> getRentreeScolaires() {
		return rentreeScolaires;
	}

	public void setRentreeScolaires(Set<RentreeScolaire> rentreeScolaires) {
		this.rentreeScolaires = rentreeScolaires;
	}

	public Long getId() {
		return id;
	};

}
