package OpenData;

public abstract class Document {
	
	private boolean dispo; //disponibilité du document
	private int numNotice; //numéro de notice
	private int ean; //numéro ean
	private boolean serie; //fait partie d'une série
	private String titreSerie; //si serie = 1, titre_serie = titre de la série auquel il appartient
	private int nbExemplaires; //nombre d'exemplaire du doc	
	private String titre; //titre de l'ouvrage
	
	public Document() {
		dispo = true;
		numNotice = 0;
		ean = 0;
		serie = false;
		nbExemplaires = 1;
	}
	
	public Document(int num, int ean, boolean serie, String titreS, String titre) {
		dispo = true;
		numNotice = num;
		this.ean = ean;
		this.serie = serie;
		if(serie) titreSerie = titreS;
		this.titre = titre;
		
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
	
	public String getTitre() {
		return titre;
	}
	
	public void setDispo() {
		dispo = !dispo;
	}
	
	public void setNbExemplaires(int newNb) {
		nbExemplaires = newNb;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder (getNumNotice() + ";	" + " "+ ";	" + getEan() + ";	" + getTitre() + ";");
		return res.toString();
	}
	
}


