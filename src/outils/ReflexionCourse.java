package outils;

import java.util.List;

import models.Produit;

public class ReflexionCourse {

	public ReflexionCourse()
	{
		List<Produit> produits=XMLParser.lire("datas/produits.xml", Produit.class);
		System.out.println("length : "+produits.size());
		XMLParser.ecrire("datas/newFile.xml", produits);
	System.out.println("fin");
		
	}
	/*private void example3(){
		try {
			Etudiant etudiant=new Etudiant();
			Etudiant etudiant2=new Etudiant();
			etudiant.setId(10);
			etudiant2.setId(20);
			etudiant.setNom("tmimi");
			etudiant2.setNom("berrada");
			etudiant.setPrenom("mehdi");
			etudiant2.setPrenom("alae");
			etudiant.setAdresse("fes");
			etudiant2.setAdresse("rabat");
			
			Field[] fileds=etudiant.getClass().getDeclaredFields();
			for(int i=0;i<fileds.length;i++)
			{
				Field f=fileds[i];
				System.out.print(f.getName()+" de type "+f.getType()+" : " );
				String geter="get"+f.getName().toUpperCase().charAt(0)+
						f.getName().substring(1);
				Method m =Etudiant.class.getDeclaredMethod(geter);
				
				System.out.println(m.invoke(etudiant) +"");
			}
		}catch (Exception e) {
				e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		new ReflexionCourse();
	}
	private void exemple2() {
		try {
			Class c = Class.forName("models.Etudiant");
			Etudiant o =(Etudiant) c.newInstance();
			o.setId(20);
			System.out.println(o.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void exemple1()
	{
		try {
			Etudiant e=instancier(Etudiant.class);
			e.setId(10);
			System.out.println(e.getId());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private <T> T  instancier(Class<T> c) throws InstantiationException, IllegalAccessException {
		return c.newInstance();
	}
*/
}
