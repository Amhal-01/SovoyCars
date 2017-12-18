package ma.itti.sovoyCars.ittisovoycars.services;

import java.util.List;
import ma.itti.sovoyCars.ittisovoycars.models.Promotion;


public interface PromotionService {
	List<Promotion> getPromotions();
	void ajouterPromotion(Promotion p);
	void modifierPromotion(Promotion p);
	void supprimerPromotion(Promotion p);
	Promotion getById(int id);
}