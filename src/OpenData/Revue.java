package OpenData;

public class Revue extends Document {

	public Revue() {
		super();
	}
	
	public Revue(int num, int ean, boolean serie, String titreS, String titre, int dateP) {
		super(num, ean, titre, dateP);
	}
}
