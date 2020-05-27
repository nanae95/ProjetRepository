package OpenData;

public class Livre extends Document {
	
	int isbn;
	
	public Livre() {
		super();
	}
	
	public Livre(int num, int ean, boolean serie, String titreS, int isbn, String titre) {
		super(num, ean, serie, titreS, titre);
		this.isbn = isbn;
	}
	
	public int getIsbn() {
		return isbn;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder (getNumNotice() + ";	" + getIsbn() + ";	" + getEan() + ";	" + getTitre() + ";");
		return res.toString();
	}

}
