package ma.itti.sovoyCars.ittisovoycars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itti.sovoyCars.ittisovoycars.models.Voiture;
import ma.itti.sovoyCars.ittisovoycars.repository.VoitureRepository;

@Service("voitureService")
public class VoitureServiceImpl implements VoitureService {

	@Autowired
	VoitureRepository voitureRepository;
	
	@Override
	public List<Voiture> getVoitures() {
		return voitureRepository.findAll();
	}

	@Override
	public void ajouterVoiture(Voiture o) {
		voitureRepository.save(o);

	}

	@Override
	public void modifierVoiture(Voiture o) {
		voitureRepository.save(o);
	}

	@Override
	public void supprimerVoiture(Voiture o) {
		voitureRepository.delete(o);		
	}
	
	@Override
	public Voiture getById(int id) {
		return voitureRepository.findOne(id);
	}

}
