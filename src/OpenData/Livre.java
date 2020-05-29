package OpenData;

public class Livre extends Document {
	
	int isbn;
	
	public Livre() {
		super();
	}
	
	public Livre(int ean, int isbn, String titre, String editeur,int dateP, String titreS, int nbSerie, String auteurNom, String auteurPrenom) {
		super(ean, titre, editeur,dateP, titreS, nbSerie, auteurNom, auteurPrenom);
		this.isbn = isbn;
	}
	
	public int getIsbn() {
		return isbn;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder (getIsbn() + ";	" + getEan() + ";	" + getTitre() + ";");
		return res.toString();
	}

}
