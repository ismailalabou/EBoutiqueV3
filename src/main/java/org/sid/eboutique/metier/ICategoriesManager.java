package org.sid.eboutique.metier;

import org.sid.eboutique.entities.Categorie;

public interface ICategoriesManager extends IUserCatalogue {
	public Long ajouterCategorie(Categorie c);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categorie c);
}
