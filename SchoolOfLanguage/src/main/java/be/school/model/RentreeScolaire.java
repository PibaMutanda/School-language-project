package be.school.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class RentreeScolaire {

	@Id
	@GeneratedValue
	private Long id;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Temporal(TemporalType.DATE)
	@NotNull(message="Saisir la date")
	@Column(unique=true)
	private Date dateScolaireDeb;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Temporal(TemporalType.DATE)
	private Date dateScolaireFin;

	public Date getDateScolaireDeb() {
		return dateScolaireDeb;
	}

	public void setDateScolaireDeb(Date dateScolaire) {
		this.dateScolaireDeb = dateScolaire;
	}
    
	public Date getDateScolaireFin() {
		return dateScolaireFin;
	}

	public void setDateScolaireFin(Date dateScolaireFin) {
		this.dateScolaireFin = dateScolaireFin;
	}

	public Long getId() {
		return id;
	}
	
	
}
