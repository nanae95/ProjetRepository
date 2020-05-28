package OpenData;

public class Reseau {

	public static void main(String[] args) {
		BD bd = new BD(05, 5, "leTitre", 2019);
		ListeDoc liste = new ListeDoc();
		liste.ajouter(bd);
		liste.consulter();
		System.out.println(liste.get(5));
		System.out.println(liste.get(5).getClass().getName());
		
		BD bd1 = new BD(05, 5, "leTitre", 2019);
		bd1.setSerie(true, "LaSerie", 1);
		bd1.setAuteur("LeNom", "LePrenom");
		BD bd2 = new BD(05, 5, "leTitre", 2017);
		bd2.setSerie(true, "LaSerie", 2);
		bd2.setAuteur("LeNom", "LePrenom");
		BD bd3 = new BD(05, 5, "leTitre", 1995);
		bd3.setSerie(true, "LaSerie", 3);
		bd3.setAuteur("LeNom2", "LePrenom3");
		
		ListeSerie liste2 = new ListeSerie();
		liste2.ajouter(bd2);
		liste2.ajouter(bd3);
		liste2.ajouter(bd1);
		//liste2.consulter("ddd");
		//liste2.consulter("LaSerie");
		//liste2.consulterNom("LeNom");
		
	}

}
