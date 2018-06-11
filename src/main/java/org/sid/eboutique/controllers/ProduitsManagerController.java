package org.sid.eboutique.controllers;

import java.io.File;
import java.util.List;

import javax.validation.Valid;

import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Produit;
import org.sid.eboutique.metier.IProduitsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/produits")
public class ProduitsManagerController {
	@Autowired
	private IProduitsManager metier;
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("produit", new Produit());
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("produits", metier.listproduits());
		return "ProduitsView";
	}
	@RequestMapping(value="/saveProduit")
	public String enregistrer(@Valid Produit p, BindingResult bindingResult,
	MultipartFile file,
	Model model) throws Exception{
	if(bindingResult.hasErrors()) {
		model.addAttribute("produits", metier.listproduits());
		return "ProduitsView";
	}
	if(!file.isEmpty()){
		p.setPhoto(file.getOriginalFilename());
	}
	if(p.getIdProduit()==null){
	metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
	}
	else{
		metier.modifierProduit(p);
	}
	if(!file.isEmpty()){
		String path=System.getProperty("java.io.tmpdir")+"/"+p.getIdProduit();
		file.transferTo(new File(path));
	}
	model.addAttribute("produit", new Produit());
	model.addAttribute("produits", metier.listproduits());
	return "ProduitsView";
	}
	@ModelAttribute("categories")
	public List<Categorie> listCategories(){
		return metier.listCategories();
	}
	@RequestMapping(value="/deleteProd")
	public String deleteProduit(@RequestParam("idP")Long idP,Model model){
		metier.supprimerProduit(idP);
		model.addAttribute("produits", metier.listproduits());
		model.addAttribute("produit",new Produit());
		return "ProduitsView";
	}
	@RequestMapping(value="/editProd")
	public String editProduit(@RequestParam("idP")Long idP,Model model){
		Produit p=metier.getProduit(idP);
		model.addAttribute("produit",p);
		model.addAttribute("produits", metier.listproduits());
		return "ProduitsView";
	}
}
