package org.sid.eboutique.model;

import org.sid.eboutique.entities.Produit;

public class ArticlePanier {
	private Produit produit;
	private int quantite;
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public ArticlePanier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArticlePanier(Produit produit, int quantite) {
		super();
		this.produit = produit;
		this.quantite = quantite;
	}
}
