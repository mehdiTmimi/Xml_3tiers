package business;

import java.util.List;

import models.Produit;

public interface Services {
	
	public boolean add(Produit produit);
	public List<Produit> getAll();

}
