package OpenData2;

public class Vinyle extends Document {
	
	public Vinyle() {
		super();
	}
	
	public Vinyle(String ean, String titre, String editeur,int dateP, String titreS, int nbSerie, String auteurNom, String auteurPrenom) {
		super(ean, titre, editeur,dateP, titreS, nbSerie, auteurNom, auteurPrenom);
	}
}
