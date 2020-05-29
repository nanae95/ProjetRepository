package OpenData;

public class JeuDeSociete extends Document {

	public JeuDeSociete() {
		super();
	}
	
	public JeuDeSociete(String ean, String titre, String editeur,int dateP, String titreS, int nbSerie, String auteurNom, String auteurPrenom) {
		super(ean, titre, editeur,dateP, titreS, nbSerie, auteurNom, auteurPrenom);
	}
}
