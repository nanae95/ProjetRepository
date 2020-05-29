package OpenData;

public abstract class Document {
	
	private boolean dispo; //disponibilité du document
	private String ean; //numéro ean
	private boolean serie; //fait partie d'une série
	private String titreSerie; //si serie = 1, titre_serie = titre de la série auquel il appartient
	private int numSerie; //Numero de la serie en question
	private int nbExemplaires; //nombre d'exemplaire du doc	
	private String titre; //titre de l'ouvrage
	private int datePubli; //date de publication
	private String nomAuteur; //nom de l'auteur
	private String prenomAuteur; //prenom de l'auteur
	private String editeur; //nom de l'editeur
	
	public Document() {
		dispo = true;
		ean = "";
		serie = false;
		nbExemplaires = 1;
	}
	
	public Document(String ean, String titre, String editeur,int dateP, String titreS, int nbSerie, String auteurNom, String auteurPrenom) {
		dispo = true;
		this.ean = ean;
		this.titre = titre;
		datePubli = dateP;
		this.nomAuteur = auteurNom;
		this.prenomAuteur = auteurPrenom;
		this.editeur = editeur;
		try {
			setSerie(titreS, nbSerie);
		} catch (ExceptionSerie e) {
			serie = false;
		}
	}
	
	public boolean getDispo() {
		return dispo;
	}
	
	public String getEan() {
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
	
	public void setSerie(String titreS, int numSerie) throws ExceptionSerie {
		if(titreS == "") {
			throw new ExceptionSerie(this);
		}
		else {
			this.serie = true;
			this.titreSerie = titreS;
			this.numSerie = numSerie;
		}
	}
	
	public void setNbExemplaires(int newNb) {
		nbExemplaires = newNb;
	}
	
	public void setAuteur(String nom, String prenom) {
		nomAuteur = nom;
		prenomAuteur = prenom;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder (" "+ ";	" + getEan() + ";	" + getTitre() + ";	" + getDatePubli() + ";");
		return res.toString();
	}
	
	
}


