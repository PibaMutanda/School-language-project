package be.school.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="LocalCours")
public class Local {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message="Saisir le numéro du local")
	@Column(unique=true)
	private String numLocal;
	@Pattern(message="Donnée incorrecte", regexp="^[0-9]*$")
	private String capacite;
	
	
	@OneToMany(mappedBy = "local", cascade = CascadeType.ALL)
	private List<DetailLocalFormation> detailLocalFormations = new ArrayList<DetailLocalFormation>();
	
	
	private boolean estLibre=true;
	
	

	public List<DetailLocalFormation> getDetailLocalFormations() {
		return detailLocalFormations;
	}

	public void setDetailLocalFormations(
			List<DetailLocalFormation> detailLocalFormations) {
		this.detailLocalFormations = detailLocalFormations;
	}

	public boolean isEstLibre() {
		return estLibre;
	}

	public void setEstLibre(boolean estLibre) {
		this.estLibre = estLibre;
	}

	@OneToMany(mappedBy="local")
	private Set<Participant> participants = new HashSet<Participant>();

	public String getNumLocal() {
		return numLocal;
	}

	public void setNumLocal(String numLocal) {
		this.numLocal = numLocal;
	}

	public String getCapacite() {
		return capacite;
	}

	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	public Long getId() {
		return id;
	}
	
}
