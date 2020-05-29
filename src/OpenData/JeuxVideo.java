package OpenData;

public class JeuxVideo extends Document {

	public JeuxVideo() {
		super();
	}
	
	public JeuxVideo(String ean, String titre, String editeur,int dateP, String titreS, int nbSerie, String auteurNom, String auteurPrenom) {
		super(ean, titre, editeur,dateP, titreS, nbSerie, auteurNom, auteurPrenom);
	}
}
