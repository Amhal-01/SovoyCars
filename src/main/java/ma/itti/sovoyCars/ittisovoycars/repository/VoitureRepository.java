package ma.itti.sovoyCars.ittisovoycars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.itti.sovoyCars.ittisovoycars.models.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Integer>{
}