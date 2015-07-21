package be.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQuery(name = "StatutProfessionnel.findAll", query = "select st from StatutProfessionnel st")
public class StatutProfessionnel {

	@Id
	@GeneratedValue
	private Long id;

	@Size(max = 30)
	@NotEmpty(message = "Le statut ne doit pas être vide")
	@Column(name = "statut", unique = true)
	private String statut;

	private Double prix;

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Long getId() {
		return id;
	}

}
