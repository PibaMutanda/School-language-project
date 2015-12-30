package be.school.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * Reservation class
 * 
 * @author P. Mutanda
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Reservation.findListByDate", query = "select r from Reservation r where r.dateRdv like :dateRdv"),
		@NamedQuery(name = "Reservation.findAll", query = "select r from Reservation r") })
public class Reservation {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull(message = "Saisissez votre nom")
	@Size(max = 45, message = "La taille maximun est de 45 caractères")
	private String nom;

	@NotNull(message = "Saisissez le prénom")
	@Size(max = 45, message = "La taille maximun est de 45 caractères")
	private String prenom;

	@NotNull(message = "entrer votre mail")
	@Column(unique = true)
	@Pattern(message = "adressee é-mail non valide", regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
	private String email;

	@Pattern(message = "Numéro de Gsm n'est pas valide, commencez par 0032 ou +32 sans espace", regexp = "^[0]{2}[32]{1}[0-9]{10}$|^[+]{1}[32]{1}[0-9]{10}$")
	private String gsm;
	@DateTimeFormat(iso = ISO.DATE)
	@Temporal(TemporalType.DATE)
	private Date dateReserv;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateRdv;

	@OneToMany
	@JoinColumn
	private List<Formation> formations = new ArrayList<Formation>();

	/**
	 * 
	 * @return retourne le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @param nom
	 *            nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * 
	 * @return retourne le prénom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * 
	 * @param prenom
	 *            prénom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * 
	 * @return retourne é-mail
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 *            é-mail
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return retourne formations
	 */
	public List<Formation> getFormations() {
		return formations;
	}

	/**
	 * 
	 * @param formations
	 *            formations
	 */
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	/**
	 * 
	 * @param formation
	 *            formation
	 */
	public void add(Formation formation) {
		this.formations.add(formation);
	}

	/**
	 * 
	 * @return retourne le Gsm
	 */
	public String getGsm() {
		return gsm;
	}

	/**
	 * 
	 * @param gsm
	 *            Gsm
	 */
	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	/**
	 * 
	 * @return retourne la date pour la réservation
	 */
	public Date getDateReserv() {
		return dateReserv;
	}

	/**
	 * 
	 * @param dateReserv
	 *            dateReserv
	 */
	public void setDateReserv(Date dateReserv) {
		this.dateReserv = dateReserv;
	}

	/**
	 * 
	 * @return retourne la date du rendez-vous
	 */
	public Date getDateRdv() {
		return dateRdv;
	}

	/**
	 * 
	 * @param dateRdv
	 *            dateRdv
	 */
	public void setDateRdv(Date dateRdv) {

		this.dateRdv = dateRdv;
	}

	/**
	 * 
	 * @return retourne Id
	 */
	public Long getId() {
		return id;
	}
}
