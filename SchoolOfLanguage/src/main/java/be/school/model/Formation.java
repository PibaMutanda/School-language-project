package be.school.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Formation {

	@Id
	@GeneratedValue
	private Long id;

	@Size(max = 25)
	@Column(unique = true)
	private String codeFormation;

	@Column(nullable = false, unique = true)
	@NotEmpty(message = "Saisir le titre de la formation")
	private String titre;

	@OneToMany(mappedBy = "formation")
	private List<DetailLocalFormation> detailLocalFormations = new ArrayList<DetailLocalFormation>();

	public String getCodeFormation() {
		return codeFormation;
	}

	public void setCodeFormation(String codeFormation) {
		this.codeFormation = codeFormation;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		titre = titre.toUpperCase();
		this.titre = titre;
	}

	

	public List<DetailLocalFormation> getDetailLocalFormations() {
		return detailLocalFormations;
	}

	public void setDetailLocalFormations(
			List<DetailLocalFormation> detailLocalFormations) {
		this.detailLocalFormations = detailLocalFormations;
	}

	public Long getId() {
		return id;
	}
}
