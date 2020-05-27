package OpenData;

public abstract class Document {
	
	private boolean dispo; //disponibilit� du document
	private int numNotice; //num�ro de notice
	private int ean; //num�ro ean
	private boolean serie; //fait partie d'une s�rie
	private String titreSerie; //si serie = 1, titre_serie = titre de la s�rie auquel il appartient
	private int nbExemplaires; //nombre d'exemplaire du doc	
	
	public Document() {
		dispo = true;
		numNotice = 0;
		ean = 0;
		serie = false;
		nbExemplaires = 1;
	}
	
	public Document(int num, int ean, boolean serie, String titreS) {
		dispo = true;
		numNotice = num;
		this.ean = ean;
		this.serie = serie;
		if(serie) titreSerie = titreS;
	}
	
	public boolean getDispo() {
		return dispo;
	}
	
	public int getNumNotice() {
		return numNotice;
	}
	
	public int getEan() {
		return ean;
	}
	
	public boolean getSerie() {
		return serie;
	}
	
	public String getTitreSerie() {
		return titreSerie;
	}
	
	public int getNbExemplaires() {
		return nbExemplaires;
	}
	
	public void setDispo() {
		dispo = !dispo;
	}
	
	public void setNbExemplaires(int newNb) {
		nbExemplaires = newNb;
	}
	
}


