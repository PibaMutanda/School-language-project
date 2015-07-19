package be.school.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@NamedQueries({
@NamedQuery(name="PublicationInscription.findByDate", query="select pi from PublicationInscription pi where pi.dateDebInscr=:dateDebInscr and pi.dateFinInscr=:dateFinInscr"),
@NamedQuery(name="PublicationInscription.findAll",query="select pi from PublicationInscription pi")})
public class PublicationInscription {

	@Id
	@GeneratedValue
	private Long id;
	
	private String messageInscription;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateDebInscr;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateFinInscr;
	
	@ManyToOne
	private Employe employe;

	public String getMessageInscription() {
		return messageInscription;
	}

	public void setMessageInscription(String messageInscription) {
		this.messageInscription = messageInscription;
	}

	public Date getDateDebInscr() {
		return dateDebInscr;
	}

	public void setDateDebInscr(Date dateDebInscr) {
		this.dateDebInscr = dateDebInscr;
	}

	public Date getDateFinInscr() {
		return dateFinInscr;
	}

	public void setDateFinInscr(Date dateFinInscr) {
		this.dateFinInscr = dateFinInscr;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Long getId() {
		return id;
	}
	
	
}
