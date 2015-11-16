package be.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * StatutProfessionnel class
 * 
 * @author P. Mutanda
 *
 */
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
	@NotNull(message = "Saisir le prix")
	private Double prix;

	/**
	 * 
	 * @return retourne le prix
	 */
	public Double getPrix() {
		return prix;
	}

	/**
	 * 
	 * @param prix
	 *            prix
	 */
	public void setPrix(Double prix) {
		this.prix = prix;
	}

	/**
	 * 
	 * @return retourne le statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * 
	 * @param statut
	 *            statut
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

	/**
	 * 
	 * @return retourne Id
	 */
	public Long getId() {
		return id;
	}

}
