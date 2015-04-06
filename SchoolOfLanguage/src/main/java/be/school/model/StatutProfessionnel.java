package be.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class StatutProfessionnel {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(max=30)
	@NotEmpty(message="Le statut ne doit pas être vide")
	@Column(name="statut",unique=true)
	private String statut;

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Long getId() {
		return id;
	}
	

}
