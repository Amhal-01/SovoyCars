package ma.itti.sovoyCars.ittisovoycars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.itti.sovoyCars.ittisovoycars.models.Voiture;
import ma.itti.sovoyCars.ittisovoycars.services.VoitureService;

@Controller
@RequestMapping("/voitures")
public class VoitureController {
	@Autowired
	VoitureService service;
	
	@GetMapping("/add")
	public String ajouter() {
		return "voitures/ajouter";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Voiture i, BindingResult result) {
		if(result.hasErrors()) {
			return "voitures/ajouter";
		}
		service.ajouterVoiture(i);
		return "redirect:liste";
	}
	
	@GetMapping("/liste")
	public String index(Model m) {
		m.addAttribute("voitures",service.getVoitures() );
		return "voitures/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Voiture voiture = service.getById(id);
		service.supprimerVoiture(voiture);
		return "redirect:../liste";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("voiture",service.getById(id));
		return "voitures/modifier";
	}
	
	@PostMapping("/details/{id}")
	public String details(@ModelAttribute Voiture i, BindingResult result) {
		if(result.hasErrors()) {
			return "voitures/details/{id}";
		}
		service.modifierVoiture(i);
		return "redirect:../liste";
	}
}
