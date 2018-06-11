package org.sid.eboutique.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Produit;
import org.sid.eboutique.metier.IAdminProduitMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/adminProd")
public class AdminProduitsControllers {
	@Autowired
	private IAdminProduitMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", metier.listproduits());
		model.addAttribute("categories", metier.listCategories());
		return "produits";
	}
	
	@RequestMapping("/saveProd")
	public String saveProd(@Valid Produit p,BindingResult bindingResult, Model model,MultipartFile file) throws Exception{
		if(bindingResult.hasErrors()){
			model.addAttribute("categories", metier.listCategories());
			model.addAttribute("produits", metier.listproduits());
			return "produits";
		}
		//p.setPhoto(path);
		//BufferedImage bi=ImageIO.read(file.getInputStream());
		if(!file.isEmpty()){
			String path=System.getProperty("java.io.tmpdir");
			p.setPhoto(file.getOriginalFilename());
			Long idP=null;
			if(p.getIdProduit()==null){
				idP=metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
			}
			else{
				metier.modifierProduit(p);
				idP=p.getIdProduit();
			}
			file.transferTo(new File(path+"/"+"PROD_"+idP+"_"+file.getOriginalFilename()));
			//p.setPhoto(path);
			/*c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());*/
		}
		else{
			metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
		}
		/*else{
			if(c.getIdCategorie()!=null){
				if(file.isEmpty()){
					Categorie cat=(Categorie) model.asMap().get("editedCat");
					c.setPhoto(cat.getPhoto());
				}
			}
		}
		if(c.getIdCategorie()==null){
			metier.ajouterCategorie(c);
		}
		else metier.modifierCategorie(c);*/
		
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", metier.listproduits());
		model.addAttribute("categories", metier.listCategories());
		return "produits";
	}
	
	@RequestMapping(value="/photoProd",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long idProd) throws IOException{
		Produit p=metier.getProduit(idProd);
		File f=new File(System.getProperty("java.io.tmpdir")+"PROD_"+idProd+"_"+p.getPhoto());
		/*Categorie c=metier.getCategorie(idCat);
		if(c.getPhoto()==null) return new byte[0];*/
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	@RequestMapping(value="/suppProd")
	public String suppCat(Long idProd,Model model){
		metier.supprimerProduit(idProd);
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", metier.listproduits());
		model.addAttribute("categories", metier.listCategories());
		return "produits";
	}
	
	@RequestMapping(value="/editProd")
	public String editProd(Long idProd,Model model){
		Produit p=metier.getProduit(idProd);
		model.addAttribute("produit", p);
		model.addAttribute("produits", metier.listproduits());
		model.addAttribute("categories", metier.listCategories());
		return "produits";
	}
	
}
