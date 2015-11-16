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

/**
 * PublicationInscription class
 * 
 * @author P. Mutanda
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "PublicationInscription.findByDate", query = "select pi from PublicationInscription pi where pi.dateDebInscr=:dateDebInscr and pi.dateFinInscr=:dateFinInscr"),
		@NamedQuery(name = "PublicationInscription.findAll", query = "select pi from PublicationInscription pi") })
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

	/**
	 * 
	 * @return retourne message inscription
	 */
	public String getMessageInscription() {
		return messageInscription;
	}

	/**
	 * 
	 * @param messageInscription
	 *            messageInscription
	 */
	public void setMessageInscription(String messageInscription) {
		this.messageInscription = messageInscription;
	}

	/**
	 * 
	 * @return retourne date du début pour inscription
	 */
	public Date getDateDebInscr() {
		return dateDebInscr;
	}

	/**
	 * 
	 * @param dateDebInscr
	 *            dateDebInscr
	 */
	public void setDateDebInscr(Date dateDebInscr) {
		this.dateDebInscr = dateDebInscr;
	}

	/**
	 * 
	 * @return retourne date de fin pour inscription
	 */
	public Date getDateFinInscr() {
		return dateFinInscr;
	}

	/**
	 * 
	 * @param dateFinInscr
	 *            dateFinInscr
	 */
	public void setDateFinInscr(Date dateFinInscr) {
		this.dateFinInscr = dateFinInscr;
	}

	/**
	 * 
	 * @return retourne employe
	 */
	public Employe getEmploye() {
		return employe;
	}

	/**
	 * 
	 * @param employe
	 *            employe
	 */
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	/**
	 * 
	 * @return retourne Id
	 */
	public Long getId() {
		return id;
	}

}
