package ma.itti.sovoyCars.ittisovoycars.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Voiture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String marque;
	private String photo;
	private String numImm;
	private double prix;
	private int modele;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateFinAssurance;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateVisite;
	@ManyToOne
	private Categorie categorie;
	@ManyToOne
	private Promotion promotion;

	public Voiture() {
	}

	public Voiture(String marque, String photo, String numImm, double prix, int modele, LocalDate dateFinAssurance,
			LocalDate dateVisite, Categorie categorie) {
		this.marque = marque;
		this.photo = photo;
		this.numImm = numImm;
		this.prix = prix;
		this.modele = modele;
		this.dateFinAssurance = dateFinAssurance;
		this.dateVisite = dateVisite;
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNumImm() {
		return numImm;
	}

	public void setNumImm(String numImm) {
		this.numImm = numImm;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getModele() {
		return modele;
	}

	public void setModele(int modele) {
		this.modele = modele;
	}

	public LocalDate getDateFinAssurance() {
		return dateFinAssurance;
	}

	public void setDateFinAssurance(LocalDate dateFinAssurance) {
		this.dateFinAssurance = dateFinAssurance;
	}

	public LocalDate getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(LocalDate dateVisite) {
		this.dateVisite = dateVisite;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

}
