package OpenData2;

public class Partition extends Document {

	public Partition() {
		super();
	}
	
	public Partition(String ean, String titre, String editeur,int dateP, String titreS, int nbSerie, String auteurNom, String auteurPrenom) {
		super(ean, titre, editeur,dateP, titreS, nbSerie, auteurNom, auteurPrenom);
	}
}
