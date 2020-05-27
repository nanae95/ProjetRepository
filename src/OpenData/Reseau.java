package OpenData;

public class Reseau {

	public static void main(String[] args) {
		BD bd = new BD(05, 5, true, "laSerie", "leTitre");
		ListeDoc liste = new ListeDoc();
		liste.ajouter(bd);
		liste.consulter();
		
		
	}

}
