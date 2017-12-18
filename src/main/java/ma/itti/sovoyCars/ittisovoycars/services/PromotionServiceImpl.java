package ma.itti.sovoyCars.ittisovoycars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itti.sovoyCars.ittisovoycars.models.Promotion;
import ma.itti.sovoyCars.ittisovoycars.repository.PromotionRepository;

@Service("promotionService")
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	PromotionRepository promotionRepository;
	
	@Override
	public List<Promotion> getPromotions() {
		return promotionRepository.findAll();
	}

	@Override
	public void ajouterPromotion(Promotion p) {
		promotionRepository.save(p);

	}

	@Override
	public void modifierPromotion(Promotion p) {
		promotionRepository.save(p);
	}

	@Override
	public void supprimerPromotion(Promotion p) {
		promotionRepository.delete(p);		
	}
	
	@Override
	public Promotion getById(int id) {
		return promotionRepository.findOne(id);
	}

}
