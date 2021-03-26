package dao;

import java.util.List;

import models.Produit;

public interface ProduitDao {

	public boolean add(Produit produit);
	public List<Produit> getAll();
}
