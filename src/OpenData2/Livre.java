package OpenData2;

public class Livre extends Document {
	
	String isbn;
	
	public Livre() {
		super();
	}
	
	public Livre(String ean, String isbn, String titre, String editeur,int dateP, String titreS, int nbSerie, String auteurNom, String auteurPrenom) {
		super(ean, titre, editeur,dateP, titreS, nbSerie, auteurNom, auteurPrenom);
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder (getIsbn() + ";	" + getEan() + ";	" + getTitre() + ";");
		return res.toString();
	}

}
