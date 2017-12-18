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

import ma.itti.sovoyCars.ittisovoycars.models.Categorie;
import ma.itti.sovoyCars.ittisovoycars.services.CategorieService;

@Controller
@RequestMapping("/categories")
public class CategorieController {
	@Autowired
	CategorieService service;
	
	@GetMapping("/add")
	public String ajouter() {
		return "categories/ajouter";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Categorie i, BindingResult result) {
		if(result.hasErrors()) {
			return "categories/ajouter";
		}
		service.ajouterCategorie(i);
		return "redirect:liste";
	}
	
	@GetMapping("/liste")
	public String index(Model m) {
		m.addAttribute("categories",service.getCategories() );
		return "categories/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Categorie categorie = service.getById(id);
		service.supprimerCategorie(categorie);
		return "redirect:../liste";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("categorie",service.getById(id));
		return "categories/modifier";
	}
	
	@PostMapping("/details/{id}")
	public String details(@ModelAttribute Categorie i, BindingResult result) {
		if(result.hasErrors()) {
			return "categories/details/{id}";
		}
		service.modifierCategorie(i);
		return "redirect:../liste";
	}
}
