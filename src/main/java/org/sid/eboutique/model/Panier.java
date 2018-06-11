package org.sid.eboutique.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.sid.eboutique.entities.Produit;

public class Panier {
	private Map<Long, ArticlePanier> articles=new HashMap<Long, ArticlePanier>();
	
	public void ajouterArticle(Produit p,int quantite){
		ArticlePanier art=articles.get(p.getIdProduit());
		if(art!=null) art.setQuantite(art.getQuantite()+quantite);
		else articles.put(p.getIdProduit(), new ArticlePanier(p, quantite));
	}
	public Collection<ArticlePanier> getArticles(){
		return articles.values();
	}
	public double getTotal(){
		double total=0;
		Collection<ArticlePanier> items=getArticles();
		for(ArticlePanier art:items){
			total+=art.getQuantite()*art.getProduit().getPrix();
		}
		return total;
	}
	public void deleteItem(Long idProduit){
		articles.remove(idProduit);
	}
	public int getSize(){
		int nb=0;
		Collection<ArticlePanier> items=getArticles();
		for(ArticlePanier art:items){
			nb+=art.getQuantite();
		}
		return nb;
	}
}
