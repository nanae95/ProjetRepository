package OpenData;

public class BD extends Document {

	public BD() {
		super();
	}
	
	public BD(int ean, String titre, String editeur,int dateP, String titreS, int nbSerie, String auteurNom, String auteurPrenom) {
		super(ean, titre, editeur,dateP, titreS, nbSerie, auteurNom, auteurPrenom);
	}
}
