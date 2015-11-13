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
	 * @return
	 */
	public Seance getSeance() {
		return seance;
	}

	/**
	 * 
	 * @param seance
	 */
	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	/**
	 * 
	 * @return
	 */
	public String getQuota() {
		return quota;
	}

	/**
	 * 
	 * @param quota
	 */
	public void setQuota(String quota) {
		this.quota = quota;
	}

	/**
	 * 
	 * @return
	 */
	public Formation getFormation() {
		return formation;
	}

	/**
	 * 
	 * @param formation
	 */
	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	/**
	 * 
	 * @return
	 */
	public Formateur getFormateur() {
		return formateur;
	}

	/**
	 * 
	 * @param formateur
	 */
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Local getLocal() {
		return local;
	}

	/**
	 * @return the participant
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
	 */
	public void setLocal(Local local) {
		this.local = local;
	}

	/**
	 * 
	 * @return
	 */
	public String getNiveau() {
		return niveau;
	}

	/**
	 * 
	 * @param niveau
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	/**
	 * 
	 * @return
	 */
	public Jour getJour() {
		return jour;
	}

	/**
	 * 
	 * @param jour
	 */
	public void setJour(Jour jour) {
		this.jour = jour;
	}

	/**
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

}
