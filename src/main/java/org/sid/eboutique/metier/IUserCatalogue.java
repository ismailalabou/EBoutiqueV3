package org.sid.eboutique.metier;

import java.util.List;

import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Produit;

public interface IUserCatalogue {
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idP);
	public List<Produit> produitsParCategorie(Long idCat);
}
