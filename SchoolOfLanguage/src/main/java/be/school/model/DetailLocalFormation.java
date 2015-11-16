package be.school.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import be.school.enumClass.Jour;
import be.school.enumClass.Seance;

/**
 * DetailLocalFormation class
 * 
 * @author P. Mutanda
 *
 */
@Entity
@NamedQuery(name = "DetailLocalFormation.findAll", query = "select nf from DetailLocalFormation nf")
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

	@ManyToOne
	@JoinColumn
	private Formateur formateur;

	@Enumerated(EnumType.ORDINAL)
	private Seance seance;

	@Enumerated(EnumType.ORDINAL)
	private Jour jour;

	@ManyToOne
	@JoinColumn
	private Participant participant;

	/**
	 * 
	 * @return retourne une séance
	 */
	public Seance getSeance() {
		return seance;
	}

	/**
	 * 
	 * @param seance
	 *            seance
	 */
	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	/**
	 * 
	 * @return retourne le quota
	 */
	public String getQuota() {
		return quota;
	}

	/**
	 * 
	 * @param quota
	 *            quota
	 */
	public void setQuota(String quota) {
		this.quota = quota;
	}

	/**
	 * 
	 * @return retourne une formation
	 */
	public Formation getFormation() {
		return formation;
	}

	/**
	 * 
	 * @param formation
	 *            formation
	 */
	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	/**
	 * 
	 * @return retourne un formateur
	 */
	public Formateur getFormateur() {
		return formateur;
	}

	/**
	 * 
	 * @param formateur
	 *            formateur
	 */
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	/**
	 * 
	 * @return retourne le local
	 */
	public Local getLocal() {
		return local;
	}

	/**
	 * @return retourne le participant
	 */
	public Participant getParticipant() {
		return participant;
	}

	/**
	 * @param participant
	 *            the participant to set
	 */
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	/**
	 * 
	 * @param local
	 *            local
	 */
	public void setLocal(Local local) {
		this.local = local;
	}

	/**
	 * 
	 * @return retourne le niveau de la formation
	 */
	public String getNiveau() {
		return niveau;
	}

	/**
	 * 
	 * @param niveau
	 *            niveau
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	/**
	 * 
	 * @return retourne le jour
	 */
	public Jour getJour() {
		return jour;
	}

	/**
	 * 
	 * @param jour
	 *            jour
	 */
	public void setJour(Jour jour) {
		this.jour = jour;
	}

	/**
	 * 
	 * @return retourne id
	 */
	public Long getId() {
		return id;
	}

}
