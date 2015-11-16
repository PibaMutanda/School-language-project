package be.school.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * Inscription class
 * 
 * @author P. Mutanda
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Inscription.findByDate", query = "select inscr from Inscription inscr where inscr.dateInscription=:dateInscr"),
		@NamedQuery(name = "Inscription.findAll", query = "select i from Inscription i") })
public class Inscription {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn
	private Participant participant;

	private String communicationPaie;

	private double montantPaie;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateInscription;

	/**
	 * 
	 * @return retourne participant
	 */
	public Participant getParticipant() {
		return participant;
	}

	/**
	 * 
	 * @param participant
	 *            participant
	 */
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	/**
	 * 
	 * @return retourne date inscription
	 */
	public Date getDateInscription() {
		return dateInscription;
	}

	/**
	 * 
	 * @param dateInscription
	 *            dateInscription
	 */
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	/**
	 * 
	 * @return retourne communication paie
	 */
	public String getCommunicationPaie() {
		return communicationPaie;
	}

	/**
	 * 
	 * @param communicationPaie
	 *            communicationPaie
	 */
	public void setCommunicationPaie(String communicationPaie) {
		this.communicationPaie = communicationPaie;
	}

	/**
	 * 
	 * @return retourne montant
	 */
	public double getMontantPaie() {
		return montantPaie;
	}

	/**
	 * 
	 * @param montantPaie
	 *            montant
	 */
	public void setMontantPaie(double montantPaie) {
		this.montantPaie = montantPaie;
	}

	/**
	 * 
	 * @return retourne id
	 */
	public Long getId() {
		return id;
	}

}
