package OpenData2;

public class Carte extends Document {
	
	public Carte() {
		super();
	}
	
	public Carte(String ean, String titre, String editeur,int dateP, String titreS, int nbSerie, String auteurNom, String auteurPrenom) {
		super(ean, titre, editeur,dateP, titreS, nbSerie, auteurNom, auteurPrenom);
	}
}
