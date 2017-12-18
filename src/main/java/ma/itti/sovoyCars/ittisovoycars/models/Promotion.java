package ma.itti.sovoyCars.ittisovoycars.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String designation;
	@OneToMany
	private List<Voiture> voiture;	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateDebut;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateFin;
	
	public Promotion() {
	}


	public Promotion(String designation, LocalDate dateDebut, LocalDate dateFin) {
		this.designation = designation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public List<Voiture> getVoiture() {
		return voiture;
	}


	public void setVoiture(List<Voiture> voiture) {
		this.voiture = voiture;
	}


	public LocalDate getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}


	public LocalDate getDateFin() {
		return dateFin;
	}


	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

}
