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


@Entity
@NamedQueries({ @NamedQuery(name = "Inscription.findByDate", query = "select inscr from Inscription inscr where inscr.dateInscription=:dateInscr"),
	            @NamedQuery(name="Inscription.findAll",query="select i from Inscription i")})
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

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	

	public String getCommunicationPaie() {
		return communicationPaie;
	}

	public void setCommunicationPaie(String communicationPaie) {
		this.communicationPaie = communicationPaie;
	}

	
	public double getMontantPaie() {
		return montantPaie;
	}

	public void setMontantPaie(double montantPaie) {
		this.montantPaie = montantPaie;
	}

	public Long getId() {
		return id;
	}

}
