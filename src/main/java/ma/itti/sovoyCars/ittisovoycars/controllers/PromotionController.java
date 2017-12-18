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

import ma.itti.sovoyCars.ittisovoycars.models.Promotion;
import ma.itti.sovoyCars.ittisovoycars.services.PromotionService;

@Controller
@RequestMapping("/promotions")
public class PromotionController {
	@Autowired
	PromotionService service;
	
	@GetMapping("/add")
	public String ajouter() {
		return "promotions/ajouter";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Promotion i, BindingResult result) {
		if(result.hasErrors()) {
			return "promotions/ajouter";
		}
		service.ajouterPromotion(i);
		return "redirect:liste";
	}
	
	@GetMapping("/liste")
	public String index(Model m) {
		m.addAttribute("promotions",service.getPromotions() );
		return "promotions/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Promotion promotion = service.getById(id);
		service.supprimerPromotion(promotion);
		return "redirect:../liste";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("promotion",service.getById(id));
		return "promotions/modifier";
	}
	
	@PostMapping("/details/{id}")
	public String details(@ModelAttribute Promotion i, BindingResult result) {
		if(result.hasErrors()) {
			return "promotions/details/{id}";
		}
		service.modifierPromotion(i);
		return "redirect:../liste";
	}
}
