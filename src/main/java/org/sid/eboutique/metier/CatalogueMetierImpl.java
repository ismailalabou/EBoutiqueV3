package org.sid.eboutique.metier;

import java.util.List;

import org.sid.eboutique.dao.ICatalogueDao;
import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Produit;

public class CatalogueMetierImpl implements IProduitsManager, ICategoriesManager {
	private ICatalogueDao dao;
	
	public void setDao(ICatalogueDao dao) {
		this.dao = dao;
	}
	@Override
	public List<Categorie> listCategories() {
		return dao.listCategories();
	}
	@Override
	public Categorie getCategorie(Long idCat) {
		return dao.getCategorie(idCat);
	}
	@Override
	public List<Produit> listproduits() {
		return dao.listproduits();
	}
	@Override
	public List<Produit> produitsParMotCle(String mc) {
		return dao.produitsParMotCle(mc);
	}
	@Override
	public List<Produit> produitsSelectionnes() {
		return dao.produitsSelectionnes();
	}
	@Override
	public Long ajouterCategorie(Categorie c) {
		return dao.ajouterCategorie(c);
	}
	@Override
	public void supprimerCategrorie(Long idcat) {
		// TODO Auto-generated method stub
		dao.supprimerCategrorie(idcat);
	}
	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		dao.modifierCategorie(c);
	}
	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		return dao.ajouterProduit(p, idCat);
	}
	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return dao.getProduit(idP);
	}
	@Override
	public void supprimerProduit(Long idP) {
		// TODO Auto-generated method stub
		dao.supprimerProduit(idP);
	}
	@Override
	public void modifierProduit(Produit p) {
		// TODO Auto-generated method stub
		dao.modifierProduit(p);
	}
	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.produitsParCategorie(idCat);
	}
}
