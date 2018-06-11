package org.sid.eboutique;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Produit;
import org.sid.eboutique.metier.IAdminCategoriesMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {
	ClassPathXmlApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}

	@Test
	public void test1() {
		try {
			//assertTrue(true);
			IAdminCategoriesMetier metier=(IAdminCategoriesMetier) context.getBean("metier");
			List<Categorie> cats1=metier.listCategories();
			metier.ajouterCategorie(new Categorie("Ordinateurs", "Ordsssssssssss", null, "image1.jpg"));
			metier.ajouterCategorie(new Categorie("Imprimantes", "Impsssssssssss", null, "image2.jpg"));
			List<Categorie> cats2=metier.listCategories();
			assertTrue(cats1.size()+2==cats2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(),false);
		}
	}
	
	@Test
	public void test2() {
		try {
			//assertTrue(true);
			IAdminCategoriesMetier metier=(IAdminCategoriesMetier) context.getBean("metier");
			List<Produit> prods1=metier.listproduits();
			metier.ajouterProduit(new Produit("DIS20BS0084FE", "Lenovo ThinkPad X1 CARBON", 25355, true, "image3.jpg", 10), 1L);
			metier.ajouterProduit(new Produit("DIS20BS0084FE", "DELL INSPIRON i3543", 7329, true, "image4.jpg", 10), 1L);
			List<Produit> prods2=metier.listproduits();
			assertTrue(prods1.size()+2==prods2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(),false);
		}
	}

}
