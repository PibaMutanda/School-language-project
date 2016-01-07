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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * local class
 * 
 * @author P. Mutanda
 *
 */
@Entity
@Table(name = "LocalCours")
@NamedQueries({
		@NamedQuery(name = "Local.findAll", query = "select l from Local l"),
		@NamedQuery(name = "Local.findAllbyFormation", query = "select l from Local l join l.detailLocalFormations ld where ld.formation.id=:id") })
public class Local {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "Saisir le numéro du local")
	@Column(unique = true)
	private String numLocal;
	@Pattern(message = "Donnée incorrecte", regexp = "^[0-9]*$")
	private String capacite;

	@OneToMany(mappedBy = "local", cascade = CascadeType.ALL)
	private List<DetailLocalFormation> detailLocalFormations = new ArrayList<DetailLocalFormation>();

	private boolean estLibre = true;

	/**
	 * 
	 * @return retourne la liste detaillocalformation
	 */
	public List<DetailLocalFormation> getDetailLocalFormations() {
		return detailLocalFormations;
	}

	/**
	 * 
	 * @param detailLocalFormations
	 *            detailLocalFormations
	 */
	public void setDetailLocalFormations(
			List<DetailLocalFormation> detailLocalFormations) {
		this.detailLocalFormations = detailLocalFormations;
	}

	/**
	 * 
	 * @return retourne un boolean
	 */
	public boolean isEstLibre() {
		return estLibre;
	}

	/**
	 * 
	 * @param estLibre
	 *            estLibre
	 */
	public void setEstLibre(boolean estLibre) {
		this.estLibre = estLibre;
	}

	@OneToMany(mappedBy = "local")
	private Set<Participant> participants = new HashSet<Participant>();

	/**
	 * 
	 * @return retourne le numéro d'un local
	 */
	public String getNumLocal() {
		return numLocal;
	}

	/**
	 * 
	 * @param numLocal
	 *            numLocal
	 */
	public void setNumLocal(String numLocal) {
		this.numLocal = numLocal;
	}

	/**
	 * 
	 * @return retourne la capacité maximale d'un local
	 */
	public String getCapacite() {
		return capacite;
	}

	/**
	 * 
	 * @param capacite
	 *            capacité
	 */
	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}

	/**
	 * 
	 * @return retourne un set des participants
	 */
	public Set<Participant> getParticipants() {
		return participants;
	}

	/**
	 * 
	 * @param participants
	 *            participants
	 */
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	/**
	 * 
	 * @return retourne ID
	 */
	public Long getId() {
		return id;
	}

}
