package be.school.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@NamedQuery(name="Reservation.findAll", query="select r from Reservation r")
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
	@Column(unique=true)
	@Pattern(message = "ville mail pas valide", regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
    public void add(Formation formation){
    	this.formations.add(formation);
    }
	public String getGsm() {
		return gsm;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public Date getDateReserv() {
		return dateReserv;
	}

	public void setDateReserv(Date dateReserv) {
		this.dateReserv = dateReserv;
	}
    
	
    
	public Date getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(Date dateRdv) {
		
		this.dateRdv = dateRdv;
	}

	public Long getId() {
		return id;
	}

	
}
