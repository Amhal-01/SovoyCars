package ma.itti.sovoyCars.ittisovoycars.services;

import java.util.List;
import ma.itti.sovoyCars.ittisovoycars.models.Categorie;


public interface CategorieService {
	List<Categorie> getCategories();
	void ajouterCategorie(Categorie c);
	void modifierCategorie(Categorie c);
	void supprimerCategorie(Categorie c);
	Categorie getById(int id);
}
