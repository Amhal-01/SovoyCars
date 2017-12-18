package ma.itti.sovoyCars.ittisovoycars.services;

import java.util.List;
import ma.itti.sovoyCars.ittisovoycars.models.Voiture;


public interface VoitureService {
	List<Voiture> getVoitures();
	void ajouterVoiture(Voiture v);
	void modifierVoiture(Voiture v);
	void supprimerVoiture(Voiture v);
	Voiture getById(int id);
}