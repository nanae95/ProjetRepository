package OpenData;

public abstract class Document {
	
	private boolean dispo; //disponibilité du document
	private int numNotice; //numéro de notice
	private int ean; //numéro ean
	private boolean serie; //fait partie d'une série
	private String titreSerie; //si serie = 1, titre_serie = titre de la série auquel il appartient
	private int numSerie; //Numero de la serie en question
	private int nbExemplaires; //nombre d'exemplaire du doc	
	private String titre; //titre de l'ouvrage
	private int datePubli; //date de publication
	private String nomAuteur; //nom de l'auteur
	private String prenomAuteur; //prenom de l'auteur
	
	public Document() {
		dispo = true;
		numNotice = 0;
		ean = 0;
		serie = false;
		nbExemplaires = 1;
	}
	
	public Document(int num, int ean, String titre, int dateP) {
		dispo = true;
		numNotice = num;
		this.ean = ean;
		this.serie = false;
		this.titre = titre;
		datePubli = dateP;
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
	
	public int getNumSerie() {
		return numSerie;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public int getDatePubli() {
		return datePubli;
	}
	
	public String getNomAuteur() {
		return nomAuteur;
	}
	
	public String getPrenomAuteur() {
		return prenomAuteur;
	}
	
	public void setDispo() {
		dispo = !dispo;
	}
	
	public void setSerie( boolean serie, String titreS, int numSerie) {
		//ATTENTION EXCEPTION SI PAS SERIE
		this.serie = serie;
		this.titreSerie = titreS;
		this.numSerie = numSerie;
	}
	
	public void setNbExemplaires(int newNb) {
		nbExemplaires = newNb;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder (getNumNotice() + ";	" + " "+ ";	" + getEan() + ";	" + getTitre() + ";	" + getDatePubli() + ";");
		return res.toString();
	}
	
	
}


