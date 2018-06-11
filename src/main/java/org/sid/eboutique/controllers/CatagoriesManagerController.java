package org.sid.eboutique.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.slf4j.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.metier.ICategoriesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CatagoriesManagerController implements HandlerExceptionResolver {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ICategoriesManager metier;
	@RequestMapping(value="/index")
	public String categories(Model model){
		model.addAttribute("categories",metier.listCategories() );
		model.addAttribute("categorie", new Categorie());
		return "CategoriesView";
	}
	@RequestMapping(value="/enregistrer")
	public String enregietrer(@Valid Categorie c, BindingResult bindingResult,
	Model model, MultipartFile file) throws Exception{
		if(bindingResult.hasErrors()){
			model.addAttribute("categories",metier.listCategories());
			return"CategoriesView";
		}
		if(!file.isEmpty()){
			BufferedImage bi=ImageIO.read(file.getInputStream());
			c.setNomPhoto(file.getOriginalFilename()); c.setPhoto(file.getBytes());
		}
		else{
			Categorie cat=(Categorie) model.asMap().get("cat");c.setPhoto(cat.getPhoto());
		}
		if(c.getIdCategorie()==null) metier.ajouterCategorie(c);
		else metier.modifierCategorie(c);
		model.addAttribute("categories",metier.listCategories() );
		model.addAttribute("categorie", new Categorie());
		return "CategoriesView";
	}
	@ResponseBody
	@RequestMapping(value="/photoCat",produces=MediaType.IMAGE_JPEG_VALUE)
	public byte[] photo(@RequestParam(value="idCat")Long idCat)throws IOException{
		Categorie c=metier.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ModelAndView resolveException(HttpServletRequest req,
	HttpServletResponse arg1, Object arg2, Exception exception) {
		logger.error("Request: " + req.getRequestURL() + " raised " + exception);
		exception.printStackTrace();
		ModelAndView mav = new ModelAndView();
		mav.addObject("errors", exception.getMessage());
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("CategoriesView");
		mav.addObject("categories",metier.listCategories() );
		mav.addObject("categorie", new Categorie());
		return mav;
	}
	@RequestMapping("/suppCat")
	public String deleteCat(@RequestParam(value="idCat") Long idCat,Model mdeol){
		metier.supprimerCategrorie(idCat);
		mdeol.addAttribute("categories",metier.listCategories() );
		mdeol.addAttribute("categorie", new Categorie());
		return "CategoriesView";
	}
	@RequestMapping("/editCat")
	public String editCat(@RequestParam(value="idCat") Long idCat,Model model){
		Categorie c=metier.getCategorie(idCat);
		model.addAttribute("categories",metier.listCategories() );
		model.addAttribute("categorie",c);
		model.addAttribute("cat", c);
		return "CategoriesView";
	}
}
