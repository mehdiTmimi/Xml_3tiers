package business;

import java.util.List;

import dao.ProduitDao;
import dao.ProduitXmlDao;
import models.Produit;

public class DefaultServices implements Services{

	private ProduitDao produitDao;
	private static DefaultServices instance=null;
	public static DefaultServices getInstance()
	{
		if(instance==null)
			instance=new DefaultServices();
		return instance;
	}
	 private DefaultServices() {
		 this.produitDao=new ProduitXmlDao();
	 }
	@Override
	public boolean add(Produit produit) {
		return produitDao.add(produit);
	}

	@Override
	public List<Produit> getAll() {
		return produitDao.getAll();
	}

}
