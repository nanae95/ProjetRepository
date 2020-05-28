package OpenData;

public class Livre extends Document {
	
	int isbn;
	
	public Livre() {
		super();
	}
	
	public Livre(int num, int ean, int isbn, String titre, int dateP) {
		super(num, ean, titre, dateP);
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
