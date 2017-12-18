package ma.itti.sovoyCars.ittisovoycars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itti.sovoyCars.ittisovoycars.models.Categorie;
import ma.itti.sovoyCars.ittisovoycars.repository.CategorieRepository;

@Service("categorieService")
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	CategorieRepository categorieRepository;
	
	@Override
	public List<Categorie> getCategories() {
		return categorieRepository.findAll();
	}

	@Override
	public void ajouterCategorie(Categorie c) {
		categorieRepository.save(c);

	}

	@Override
	public void modifierCategorie(Categorie c) {
		categorieRepository.save(c);
	}

	@Override
	public void supprimerCategorie(Categorie c) {
		categorieRepository.delete(c);		
	}
	
	@Override
	public Categorie getById(int id) {
		return categorieRepository.findOne(id);
	}

}
