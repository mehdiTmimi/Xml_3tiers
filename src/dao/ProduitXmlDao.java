package dao;

import java.util.List;

import models.Produit;
import outils.XMLParser;

public class ProduitXmlDao implements ProduitDao{
	public final String PATH="datas/produits.xml";
	
	@Override
	public boolean add(Produit produit) {
		List<Produit> produits=XMLParser.lire(PATH, Produit.class);
		produits.add(produit);
		return XMLParser.ecrire(PATH, produits);
	}

	@Override
	public List<Produit> getAll() {
		return XMLParser.lire(PATH, Produit.class);
	}

}
