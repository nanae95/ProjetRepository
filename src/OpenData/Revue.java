package OpenData;

public class Revue extends Document {

	public Revue() {
		super();
	}
	
	public Revue(int ean, String titre, String editeur,int dateP, String titreS, int nbSerie, String auteurNom, String auteurPrenom) {
		super(ean, titre, editeur,dateP, titreS, nbSerie, auteurNom, auteurPrenom);
	}
}
